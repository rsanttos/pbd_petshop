package services;

import dao.ServicoDAO;
import model.Servico;

public class ServicoService {
	private Servico servico;
	private ServicoDAO sdao;
	
	public ServicoService(Servico servico){
		this.servico = servico;
		this.sdao = new ServicoDAO();
	}
	
	public boolean valida(){
		if(this.servico.getDescricao() == null){
			return false;
		}else if(this.servico.getPreco() < 0){
			return false;
		}
		return true;
	}
	
	public void persiste(){
		if(valida()){
			sdao.inserir(this.servico);
		}
	}
}
