package fr.fireowls.fireband.musiciens;

import java.io.Serializable;

import fr.fireowls.fireband.instruments.Instruments;
import fr.fireowls.fireband.interfaces.Achetable;
import fr.fireowls.fireband.util.BigValue;
import fr.fireowls.fireband.util.Constant;

/**
 * Classe pour creer un musicien
 * @author TheTeKsa
 */
public class Musicien implements Achetable, Serializable {

    /**
     * Nom du musicien
     */
    private String name;

    /**
     * Instrument que le musicien sait jouer
     */
    private Instruments instrument;
    /**
     * Nombre de point de competence que le musicien raporte par heure
     */
    private BigValue pointParHeure;
    /**
     * Duree durant laquelle le musicien raporte des points quand l application est fermee
     */
    private static int limite;

    private int tier;

    private BigValue tierPrice[] = Constant.getMusicienPrice();

    /**
     * Constructeur pour creer un musicien
     * @param name Nom du musicien
     * @param instrument Instrument que le musicien sait jouer
     * @param pointParHeure Le nombre de point que raporte le musicien par heure
     */
    public Musicien(String name, Instruments instrument, BigValue pointParHeure, int tier) {
        this.name = name;
        this.instrument = instrument;
        this.pointParHeure = pointParHeure;
        limite = 2;
        this.tier = tier;
    }

    /**
     * Reciperer le nom du musicien
     * @return le nom du musicien
     */
    public String getName() {
        return name;
    }

    /**
     * Recuperer le prix du musicien
     * @return le prix du musicien
     */
    public BigValue getPrice(int tier) {
        return this.tierPrice[tier];
    }

    /**
     * Recuperer l instrument joue par le musicien
     * @return l instrument joue par le musicien
     */
    public Instruments getInstrument() {
        return this.instrument;
    }

    /**
     * Recuperer le nombre de point raporte par le musicien
     * @return le nombre de point raporte par le musicien
     */
    public BigValue getPointParHeure() {
        return this.pointParHeure;
    }

    /**
     * Definir le nombre de point raporte par le musicien
     * @param pointParHeure Le nouveau nombre de point raporte par le musicien
     */
    public void setPointParHeure(int pointParHeure) {
        this.pointParHeure.setValue(pointParHeure);
    }

}
