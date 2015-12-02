package interceptor;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import dao.InterceptorPadraoDAO;
import dao.Persistencia;
import model.Contato;
import model.LogDatabase;

public class InterceptorPadrao extends EmptyInterceptor{

	private static final long serialVersionUID = 1L;
	private String tipoOperacao;
	
	private Set<Persistencia> objSalvos = new HashSet<Persistencia>();
	private Set<Persistencia> objDeletados = new HashSet<Persistencia>();
	private Set<Persistencia> objAtualizados = new HashSet<Persistencia>();
	
	private Set<Contato> contatosSalvos = new HashSet<Contato>();
	
	InterceptorPadraoDAO dao = new InterceptorPadraoDAO();
	
	
	public boolean onSave(Object entity, Serializable id, Object[] state,
		String[] propertyNames, Type[] types){
		
		if(entity instanceof Persistencia){
			objSalvos.add((Persistencia) entity);
		}
		tipoOperacao = "Save";
		
		return super.onSave(entity, id, state, propertyNames, types);
	}
	
	public boolean onFlushDirty(Object entity, Serializable id, Object[] state,
		String[] propertyNames, Type[] types){
		
		if(entity instanceof Persistencia){
			objAtualizados.add((Persistencia) entity);
		}
		tipoOperacao = "Update";
		
		return super.onSave(entity, id, state, propertyNames, types);
	}
	
	public void onDelete(Object entity, Serializable id, Object[] state,
		String[] propertyNames, Type[] types){
		
		if(entity instanceof Persistencia){
			objDeletados.add((Persistencia) entity);
		}
		tipoOperacao = "Delete";
	}
	
	
	@Override
    public void postFlush(@SuppressWarnings("rawtypes") Iterator entities) {        
        super.postFlush(entities);
        for (Persistencia cont : objSalvos) {
        	LogDatabase log = new LogDatabase();
        	log.setEntidade(cont.getClass().getCanonicalName());
    		log.setTipoOperacao(tipoOperacao);
    		log.setValorAlterado(cont.getId().toString());
    		log.setDataAlteracao(new Date());
    		dao.inserirLog(log);
        }
        for (Persistencia cont : objAtualizados) {
        	LogDatabase log = new LogDatabase();
        	log.setEntidade(cont.getClass().getCanonicalName());
    		log.setTipoOperacao(tipoOperacao);
    		log.setValorAlterado(cont.getId().toString());
    		log.setDataAlteracao(new Date());
    		dao.inserirLog(log);
        }
        for (Persistencia cont : objDeletados) {
        	LogDatabase log = new LogDatabase();
        	log.setEntidade(cont.getClass().getCanonicalName());
    		log.setTipoOperacao(tipoOperacao);
    		log.setValorAlterado(cont.getId().toString());
    		log.setDataAlteracao(new Date());
    		dao.inserirLog(log);
        }
        objSalvos = new HashSet<Persistencia>();
        objAtualizados = new HashSet<Persistencia>();
        objDeletados = new HashSet<Persistencia>();
	}
	public void imprime(){
		System.out.println("Tipo da operação: " + this.tipoOperacao);
		for(Contato c: contatosSalvos){
			System.out.println();
		}
	}

}
