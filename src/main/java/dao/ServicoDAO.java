package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Servico;

public class ServicoDAO implements GenericDAO<Servico>{

    public void inserir(Servico objeto) {
        // TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
    }

    public void deletar(Servico objeto) {
        // TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
    }

    public void atualizar(Servico objeto) {
        // TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
    }

    public Object buscaPorID(Class<Servico> objeto, long id) {
        // TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Servico o = em.find(objeto, id);
        em.getTransaction().commit();
        
        return o;
    }

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

    public void inserirLog(Servico objeto) {
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