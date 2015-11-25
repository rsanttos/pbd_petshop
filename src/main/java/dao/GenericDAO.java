package dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public interface GenericDAO <T> {
	
	public void inserir (T objeto);
	
	public void deletar (T objeto);
	
	public void atualizar (T objeto);
	
	public Object buscaPorID (Class<T> objeto, long id);
	
	public void listar();
	
	public void listarPorID(long id);
	
	public EntityManager getEntityManager();
	
	public void inserirLog(T objeto);

}
