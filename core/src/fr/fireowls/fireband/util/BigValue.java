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
public class BigValue implements Comparable<BigValue>{

    private BigInteger value;
    /**
     * Character qui sera attribué à l'unité que l'on traite, il est surtout utile lors de l'affichage
     * (ex : $, €, ...ect)
     */
    private String unite;
    /**
     * Tableau de String permettant l'affichage des valeurs
     */
    private String divition[] = Constant.divition;

    /**
     * Nombre maximum stockable dans le BitInteger
     */
    private BigInteger maxValue = new BigInteger("100000000000000");

    /**
     *
     * @param unite correspond au caractère afficher lors de l'affichage du nombre
     */
    public BigValue(String unite){
        this(unite, new BigInteger("0"));
    }

    public BigValue(String unite, BigInteger value){
        this.unite = unite;
        this.value = value;
    }

    public BigValue(String unite, int value){
        this.unite = unite;
        this.value = new BigInteger(value+"");
    }

    /**
     *
     * @return la chaine de charactère affiché
     */
    public String getUnite(){
        return this.unite;
    }

    /**
     * Set la chaine de charactère affiché
     * @param unite
     */
    public void setUnite(String unite){
        this.unite = unite;
    }

    /**
     *
     * @return le BigInteger
     */
    public BigInteger getValue() {
        return value;
    }

    public void setValue(BigInteger value){
        this.value = value;
    }

    public void setValue(int value){
        this.value = new BigInteger(value + "");
    }

    public void setValue(long value){
        this.value = new BigInteger(value + "");
    }

    /**
     * subtract cette valeur a la valeur passer en paramètre
     * @param number
     */
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

    /**
     * multiplie cette valeur à la valeur passer en paramètre
     * @param number
     */
    public void multiply(BigValue number) { value = value.multiply(number.getValue());}

    public void multiply(BigInteger number) {
        value = value.multiply(number);
    }

    public void multiply(int number) {
        multiply(new BigInteger(number+""));
    }

    public void multiply(long number) {
        multiply(new BigInteger(number+""));
    }

    /**
     * divise cette valeur à la valeur passer en paramètre
     * @param number
     */
    public void divide(BigValue number) { value = value.divide(number.getValue());}

    public void divide(BigInteger number) {
        value = value.divide(number);
    }

    public void divide(int number) {
        divide(new BigInteger(number+""));
    }

    public void divide(long number) {
        divide(new BigInteger(number+""));
    }

    /**
     * Additionne cette valeur à la valeur passer en paramètre
     * @param number
     */
    public void add(BigValue number) {
        if(value.add(number.getValue()).compareTo(maxValue) != 1)value = value.add(number.getValue());
    }
    
    public void add(BigInteger number) {
        if(value.add(number).compareTo(maxValue) != 1)value = value.add(number);
    }
    
    public void add(int number) {
    	add(new BigInteger(number+""));
    }
    
    public void add(long number) {
    	add(new BigInteger(number+""));
    }

    public void add(String number){
        add(new BigInteger(number));
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
    	if(value.toString().length() % 3 == 1) return value.toString().substring(0, 1) + "." + value.toString().substring(1, 3) + getSubDivition() + unite;
    	if(value.toString().length() % 3 == 2) return value.toString().substring(0, 2) + "." + value.toString().substring(2, 3) + getSubDivition() + unite;
    	return "Error";
    }

    @Override
    public int compareTo(BigValue o) {
        return this.value.compareTo(o.value);
    }
}
