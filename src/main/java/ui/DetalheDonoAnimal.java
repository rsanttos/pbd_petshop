package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.DonoAnimal;
import model.Pessoa;
import services.DonoAnimalService;

public class DetalheDonoAnimal extends JFrame {
	private static JButton botaosair;
	private static JButton botaocadastrar;
	private static JPanel painel;
	
	private DonoAnimal donoanimal;

	public DetalheDonoAnimal() {
		this.donoanimal = new DonoAnimal();
		painel = new JPanel();
		painel.setLayout(new GridLayout(0, 2));
	
		criaForm();
		
		this.add(painel);
		this.setTitle("PetShop - Atualização de clientes");
		this.setSize(700, 600);
		this.setResizable(true);
		this.setVisible(true);		
		this.pack();
		this.setLocationRelativeTo(null);
	}

	public DetalheDonoAnimal(DonoAnimal donoanimal) {
		painel = new JPanel();
		painel.setLayout(new GridLayout(0, 2));
		
		this.donoanimal = donoanimal;
	
		criaForm();
		
		this.add(painel);
		this.setTitle("PetShop - Atualização de clientes");
		this.setSize(700, 600);
		this.setResizable(true);
		this.setVisible(true);		
		this.pack();
		this.setLocationRelativeTo(null);
	}
	
	private void criaForm() {

		JLabel lnome = new JLabel("Nome: \n");
		lnome.setBounds(10, 10, 80, 25);
		painel.add(lnome);

		final JTextField tfnome = new JTextField(15);
		tfnome.setBounds(100, 10, 160, 25);
		tfnome.setText(this.donoanimal.getPessoa().getNome());
		painel.add(tfnome);

		JLabel lcpf = new JLabel("CPF: ");
		lcpf.setBounds(10, 10, 80, 25);
		painel.add(lcpf);

		final JTextField tfcpf = new JTextField(15);	
		tfcpf.setBounds(100, 10, 160, 25);
		tfcpf.setText(this.donoanimal.getPessoa().getCpf());
		painel.add(tfcpf);

		JLabel ldatanascimento = new JLabel("Data de nascimento: ");
		ldatanascimento.setBounds(10, 10, 80, 25);
		painel.add(ldatanascimento);

		final JTextField tfdatanascimento = new JTextField(15);
		tfdatanascimento.setBounds(100, 10, 160, 25);
		tfdatanascimento.setText(String.valueOf(this.donoanimal.getPessoa().getDataNascimento()));
		painel.add(tfdatanascimento);

		JLabel lsexo = new JLabel("Sexo: ");
		lsexo.setBounds(10, 10, 80, 25);
		painel.add(lsexo);

		final JTextField tfsexo = new JTextField(15);
		tfsexo.setBounds(100, 10, 160, 25);
		tfsexo.setText(this.donoanimal.getPessoa().getSexo());
		painel.add(tfsexo);	

		JLabel ldatacadastro = new JLabel("Data de cadastro: ");
		ldatacadastro.setBounds(10, 10, 80, 25);
		painel.add(ldatacadastro);

		final JTextField tfdatacadastro = new JTextField(15);
		tfdatacadastro.setBounds(100, 10, 160, 25);
		tfdatacadastro.setText(String.valueOf(this.donoanimal.getDataCadastro()));
		tfdatacadastro.setEditable(false);
		painel.add(tfdatacadastro);

		botaocadastrar = new JButton("Atualizar");
		botaocadastrar.setBounds(10, 80, 80, 25);		
		botaocadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
/*				Pessoa novapessoa = new Pessoa();
				DonoAnimal novodono = new DonoAnimal();
				novapessoa.setNome(tfnome.getText());
				novapessoa.setCpf(tfcpf.getText());
				try {
					novapessoa.setDataNascimento( sdf.parse(tfdatanascimento.getText() ));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				novapessoa.setSexo(tfsexo.getText());
				novodono.setPessoa(novapessoa);*/
				DonoAnimalService donoservice = new DonoAnimalService(donoanimal);
				JOptionPane.showMessageDialog(null, donoservice.atualiza());
			}
		});
		painel.add(botaocadastrar);
		
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
