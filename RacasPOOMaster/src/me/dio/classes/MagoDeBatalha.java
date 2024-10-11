package me.dio.classes;

import me.dio.armaduras.Tunica;
import me.dio.armas.Espada;
import me.dio.armas.Varinha;
import me.dio.racas.RacaBase;

public class MagoDeBatalha extends ClasseBase {
    private Varinha varinha; // Varinha como offhand
    private Espada espada;

    public MagoDeBatalha(RacaBase raca) {
        super("Mago de Batalha", new Espada("Espada Rúnica", "Híbrido", (short) 12),
              new Tunica("Túnica Reforçada", (short) 15, (short) 35, (short) 0), raca);
        
        adicionarForca((short) 7);
        adicionarInteligencia((short) 13);
        adicionarAgilidade((short) 10);
        
        this.espada =  (Espada) getArma();
        //Varinha (offhand)
        this.varinha = new Varinha("Varinha de mármore", "Mágico", (short) 10);
    }

    @Override
    public void ataqueEspecial() {
        ataqueElementalBasico();
        armaArcana();
        fortificar();
        passivaGuerreiroDoSaber();
    }

    private void ataqueElementalBasico() {
        System.out.println("Ataque Elemental Básico: ataca com magias simples como bola de fogo ou raio.");
    }

    private void armaArcana() {
        System.out.println("Arma Arcana: imbui a arma com dano mágico ou elemental, dando 20% do elemento escolhido à arma.");
    }

    private void fortificar() {
        System.out.println("Fortificar: aumenta o dano mágico, a velocidade de movimento e a defesa mágica em 15% por 15 segundos.");
    }

    private void passivaGuerreiroDoSaber() {
        System.out.println("(Passiva) Guerreiro do Saber: Defesa mágica +8%, defesa física +5%, ao usar uma habilidade ganha 5% de dano físico e 8% de dano mágico por 2 segundos.");
    }
    

    @Override
   	public short calcularDanoArma01() {
       	short danoBase = espada.getDanoArma();
       	short forca = getRaca().getForca();
        short agilidade = getRaca().getAgilidade();
        short inteligencia = getRaca().getInteligencia();
        
        short bonusForca = (short) (0.7 * forca);
        short bonusAgilidade = (short) (0.5 * agilidade); 
        short bonusInteligencia = (short) (1.3 * inteligencia); 
        short danoTotal = (short) (danoBase + bonusAgilidade + bonusForca + bonusInteligencia);
   		
        return danoTotal;
       }

       
       @Override
   	public short calcularDanoArma02() {
    	   short danoBase = varinha.getDanoArma();
    	   short forca = getRaca().getForca();
           short agilidade = getRaca().getAgilidade();
           short inteligencia = getRaca().getInteligencia();
           
           short bonusForca = (short) (0.1 * forca);
           short bonusAgilidade = (short) (0.3 * agilidade); 
           short bonusInteligencia = (short) (1.2 * inteligencia); 
           short danoTotal = (short) (danoBase + bonusAgilidade + bonusForca + bonusInteligencia);
      		
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
                   " - Dano da Arma (Espada Rúnica): %d%n" +
                   " - Dano da Arma (Varinha de mármore): %d%n" +
                   " - Defesa Física: %d%n" +
                   " - Defesa Mágica: %d%n" +
                   " - Equilíbrio: %d%n",
                   getRaca().getNome(), 
                   getNomeClasse(),
                   getRaca().getRaca(),
                   espada.getTipoArma(),
                   varinha.getTipoArma(),
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
