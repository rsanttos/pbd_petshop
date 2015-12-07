package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Produto;
import services.ProdutoService;

public class DetalheProduto extends JFrame {
	private static JButton botaosair;
	private static JButton botaoatualizar;
	private static JPanel painel;
	
	private Produto produto;
	
	public DetalheProduto(){
		this.produto = new Produto();
		painel = new JPanel();
		painel.setLayout(new GridLayout(0, 2));
		
		criaForm();
		
		this.add(painel);
		this.setTitle("PetShop - Atualização de produtos");
		this.setSize(700, 600);
		this.setResizable(true);
		this.setVisible(true);		
		this.pack();
		this.setLocationRelativeTo(null);
		
	}
	
	public DetalheProduto(Produto produto){
		painel = new JPanel();
		painel.setLayout(new GridLayout(0, 2));
		
		this.produto = produto;
		
		criaForm();
		
		this.add(painel);
		this.setTitle("PetShop - Atualização de produtos");
		this.setSize(700, 600);
		this.setResizable(true);
		this.setVisible(true);		
		this.pack();
		this.setLocationRelativeTo(null);
		
	}
	
	private void criaForm() {

		JLabel ldescricao = new JLabel("Descricao: \n");
		ldescricao.setBounds(10, 10, 80, 25);
		painel.add(ldescricao);

		final JTextField tfdescricao = new JTextField(15);
		tfdescricao.setBounds(100, 10, 160, 25);
		tfdescricao.setText(this.produto.getDescricao());
		painel.add(tfdescricao);

		JLabel lpreco = new JLabel("Preço: ");
		lpreco.setBounds(10, 10, 80, 25);
		painel.add(lpreco);

		final JTextField tfpreco = new JTextField(15);	
		tfpreco.setBounds(100, 10, 160, 25);
		tfpreco.setText(String.valueOf(this.produto.getPreco()));
		painel.add(tfpreco);

		JLabel lquantidade = new JLabel("Quantidade: ");
		lquantidade.setBounds(10, 10, 80, 25);
		painel.add(lquantidade);

		final JTextField tfquantidade = new JTextField(15);
		tfquantidade.setBounds(100, 10, 160, 25);
		tfquantidade.setText(String.valueOf(this.produto.getQuantidade()));
		painel.add(tfquantidade);

		botaoatualizar = new JButton("Atualizar");
		botaoatualizar.setBounds(10, 80, 80, 25);		
		botaoatualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
/*				Produto novoproduto = new Produto();
				novoproduto.setDescricao(tfdescricao.getText());
				novoproduto.setPreco(Integer.valueOf(tfpreco.getText()));
				novoproduto.setQuantidade(Integer.valueOf(tfquantidade.getText()));*/
				ProdutoService produtoservice = new ProdutoService(produto);
				JOptionPane.showMessageDialog(null,produtoservice.persiste());
			}
		});
		painel.add(botaoatualizar);
		
		botaosair = new JButton("Voltar para janela principal");
		botaosair.setBounds(180, 80, 80, 25);		
		botaosair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new JanelaPrincipal();
			}
		});
		painel.add(botaosair);
	}
}
