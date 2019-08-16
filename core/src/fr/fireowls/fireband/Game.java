package fr.fireowls.fireband;

import java.util.Scanner;

import fr.fireowls.fireband.exceptions.InstrumentNotFoundException;
import fr.fireowls.fireband.instruments.Piano;
import fr.fireowls.fireband.player.Player;

public class Game {
    public static void main(String[] args) throws InstrumentNotFoundException {
        Player player = new Player("GeoJo");
        Scanner scan = new Scanner(System.in);
        String str = "";

        while(!str.equals("exit")) {
            player.addInstrument(new Piano());
            player.getCurrentInstrument().setTier(1);
            System.out.println(player.getName() + " --- " + player.getMoney() + " --- " + player.getCurrentInstrument());
            str = scan.nextLine();
            player.getCurrentInstrument().updateProgess();
        }
    }
}
