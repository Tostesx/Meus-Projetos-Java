package br.uemg.contagem;


public class UsaContagem{

	public static void main(String[] args) {
		Contagem c1 = new Contagem(10);
		
		System.out.println("Valor do contador padrão: " + c1.getValor());
		c1.incrementaValor();
		System.out.println("Valor do contador após incremento: " + c1.getValor());
		c1.zeraValor();
		System.out.println("Valor do contador após zerar: " + c1.getValor());
		c1.setValor(25);
		System.out.println("Valor do contador após novo valor: " + c1.getValor());

		
	}

}
