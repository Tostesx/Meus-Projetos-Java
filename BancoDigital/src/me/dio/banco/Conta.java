package me.dio.banco;

public abstract class Conta{
	protected int numero;
	protected String agencia;
	protected double saldo;
	protected Cliente cliente;
	
	public Conta(int numero, String agencia, double saldo, Cliente cliente) {
		super();
		this.numero = numero;
		this.agencia = agencia;
		this.saldo = saldo;
		this.cliente = cliente;
	}
	
	public abstract void depositar(double valor);
	public abstract void sacar(double valor);
	public abstract void transferir(double valor, Conta destino);

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

}
