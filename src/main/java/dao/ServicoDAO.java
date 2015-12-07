package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Produto;
import model.Servico;

public class ServicoDAO extends GenericDAO{

    public List<Servico> listar() {
        // TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        javax.persistence.Query query = em.createQuery("FROM Servico e");
        List<Servico> lista = ((javax.persistence.Query) query).getResultList();
        for(Servico e: lista){
           e.imprime();
        }
        return lista;        
    }

    public EntityManager getEntityManager() {
        // TODO Auto-generated method stub
        return Banco.getInstance().getEntityManager();
    }
    
	public List<Servico> listarPorID(long id) {
		// TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        javax.persistence.Query query = em.createQuery("FROM Servico e WHERE e.id = "+id);
        List<Servico> lista = ((javax.persistence.Query) query).getResultList();
        for(Servico e: lista){
           e.imprime();
        }
        return lista;
	}

	public List<Servico> listarPorDescricao(String nome) {
		// TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        javax.persistence.Query query = em.createQuery("FROM Servico d WHERE d.descricao LIKE :nome");
        query.setParameter("nome","%" + nome + "%");
        List<Servico> lista = ((javax.persistence.Query) query).getResultList();
        for(Servico e: lista){
           e.imprime();
        }
        return lista;
	}
	
	public List<String> listarNomesServicos(){
		List<Servico> servicos = this.listar();
		List<String> nomes = new ArrayList<String>();
		for(Servico s : servicos){
			nomes.add(s.getDescricao());
		}
		return nomes;
	}
}
