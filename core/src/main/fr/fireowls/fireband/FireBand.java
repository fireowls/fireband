package fr.fireowls.fireband;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.fireowls.fireband.listener.SimpleDirectionGestureDetector;
import fr.fireowls.fireband.screens.GameScreen;
import fr.fireowls.fireband.screens.ScreenManager;

public class FireBand extends Game {
	public SpriteBatch batch;
	public static ScreenManager screenManager;

	@Override
	public void create () {
		batch = new SpriteBatch();

		screenManager = new ScreenManager(this);
		ScreenManager.setNewScreen(screenManager,new GameScreen(this));
		Gdx.input.setInputProcessor(new SimpleDirectionGestureDetector(new SimpleDirectionGestureDetector.DirectionListener() {

			@Override
			public void onUp() {
				Gdx.app.log("up", "on up");
			}

			@Override
			public void onRight() {
				Gdx.app.log("right", "on right");
			}

			@Override
			public void onLeft() {
				Gdx.app.log("left", "on left");
			}

			@Override
			public void onDown() {
				Gdx.app.log("down", "on down");
			}
		}));
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
