package me.dio.app;


import me.dio.classes.*;
import me.dio.racas.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Criação de raças
        Humano h1 = new Humano("Humano", "Geraldo", (short) 100, (short)  100, (short)  15, (short)  15, (short)  15);
        Humano h2 = new Humano("Humano", "Esber", (short) 100, (short)  100, (short)  15, (short)  15, (short)  15);
        Humano h3 = new Humano("Humano", "Lohan", (short) 100, (short)  100, (short)  15, (short)  15, (short)  15);
        Humano h4 = new Humano("Humano", "Raul", (short) 100, (short)  100, (short)  15, (short)  15, (short)  15);
        Humano h5 = new Humano("Humano", "Joseph", (short) 100, (short)  100, (short)  15, (short)  15, (short)  15);
        Elfo e1 = new Elfo("Elfo", "Huluxus", (short) 100, (short)  100, (short)  5, (short)  20, (short)  20);
        Elfo e2 = new Elfo("Elfo", "Aldarux", (short) 100, (short)  100, (short)  5, (short)  20, (short)  20);
        Elfo e3 = new Elfo("Elfo", "Hedorh", (short) 100, (short)  100, (short)  5, (short)  20, (short)  20);
        Elfo e4 = new Elfo("Elfo", "Illahx", (short) 100, (short)  100, (short)  5, (short)  20, (short)  20);
        Elfo e5 = new Elfo("Elfo", "Dhrix", (short) 100, (short)  100, (short)  5, (short)  20, (short)  20);
        Orc o1 = new Orc("Orc", "Gothrark", (short) 100, (short)  100, (short)  25, (short)  5, (short)  15);
        Orc o2 = new Orc("Orc", "Rorfozz", (short) 100, (short)  100, (short)  25, (short)  5, (short)  15);
        Orc o3 = new Orc("Orc", "Zzglebb", (short) 100, (short)  100, (short)  25, (short)  5, (short)  15);
        Orc o4 = new Orc("Orc", "Zaaldrax", (short) 100, (short)  100, (short)  25, (short)  5, (short)  15);
        Orc o5 = new Orc("Orc", "Bolgrob", (short) 100, (short)  100, (short)  25, (short)  5, (short)  15);

        // Criação de classes
        Assassino assassino1 = new Assassino(h1);
        Assassino assassino2 = new Assassino(e1);
        Assassino assassino3 = new Assassino(o1);
        Barbaro barbaro1 = new Barbaro(h2);
        Barbaro barbaro2 = new Barbaro(e2);
        Barbaro barbaro3 = new Barbaro(o2);
        MagoDeBatalha magoDeBatalha1 = new MagoDeBatalha(h3);
        MagoDeBatalha magoDeBatalha2 = new MagoDeBatalha(e3);
        MagoDeBatalha magoDeBatalha3 = new MagoDeBatalha(o3);
        Cavaleiro cavaleiro1 = new Cavaleiro(h4);
        Cavaleiro cavaleiro2 = new Cavaleiro(e4);
        Cavaleiro cavaleiro3 = new Cavaleiro(o4);
        Feiticeiro feiticeiro1 = new Feiticeiro(h5);
        Feiticeiro feiticeiro2 = new Feiticeiro(e5);
        Feiticeiro feiticeiro3 = new Feiticeiro(o5);

        // Lista de personagens
        List<ClasseBase> personagens = new ArrayList<>();
        personagens.add(assassino1);
        personagens.add(assassino2);
        personagens.add(assassino3);
        personagens.add(barbaro1);
        personagens.add(barbaro2);
        personagens.add(barbaro3);
        personagens.add(magoDeBatalha1);
        personagens.add(magoDeBatalha2);
        personagens.add(magoDeBatalha3);
        personagens.add(cavaleiro1);
        personagens.add(cavaleiro2);
        personagens.add(cavaleiro3);
        personagens.add(feiticeiro1);
        personagens.add(feiticeiro2);
        personagens.add(feiticeiro3);

        // Simulação 
        for (ClasseBase personagem : personagens) {
            System.out.println(personagem.getNomeClasse() + ":");
            System.out.println(personagem.descreverClasse() + "\nSuas Habilidades:");
            personagem.ataqueEspecial();
            System.out.println();  
        }
    }
}
