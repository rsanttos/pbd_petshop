package ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ListaDonos extends JFrame {
	private JButton botaosair;
	private JButton botaocadastrar;
	private JPanel painel;

	public ListaDonos() {
		this.painel = new JPanel();
		this.painel.setLayout(new FlowLayout());
		this.botaosair = new JButton("Voltar para janela principal");
		this.botaosair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new JanelaPrincipal();
			}
		});
		painel.add(this.botaosair);
		
		this.botaocadastrar = new JButton("Cadastrar");
		this.botaocadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new JanelaPrincipal();
			}
		});
		painel.add(botaocadastrar);		
		
		this.add(this.painel);
		this.setSize(700, 600);
		this.setResizable(true);
		this.setVisible(true);
	}
}
