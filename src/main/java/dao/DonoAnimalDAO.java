package dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.Animal;
import model.DonoAnimal;
import model.Pessoa;
import model.Venda;

public class DonoAnimalDAO extends GenericDAO{

    public List<DonoAnimal> listar() {
        // TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        javax.persistence.Query query = em.createQuery("FROM DonoAnimal e");
        List<DonoAnimal> lista = ((javax.persistence.Query) query).getResultList();
        for(DonoAnimal e: lista){
           e.imprime();
        }
        return lista;
    }

    public EntityManager getEntityManager() {
        // TODO Auto-generated method stub
        return Banco.getInstance().getEntityManager();
    }

	public List<DonoAnimal> listarPorID(long id) {
		// TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        javax.persistence.Query query = em.createQuery("FROM DonoAnimal e WHERE e.id = :id");
        query.setParameter("id", id);
        List<DonoAnimal> lista = ((javax.persistence.Query) query).getResultList();
        for(DonoAnimal e: lista){
           e.imprime();
        }
        return lista;
	}

	public List<DonoAnimal> listarPorNome(String nome) {
		// TODO Auto-generated method stub
        EntityManager em = getEntityManager();
        javax.persistence.Query query = em.createQuery("FROM DonoAnimal d WHERE d.pessoa.nome LIKE :nome");
        query.setParameter("nome","%" + nome + "%");
        List<DonoAnimal> lista = ((javax.persistence.Query) query).getResultList();
        for(DonoAnimal e: lista){
           e.imprime();
        }
        return lista;
	}


	public List<Pessoa> listarPessoaDonoAnimal(){
        EntityManager em = getEntityManager();
        javax.persistence.Query query = em.createQuery("FROM DonoAnimal e, Pessoa p WHERE e.id = p.id");
        List<Pessoa> listaPessoa = ((javax.persistence.Query) query).getResultList();
        //List<DonoAnimal> listaDonoAnimal = ((javax.persistence.Query) query).getResultList();
        for(Pessoa e: listaPessoa){
           e.imprime();           
        }
        
        return listaPessoa;
	}
	
	public List<Animal> listarAnimais(long id){
        EntityManager em = getEntityManager();
        javax.persistence.Query query = em.createQuery("FROM Animal a WHERE a.donoanimal.id = :id");
        query.setParameter("id", id);
        List<Animal> lista = ((javax.persistence.Query) query).getResultList();
        for(Animal e: lista){
        		e.imprime();
        }
        return lista;
	}
	
	public List<Venda> listarCompras(long id){
        EntityManager em = getEntityManager();
        javax.persistence.Query query = em.createQuery("FROM Venda v WHERE v.donoanimal.id = :id");
        query.setParameter("id", id);
        List<Venda> lista = ((javax.persistence.Query) query).getResultList();
        for(Venda e: lista){
        		e.imprime();
        }
        return lista;
	}
}
