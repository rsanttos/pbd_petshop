package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Animal;
import model.Produto;

public class ProdutoDAO extends GenericDAO{


    public EntityManager getEntityManager() {
        // TODO Auto-generated method stub
        return Banco.getInstance().getEntityManager();
    }
	public List<Produto> listar() {
		// TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        javax.persistence.Query query = em.createQuery("FROM Produto e");
        List<Produto> lista = ((javax.persistence.Query) query).getResultList();
        for(Produto e: lista){
           e.imprime();
        }
        return lista;		
	}

	public void listarPorID(long id) {
		// TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        javax.persistence.Query query = em.createQuery("FROM Produto e WHERE e.id = "+id);
        List<Produto> lista = ((javax.persistence.Query) query).getResultList();
        for(Produto e: lista){
           e.imprime();
        }
	}
}
