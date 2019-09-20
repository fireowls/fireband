package fr.fireowls.fireband.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import fr.fireowls.fireband.FireBand;
import fr.fireowls.fireband.hud.GameHud;
import fr.fireowls.fireband.hud.InstrumentHud;
import fr.fireowls.fireband.hud.PlayerHud;
import fr.fireowls.fireband.instruments.Piano;
import fr.fireowls.fireband.player.Player;

public class GameScreen implements Screen {

    private FireBand game;
    private OrthographicCamera gamecam;
    private Viewport gameport;

    private GameHud gHud;

    Texture img = new Texture("[FireBand] piano I.png");

    public GameScreen(FireBand game){
        this.game = game;
        this.gamecam = new OrthographicCamera();
        this.gameport = new FitViewport(Gdx.graphics.getHeight(),Gdx.graphics.getWidth(),this.gamecam);
        this.gHud = new GameHud(game, new Piano(), new Player("TheTeKsa"));
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.game.batch.begin();
        this.game.batch.draw(img, 0, 0);
        this.game.batch.end();

        this.game.batch.setProjectionMatrix(this.gHud.stage.getCamera().combined);
        this.gHud.stage.draw();
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
        img.dispose();
        gHud.dispose();
    }
}
