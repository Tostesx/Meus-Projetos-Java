package br.uemg.classes.quadrado;

public class Quadrado {
	private float lado;
	private float area;
	private float perimetro;
	
	// Construtor que inicializa o lado do quadrado.
	public Quadrado(float lado) {
		this.lado = lado;
	}
	// Calcula a área do quadrado (lado * lado) e armazena no atributo 'area'.
	public void calcularArea() {
		area = lado * lado;
	}
	// Calcula o perímetro do quadrado (4 * lado) e armazena no atributo 'perimetro'.
	public void calcularPerimetro() {
		perimetro = 4 * lado;
	}
	// Imprime o lado, área e perímetro do quadrado.
	public void imprimir() {
		System.out.println("Lado: " + lado);
		System.out.println("Área: " + area);
		System.out.println("Perímetro: " + perimetro);
	}
	//	Getters and Setters //
	public float getArea() {
		return area;
	}
	// Método setter que permite definir a área do quadrado (nem sempre necessário).
	public void setArea(float area) {
		this.area = area;
	}

	public float getLado() {
		return lado;
	}

	public float getPerimetro() {
		return perimetro;
	}
	
	
	

}
