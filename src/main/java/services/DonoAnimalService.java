package services;

import java.util.Date;

import dao.DonoAnimalDAO;
import model.DonoAnimal;
import model.Produto;

public class DonoAnimalService {
	private DonoAnimal dono;
	private DonoAnimalDAO donodao;
	
	private static String mensagemErro;
	private static String mensagemOk;
	
	public DonoAnimalService(DonoAnimal dono){
		this.dono = dono;
		this.donodao = new DonoAnimalDAO();
		
		mensagemErro = "Todos os campos devem ser preenchidos.";
		mensagemOk = "O dono foi cadastrado!";
	}
	
	public String valida(){
		if(this.dono.getPessoa().getNome() == null || this.dono.getPessoa().getNome() == ""){
			return mensagemErro;
		}else if(this.dono.getPessoa().getCpf() == null || this.dono.getPessoa().getCpf() == ""){
			return mensagemErro;
		}else if(this.dono.getPessoa().getDataNascimento() == null){
			return mensagemErro;
		}else if(this.dono.getPessoa().getSexo() == null || this.dono.getPessoa().getSexo() == ""){
			return mensagemErro;
		}		
		return mensagemOk;
	}
	
	public String persiste(){
		String mensagem = this.valida();
		if(mensagem == mensagemOk){
			this.dono.setDataCadastro(new Date());
			donodao.inserir(this.dono);
			return mensagem;
		}else{
			return mensagem;
		}
	}
	
	public String atualiza(){
		DonoAnimal p = this.dono;
		String mensagem = this.valida();
		if(mensagem == mensagemOk){
			donodao.atualizar(p);
			return mensagem;
		}else{
			return mensagem;
		}
	}
}
