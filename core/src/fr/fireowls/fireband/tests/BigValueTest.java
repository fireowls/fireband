package fr.fireowls.fireband.tests;

import fr.fireowls.fireband.util.BigValue;

public class BigValueTest {
    public static void main(String[] args){
        BigValue a = new BigValue("A");
        BigValue b = new BigValue("B");
        System.out.println("--------Debut des Tests--------");
        System.out.println("-Vérification valeurs initiale-");
        System.out.println("a == 0 : "+a.toString().equals("0 A"));
        System.out.println("b == 0 : "+b.toString().equals("0 B"));

        System.out.println("-----Vérification addition-----");
        a.add(1);
        System.out.println(a.compareTo(new BigValue("Z", 1)) == 0);

        System.out.println("------Vérification unite-------");
        System.out.println(new BigValue("$", 10000).toString().equals("10.0 k$"));
        System.out.println(new BigValue(".", 123456789).toString().equals("123 M."));



    }
}
