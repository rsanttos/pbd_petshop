package dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.DonoAnimal;
import model.Pessoa;

public class DonoAnimalDAO extends GenericDAO{

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
	}

	public void inserirLog(Object log) {
		// TODO Auto-generated method stub
		
	}
}
