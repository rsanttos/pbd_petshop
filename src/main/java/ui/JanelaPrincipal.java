package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JanelaPrincipal extends JFrame {

	private JPanel panel;
	public JanelaPrincipal() {

		this.panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panel.setLayout(new GridLayout(5, 4, 5, 5));
		this.setResizable(true);
		this.setVisible(true);
		initUI();
	}

	public void initUI() {

		String[] buttons = { "", "Sair do sistema", "Cadastrar Funcionario", "Cadastrar Dono de Animal",
				"Realizar venda", "Listar produtos", "Listar Servicos", "Donos cadastrados",
				"Funcionarios cadastrados" };

		for (int i = 0; i < buttons.length; i++) {

			if (i == 0) {
				this.panel.add(new JLabel(buttons[i]));
			} else if (i == 1) {
				JButton botaosair = new JButton(buttons[i]);
				botaosair.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						System.exit(0);
					}
				});
				panel.add(botaosair);
			} else if (i == 2) {
				JButton botaocadastrarfuncionario = new JButton(buttons[i]);
				botaocadastrarfuncionario.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						new CadastroFuncionario();
					}
				});
				panel.add(botaocadastrarfuncionario);
			} else if (i == 3) {
				JButton botaocadastrardono = new JButton(buttons[i]);
				botaocadastrardono.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						new CadastroDono();
					}
				});
				panel.add(botaocadastrardono);
			} else if (i == 4) {
				JButton botaovenda = new JButton(buttons[i]);
				botaovenda.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						new RealizaVenda();
					}
				});
				panel.add(botaovenda);
			} else if (i == 5) {
				JButton botaolistaprodutos = new JButton(buttons[i]);
				botaolistaprodutos.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						new ListaProdutos();
					}
				});
				panel.add(botaolistaprodutos);
			} else if (i == 6) {
				JButton botaolistaservicos = new JButton(buttons[i]);
				botaolistaservicos.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						new ListaServicos();
					}
				});
				panel.add(botaolistaservicos);
			} else if (i == 7) {
				JButton botaolistadonos = new JButton(buttons[i]);
				botaolistadonos.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						new ListaDonos();
					}
				});
				panel.add(botaolistadonos);
			} else if (i == 8) {
				JButton botaolistafuncionarios = new JButton(buttons[i]);
				botaolistafuncionarios.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						new ListaFuncionarios();
					}
				});
				panel.add(botaolistafuncionarios);
			}else{
				panel.add(new JButton(buttons[i]));
			}
		}

		add(panel);

		setTitle("PetShop");
		setSize(500, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
}
