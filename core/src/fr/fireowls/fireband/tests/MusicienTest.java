package fr.fireowls.fireband.tests;

import fr.fireowls.fireband.instruments.Piano;
import fr.fireowls.fireband.musiciens.Musicien;
import fr.fireowls.fireband.util.BigValue;

public class MusicienTest {

    public static void main(String[] args) {
        Musicien musicien = new Musicien("Jellock", new BigValue("$"), new Piano(), new BigValue("$"));

        System.out.println(musicien.getName());
        System.out.println(musicien.getInstrument());
        musicien.getPrice().add(50);
        System.out.println(musicien.getPrice());
        System.out.println(musicien.getPointParHeure());
        musicien.setPointParHeure(30);
        System.out.println(musicien.getPointParHeure());
    }

}
