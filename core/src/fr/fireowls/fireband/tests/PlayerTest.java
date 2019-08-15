package fr.fireowls.fireband.tests;

import fr.fireowls.fireband.instruments.Piano;
import fr.fireowls.fireband.player.Player;

public class PlayerTest {

    public static void main(String[] args) {
        Player player = new Player("Madeline");
        Piano piano = new Piano();

        System.out.println(player.addInstrument(piano) + player.getInstruments().toString());
        System.out.println(player.removeInstrument(piano) + player.getInstruments().toString());
        System.out.println(player.getMoney().toString());
        player.addMoney(500);
        System.out.println(player.getMoney().toString());
        player.addMoney(-600);
        System.out.println(player.getMoney().toString());
    }

}
