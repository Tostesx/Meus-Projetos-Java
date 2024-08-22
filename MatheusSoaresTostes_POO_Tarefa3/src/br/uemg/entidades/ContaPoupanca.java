package br.uemg.entidades;

public class ContaPoupanca extends ContaBancaria{
	private int diaRendimento;

	/**
	 * @param cliente
	 * @param num_conta
	 * @param saldo
	 */
	public ContaPoupanca(String cliente, int num_conta, float saldo, int diaRendimento) {
		super(cliente, num_conta, saldo);
		this.diaRendimento = diaRendimento;
	}

	public void calcularNovoSaldo(float taxaRendimento) {
		float novoSaldo = getSaldo() + (getSaldo() * taxaRendimento);
		depositar(novoSaldo - getSaldo());
	}
	
	 @Override
	    public void mostrarDados() {
	        super.mostrarDados();
	        System.out.println("Dia de Rendimento: " + diaRendimento + "\n");
	    }
	 
	

}
