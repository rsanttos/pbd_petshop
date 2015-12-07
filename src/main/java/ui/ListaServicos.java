package ui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingUtilities;

import dao.ServicoDAO;

public class ListaServicos extends JFrame {
	private JButton botaosair;
	private JButton botaoeditar;
	private JButton botaopesquisar;
	private JPanel painel;
	private JLabel label;
	private JScrollPane scrollpane;
	private JTable table;
	private GroupLayout grouplayout;
    private int linhaSelecionada;

	private static TMListaServicos modelo;

	public ListaServicos() {
		this.painel = new JPanel();
		this.label = new JLabel();
		this.table = new JTable();
		this.scrollpane = new JScrollPane();
		this.grouplayout = new GroupLayout(painel);
		this.linhaSelecionada = -1;
		
		
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
				new BuscaServico();
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
		ServicoDAO sdao = new ServicoDAO();
		modelo = new TMListaServicos(sdao.listar());
		this.table.setModel(modelo);
		
		
		this.table.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		linhaSelecionada = table.getSelectedRow();
        		
        		Point p = e.getPoint();
        		if (e.getClickCount() == 2) {
        			System.out.println(linhaSelecionada);
        			
        			Container container = SwingUtilities.getAncestorOfClass(JDesktopPane.class, (Component)e.getSource());

                    if (container != null)
                    {
                        JRootPane desktopPane = getRootPane();
                        DetalheServico jdp = new DetalheServico(modelo.getServico(linhaSelecionada));
                        desktopPane.add(jdp);//add f1 to desktop pane
                        jdp.setResizable(true);
            			jdp.pack();
            			jdp.setVisible(true);
                        ;
                       /* Dimension desktopSize = getDesktopPane().getSize();
                        f1.setSize(desktopSize);
                        f1.setPreferredSize(desktopSize);
                        MainClass.dontmoveframe();*/
                    } 
        			
        			
                    DetalheServico jdp = new DetalheServico(modelo.getServico(linhaSelecionada));
        			
        		}
        	}
        });
		

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
		
		
		// *************************************************************************************************************************************** //
		
		this.setTitle("PetShop - Listagem de serviços");
		this.setSize(700, 600);
		this.setResizable(true);
		this.setVisible(true);
	}
	public ListaServicos(String nome) {
		this.painel = new JPanel();
		this.label = new JLabel();
		this.table = new JTable();
		this.scrollpane = new JScrollPane();
		this.grouplayout = new GroupLayout(painel);
		this.linhaSelecionada = -1;
		
		
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
				new BuscaServico();
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
		ServicoDAO sdao = new ServicoDAO();
		modelo = new TMListaServicos(sdao.listarPorDescricao(nome));
		this.table.setModel(modelo);
		
		
		this.table.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		linhaSelecionada = table.getSelectedRow();
        		
        		Point p = e.getPoint();
        		if (e.getClickCount() == 2) {
        			System.out.println(linhaSelecionada);
        			
        			Container container = SwingUtilities.getAncestorOfClass(JDesktopPane.class, (Component)e.getSource());

                    if (container != null)
                    {
                        JRootPane desktopPane = getRootPane();
                        DetalheServico jdp = new DetalheServico(modelo.getServico(linhaSelecionada));
                        desktopPane.add(jdp);//add f1 to desktop pane
                        jdp.setResizable(true);
            			jdp.pack();
            			jdp.setVisible(true);
                        ;
                       /* Dimension desktopSize = getDesktopPane().getSize();
                        f1.setSize(desktopSize);
                        f1.setPreferredSize(desktopSize);
                        MainClass.dontmoveframe();*/
                    } 
        			
        			
                    DetalheServico jdp = new DetalheServico(modelo.getServico(linhaSelecionada));
        			
        		}
        	}
        });
		

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
		
		
		// *************************************************************************************************************************************** //
		
		this.setTitle("PetShop - Listagem de serviços");
		this.setSize(700, 600);
		this.setResizable(true);
		this.setVisible(true);
	}
}
