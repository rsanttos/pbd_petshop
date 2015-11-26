package main;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;

import org.hibernate.mapping.List;

import dao.DonoAnimalDAO;
import dao.FuncionarioDAO;
import dao.InterceptorPadraoDAO;
import dao.PessoaDAO;
import dao.ProdutoDAO;
import dao.ServicoDAO;
import dao.VendaDAO;
import model.DonoAnimal;
import model.Funcionario;
import model.Pessoa;

public class Principal {

	public static void main(String[] args) throws ParseException {
		
		Calendar data = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		

		PessoaDAO pdao = new PessoaDAO();
		FuncionarioDAO fdao = new FuncionarioDAO();
		DonoAnimalDAO donodao = new DonoAnimalDAO();
		VendaDAO vdao = new VendaDAO();
		ServicoDAO sdao = new ServicoDAO();
		ProdutoDAO produtodao = new ProdutoDAO();
		InterceptorPadraoDAO ipdao = new InterceptorPadraoDAO();
		
		Pessoa p = new Pessoa();
		p.setNome("Ramon");
		p.setSexo("H");
		p.setCpf("11111111");
		Funcionario f = new Funcionario();
		f.setSalario(2000);
		f.setPessoa(p);
		p.setFuncionarios(Collections.singleton(f));
//		p.getFuncionarios().add(f);
		
		Pessoa p2 = new Pessoa();
		p2.setNome("Jose");
		p2.setSexo("H");
		p2.setCpf("0000000");
		DonoAnimal dono = new DonoAnimal();
		dono.setDataCadastro(sdf.parse("11/11/2015"));
		dono.setPessoa(p);
		p2.setDonos(Collections.singleton(dono));
//		p.getDonos().add(dono);

		
		fdao.inserir(f);
		donodao.inserir(dono);
		pdao.inserir(p);
		pdao.inserir(p2);
		
	}

}
