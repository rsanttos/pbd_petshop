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

public class PersisteBanco {
	public static void main(String[] args) throws ParseException {
		
		Calendar data = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Produto> produtos = new ArrayList<Produto>();
		List<Servico> servicos = new ArrayList<Servico>();
		
		PessoaDAO pdao = new PessoaDAO();
		FuncionarioDAO fdao = new FuncionarioDAO();
		DonoAnimalDAO donodao = new DonoAnimalDAO();
		VendaDAO vdao = new VendaDAO();
		ServicoDAO sdao = new ServicoDAO();
		ProdutoDAO produtodao = new ProdutoDAO();
		AnimalDAO adao = new AnimalDAO();
	
		Produto pr1 = new Produto();
		pr1.setDescricao("shampoo");
		pr1.setPreco(200);
		pr1.setQuantidade(10);	
		Produto pr2 = new Produto();
		pr2.setDescricao("carrapaticida");
		pr2.setPreco(50);
		pr2.setQuantidade(10);	
		Produto pr3 = new Produto();
		pr3.setDescricao("vacina");
		pr3.setPreco(60);
		pr3.setQuantidade(10);
		pr3.setQuantidade(10);	
		Produto pr4 = new Produto();
		pr4.setDescricao("coleira");
		pr4.setPreco(12);
		pr4.setQuantidade(10);	
		Produto pr5 = new Produto();
		pr5.setDescricao("Ração para cães");
		pr5.setPreco(150);
		pr5.setQuantidade(10);	
		Produto pr6 = new Produto();
		pr6.setDescricao("Ração para gatos");
		pr6.setPreco(50);
		pr6.setQuantidade(10);	
		
		produtos.add(pr1);
		produtos.add(pr2);
		produtos.add(pr3);
		produtos.add(pr4);
		produtos.add(pr5);
		produtos.add(pr6);
		
		Servico se1 = new Servico();
		se1.setDescricao("banho");
		se1.setPreco(30);
		Servico se2 = new Servico();
		se2.setDescricao("tosa");
		se2.setPreco(30);
		Servico se3 = new Servico();
		se3.setDescricao("consulta");
		se3.setPreco(30);
		
		servicos.add(se1);
		servicos.add(se2);
		servicos.add(se3);
		
		produtodao.inserir(pr1);
		produtodao.inserir(pr2);
		produtodao.inserir(pr3);
		produtodao.inserir(pr4);
		produtodao.inserir(pr5);
		produtodao.inserir(pr6);
		
		sdao.inserir(se1);
		sdao.inserir(se2);
		sdao.inserir(se3);
		
		Pessoa p = new Pessoa();
		p.setNome("Ramon Santos");
		p.setSexo("H");
		p.setCpf("10904368408"); 
		Funcionario f = new Funcionario();
		f.setSalario(2000);
		f.setPessoa(p);
		p.setFuncionarios(Collections.singleton(f));		
		
		
		Pessoa p1 = new Pessoa();
		p1.setNome("Victor Vilar");
		p1.setSexo("H");
		p1.setCpf("08294058400"); 
		Funcionario f1 = new Funcionario();
		f1.setSalario(1000);
		f1.setPessoa(p1);
		p1.setFuncionarios(Collections.singleton(f));
		
		Pessoa p2 = new Pessoa();
		p2.setNome("Cephas Barreto");
		p2.setSexo("H");
		p2.setCpf("10904368408"); 
		Funcionario f2 = new Funcionario();
		f2.setSalario(3000);
		f2.setPessoa(p2);
		p2.setFuncionarios(Collections.singleton(f));
		
		fdao.inserir(f);
		fdao.inserir(f1);
		fdao.inserir(f2);
		
		Pessoa p3 = new Pessoa();
		p3.setNome("João Carlos");
		p3.setSexo("H");
		p3.setCpf("95847136295");
		DonoAnimal dono = new DonoAnimal();
		dono.setDataCadastro(new Date());
		dono.setPessoa(p3);
		p3.setDonos(Collections.singleton(dono));

		Pessoa p4 = new Pessoa();
		p4.setNome("João Carlos");
		p4.setSexo("H");
		p4.setCpf("95847136295");
		DonoAnimal dono1 = new DonoAnimal();
		dono1.setDataCadastro(new Date());
		dono1.setPessoa(p4);
		p4.setDonos(Collections.singleton(dono1));
		

		Pessoa p5 = new Pessoa();
		p5.setNome("Rafael Sonhador");
		p5.setSexo("H");
		p5.setCpf("74812564953");
		DonoAnimal dono2 = new DonoAnimal();
		dono2.setDataCadastro(new Date());
		dono2.setPessoa(p5);
		p5.setDonos(Collections.singleton(dono2));
		

		Pessoa p6 = new Pessoa();
		p6.setNome("Jeffersson Galvão");
		p6.setSexo("H");
		p6.setCpf("74812564953");
		DonoAnimal dono3 = new DonoAnimal();
		dono3.setDataCadastro(new Date());
		dono3.setPessoa(p6);
		p5.setDonos(Collections.singleton(dono3));
		
		donodao.inserir(dono);
		donodao.inserir(dono1);
		donodao.inserir(dono2);
		donodao.inserir(dono3);
		
		
		Animal a = new Animal();
		a.setNome("Rex");
		a.setRaca("pastor");
		a.setSexo("M");
		a.setDonoanimal(dono);

		Animal a1 = new Animal();
		a1.setNome("Ted");
		a1.setRaca("viralata");
		a1.setSexo("F");
		a1.setDonoanimal(dono);

		Animal a2 = new Animal();
		a2.setNome("Bob");
		a2.setRaca("viralata");
		a2.setSexo("F");
		a2.setDonoanimal(dono1);
		
		Animal a3 = new Animal();
		a3.setNome("Totó");
		a3.setRaca("huskysiberiano");
		a3.setSexo("M");
		a3.setDonoanimal(dono2);
		
		adao.inserir(a);
		adao.inserir(a1);
		adao.inserir(a2);
		adao.inserir(a3);
		

		Venda v = new Venda();
		v.setDataVenda(new Date());
		v.setDonoanimal(dono);
		v.setFuncionario(f);
		v.setProdutos(produtos);
		v.setServicos(servicos);
		
		vdao.inserir(v);
	}
}
