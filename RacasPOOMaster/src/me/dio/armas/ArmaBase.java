package me.dio.armas;


public abstract class ArmaBase {
	private String tipoArma;
	private String atributoArma;
	private short danoArma;
	
	public ArmaBase(String tipoArma, String atributoArma, short danoArma) {
		this.tipoArma = tipoArma;
		this.atributoArma = atributoArma;
		this.danoArma = danoArma;
	}

	public String getTipoArma() {
		return tipoArma;
	}

	public void setTipoArma(String tipoArma) {
		this.tipoArma = tipoArma;
	}

	public String getAtributoArma() {
		return atributoArma;
	}

	public void setAtributoArma(String atributoArma) {
		this.atributoArma = atributoArma;
	}

	public short getDanoArma() {
		return danoArma;
	}

	public void setDanoArma(short danoArma) {
		this.danoArma = danoArma;
	}
	
	public void novoDanoArma(short adicionalDano) {
        this.danoArma += adicionalDano;
	}
	

}
