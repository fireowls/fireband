package fr.fireowls.fireband.util;

import java.util.ArrayList;

/**
 * Classe permettant de gerer de très grand nombres ayant pour seul limite la taille d'une arraylist
 * dans chaque index est stocké un nombre jusqu'a trois chiffres.
 * Cette classe a initialement été concu pour le jeu de type mobile de type clicker 'FireBand'
 * developé par FireOwls.
 * @author vaniscotte-geoffrey
 */
public class BigValue {

    /**
     * ArrayList d'Integer qui stocke les entier par trois afin de differencier les unités des
     * milliers d'unité, millions , ...etc
     */
    private ArrayList<Integer> valueList;
    /**
     * Character qui sera attribué à l'unité que l'on traite, il est surtout utile lors de l'affichage
     * (ex : $, €, ...ect)
     */
    private char unite;
    /**
     * Tableau de String permettant l'affichage des valeurs
     */
    private String c[] = {"", "k", "M", "B", "T"};

    /**
     *
     * @param unite correspond au caractère afficher lors de l'affichage du nombre
     */
    public BigValue(char unite){
        this.unite = unite;
        valueList = new ArrayList<>();
        valueList.add(new Integer(0));
    }

    /**
     * Additionne une nombre au BigValue
     * @param number le nombre que vous voulez ajouter
     */
    public void add(long number){
        ArrayList<Integer> list = numberToArrayList(number);
        for(int i = list.size()-1; i >= 0; i--){
            try{
                valueList.get(i);
            }catch (IndexOutOfBoundsException e) {
                valueList.add(new Integer(0));
            }
            if(valueList.get(i) + list.get(i) >= 1000) {
                valueList.set(i, (valueList.get(i) + list.get(i))-1000);
                if(i == 0) valueList.add(1);
            }else {
                valueList.set(i, valueList.get(i) + list.get(i));
            }
        }
    }

    /**
     * Retourne un ArrayList correspondant au nombre passer en paramètre
     * sous la forme : index 0 : unité, index 1 : millier, etc...
     * @param number le nombre à convertir
     * @return une Arraylist d'Integer
     */
    public static ArrayList<Integer> numberToArrayList(long number){
        ArrayList<Integer> list = new ArrayList<>();
        long initialNumber = number;
        while(number/1000 != 0){
            list.add((int)(initialNumber - number/1000*1000)); //cette formule permet de recuper les trois derniers chiffres d'un nombre
            number = number / 1000;
        }
        list.add(new Integer((int)number));
        return list;
    }

    /**
     * Affiche le bigvalue (ex : 789 $, 456 k$, 123 M$) si le caractere d'unité est '$'
     */
    public String toString() {
        String unit = "";
        if(c[valueList.size()-1] == null) {
            unit = "";
        } else {
            unit = c[valueList.size()-1];
        }
        return valueList.get(valueList.size()-1) + " " + unit + unite;
    }
}
