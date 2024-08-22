package br.uemg.contagem;

public class Contagem {
	private int valor;
	
	public Contagem(int valorInicial) {
		this.valor = valorInicial;
	}
	
	public void zeraValor() {
		this.valor = 0;
	}
	
	public void incrementaValor() {
		this.valor++;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	

}
