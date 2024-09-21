package me.dio.banco;

public class ContaCorrente extends Conta{

	public ContaCorrente(int numero, String agencia, double saldo, Cliente cliente) {
		super(numero, agencia, saldo, cliente);
		
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
		
	}

	@Override
	public void sacar(double valor) {
		if(valor >= saldo) {
			saldo -= valor;
		} else {
			System.out.println("Saldo insuficiente para o saque: " + valor);
		}
		
	}

	@Override
	public void transferir(double valor, Conta destino) {
		if (valor <= saldo) {
            this.sacar(valor); 
            destino.depositar(valor); 
        } else {
            System.out.println("Saldo insuficiente para realizar a transferência: " + valor);
        }
		
		
	}

}
