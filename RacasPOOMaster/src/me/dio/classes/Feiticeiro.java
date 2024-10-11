package me.dio.classes;

import me.dio.armaduras.Tunica;
import me.dio.armas.Cajado; 
import me.dio.racas.RacaBase;

public class Feiticeiro extends ClasseBase {
	private Cajado cajado;

    public Feiticeiro(RacaBase raca) {
        super("Feiticeiro", new Cajado("Cajado", "Mágico", (short) 23),
              new Tunica("Roupão do Sábio", (short) 10, (short) 40, (short) 0), raca);
        adicionarForca((short) 5); 
        adicionarInteligencia((short) 18);
        adicionarAgilidade((short) 7);
        
        this.cajado = (Cajado) getArma();
    }

    @Override
    public void ataqueEspecial() {
        ataqueElementalBasico();
        ataqueMental();
        calamidadeDaNatureza();
        passivaMestreArcano();
    }

    private void ataqueElementalBasico() {
        System.out.println("Ataque Elemental Básico: ataca com magias simples como bola de fogo ou raio.");
    }

    private void ataqueMental() {
        System.out.println("Ataque Mental: entra na mente do inimigo, podendo destruí-lo de dentro para fora.");
    }

    private void calamidadeDaNatureza() {
        System.out.println("Calamidade da Natureza: invoca desastres naturais como chuva de meteoros, terremotos ou tsunames.");
    }

    private void passivaMestreArcano() {
        System.out.println("(Passiva) Mestre Arcano: defesa mágica + 10%, dano mágico + 5% e recuperação de mana + 15%.");
    }
    

    @Override
   	public short calcularDanoArma01() {
       	short danoBase = cajado.getDanoArma();
       	short forca = getRaca().getForca();
        short agilidade = getRaca().getAgilidade();
        short inteligencia = getRaca().getInteligencia();
        
        short bonusForca = (short) (0.1 * forca);
        short bonusAgilidade = (short) (0.3 * agilidade); 
        short bonusInteligencia = (short) (2.7 * inteligencia); 
        short danoTotal = (short) (danoBase + bonusAgilidade + bonusForca + bonusInteligencia);
   		
        return danoTotal;
       }

       
       @Override
   	public short calcularDanoArma02() {
   		
        return 0;
       }
      
       @Override
       public String descreverClasse() {
           return String.format("%s é um(a) %s da raça %s que utiliza somente %s, veste %s.%n" +
                   "Atributos:%n" +
                   " - Força: %d%n" +
                   " - Agilidade: %d%n" +
                   " - Inteligência: %d%n" +
                   " - Vida: %d%n" +
                   " - Mana: %d%n" +
                   " - Dano da Arma (Cajado): %d%n" +
                   " - Defesa Física: %d%n" +
                   " - Defesa Mágica: %d%n" +
                   " - Equilíbrio: %d%n",
                   getRaca().getNome(), 
                   getNomeClasse(),
                   getRaca().getRaca(),
                   cajado.getTipoArma(),
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
