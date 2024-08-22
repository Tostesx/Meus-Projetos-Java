package br.uemg.entidades;

public class ContaEspecial extends ContaBancaria{
	private float limite;

	/**
 	* @param cliente
 	* @param num_conta
 	* @param saldo
 	*/
	public ContaEspecial(String cliente, int num_conta, float saldo, float limite) {
		super(cliente, num_conta, saldo);
		this.limite = limite;
}

	@Override
	public boolean sacar(float valor) {
	    if (valor > 0 && valor <= (getSaldo() + limite)) {
	        saldo -= valor;
	        if (saldo < 0) {
	            limite += saldo; // Reduz o limite pelo valor que o saldo ficou negativo
	            saldo = 0; // O saldo não pode ficar negativo
	        }
	        return true;
	    }
	    System.out.println("\nNão foi possível fazer esta operação: Sem saldo e limite suficiente!");
	    return false;
	}
	@Override
    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("Limite: " + limite + "/n");
    }
}
