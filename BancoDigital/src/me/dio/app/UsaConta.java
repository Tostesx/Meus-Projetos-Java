package me.dio.app;

import me.dio.banco.Banco;
import me.dio.banco.Conta;
import me.dio.banco.ContaCorrente;
import me.dio.banco.ContaPoupanca;
import me.dio.banco.Cliente;

import java.util.ArrayList;

public class UsaConta {

    public static void main(String[] args) {
        // Criando o cliente
        Cliente cliente1 = new Cliente("João", "12345678910", new ArrayList<>());
        Cliente cliente2 = new Cliente("Maria", "10987654321", new ArrayList<>());

        // Criando contas para os clientes
        Conta contaCorrente = new ContaCorrente(1234, "001", 1000.0, cliente1);
        Conta contaPoupanca = new ContaPoupanca(5678, "002", 500.0, cliente2);

        // Associando as contas ao cliente
        cliente1.getContas().add(contaCorrente);
        cliente2.getContas().add(contaPoupanca);

        // Criando o banco e adicionando os clientes
        Banco banco = new Banco("Banco Digital", new ArrayList<>());
        banco.adicionarCliente(cliente1);
        banco.adicionarCliente(cliente2);

        // Exibindo os clientes do banco
        System.out.println("Clientes do " + banco.getNome() + ":");
        banco.listarClientes();

        // Realizando operações com a conta corrente
        contaCorrente.depositar(500.0);
        System.out.println("Saldo da Conta Corrente após depósito: " + contaCorrente.getSaldo());

        contaCorrente.sacar(200.0);
        System.out.println("Saldo da Conta Corrente após saque: " + contaCorrente.getSaldo());

        // Transferindo da conta corrente para a poupança
        contaCorrente.transferir(300.0, contaPoupanca);
        System.out.println("Saldo da Conta Corrente após transferência: " + contaCorrente.getSaldo());
        System.out.println("Saldo da Conta Poupança após receber transferência: " + contaPoupanca.getSaldo());
    }
}
