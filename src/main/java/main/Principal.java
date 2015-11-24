package main;

import java.util.Calendar;

import dao.GenericDAO;
import model.Contato;
import model.Funcionario;

public class Principal {

	public static void main(String[] args) {
		
		Calendar data = Calendar.getInstance();
		GenericDAO gdao = new GenericDAO();
		
		Contato c = new Contato();
        c.setNome("Ningu�m Sabe!!!!");
        c.setTelefone("8888-3333");
        c.setDataNascimento(data.getTime());
		gdao.inserir(c);
		
		Funcionario f = new Funcionario();
		f.setNome("Ramon");
		f.setSexo("homem");
		f.setCpf("11111111");
		f.setSalario(2000);
		gdao.inserir(f);
		
	}

}
