package br.uemg.principal;

import br.uemg.racas.Humano;
import br.uemg.racas.Elfo;
import br.uemg.racas.Anao;

public class Principal {
	public static void main(String[] args) {
		
		Humano h1 = new Humano("Aragorn");
		Elfo e1 = new Elfo("Legolas");
		Anao a1 = new Anao("Gimli");
		
		h1.Imprimir();
		e1.Imprimir();
		a1.Imprimir();
	}
	
	
}
