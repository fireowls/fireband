package fr.fireowls.fireband.mini_game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import fr.fireowls.fireband.FireBand;

public class PianoMiniGame implements Screen {

    private FireBand game;
    private OrthographicCamera gamecam;
    private Viewport gameport;

    Texture img2 = new Texture("[FireBand] Fond.png");
    Sprite backgroundSprite;
    ShapeRenderer shape;

    public PianoMiniGame(FireBand game){
        this.game = game;
        this.gamecam = new OrthographicCamera();
        this.gameport = new StretchViewport(FireBand.V_WIDTH / FireBand.PPM, FireBand.V_HEIGHT / FireBand.PPM, gamecam);
        backgroundSprite = new Sprite(img2);
        backgroundSprite.setSize(FireBand.V_WIDTH / FireBand.PPM, FireBand.V_HEIGHT / FireBand.PPM);
        gamecam.position.set(gameport.getWorldWidth() / 2, gameport.getWorldHeight() /2, 0);
        shape = new ShapeRenderer();
    }

    @Override
    public void show() {

    }

    private void shapeRender(){
        shape.setProjectionMatrix(gamecam.combined);
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(Color.BLACK);
        shape.rect(0,0,100,100);
        shape.end();
    }

    @Override
    public void render(float delta) {
        update();
        Gdx.gl.glClearColor(0,0,0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.setProjectionMatrix(gamecam.combined);
        this.game.batch.begin();
        game.batch.draw(backgroundSprite, 0, 0, FireBand.V_WIDTH / FireBand.PPM, FireBand.V_HEIGHT / FireBand.PPM);

        this.game.batch.end();
    }

    public void update(){
        gamecam.update();
    }

    @Override
    public void resize(int width, int height) {
        this.gameport.update(width,height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
    }
}
