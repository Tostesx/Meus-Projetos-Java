package br.uemg.pacote;

import javax.swing.JFrame;

public class QuadroJogo extends JFrame {
	
	QuadroJogo(){
		this.add(new PainelJogo());
		this.setTitle("Cobrinha");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

}
