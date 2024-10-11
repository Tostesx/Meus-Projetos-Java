package me.dio.classes;

import me.dio.armaduras.ArmaduraLeve;
import me.dio.armas.MarteloColossal; // Importar o martelo colossal
import me.dio.racas.RacaBase;

public class Barbaro extends ClasseBase {
	private MarteloColossal marteloc;

    public Barbaro(RacaBase raca) {
        super("Bárbaro", new MarteloColossal("Martelo Colossal", "Físico", (short) 30),
              new ArmaduraLeve("Armadura Leve", (short) 26, (short) 24, (short) 0), raca);
        
        adicionarForca((short) 19); 
        adicionarInteligencia((short) 3);
        adicionarAgilidade((short) 8);
        
        this.marteloc =  (MarteloColossal) getArma();
    }

    @Override
    public void ataqueEspecial() {
        enfurecer();
        tornado();
        gritoIntimidante();
        passivaFrenesi();
    }

    private void enfurecer() {
        System.out.println("Enfurecer: aumenta a força e agilidade em 20%, mas perde 15% de defesa por 45 segundos.");
    }

    private void tornado() {
        System.out.println("Tornado: gira incessantemente causando dano em área e ganhando 50% de defesa mágica e + 20 de equilíbrio.");
    }

    private void gritoIntimidante() {
        System.out.println("Grito Intimidante: causa onda sonora que reduz a defesa física dos inimigos em 40% e os faz fugir por 5 segundos.");
    }

    private void passivaFrenesi() {
        System.out.println("(Passiva) Frenesi: abaixo de 40% de sua vida, seu dano e defesa aumentam conforme a vida é perdida.");
    }
    
    @Override
   	public short calcularDanoArma01() {
       	short danoBase = marteloc.getDanoArma();
       	short forca = getRaca().getForca();
        short agilidade = getRaca().getAgilidade();
        
        short bonusForca = (short) (2.5 * forca);
        short bonusAgilidade = (short) (0.6 * agilidade); 
        short danoTotal = (short) (danoBase + bonusAgilidade + bonusForca);
   		
        return danoTotal;
       }

       
       @Override
   	public short calcularDanoArma02() {
    	   return 0;
       }
      
       @Override
       public String descreverClasse() {
           return String.format("%s é um(a) %s da raça %s que utiliza %s, veste %s.%n" +
                   "Atributos:%n" +
                   " - Força: %d%n" +
                   " - Agilidade: %d%n" +
                   " - Inteligência: %d%n" +
                   " - Vida: %d%n" +
                   " - Mana: %d%n" +
                   " - Dano da Arma (Martelo Colossal): %d%n" +
                   " - Defesa Física: %d%n" +
                   " - Defesa Mágica: %d%n" +
                   " - Equilíbrio: %d%n",
                   getRaca().getNome(), 
                   getNomeClasse(),
                   getRaca().getRaca(),
                   marteloc.getTipoArma(),
                   getArmadura().getTipoArmadura(),
                   getRaca().getForca(), 
                   getRaca().getAgilidade(), 
                   getRaca().getInteligencia(), 
                   getRaca().getVida(), 
                   getRaca().getMana(),
                   calcularDanoArma01(), 
                   getArmadura().getDefesaFisica(), 
                   getArmadura().getDefesaMagica(), 
                   getArmadura().getEquilibrio());
       }
}
