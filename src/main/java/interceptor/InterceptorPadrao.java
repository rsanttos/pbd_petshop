package interceptor;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import dao.InterceptorPadraoDAO;
import model.Contato;
import model.LogDatabase;

public class InterceptorPadrao extends EmptyInterceptor{

	private static final long serialVersionUID = 1L;
	private String tipoOperacao;
	private Set<Contato> contatosSalvos = new HashSet<Contato>();
	
	InterceptorPadraoDAO dao = new InterceptorPadraoDAO();
	
	public boolean onSave(Object entity, Serializable id, Object[] state,
		String[] propertyNames, Type[] types){
		
		if (entity instanceof Contato) {
			Contato ent = (Contato) entity;
			contatosSalvos.add(ent);
		}
		tipoOperacao = "Save";
		
		return super.onSave(entity, id, state, propertyNames, types);
	}
	
	@Override
    public void postFlush(@SuppressWarnings("rawtypes") Iterator entities) {        
        super.postFlush(entities);
        for (Contato cont : contatosSalvos) {
        	LogDatabase log = new LogDatabase();
        	log.setEntidade(cont.getClass().getCanonicalName());
    		log.setTipoOperacao(tipoOperacao);
    		log.setValorAlterado(cont.getId().toString());
    		log.setDataAlteracao(new Date());
    		dao.inserirLog(log);
        }
	}
	public void imprime(){
		System.out.println("Tipo da operação: " + this.tipoOperacao);
		for(Contato c: contatosSalvos){
			System.out.println();
		}
	}

}
