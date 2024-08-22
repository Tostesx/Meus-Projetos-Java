package br.uemg.aplicacao;

import br.uemg.entidades.ContaBancaria;
import br.uemg.entidades.ContaPoupanca;
import br.uemg.entidades.ContaEspecial;


public class UsaContas {

	public static void main(String[] args) {
		//Conta Poupança
        ContaPoupanca p1 = new ContaPoupanca("Matheus Tostes", 1234, 5200.0f, 10);
        //Conta Especial
        ContaEspecial esp1 = new ContaEspecial("Mauro Hemerly", 5678, 13000.0f, 500.0f);

        // Sacar e Depositar na Poupança
        p1.sacar(5200.0f);
        p1.depositar(0.0f);

        // Novo saldo da poupança
        p1.calcularNovoSaldo(0.01f); // 1% de rendimento

        // Dados da Poupança
        System.out.println("Dados da Conta Poupança:");
        p1.mostrarDados();
        

        // Sacar e Depositar na Conta Especial
        esp1.sacar(13500.0f); // Permitir até o limite
        esp1.depositar(300.0f);

        // Dados da Conta Especial
        System.out.println("Dados da Conta Especial:");
        esp1.mostrarDados();
	}

}
