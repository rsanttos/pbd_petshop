package dao;

import java.util.List;

import javax.persistence.EntityManager;

import interceptor.InterceptorPadrao;
import model.LogDatabase;

public class InterceptorPadraoDAO implements GenericDAO<InterceptorPadrao>{

    public void inserir(InterceptorPadrao objeto) {
        // TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
    }

    public void deletar(InterceptorPadrao objeto) {
        // TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
    }

    public void atualizar(InterceptorPadrao objeto) {
        // TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
    }

    public Object buscaPorID(Class<InterceptorPadrao> objeto, long id) {
        // TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        InterceptorPadrao o = em.find(objeto, id);
        em.getTransaction().commit();
        
        return o;
    }

    public void listar() {
        // TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        javax.persistence.Query query = em.createQuery("FROM InterceptorPadrao e");
        List<InterceptorPadrao> lista = ((javax.persistence.Query) query).getResultList();
        for(InterceptorPadrao e: lista){
           e.imprime();
        }
        
    }

    public EntityManager getEntityManager() {
        // TODO Auto-generated method stub
        return Banco.getInstance().getEntityManager();
    }

    public void inserirLog(LogDatabase log) {
        // TODO Auto-generated method stub
        
    }

    public void inserirLog(InterceptorPadrao objeto) {
    }

	public void listarPorID(long id) {
		// TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        javax.persistence.Query query = em.createQuery("FROM InterceptorPadrao e WHERE e.id = "+id);
        List<InterceptorPadrao> lista = ((javax.persistence.Query) query).getResultList();
        for(InterceptorPadrao e: lista){
           e.imprime();
        }	
	}
}
