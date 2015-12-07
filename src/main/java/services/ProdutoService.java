package services;

import java.util.List;

import dao.ProdutoDAO;
import model.Produto;
import model.Servico;

public class ProdutoService {
	private Produto produto;
	private ProdutoDAO pdao;

	private static String mensagemErro;
	private static String mensagemOk;
	
	public ProdutoService(Produto produto){
		this.produto = produto;
		this.pdao = new ProdutoDAO();
		mensagemErro = "Todos os campos devem ser preenchidos.";
		mensagemOk = "O produto foi cadastrado!";
	}
	
	public ProdutoService(){
		this.produto = new Produto();
		this.pdao = new ProdutoDAO();
	}
	
	public String valida(){
		if(this.produto.getDescricao() == null){
			return mensagemErro;
		}else if(this.produto.getPreco() < 0){
			return mensagemErro;
		}else if(this.produto.getQuantidade() < 1){
			return mensagemErro;
		}
		return mensagemOk;
	}
	
	public String persiste(){
		String mensagem = this.valida();
		if(mensagem == mensagemOk){
			pdao.inserir(this.produto);
			return mensagem;
		}else{
			return mensagem;
		}
	}
	
	public String atualiza(){
		Produto p = this.produto;
		String mensagem = this.valida();
		if(mensagem == mensagemOk){
			pdao.atualizar(p);
			return mensagem;
		}else{
			return mensagem;
		}
	}
	
	public List<String> recebeNomesProdutos(){
		List<String> nomesprodutos = pdao.listarNomesProdutos();
		if(nomesprodutos != null){
			return nomesprodutos;
		}
		return null;
	}
	
}
