package fr.fireowls.fireband;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.fireowls.fireband.listener.SimpleDirectionGestureDetector;

public class FireBand extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture img2;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("guitar_tier0.png");
		img2 = new Texture("badlogic.jpg");
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
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.draw(img2,img2.getWidth(),img2.getHeight());
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
