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
	
	public void deletar (Object entidade){
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.remove(entidade);
		em.getTransaction().commit();
	}
	
	public void atualizar (Object entidade){
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.merge(entidade);
		em.getTransaction().commit();
	}
	
	public Object buscaPorID (Class entidade , long id){
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		Object o = em.find(entidade, id);
		em.getTransaction().commit();
		
		return o;
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
