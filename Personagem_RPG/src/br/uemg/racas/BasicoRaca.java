package br.uemg.racas;

public class BasicoRaca {
	private String nome;
	private byte forca;
	private byte destreza;
	private byte constituicao;
	private byte inteligencia;
	private byte sabedoria;
	
	public BasicoRaca(String nome, byte forca, byte destreza, byte constituicao, byte inteligencia, byte sabedoria) {
		super();
		this.nome = nome;
		this.forca = forca;
		this.destreza = destreza;
		this.constituicao = constituicao;
		this.inteligencia = inteligencia;
		this.sabedoria = sabedoria;
	}
	
	public void Imprimir() {
		System.out.println("\nNome:" + nome);
		System.out.println("Força:" + forca);
		System.out.println("Destreza:" + destreza);
		System.out.println("Constituição:" + constituicao);
		System.out.println("Inteligência:" + inteligencia);
		System.out.println("Sabedoria:" + sabedoria);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public byte getForca() {
		return forca;
	}

	public void setForca(byte forca) {
		this.forca = forca;
	}

	public byte getDestreza() {
		return destreza;
	}

	public void setDestreza(byte destreza) {
		this.destreza = destreza;
	}

	public byte getConstituicao() {
		return constituicao;
	}

	public void setConstituicao(byte constituicao) {
		this.constituicao = constituicao;
	}

	public byte getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(byte inteligencia) {
		this.inteligencia = inteligencia;
	}

	public byte getSabedoria() {
		return sabedoria;
	}

	public void setSabedoria(byte sabedoria) {
		this.sabedoria = sabedoria;
	}
	
	
}
