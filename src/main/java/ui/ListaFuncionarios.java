package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;

import dao.FuncionarioDAO;

public class ListaFuncionarios extends JFrame {
	private JButton botaosair;
	private JButton botaoeditar;
	private JButton botaopesquisar;
	private JPanel painel;
	private JLabel label;
	private JScrollPane scrollpane;
	private JTable table;
	private GroupLayout grouplayout;
	
	private static TMListaFuncionarios modelo;

	public ListaFuncionarios() {
		this.painel = new JPanel();
		this.label = new JLabel();
		this.table = new JTable();
		this.scrollpane = new JScrollPane();
		this.grouplayout = new GroupLayout(painel);
		
		
		this.botaosair = new JButton("Voltar para janela principal");
		this.botaosair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new JanelaPrincipal();
			}
		});
		
		this.botaoeditar = new JButton("Editar");
		this.botaoeditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new JanelaPrincipal();
			}
		});
		this.botaopesquisar = new JButton("Pesquisar");
		this.botaopesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new BuscaFuncionario();
			}
		});
		
		this.painel.setLayout(grouplayout);
		this.grouplayout.setHorizontalGroup(
				this.grouplayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(this.label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        );
		this.grouplayout.setVerticalGroup(
				this.grouplayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(this.grouplayout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(this.label)
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
		FuncionarioDAO fdao = new FuncionarioDAO();
		modelo = new TMListaFuncionarios(fdao.listar());
		this.table.setModel(modelo);

		this.table.setColumnSelectionAllowed(true);
		this.scrollpane.setViewportView(this.table);
        if (this.table.getColumnModel().getColumnCount() > 0) {
        	this.table.getColumnModel().getColumn(0).setMinWidth(0);
        	this.table.getColumnModel().getColumn(0).setPreferredWidth(0);
        	this.table.getColumnModel().getColumn(0).setMaxWidth(0);
        }
        this.table.setVisible(true);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addComponent(this.painel, GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
        		.addComponent(this.scrollpane, GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(484, Short.MAX_VALUE)
        			.addComponent(this.botaosair)
        			.addGap(18)
        			.addComponent(this.botaoeditar)
        			.addGap(18)
        			.addComponent(this.botaopesquisar)
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(this.painel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(this.scrollpane, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(this.botaosair)
        				.addComponent(this.botaoeditar)
        				.addComponent(this.botaopesquisar))
        			.addContainerGap(31, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
        
        // ******************************************************************************* //
		
		this.add(this.painel);
		this.setTitle("PetShop - Listagem de funcionarios");
		this.setSize(700, 600);
		this.setResizable(true);
		this.setVisible(true);
	}
	
	public ListaFuncionarios(String nome) {
		this.painel = new JPanel();
		this.label = new JLabel();
		this.table = new JTable();
		this.scrollpane = new JScrollPane();
		this.grouplayout = new GroupLayout(painel);
		
		this.botaosair = new JButton("Voltar para janela principal");
		this.botaosair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new JanelaPrincipal();
			}
		});	
		
		this.botaoeditar = new JButton("Editar");
		this.botaoeditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new JanelaPrincipal();
			}
		});
		this.botaopesquisar = new JButton("Pesquisar");
		this.botaopesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new BuscaFuncionario();
			}
		});
		
		this.painel.setLayout(grouplayout);
		this.grouplayout.setHorizontalGroup(
				this.grouplayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(this.label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        );
		this.grouplayout.setVerticalGroup(
				this.grouplayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(this.grouplayout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(this.label)
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
		FuncionarioDAO fdao = new FuncionarioDAO();
		modelo = new TMListaFuncionarios(fdao.listarPorNome(nome));
		this.table.setModel(modelo);

		this.table.setColumnSelectionAllowed(true);
		this.scrollpane.setViewportView(this.table);
        if (this.table.getColumnModel().getColumnCount() > 0) {
        	this.table.getColumnModel().getColumn(0).setMinWidth(0);
        	this.table.getColumnModel().getColumn(0).setPreferredWidth(0);
        	this.table.getColumnModel().getColumn(0).setMaxWidth(0);
        }
        this.table.setVisible(true);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addComponent(this.painel, GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
        		.addComponent(this.scrollpane, GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(484, Short.MAX_VALUE)
        			.addComponent(this.botaosair)
        			.addGap(18)
        			.addComponent(this.botaoeditar)
        			.addGap(18)
        			.addComponent(this.botaopesquisar)
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(this.painel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(this.scrollpane, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(this.botaosair)
        				.addComponent(this.botaoeditar)
    					.addComponent(this.botaopesquisar))
        			.addContainerGap(31, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
        
        // ******************************************************************************* //
		
		this.add(this.painel);
		this.setTitle("PetShop - Listagem de funcionarios");
		this.setSize(700, 600);
		this.setResizable(true);
		this.setVisible(true);
	}	
	
}
