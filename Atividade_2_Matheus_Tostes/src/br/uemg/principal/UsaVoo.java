package br.uemg.principal;

import br.uemg.classes.Data;
import br.uemg.classes.Voo;

public class UsaVoo {
    public static void main(String[] args) {
        Data dv1 = new Data((byte) 11, (byte) 5, (byte) 7, 2024);
        Data dv2 = new Data((byte) 23, (byte) 8, (byte) 9, 2025);
        Data dv3 = new Data((byte) 5, (byte) 23, (byte) 11, 2056);
        
        Voo v1 = new Voo(123, dv1, 90);
        Voo v2 = new Voo(2255, dv2, 99);
        Voo v3 = new Voo(333, dv3, 83);
        
        v1.imprimir();
        System.out.println();
        v2.imprimir();
        System.out.println();
        v3.imprimir();
}
}