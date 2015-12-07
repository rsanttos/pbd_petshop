package main;


import java.text.ParseException;

import javax.swing.SwingUtilities;

import ui.JanelaPrincipal;

public class Principal {

	public static void main(String[] args) throws ParseException {
	
		SwingUtilities.invokeLater(new Runnable() {

            public void run() {
            	JanelaPrincipal ex = new JanelaPrincipal();
                ex.setVisible(true);
            }
        });
	}

}
