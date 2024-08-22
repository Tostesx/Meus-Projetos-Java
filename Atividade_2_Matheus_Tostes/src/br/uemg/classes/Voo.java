package br.uemg.classes;

public class Voo {
    private int numeroVoo;
    private Data dataVoo;
    private byte[] assentos;
    private byte proximoAssentoLivre;

    public Voo(int numeroVoo, Data dataVoo, int assentosOcupados) {
        this.numeroVoo = numeroVoo;
        this.dataVoo = dataVoo;
        this.assentos = new byte[100]; 
        this.proximoAssentoLivre = 0;

        for (int i = 0; i < assentosOcupados; i++) {
            assentos[i] = 1;
        }
    }
    
    public void imprimir() {
        System.out.println("Número do voo: " + numeroVoo);
        System.out.println("Data do voo: " + dataVoo.getDia() + "/" + dataVoo.getMes() + "/" + dataVoo.getAno());
        System.out.println(String.format("Hora: %02d:%02d", dataVoo.getHora(), 0)); // Corrigido
        System.out.println("Próximo assento livre: " + (assentosOcupados() + 1));
        System.out.println("Assentos ocupados: " + assentosOcupados());
        System.out.println("Vagas disponíveis: " + (100 - assentosOcupados()));
    }


    public void configura(int numeroVoo, Data dataVoo) {
        this.numeroVoo = numeroVoo;
        this.dataVoo = dataVoo;
    }

    public int proximoLivre() {
        for (int i = proximoAssentoLivre; i < assentos.length; i++) {
            if (assentos[i] == 0) {
                proximoAssentoLivre = (byte) i;
                return proximoAssentoLivre + 1; 
            }
        }
        return -1; 
    }

    public boolean verifica(int numeroAssento) {
        if (numeroAssento > 0 && numeroAssento <= assentos.length) {
            return assentos[numeroAssento - 1] == 1;
        }
        return false;
    }

    public boolean ocupa(int numeroAssento) {
        if (verifica(numeroAssento)) {
            return false; 
        }
        if (numeroAssento > 0 && numeroAssento <= assentos.length) {
            assentos[numeroAssento - 1] = 1;
            return true; 
        }
        return false; 
    }

    public int vagas() {
        int count = 0;
        for (byte assento : assentos) {
            if (assento == 0) {
                count++;
            }
        }
        return count;
    }

    public int retVoo() {
        return numeroVoo;
    }

    public Data retData() {
        return dataVoo;
    }

    public int assentosOcupados() {
        int ocupados = 0;
        for (byte assento : assentos) {
            if (assento == 1) {
                ocupados++;
            }
        }
        return ocupados;
    }
}
