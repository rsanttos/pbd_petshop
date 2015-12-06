package services;

import java.text.SimpleDateFormat;

import dao.FuncionarioDAO;
import model.Funcionario;

public class FuncionarioService {
	private Funcionario funcionario;
	private FuncionarioDAO fdao;
	
	public FuncionarioService(Funcionario funcionario){
		this.fdao = new FuncionarioDAO();
		this.funcionario = funcionario;
	}
	
	public boolean valida(){
		if(this.funcionario.getPessoa().getNome() == null){
			return false;
		}else if(this.funcionario.getPessoa().getCpf() == null){
			return false;
		}else if(this.funcionario.getPessoa().getDataNascimento() == null){
			return false;
		}else if(this.funcionario.getPessoa().getSexo() == null){
			return false;
		}else if(this.funcionario.getSalario() < 0){
			return false;
		}
		return true;
	}
	
	public void persiste(){
		if(this.valida()){
			fdao.inserir(this.funcionario);
		}
	}
	
	
}
