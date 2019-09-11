package fr.fireowls.fireband.tests;

import fr.fireowls.fireband.instruments.Piano;
import fr.fireowls.fireband.musiciens.Musicien;
import fr.fireowls.fireband.util.BigValue;
import fr.fireowls.fireband.util.Constant;

public class MusicienTest {

    public static void main(String[] args) {
        Musicien musicien = new Musicien("Jellock", new Piano(), new BigValue(Constant.EXP_CHAR),0);

        System.out.println(musicien.getName());
        System.out.println(musicien.getInstrument());
        System.out.println("musicien tier price "+musicien.getPrice(1));
        System.out.println(musicien.getPointParHeure());
        musicien.setPointParHeure(30);
        System.out.println(musicien.getPointParHeure());
    }

}
