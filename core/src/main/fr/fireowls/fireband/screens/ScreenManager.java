package fr.fireowls.fireband.screens;

import com.badlogic.gdx.Screen;

import fr.fireowls.fireband.FireBand;

public class ScreenManager {

    public FireBand game;

    public ScreenManager(FireBand fb){
        this.game = fb;
    }

    public static void setNewScreen(ScreenManager sm, Screen screen){
        sm.game.setScreen(screen);
    }

}
