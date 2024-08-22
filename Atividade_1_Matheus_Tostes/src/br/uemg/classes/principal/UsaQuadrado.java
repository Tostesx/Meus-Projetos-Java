// Pacote principal da aplicação
package br.uemg.classes.principal;

import br.uemg.classes.quadrado.Quadrado;

public class UsaQuadrado {

	public static void main(String[] args) {
		// Objetos 'Quadrado' q1 e q2 com lado 5.0f e 25.0f
		Quadrado q1 = new Quadrado(5.0f);
		Quadrado q2 = new Quadrado(25.0f);
		
		System.out.println("Quadrado 1:"); // Imprime informações do quadrado 1
        q1.calcularArea(); // Calcula a área do quadrado 1
        q1.calcularPerimetro(); // Calcula o perímetro do quadrado 1
        q1.imprimir(); // Imprime o lado, área e perímetro do quadrado 1

        System.out.println(); // Linha em branco para separação

        System.out.println("Quadrado 2:"); // Imprime informações do quadrado 2
        q2.calcularArea(); // Calcula a área do quadrado 2
        q2.calcularPerimetro(); // Calcula o perímetro do quadrado 2
        q2.imprimir(); // Imprime o lado, área e perímetro do quadrado 2
	}

}
