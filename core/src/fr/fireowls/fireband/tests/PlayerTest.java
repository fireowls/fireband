package fr.fireowls.fireband.tests;

import fr.fireowls.fireband.exceptions.InstrumentNotFoundException;
import fr.fireowls.fireband.instruments.Batterie;
import fr.fireowls.fireband.instruments.Piano;
import fr.fireowls.fireband.musiciens.Musicien;
import fr.fireowls.fireband.player.Player;
import fr.fireowls.fireband.util.BigValue;

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
        Musicien musicien = new Musicien("Jellock", new BigValue("$"), new Piano(), new BigValue("$"));

        musicien.getPrice().add(50);
        System.out.println(player.getName());
        System.out.println(player.addInstrument(piano) + player.getInstruments().toString());
        System.out.println(player.removeInstrument(piano) + player.getInstruments().toString());
        System.out.println(player.getMoney().toString());
        player.addMoney(500);
        System.out.println(player.getMoney().toString());
        player.substractMoney(400);
        System.out.println(player.getMoney().toString());
        System.out.println(piano.getPrice());
        System.out.println(player.buy(musicien));
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
