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

import model.Funcionario;
import services.FuncionarioService;

public class DetalheFuncionario extends JFrame {
	private static JButton botaosair;
	private static JButton botaocadastrar;
	private static JPanel painel;
	
	private Funcionario funcionario;

	public DetalheFuncionario() {
		this.funcionario = new Funcionario();
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

	public DetalheFuncionario(Funcionario funcionario) {
		painel = new JPanel();
		painel.setLayout(new GridLayout(0, 2));
		
		this.funcionario = funcionario;
	
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
		tfnome.setText(this.funcionario.getPessoa().getNome());
		painel.add(tfnome);

		JLabel lcpf = new JLabel("CPF: ");
		lcpf.setBounds(10, 10, 80, 25);
		painel.add(lcpf);

		final JTextField tfcpf = new JTextField(15);	
		tfcpf.setBounds(100, 10, 160, 25);
		tfcpf.setText(this.funcionario.getPessoa().getCpf());
		painel.add(tfcpf);

		JLabel ldatanascimento = new JLabel("Data de nascimento: ");
		ldatanascimento.setBounds(10, 10, 80, 25);
		painel.add(ldatanascimento);

		final JTextField tfdatanascimento = new JTextField(15);
		tfdatanascimento.setBounds(100, 10, 160, 25);
		tfdatanascimento.setText(String.valueOf(this.funcionario.getPessoa().getDataNascimento()));
		painel.add(tfdatanascimento);

		JLabel lsexo = new JLabel("Sexo: ");
		lsexo.setBounds(10, 10, 80, 25);
		painel.add(lsexo);

		final JTextField tfsexo = new JTextField(15);
		tfsexo.setBounds(100, 10, 160, 25);
		tfsexo.setText(this.funcionario.getPessoa().getSexo());
		painel.add(tfsexo);	

		JLabel lsalario = new JLabel("Salário: ");
		lsalario.setBounds(10, 10, 80, 25);
		painel.add(lsalario);

		final JTextField tfsalario = new JTextField(15);
		tfsalario.setBounds(100, 10, 160, 25);
		tfsalario.setText(String.valueOf(this.funcionario.getSalario()));
		painel.add(tfsalario);

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
				FuncionarioService funcionarioservice = new FuncionarioService(funcionario);
				JOptionPane.showMessageDialog(null, funcionarioservice.atualiza());
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
