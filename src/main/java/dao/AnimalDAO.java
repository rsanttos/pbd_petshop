package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Animal;

public class AnimalDAO implements GenericDAO<Animal>{

	public void inserir(Animal objeto) {
		// TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
	}

	public void deletar(Animal objeto) {
		// TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
	}

	public void atualizar(Animal objeto) {
		// TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
	}

	public Object buscaPorID(Class<Animal> objeto, long id) {
		// TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Animal o = em.find(objeto, id);
        em.getTransaction().commit();
        
        return o;
	}

	public void listar() {
		// TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        javax.persistence.Query query = em.createQuery("FROM Animal e");
        List<Animal> lista = ((javax.persistence.Query) query).getResultList();
        for(Animal e: lista){
           e.imprime();
        }
		
	}

	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
        return Banco.getInstance().getEntityManager();
	}

	public void inserirLog(Animal objeto) {
	}

	public void listarPorID(long id) {
		// TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        javax.persistence.Query query = em.createQuery("FROM Animal e WHERE e.id = "+id);
        List<Animal> lista = ((javax.persistence.Query) query).getResultList();
        for(Animal e: lista){
           e.imprime();
        }
	}
}
