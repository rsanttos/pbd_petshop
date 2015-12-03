package interceptor;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import dao.GenericDAO;
import dao.Persistencia;
import model.LogDatabase;

public class InterceptorPadrao extends EmptyInterceptor{

	private static final long serialVersionUID = 1L;
	private String tipoOperacao;
	private Set<Persistencia> objetosSalvos = new HashSet<Persistencia>();
	private Set<Persistencia> objetosRemovidos = new HashSet<Persistencia>();
	private Set<Persistencia> objetosAtualizados = new HashSet<Persistencia>();
	
	GenericDAO dao = new GenericDAO();
	
	public boolean onSave(Object entity, Serializable id, Object[] state,
		String[] propertyNames, Type[] types){
		if (entity instanceof Persistencia)
			objetosSalvos.add((Persistencia) entity);
		tipoOperacao = "Save";
		return super.onSave(entity, id, state, propertyNames, types);
	}
	
	public boolean onFlushDirty(Object entity,Serializable id,
		Object[] currentState,Object[] previousState,
		String[] propertyNames,Type[] types){
		if (entity instanceof Persistencia)
			objetosAtualizados.add((Persistencia) entity);
		tipoOperacao = "Update";
		return super.onFlushDirty(entity, id, currentState, previousState, propertyNames, types);
	}
	
	public void onDelete(Object entity, Serializable id, Object[] state,
		String[] propertyNames, Type[] types){
		if (entity instanceof Persistencia)
			objetosRemovidos.add((Persistencia) entity);
		tipoOperacao = "Delete";
		super.onDelete(entity, id, state, propertyNames, types);
	}
	
	@Override
    public void postFlush(@SuppressWarnings("rawtypes") Iterator entities) {        
        super.postFlush(entities);
        for (Persistencia obj : objetosSalvos) {
        	LogDatabase log = new LogDatabase();
        	log.setEntidade(obj.getClass().getCanonicalName());
    		log.setTipoOperacao(tipoOperacao);
    		log.setValorAlterado(obj.getId().toString());
    		log.setDataAlteracao(new Date());
    		dao.inserirLog(log);
        }
        for (Persistencia obj : objetosAtualizados) {
        	LogDatabase log = new LogDatabase();
        	log.setEntidade(obj.getClass().getCanonicalName());
    		log.setTipoOperacao(tipoOperacao);
    		log.setValorAlterado(obj.getId().toString());
    		log.setDataAlteracao(new Date());
    		dao.inserirLog(log);
        }
        for (Persistencia obj : objetosRemovidos) {
        	LogDatabase log = new LogDatabase();
        	log.setEntidade(obj.getClass().getCanonicalName());
    		log.setTipoOperacao(tipoOperacao);
    		log.setValorAlterado(obj.getId().toString());
    		log.setDataAlteracao(new Date());
    		dao.inserirLog(log);
        }
        objetosSalvos = new HashSet<Persistencia>();
    	objetosRemovidos = new HashSet<Persistencia>();
    	objetosAtualizados = new HashSet<Persistencia>();
	}    

}