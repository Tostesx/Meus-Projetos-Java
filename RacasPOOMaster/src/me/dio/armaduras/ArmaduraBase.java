package me.dio.armaduras;

public abstract class ArmaduraBase {
	private String tipoArmadura;
	private short defesaFisica;
	private short defesaMagica;
	private short equilibrio;
	
	public ArmaduraBase(String tipoArmadura, short defesaFisica, short defesaMagica, short equilibrio) {
		// Pontuação para distribuir entre defesaFisica e defesaMagica = 50 pts

		this.tipoArmadura = tipoArmadura;
		this.defesaFisica = defesaFisica;
		this.defesaMagica = defesaMagica;
		this.equilibrio = equilibrio; // Fórmula do equilíbrio = defesaFisica - defesaMagica + 2

	}

	public String getTipoArmadura() {
		return tipoArmadura;
	}

	public void setTipoArmadura(String tipoArmadura) {
		this.tipoArmadura = tipoArmadura;
	}

	public short getDefesaFisica() {
		return defesaFisica;
	}

	public void setDefesaFisica(short defesaFisica) {
		this.defesaFisica = defesaFisica;
	}

	public short getDefesaMagica() {
		return defesaMagica;
	}

	public void setDefesaMagica(short defesaMagica) {
		this.defesaMagica = defesaMagica;
	}

	public short getEquilibrio() {
		short equilibrioCalculado = (short) (defesaFisica - defesaMagica + 2);
		if (equilibrioCalculado > 0) {
			return equilibrioCalculado;
		} else {
			return 0;
		}
	}

	public void setEquilibrio(short equilibrio) {
		this.equilibrio = equilibrio;
	}
	
	
}
