package fr.fireowls.fireband.musiciens;

import fr.fireowls.fireband.instruments.Instruments;
import fr.fireowls.fireband.interfaces.Achetable;
import fr.fireowls.fireband.util.BigValue;

public class Musicien implements Achetable {

    private String name;
    private BigValue price;
    private Instruments instrument;
    private BigValue pointParHeure;
    private static int duree;

    public Musicien(String name, BigValue price, Instruments instrument, BigValue pointParHeure) {
        this.name = name;
        this.price = price;
        this.instrument = instrument;
        this.pointParHeure = pointParHeure;
        duree = 2;
    }

    public String getName() {
        return name;
    }

    public BigValue getPrice() {
        return this.price;
    }

    public Instruments getInstrument() {
        return this.instrument;
    }

    public BigValue getPointParHeure() {
        return this.pointParHeure;
    }

    public void setPointParHeure(BigValue pointParHeure) {
        this.pointParHeure = pointParHeure;
    }

}
