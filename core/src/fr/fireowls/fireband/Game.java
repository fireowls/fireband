package fr.fireowls.fireband;

import java.util.Scanner;

import fr.fireowls.fireband.instruments.Piano;
import fr.fireowls.fireband.player.Player;

public class Game {
    public static void main(String[] args){
        Player player = new Player("GeoJo");
        Scanner scan = new Scanner(System.in);
        String str = "";

        while(!str.equals("exit")) {
            player.addInstrument(new Piano());
            System.out.println(player.getName() + " --- " + player.getMoney() + " --- " + player.getInstruments().get(0));
            str = scan.nextLine();
            player.getInstruments().get(0).updateProgess();
        }
    }
}
