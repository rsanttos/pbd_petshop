package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Animal;
import model.Funcionario;
import model.Venda;

public class FuncionarioDAO extends GenericDAO{

    public void listar() {
        // TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        javax.persistence.Query query = em.createQuery("FROM Funcionario e");
        List<Funcionario> lista = ((javax.persistence.Query) query).getResultList();
        for(Funcionario e: lista){
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
        javax.persistence.Query query = em.createQuery("FROM Funcionario e WHERE e.id = "+id);
        List<Funcionario> lista = ((javax.persistence.Query) query).getResultList();
        for(Funcionario e: lista){
           e.imprime();
        }
	}
	
	public void listarVendas(long id){
        EntityManager em = getEntityManager();
        javax.persistence.Query query = em.createQuery("FROM Venda v WHERE v.funcionario.id = :id");
        query.setParameter("id", id);
        List<Venda> lista = ((javax.persistence.Query) query).getResultList();
        for(Venda e: lista){
        		e.imprime();
        }	
	}
}
