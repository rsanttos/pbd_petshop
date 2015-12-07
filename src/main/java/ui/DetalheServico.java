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

import model.Servico;
import services.ServicoService;

public class DetalheServico extends JFrame {
	private static JButton botaosair;
	private static JButton botaoeditar;
	private static JPanel painel;
	
	private Servico servico;

	public DetalheServico() {
		this.servico = new Servico();
		painel = new JPanel();
		painel.setLayout(new GridLayout(0, 2));
		
		criaForm();

		this.add(painel);
		this.setTitle("PetShop - Cadastro de serviços");
		this.setSize(700, 600);
		this.setResizable(true);
		this.setVisible(true);
		this.pack();
		this.setLocationRelativeTo(null);
	}

	public DetalheServico(Servico servico) {
		painel = new JPanel();
		painel.setLayout(new GridLayout(0, 2));
		
		this.servico = servico;
		
		criaForm();

		this.add(painel);
		this.setTitle("PetShop - Cadastro de serviços");
		this.setSize(700, 600);
		this.setResizable(true);
		this.setVisible(true);
		this.pack();
		this.setLocationRelativeTo(null);

	}

	public void criaForm() {

		JLabel ldescricao = new JLabel("Descricao: \n");
		ldescricao.setBounds(10, 10, 80, 25);
		painel.add(ldescricao);

		final JTextField tfdescricao = new JTextField(15);
		tfdescricao.setBounds(100, 10, 160, 25);
		tfdescricao.setText(this.servico.getDescricao());
		painel.add(tfdescricao);

		JLabel lpreco = new JLabel("Preço: ");
		lpreco.setBounds(10, 10, 80, 25);
		painel.add(lpreco);

		final JTextField tfpreco = new JTextField(15);	
		tfpreco.setBounds(100, 10, 160, 25);
		tfpreco.setText(String.valueOf(this.servico.getPreco()));
		painel.add(tfpreco);
		
		botaoeditar = new JButton("Editar");
		botaoeditar.setBounds(10, 80, 80, 25);		
		botaoeditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Servico novoservico = new Servico();
				novoservico.setDescricao(tfdescricao.getText());
				novoservico.setPreco(Integer.valueOf(tfpreco.getText()));
				ServicoService servicoservice = new ServicoService(novoservico);
				JOptionPane.showMessageDialog(null, servicoservice.atualiza());
			}
		});
		painel.add(botaoeditar);
		
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
