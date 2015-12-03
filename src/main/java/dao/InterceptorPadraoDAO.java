package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interceptor.InterceptorPadrao;

public class InterceptorPadraoDAO extends GenericDAO{

    public void listar() {
        // TODO Auto-generated method stub
//        EntityManager em = getEntityManager();
//        javax.persistence.Query query = em.createQuery("FROM InterceptorPadrao e");
//        List<InterceptorPadrao> lista = ((javax.persistence.Query) query).getResultList();
//        for(InterceptorPadrao e: lista){
//           e.imprime();
//        }        
    }

    public EntityManager getEntityManager() {
        // TODO Auto-generated method stub
        return Banco.getInstance().getEntityManager();
    }

//	public void listarPorID(long id) {
//		// TODO Auto-generated method stub
//        EntityManager em = getEntityManager();
//        javax.persistence.Query query = em.createQuery("FROM InterceptorPadrao e WHERE e.id = "+id);
//        List<InterceptorPadrao> lista = ((javax.persistence.Query) query).getResultList();
//        for(InterceptorPadrao e: lista){
//           e.imprime();
//        }	
//	}

	public void inserirLog(Object objeto) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexaoDB");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(objeto);		
			em.getTransaction().commit();
		}
		finally {
			em.close();
		}
	}

	public void listarPorID(long id) {
		// TODO Auto-generated method stub
		
	}	
}
