package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Servico;

public class ServicoDAO extends GenericDAO{

    public void listar() {
        // TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        javax.persistence.Query query = em.createQuery("FROM Produto e");
        List<Servico> lista = ((javax.persistence.Query) query).getResultList();
        for(Servico e: lista){
           e.imprime();
        }
        
    }

    public EntityManager getEntityManager() {
        // TODO Auto-generated method stub
        return Banco.getInstance().getEntityManager();
    }
    
	public void listarPorID(long id) {
		// TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        javax.persistence.Query query = em.createQuery("FROM Servico e WHERE e.id = "+id);
        List<Servico> lista = ((javax.persistence.Query) query).getResultList();
        for(Servico e: lista){
           e.imprime();
        }
	}
}
