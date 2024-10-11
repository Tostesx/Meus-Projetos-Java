package me.dio.racas;

public abstract class RacaBase implements Raca {	
	private String raca;
	private String nome;
	private short vida;
	private short mana;
	private short forca;
	private short inteligencia;
	private short agilidade;
	
	// Pontuação para distribuir ao criar uma raça = 45 pts entre força inteligência e agilidade
	public RacaBase(String raca, String nome, short vida, short mana, short forca, short inteligencia,
			short agilidade) {
		this.raca = raca;
		this.nome = nome;
		this.vida = calcularVida();
		this.mana = calcularMana();
		this.forca = forca;
		this.inteligencia = inteligencia;
		this.agilidade = agilidade;
	}
	
	public short calcularVida() {
		return (short) (100 + 2 * this.forca);
	}
	public short calcularMana() {
		return (short) (100 + 2 * this.inteligencia);
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public short getVida() {
		return vida;
	}

	public void setVida(short vida) {
		this.vida = vida;
	}

	public short getMana() {
		return mana;
	}

	public void setMana(short mana) {
		this.mana = mana;
	}

	public short getForca() {
		return forca;
	}

	public void setForca(short forca) {
		this.forca = forca;
		this.vida = calcularVida();
	}

	public short getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(short inteligencia) {
		this.inteligencia = inteligencia;
		this.mana = calcularMana();
	}

	public short getAgilidade() {
		return agilidade;
	}

	public void setAgilidade(short agilidade) {
		this.agilidade = agilidade;
	}
	

}
