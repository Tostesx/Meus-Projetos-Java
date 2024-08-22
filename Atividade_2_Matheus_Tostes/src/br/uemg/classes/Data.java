package br.uemg.classes;


public class Data {
    private byte hora;
    private byte dia;
    private byte mes;
    private int ano;

    public Data(byte hora, byte dia, byte mes, int ano) {
        setHora(hora);
        setDia(dia);
        setMes(mes);
        this.ano = ano;
    }

	public byte getHora() {
		return hora;
	}

	public void setHora(byte hora) {
		if(hora >= 0 && hora <= 23) {
			this.hora = hora;
		} else {
			System.out.println("Hora inválida");
		}
	}

	public byte getDia() {
		return dia;
	}

	public void setDia(byte dia) {
		if(dia >= 1 && dia <= 30) {
			this.dia = dia;
		} else {
			System.out.println("Dia inválido");
		}
		
	}	

	public byte getMes() {
		return mes;
	}

	public void setMes(byte mes) {
		if(mes >= 1 && mes <= 12) {
			this.mes = mes;
		} else {
			System.out.println("Mês inválido");
		}
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
	@Override
    public String toString() {
        return String.format("%02d/%02d/%04d %02d:%02d", dia, mes, ano, hora, 0);
    }
}