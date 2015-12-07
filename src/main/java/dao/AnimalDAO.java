package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Animal;
import model.DonoAnimal;

public class AnimalDAO extends GenericDAO{

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

	public void listarPorID(long id) {
		// TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        javax.persistence.Query query = em.createQuery("FROM Animal e WHERE e.id = "+id);
        List<Animal> lista = ((javax.persistence.Query) query).getResultList();
        for(Animal e: lista){
           e.imprime();
        }
	}

	public List<Animal> listarPorNome(String nome) {
		// TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        javax.persistence.Query query = em.createQuery("FROM Animal d WHERE d.nome LIKE :nome");
        query.setParameter("nome","%" + nome + "%");
        List<Animal> lista = ((javax.persistence.Query) query).getResultList();
        for(Animal e: lista){
           e.imprime();
        }
        return lista;
	}
}
