package me.dio.classes;

import me.dio.armaduras.ArmaduraLeve;
import me.dio.armas.Adaga;
import me.dio.armas.Arco;
import me.dio.racas.RacaBase;

public class Assassino extends ClasseBase {
	private Arco arco;
	private Adaga adaga;

    public Assassino(RacaBase raca) {
        super("Assassino", new Adaga("Adaga", "Físico", (short) 3),
              new ArmaduraLeve("Armadura Leve", (short) 24, (short) 26, (short) 0), raca);
        adicionarForca((short) 7);
        adicionarInteligencia((short) 6); 
        adicionarAgilidade((short) 17); 
        
        this.arco = new Arco("Arco curto", "Físico", (short) 8);
        this.adaga = (Adaga) getArma();
    }

    @Override
    public void ataqueEspecial() {
        envenenar();
        passoDasSombras();
        aPresa();
        passivaArteFurtiva();
    }

    private void envenenar() {
        System.out.println("Envenenar: aplica veneno nas armas, causando dano extra e 5 de dano por 5 segundos.");
    }

    private void passoDasSombras() {
        System.out.println("Passo das Sombras: fica invisível por 20 segundos ou ao atacar, causando 40% de dano extra ao atacar sobre o efeito.");
    }

    private void aPresa() {
        System.out.println("A Presa: marca o alvo, dando visão absoluta sobre ele e causando dano extra ao atacar.");
    }

    private void passivaArteFurtiva() {
        System.out.println("Passiva Arte Furtiva: ao atacar pelas costas ganha 20% de dano e 15% lateral, além de 10% de evadir ataques.");
    }
    
    @Override
	public short calcularDanoArma01() {
    	short danoBase = adaga.getDanoArma(); 
        short agilidade = getRaca().getAgilidade();

        short bonusAgilidade = (short) (1.7 * agilidade); 
        short danoTotal = (short) (danoBase + bonusAgilidade);
		
        return danoTotal;
    }

    
    @Override
	public short calcularDanoArma02() {
		short danoBase = arco.getDanoArma(); 
        short forca = getRaca().getForca();
        short agilidade = getRaca().getAgilidade();
 
        short bonusForca = (short) (0.5 * forca);
        short bonusAgilidade = (short) (1.2 * agilidade);
        short danoTotal = (short) (danoBase + bonusAgilidade + bonusForca);
		
        return danoTotal;
    }
   
    @Override
    public String descreverClasse() {
        return String.format("%s é um(a) %s da raça %s que utiliza %s e %s, veste %s.%n" +
                "Atributos:%n" +
                " - Força: %d%n" +
                " - Agilidade: %d%n" +
                " - Inteligência: %d%n" +
                " - Vida: %d%n" +
                " - Mana: %d%n" +
                " - Dano da Arma (Adaga): %d%n" +
                " - Dano da Arma (Arco): %d%n" +
                " - Defesa Física: %d%n" +
                " - Defesa Mágica: %d%n" +
                " - Equilíbrio: %d%n",
                getRaca().getNome(), 
                getNomeClasse(),
                getRaca().getRaca(),
                adaga.getTipoArma(),
                arco.getTipoArma(),
                getArmadura().getTipoArmadura(),
                getRaca().getForca(), 
                getRaca().getAgilidade(), 
                getRaca().getInteligencia(), 
                getRaca().getVida(), 
                getRaca().getMana(),
                calcularDanoArma01(), 
                calcularDanoArma02(), 
                getArmadura().getDefesaFisica(), 
                getArmadura().getDefesaMagica(), 
                getArmadura().getEquilibrio());
    }

	
}
