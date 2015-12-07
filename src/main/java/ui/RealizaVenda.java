package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import services.ProdutoService;
import services.ServicoService;

public class RealizaVenda extends JFrame {
	private static JButton botaosair;
	private static JButton botaovenda;
	private static JPanel painel;
	
	private static JComboBox<String> opcoes_produtos;
	private static JComboBox<String> opcoes_servicos;
	
	private static ProdutoService produtoservice;
	private static ServicoService servicoservice;

	public RealizaVenda() {
		produtoservice = new ProdutoService();
		servicoservice = new ServicoService();
		
		painel = new JPanel();
		painel.setLayout(new GridLayout(3, 4));
		
		opcoes_produtos = new JComboBox<String>();
		opcoes_servicos = new JComboBox<String>();

		criaForm();
		
		this.add(this.painel);
		this.setSize(700, 600);
		this.setResizable(true);
		this.setVisible(true);		
		this.pack();
		this.setLocationRelativeTo(null);
	}
	
	public static void criaForm(){		
		JLabel ldescproduto = new JLabel("Escolha o produto: \n");
		ldescproduto.setBounds(10, 10, 80, 25);
		painel.add(ldescproduto);
		
		opcoes_produtos = new JComboBox<String>();
		List<String> lista_nomesprodutos = produtoservice.recebeNomesProdutos();
		for(String s : lista_nomesprodutos){
			opcoes_produtos.addItem(s);		
		}
		opcoes_produtos.insertItemAt("", 0);
		opcoes_produtos.setMaximumRowCount(7);
		painel.add(opcoes_produtos);		
		
		JLabel lproduto = new JLabel("Quantidade do produto: \n");
		lproduto.setBounds(10, 10, 80, 25);
		painel.add(lproduto);

		final JTextField tfproduto = new JTextField(15);
		tfproduto.setBounds(100, 10, 160, 25);
		painel.add(tfproduto);
		
		JLabel ldescservico = new JLabel("Escolha o serviço: \n");
		ldescservico.setBounds(10, 10, 80, 25);
		painel.add(ldescservico);
		
		opcoes_servicos = new JComboBox<String>();
		List<String> lista_nomesservicos = servicoservice.recebeNomesServicos();
		for(String s : lista_nomesservicos){
			opcoes_servicos.addItem(s);		
		}
		opcoes_servicos.insertItemAt("", 0);
		opcoes_servicos.setMaximumRowCount(7);
		painel.add(opcoes_servicos);
		
		JLabel lcpf = new JLabel("CPF do cliente: \n");
		lcpf.setBounds(10, 10, 80, 25);
		painel.add(lcpf);

		final JTextField tfcpf = new JTextField(15);
		tfcpf.setBounds(100, 10, 160, 25);
		painel.add(tfcpf);		
		
		botaosair = new JButton("Voltar para janela principal");
		botaosair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new JanelaPrincipal();
			}
		});
		painel.add(botaosair);
		
		botaovenda = new JButton("Finalizar venda");
		botaovenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new JanelaPrincipal();
			}
		});
		painel.add(botaovenda);		
	}
}
