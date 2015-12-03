package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericDAO {
	
	public void inserir (Object entidade){
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
	}
	
	public void atualizar(Object obj) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
	}
	
	public Object buscaPorID(Class classe, long i) {
		EntityManager em = getEntityManager();
		return em.find(classe, i);
	}
	
	public void deletar(Object obj) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.remove(obj);
		em.getTransaction().commit();
	}
	
	private EntityManager getEntityManager(){
		return Banco.getInstance().getEntityManager();
	}
	
	public void inserirLog(Object log){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexaoDB");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(log);		
			em.getTransaction().commit();
		}
		finally {
			em.close();
		}
	}	

}