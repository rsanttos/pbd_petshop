package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BuscaProduto extends JFrame {
	private static JButton botaosair;
	private static JButton botaopesquisar;
	private static JPanel painel;
	
	public BuscaProduto(){
		painel = new JPanel();
		painel.setLayout(new GridLayout(0,2));
		
		criaForm();
		
		this.add(painel);
		this.setTitle("PetShop - Pesquisa por produto");
		this.setSize(700, 600);
		this.setResizable(true);
		this.setVisible(true);		
		this.pack();
		this.setLocationRelativeTo(null);
	}
	
	public static void criaForm(){
		JLabel lnome = new JLabel("Descricao: \n");
		lnome.setBounds(10, 10, 80, 25);
		painel.add(lnome);

		final JTextField tfnome = new JTextField(15);
		tfnome.setBounds(100, 10, 160, 25);
		painel.add(tfnome);
		
		botaosair = new JButton("Voltar para janela principal");
		botaosair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new JanelaPrincipal();
			}
		});
		painel.add(botaosair);
		
		botaopesquisar = new JButton("Pesquisar");
		botaopesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new ListaProdutos(tfnome.getText());
			}
		});
		painel.add(botaopesquisar);		
	}
}
