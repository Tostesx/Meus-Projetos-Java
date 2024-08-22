package br.uemg.entidades;

public abstract class ContaBancaria {
	private String cliente;
	private int num_conta;
	protected float saldo;
	
	public ContaBancaria(String cliente, int num_conta, float saldo) {
		super();
		this.cliente = cliente;
		this.num_conta = num_conta;
		this.saldo = saldo;
	}
	
	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public int getNum_conta() {
		return num_conta;
	}

	public void setNum_conta(int num_conta) {
		this.num_conta = num_conta;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public void depositar(float valor) {
		if(valor > 0) {
			saldo += valor;
		}
	}
	
	public boolean sacar(float valor) {
	    if (valor > 0 && valor <= saldo) {
	        saldo -= valor;
	        return true;
	    }
	    System.out.println("Não foi possível fazer esta operação: Sem saldo suficiente!");
	    return false;
	}
	public void mostrarDados(){
		System.out.println("Cliente: " + cliente);
		System.out.println("número da conta: " + num_conta);
		System.out.println("Saldo: " + saldo);
	}

}
