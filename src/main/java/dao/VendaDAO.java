package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Venda;

public class VendaDAO implements GenericDAO<Venda>{

    public void inserir(Venda objeto) {
        // TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
    }

    public void deletar(Venda objeto) {
        // TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
    }

    public void atualizar(Venda objeto) {
        // TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
    }

    public Object buscaPorID(Class<Venda> objeto, long id) {
        // TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Venda o = em.find(objeto, id);
        em.getTransaction().commit();
        
        return o;
    }

    public void listar() {
        // TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        javax.persistence.Query query = em.createQuery("FROM Produto e");
        List<Venda> lista = ((javax.persistence.Query) query).getResultList();
        for(Venda e: lista){
           e.imprime();
        }
        
    }

    public EntityManager getEntityManager() {
        // TODO Auto-generated method stub
        return Banco.getInstance().getEntityManager();
    }

    public void inserirLog(Venda objeto) {
    }

	public void listarPorID(long id) {
		// TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        javax.persistence.Query query = em.createQuery("FROM Venda e WHERE e.id = "+id);
        List<Venda> lista = ((javax.persistence.Query) query).getResultList();
        for(Venda e: lista){
           e.imprime();
        }
	}
}
