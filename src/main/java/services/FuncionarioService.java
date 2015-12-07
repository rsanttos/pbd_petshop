package services;

import java.text.SimpleDateFormat;

import dao.FuncionarioDAO;
import model.Funcionario;

public class FuncionarioService {
	private Funcionario funcionario;
	private FuncionarioDAO fdao;

	private static String mensagemErro;
	private static String mensagemOk;
	
	public FuncionarioService(Funcionario funcionario){
		this.fdao = new FuncionarioDAO();
		this.funcionario = funcionario;
		
		mensagemErro = "Todos os campos devem ser preenchidos.";
		mensagemOk = "O funcionario foi cadastrado!";
	}
	
	public String valida(){
		if(this.funcionario.getPessoa().getNome() == null || this.funcionario.getPessoa().getNome() == ""){
			return mensagemErro;
		}else if(this.funcionario.getPessoa().getCpf() == null || this.funcionario.getPessoa().getCpf() == ""){
			return mensagemErro;
		}else if(this.funcionario.getPessoa().getDataNascimento() == null){
			return mensagemErro;
		}else if(this.funcionario.getPessoa().getSexo() == null || this.funcionario.getPessoa().getSexo() == ""){
			return mensagemErro;
		}else if(this.funcionario.getSalario() < 0){
			return mensagemErro;
		}
		return mensagemOk;
	}
	
	public String persiste(){
		String mensagem = this.valida();
		if(mensagem == mensagemOk){
			fdao.inserir(this.funcionario);
			return mensagem;
		}else{
			return mensagem;
		}
	}
	
	
}
