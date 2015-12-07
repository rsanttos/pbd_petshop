package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Pessoa;

public class PessoaDAO extends GenericDAO{


    public void listar() {
        // TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        javax.persistence.Query query = em.createQuery("FROM Pessoa e");
        List<Pessoa> lista = ((javax.persistence.Query) query).getResultList();
        for(Pessoa e: lista){
           e.imprime();
        }
        
    }

    public EntityManager getEntityManager() {
        // TODO Auto-generated method stub
        return Banco.getInstance().getEntityManager();
    }
    
	public List<Pessoa> listarPorID(long id) {
		// TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        javax.persistence.Query query = em.createQuery("FROM Pessoa e WHERE e.id = "+id);
        List<Pessoa> lista = ((javax.persistence.Query) query).getResultList();
        for(Pessoa e: lista){
           e.imprime();
        }
    	return lista;
	}
}
