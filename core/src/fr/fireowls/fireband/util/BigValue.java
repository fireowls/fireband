package fr.fireowls.fireband.util;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Classe permettant de gerer de très grand nombres ayant pour seul limite la taille d'un BigInteger
 * dans chaque index est stocké un nombre jusqu'a trois chiffres.
 * Cette classe a initialement été concu pour le jeu de type mobile de type clicker 'FireBand' 
 * developé par FireOwls.
 * @author vaniscotte-geoffrey
 */
public class BigValue {

    private BigInteger value;
    /**
     * Character qui sera attribué à l'unité que l'on traite, il est surtout utile lors de l'affichage
     * (ex : $, €, ...ect)
     */
    private char unite;
    /**
     * Tableau de String permettant l'affichage des valeurs
     */
    private String divition[] =     {"", "k", "M", "B", "T"};

    /**
     *
     * @param unite correspond au caractère afficher lors de l'affichage du nombre
     */
    public BigValue(char unite){
        this.unite = unite;
        value = new BigInteger("0");
    }
    
    public BigInteger getValue() {
    	return value;
    }
    
    public void subtract(BigValue number) {
    	value = value.subtract(number.getValue());
    }
    
    public void subtract(BigInteger number) {
    	value = value.subtract(number);
    }
    
    public void subtract(int number) {
    	subtract(new BigInteger(number+""));
    }
    
    public void subtract(long number) {
    	subtract(new BigInteger(number+""));
    }
    
    public void add(BigValue number) {
    	value = value.add(number.getValue());
    }
    
    public void add(BigInteger number) {
    	value = value.add(number);
    }
    
    public void add(int number) {
    	add(new BigInteger(number+""));
    }
    
    public void add(long number) {
    	add(new BigInteger(number+""));

    }
    
    private String getSubDivition() {
    	int numberOfChars = value.toString().length();
    	while(numberOfChars % 3 != 0) numberOfChars++;
    	return divition[numberOfChars/3-1];
    }
    
    /**
     * Affiche le bigvalue (ex : 789 $, 456 k$, 123 M$) si le caractere d'unité est '$'
     */
    public String toString() {
    	if(value.toString().length() <= 3) return value.toString() + unite;
    	if(value.toString().length() % 3 == 0) return value.toString().substring(0, 3) + getSubDivition() + unite;
    	if(value.toString().length() % 3 == 1) return value.toString().substring(0, 1) + getSubDivition() + unite;
    	if(value.toString().length() % 3 == 2) return value.toString().substring(0, 2) + getSubDivition() + unite;
    	return "Error";
    }
}
