package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import dao.DonoAnimalDAO;
import dao.FuncionarioDAO;
import dao.InterceptorPadraoDAO;
import dao.PessoaDAO;
import dao.ProdutoDAO;
import dao.ServicoDAO;
import dao.VendaDAO;
import model.DonoAnimal;
import model.Funcionario;

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
		
		Funcionario f = new Funcionario();
		f.setNome("Ramon");
		f.setSexo("homem");
		f.setCpf("11111111");
		f.setSalario(2000);
		fdao.inserir(f);
		
		DonoAnimal dono = new DonoAnimal();
		dono.setCpf("0000000");
		dono.setDataCadastro(sdf.parse("11/11/2015"));
		donodao.inserir(dono);
		
		donodao.listarPorID(26);
		
	}

}
