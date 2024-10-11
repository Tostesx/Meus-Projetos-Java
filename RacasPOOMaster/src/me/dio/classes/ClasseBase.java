package me.dio.classes;

import me.dio.armaduras.*;
import me.dio.armas.*;
import me.dio.racas.RacaBase;

public abstract class ClasseBase implements DanoCalculavel{
    private String nomeClasse;
    private ArmaBase arma;  // Associação com a classe de armas
    private ArmaduraBase armadura;  // Associação com a classe de armaduras
    private RacaBase raca;  // Associação com a raça

    public ClasseBase(String nomeClasse, ArmaBase arma, ArmaduraBase armadura, RacaBase raca) {
        this.nomeClasse = nomeClasse;
        this.arma = arma;
        this.armadura = armadura;
        this.raca = raca;
    }

    // 30 pts para distribuir para cada classe criada
    public void adicionarForca(short pontos) {
        short novaForca = (short) (raca.getForca() + pontos);
        raca.setForca(novaForca);
    }

    public void adicionarAgilidade(short pontos) {
        short novaAgilidade = (short) (raca.getAgilidade() + pontos);
        raca.setAgilidade(novaAgilidade);
    }

    public void adicionarInteligencia(short pontos) {
        short novaInteligencia = (short) (raca.getInteligencia() + pontos);
        raca.setInteligencia(novaInteligencia);
    }

    
    public String getNomeClasse() {
        return nomeClasse;
    }

    public void setNomeClasse(String nomeClasse) {
        this.nomeClasse = nomeClasse;
    }

    public ArmaBase getArma() {
        return arma;
    }

    public void setArma(ArmaBase arma) {
        this.arma = arma;
    }

    public ArmaduraBase getArmadura() {
        return armadura;
    }

    public void setArmadura(ArmaduraBase armadura) {
        this.armadura = armadura;
    }

    public RacaBase getRaca() {
        return raca;
    }

    public void setRaca(RacaBase raca) {
        this.raca = raca;
    }
    
    public abstract short calcularDanoArma01(); 
    public abstract short calcularDanoArma02();

	// Método que será implementado pelas subclasses
    public abstract void ataqueEspecial();
   
    public String descreverClasse() {
    	return String.format("%s é um(a) %s da raça %s que utiliza %s e veste %s.%n" +
    			"Atributos:%n" +
    			" - Força: %d%n" +
    			" - Agilidade: %d%n" +
    			" - Inteligência: %d%n" +
    			" - Vida: %d%n" +
    			" - Mana: %d%n" +
    			" - Dano da Arma: %d%n" +
    			" - Defesa Física: %d%n" +
    			" - Defesa Mágica: %d%n" +
    			" - Equilíbrio: %d%n",
    			raca.getNome(), 
    			nomeClasse,
    			getRaca().getRaca(),
    			arma.getTipoArma(), 
    			armadura.getTipoArmadura(),
    			raca.getForca(), 
    			raca.getAgilidade(), 
    			raca.getInteligencia(), 
    			raca.getVida(), 
    			raca.getMana(),
    			arma.getDanoArma(), 
    			armadura.getDefesaFisica(), 
    			armadura.getDefesaMagica(), 
    			armadura.getEquilibrio());
    }

}
