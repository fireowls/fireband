package fr.fireowls.fireband;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

import fr.fireowls.fireband.instruments.Basse;
import fr.fireowls.fireband.instruments.Batterie;
import fr.fireowls.fireband.instruments.Guitare;
import fr.fireowls.fireband.instruments.Instruments;
import fr.fireowls.fireband.instruments.Piano;
import fr.fireowls.fireband.player.Player;
import fr.fireowls.fireband.screens.gameScreen;
import fr.fireowls.fireband.util.BigValue;
import fr.fireowls.fireband.util.Constant;

public class FireBand extends Game {
	public SpriteBatch batch;
    private Player player;

	@Override
	public void create () {
		batch = new SpriteBatch();
		ArrayList<Instruments> instru = new ArrayList<>();
		instru.add(new Piano());
		instru.add(new Guitare());
		instru.add(new Basse());
		instru.add(new Batterie());
		player = new Player("Test",new BigValue(Constant.MONEY_CHAR),instru);
        setScreen(new gameScreen(this,player));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
