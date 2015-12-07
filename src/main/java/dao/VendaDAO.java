package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Venda;

public class VendaDAO extends GenericDAO{

    public void listar() {
        // TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        javax.persistence.Query query = em.createQuery("FROM Produto e");
        List<Venda> lista = ((javax.persistence.Query) query).getResultList();
        for(Venda e: lista){
           e.imprime();
        }
        
    }

    public EntityManager getEntityManager() {
        // TODO Auto-generated method stub
        return Banco.getInstance().getEntityManager();
    }

	public List<Venda> listarPorID(long id) {
		// TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        javax.persistence.Query query = em.createQuery("FROM Venda e WHERE e.id = "+id);
        List<Venda> lista = ((javax.persistence.Query) query).getResultList();
        for(Venda e: lista){
           e.imprime();
        }
        return lista;
	}
}
