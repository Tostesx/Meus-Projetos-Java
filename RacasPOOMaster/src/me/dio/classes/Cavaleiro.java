package me.dio.classes;

import me.dio.armaduras.ArmaduraPesada;
import me.dio.armas.Espada;
import me.dio.armas.Escudo; 
import me.dio.racas.RacaBase;

public class Cavaleiro extends ClasseBase {
    private Escudo escudo; // Escudo do Cavaleiro
    private Espada espada;

    public Cavaleiro(RacaBase raca) {
        super("Cavaleiro", new Espada("Espada Reta", "Físico", (short) 14),
              new ArmaduraPesada("Armadura Pesada", (short) 35, (short) 15, (short) 0), raca);
        adicionarForca((short) 13); 
        adicionarInteligencia((short) 8); 
        adicionarAgilidade((short) 9); 
        
        this.espada =  (Espada) getArma();
        //Escudo (offhand)
        this.escudo = new Escudo("Escudo Pesado", "Defensivo", (short) 5); 
    }

    @Override
    public void ataqueEspecial() {
        agressao();
        pancadaComEscudo();
        orgulhoDaMontanha();
        passivaOuricoDeFerro();
    }

    private void agressao() {
        System.out.println("Agressão: obriga o inimigo a atacá-lo por 3 segundos.");
    }

    private void pancadaComEscudo() {
        System.out.println("Pancada com Escudo: atordoa o inimigo por 2 segundos.");
    }

    private void orgulhoDaMontanha() {
        System.out.println("Orgulho da Montanha: reveste uma camada de pedra, aumentando defesa em 300% e equilíbrio em 100%, mas não se move por 60 segundos.");
    }

    private void passivaOuricoDeFerro() {
        System.out.println("(Passiva) Ouriço de Ferro: reflete 15% do dano físico recebido, quando atacado ganha 1.5% de regen de vida(2 segundos).");
    }
   
    @Override
   	public short calcularDanoArma01() {
       	short danoBase = espada.getDanoArma();
       	short forca = getRaca().getForca();
        short agilidade = getRaca().getAgilidade();
        
        short bonusForca = (short) (1.3 * forca);
        short bonusAgilidade = (short) (0.6 * agilidade); 
        short danoTotal = (short) (danoBase + bonusAgilidade + bonusForca);
   		
        return danoTotal;
       }

       
       @Override
   	public short calcularDanoArma02() {
   		short danoBase = escudo.getDanoArma(); 
        short forca = getRaca().getForca();
        short vida = getRaca().getVida();
    
        short bonusForca = (short) (0.2 * forca);
        short bonusVida = (short) (0.1 * vida);
        short danoTotal = (short) (danoBase + bonusVida + bonusForca);
   		
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
                   " - Dano da Arma (Espada): %d%n" +
                   " - Chance de bloqueio (Escudo): %d%n" +
                   " - Defesa Física: %d%n" +
                   " - Defesa Mágica: %d%n" +
                   " - Equilíbrio: %d%n",
                   getRaca().getNome(), 
                   getNomeClasse(),
                   getRaca().getRaca(),
                   espada.getTipoArma(),
                   escudo.getTipoArma(),
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
