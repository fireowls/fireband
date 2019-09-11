package fr.fireowls.fireband;

import java.util.Scanner;

import fr.fireowls.fireband.exceptions.InstrumentNotFoundException;
import fr.fireowls.fireband.instruments.Basse;
import fr.fireowls.fireband.instruments.Batterie;
import fr.fireowls.fireband.instruments.Guitare;
import fr.fireowls.fireband.instruments.Piano;
import fr.fireowls.fireband.player.Player;

public class Game {
    public static void main(String[] args) throws InstrumentNotFoundException {
        Player player = new Player("GeoJo");
        Scanner scan = new Scanner(System.in);
        String str = "";
        player.addMoney(100000);
        player.addInstrument(new Piano());
        player.addInstrument(new Guitare());
        player.addInstrument(new Basse());
        player.addInstrument(new Batterie());
        player.getCurrentInstrument().setTier(1);

        while(!str.equals("exit")) {

            System.out.println(player.getName() + " --- " + player.getMoney() + " --- " + player.getCurrentInstrument());
            str = scan.nextLine();
            switch (str){
                case "buy 1": player.getCurrentInstrument().upgradeTier(player, 1);
                    break;
                case "buy 2": player.getCurrentInstrument().upgradeTier(player, 2);
                    break;
                case "buy 3": player.getCurrentInstrument().upgradeTier(player, 3);
                    break;
                case "buy 4": player.getCurrentInstrument().upgradeTier(player, 4);
                    break;
                case "buy 5": player.getCurrentInstrument().upgradeTier(player, 5);
                    break;
                case "switch piano": player.switchInstrument(player.getInstruments().get(0));
                    break;
                case "switch guitare": player.switchInstrument(player.getInstruments().get(1));
                    break;
                case "switch basse": player.switchInstrument(player.getInstruments().get(2));
                    break;
                case "switch batterie": player.switchInstrument(player.getInstruments().get(3));
                    break;
            }
            player.getCurrentInstrument().updateProgess();
        }
    }
}
