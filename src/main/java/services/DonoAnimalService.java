package services;

import java.util.Date;

import dao.DonoAnimalDAO;
import model.DonoAnimal;

public class DonoAnimalService {
	private DonoAnimal dono;
	private DonoAnimalDAO donodao;
	
	public DonoAnimalService(DonoAnimal dono){
		this.dono = dono;
		this.donodao = new DonoAnimalDAO();
	}
	
	public boolean valida(){
		if(this.dono.getPessoa().getNome() == null){
			return false;
		}else if(this.dono.getPessoa().getCpf() == null){
			return false;
		}else if(this.dono.getPessoa().getDataNascimento() == null){
			return false;
		}else if(this.dono.getPessoa().getSexo() == null){
			return false;
		}		
		return true;
	}
	
	public void persiste(){
		if(this.valida()){
			this.dono.setDataCadastro(new Date());
			donodao.inserir(this.dono);
		}
	}
}
