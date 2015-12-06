package services;

import dao.ProdutoDAO;
import model.Produto;

public class ProdutoService {
	private Produto produto;
	private ProdutoDAO pdao;
	
	public ProdutoService(Produto produto){
		this.produto = produto;
		this.pdao = new ProdutoDAO();
	}
	
	public boolean valida(){
		if(this.produto.getDescricao() == null){
			return false;
		}else if(this.produto.getPreco() < 0){
			return false;
		}else if(this.produto.getQuantidade() < 1){
			return false;
		}
		return true;
	}
	
	public void persiste(){
		if(valida()){
			pdao.inserir(this.produto);
		}
	}
	
}
