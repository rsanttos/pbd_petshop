package main;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import dao.AnimalDAO;
import dao.DonoAnimalDAO;
import dao.FuncionarioDAO;
import dao.InterceptorPadraoDAO;
import dao.PessoaDAO;
import dao.ProdutoDAO;
import dao.ServicoDAO;
import dao.VendaDAO;
import model.Animal;
import model.DonoAnimal;
import model.Funcionario;
import model.Pessoa;
import model.Produto;
import model.Servico;
import model.Venda;

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
		AnimalDAO adao = new AnimalDAO();
		
		Produto pr1 = new Produto();
		pr1.setDescricao("shampoo");
		pr1.setPreco(200);
		pr1.setQuantidade(10);	
		
		Servico se1 = new Servico();
		se1.setDescricao("banho");
		se1.setPreco(30);
		
		List<Produto> produtos = new ArrayList<Produto>();
		List<Servico> servicos = new ArrayList<Servico>();
		
		
		produtodao.inserir(pr1);
		sdao.inserir(se1);
		
		produtodao.atualizar(produtodao.buscaPorID(Produto
				.class, (long) 10));
		
		produtos.add(pr1);
		servicos.add(se1);
		
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
		dono.setDataCadastro(new Date());
		dono.setPessoa(p);
		p2.setDonos(Collections.singleton(dono));
//		p.getDonos().add(dono);
		
		Animal a = new Animal();
		a.setNome("animal");
		a.setRaca("pastor");
		a.setSexo("M");
		a.setDonoanimal(dono);
		
		Animal a1 = new Animal();
		a1.setIdade(10);
		a1.setNome("animal1");
		a1.setRaca("pitbull");
		a1.setSexo("F");
		a1.setTipo("CÃO");
		a1.setDonoanimal(dono);		 
		
		fdao.inserir(f);
		donodao.inserir(dono);
		adao.inserir(a);
		adao.inserir(a1);
		pdao.inserir(p);
		pdao.inserir(p2);

		Venda v = new Venda();
		v.setDataVenda(new Date());
		v.setDonoanimal(dono);
		v.setFuncionario(f);
		v.setProdutos(produtos);
		v.setServicos(servicos);
		
		vdao.inserir(v);
	}

}
