package services;

import java.util.List;

import dao.ServicoDAO;
import model.Servico;

public class ServicoService {
	private Servico servico;
	private ServicoDAO sdao;

	private static String mensagemErro;
	private static String mensagemOk;
	
	public ServicoService(Servico servico){
		this.servico = servico;
		this.sdao = new ServicoDAO();
		mensagemErro = "Todos os campos devem ser preenchidos.";
		mensagemOk = "O serviço foi cadastrado!";
	}
	
	public ServicoService(){
		this.servico = new Servico();
		this.sdao = new ServicoDAO();
	}
	
	public String valida(){
		if(this.servico.getDescricao() == null){
			return mensagemErro;
		}else if(this.servico.getPreco() < 0){
			return mensagemErro;
		}
		return mensagemOk;
	}
	
	public String persiste(){
		String mensagem = this.valida();
		if(mensagem == mensagemOk){
			sdao.inserir(this.servico);
			return mensagem;
		}else{
			return mensagem;
		}
	}	
	public List<String> recebeNomesServicos(){
		List<String> nomesprodutos = sdao.listarNomesServicos();
		if(nomesprodutos != null){
			return nomesprodutos;
		}
		return null;
	}
}
