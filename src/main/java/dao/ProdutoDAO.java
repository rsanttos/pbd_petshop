package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Produto;

public class ProdutoDAO implements GenericDAO<Produto>{

    public void inserir(Produto objeto) {
        // TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
    }

    public void deletar(Produto objeto) {
        // TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
    }

    public void atualizar(Produto objeto) {
        // TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
    }

    public Object buscaPorID(Class<Produto> objeto, long id) {
        // TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Produto o = em.find(objeto, id);
        em.getTransaction().commit();
        
        return o;
    }

    public void listar() {
        // TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        javax.persistence.Query query = em.createQuery("FROM Produto e");
        List<Produto> lista = ((javax.persistence.Query) query).getResultList();
        for(Produto e: lista){
           e.imprime();
        }
        
    }

    public EntityManager getEntityManager() {
        // TODO Auto-generated method stub
        return Banco.getInstance().getEntityManager();
    }

    public void inserirLog(Produto objeto) {
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
