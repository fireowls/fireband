package fr.fireowls.fireband.tests;

import fr.fireowls.fireband.exceptions.InstrumentNotFoundException;
import fr.fireowls.fireband.instruments.Batterie;
import fr.fireowls.fireband.instruments.Piano;
import fr.fireowls.fireband.musiciens.Musicien;
import fr.fireowls.fireband.player.Player;
import fr.fireowls.fireband.util.BigValue;
import fr.fireowls.fireband.util.Constant;

public class PlayerTest {

    public static void main(String[] args) {
        try {
            testSwitch();
        } catch (InstrumentNotFoundException instrumentNotFoundExeption) {
            instrumentNotFoundExeption.printStackTrace();
        }
    }

    public static void testPlayer() {
        Player player = new Player("Madeline");
        Piano piano = new Piano();
        Musicien musicien = new Musicien("Jellock", new Piano(), new BigValue(Constant.EXP_CHAR),0);

        System.out.println(player.getName());
        System.out.println(player.addInstrument(piano) + player.getInstruments().toString());
        System.out.println(player.removeInstrument(piano) + player.getInstruments().toString());
        System.out.println(player.getMoney().toString());
        player.addMoney(500);
        System.out.println(player.getMoney().toString());
        player.substractMoney(400);
        System.out.println(player.getMoney().toString());
        System.out.println(piano.getPrice(piano.getTier()));
        System.out.println(player.buy(musicien, 1));
    }

    public static void testSwitch() throws InstrumentNotFoundException {
        Player player = new Player("Madeline");
        Piano piano = new Piano();
        Batterie batterie = new Batterie();

        player.addInstrument(piano);
        player.addInstrument(batterie);
        System.out.println(player.getCurrentInstrument());
        player.switchInstrument(batterie);
        System.out.println(player.getCurrentInstrument());
    }

}
