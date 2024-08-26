package me.dio.web.contabancaria;

import java.util.Scanner;

public class ContaTerminal {
	private int numero;
    private String agencia;
    private String nomeCliente;
    private float saldo;
    
	public static void main(String[] args) {
		
		ContaTerminal conta = new ContaTerminal();//Objeto da classe conta
		
		//Apesar de não ser uma boa prática abreviei o objeto do Scanner para (sc)
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o número da conta: ");
		conta.numero = sc.nextInt();

		System.out.println("Digite o número da agência: ");
		conta.agencia = sc.next();
		
		System.out.println("Digite o nome do cliente: ");
		sc.nextLine();
		conta.nomeCliente = sc.nextLine();
		
		System.out.println("Digite o saldo: ");
		conta.saldo = sc.nextFloat();
		
		// Fechar o scanner
        sc.close();
        		
        //Mensagem personalizada
        String mensagem = String.format(
                "Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %d e seu saldo %.2f já está disponível para saque.",
                conta.nomeCliente, conta.agencia, conta.numero, conta.saldo
            );

            System.out.println(mensagem);
	}


}
