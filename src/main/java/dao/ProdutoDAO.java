package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import model.Produto;

public class ProdutoDAO extends GenericDAO{


    public EntityManager getEntityManager() {
        // TODO Auto-generated method stub
        return Banco.getInstance().getEntityManager();
    }
	public List<Produto> listar() {
		// TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        javax.persistence.Query query = em.createQuery("FROM Produto e");
        List<Produto> lista = ((javax.persistence.Query) query).getResultList();
        for(Produto e: lista){
           e.imprime();
        }
        return lista;		
	}

	public List<Produto> listarPorID(long id) {
		// TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        javax.persistence.Query query = em.createQuery("FROM Produto e WHERE e.id = :id");
        query.setParameter("id", id);
        List<Produto> lista = ((javax.persistence.Query) query).getResultList();
        for(Produto e: lista){
           e.imprime();
        }
        return lista;
	}

	public List<Produto> listarPorDescricao(String nome) {
		// TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        javax.persistence.Query query = em.createQuery("FROM Produto d WHERE d.descricao LIKE :nome");
        query.setParameter("nome","%" + nome + "%");
        List<Produto> lista = ((javax.persistence.Query) query).getResultList();
        for(Produto e: lista){
           e.imprime();
        }
        return lista;
	}
	
	public List<String> listarNomesProdutos(){
		List<Produto> produtos = this.listar();
		List<String> nomes = new ArrayList<String>();
		for(Produto p : produtos){
			nomes.add(p.getDescricao());
		}
		return nomes;
	}
}
