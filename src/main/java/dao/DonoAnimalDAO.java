package dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.DonoAnimal;
import model.Pessoa;

public class DonoAnimalDAO implements GenericDAO<DonoAnimal>{

    public void inserir(DonoAnimal objeto) {
        // TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
    }

    public void deletar(DonoAnimal objeto) {
        // TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
    }

    public void atualizar(DonoAnimal objeto) {
        // TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
    }

    public Object buscaPorID(Class<DonoAnimal> objeto, long id) {
        // TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        DonoAnimal o = em.find(objeto, id);
        em.getTransaction().commit();
        
        return o;
    }

    public void listar() {
        // TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        javax.persistence.Query query = em.createQuery("FROM DonoAnimal e");
        List<DonoAnimal> lista = ((javax.persistence.Query) query).getResultList();
        for(DonoAnimal e: lista){
           e.imprime();
        }
        
    }

    public EntityManager getEntityManager() {
        // TODO Auto-generated method stub
        return Banco.getInstance().getEntityManager();
    }

    public void inserirLog(DonoAnimal objeto) {
    }

	public void listarPorID(long id) {
		// TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        javax.persistence.Query query = em.createQuery("FROM DonoAnimal e WHERE e.id = "+id);
        List<DonoAnimal> lista = ((javax.persistence.Query) query).getResultList();
        for(DonoAnimal e: lista){
           e.imprime();
        }
	}

	public void listarPessoaDonoAnimal(){
        EntityManager em = getEntityManager();
        javax.persistence.Query query = em.createQuery("FROM DonoAnimal e, Pessoa p WHERE e.id = p.id");
        List<Pessoa> listaPessoa = ((javax.persistence.Query) query).getResultList();
        //List<DonoAnimal> listaDonoAnimal = ((javax.persistence.Query) query).getResultList();
        for(Pessoa e: listaPessoa){
           e.imprime();           
        }
//        for(DonoAnimal a: listaDonoAnimal){
//        	a.imprime();
//        }
	}
}