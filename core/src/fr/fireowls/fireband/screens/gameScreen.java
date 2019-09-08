package fr.fireowls.fireband.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import fr.fireowls.fireband.FireBand;
import fr.fireowls.fireband.exceptions.InstrumentNotFoundException;
import fr.fireowls.fireband.hud.InstrumentHud;
import fr.fireowls.fireband.instruments.Piano;
import fr.fireowls.fireband.player.Player;
import fr.fireowls.fireband.util.Constant;

public class gameScreen implements Screen {

    public static final float SCREEN_WIDTH = Gdx.graphics.getWidth();
    public static final float SCREEN_HEIGHT = Gdx.graphics.getHeight();

    private FireBand game;
    private OrthographicCamera gamecam;
    private Viewport gamePort;
    private Player player;
    private InstrumentHud hud;

    public gameScreen(FireBand game, Player player){
        this.game = game;
        this.gamecam = new OrthographicCamera();
        this.gamePort = new FitViewport(gameScreen.SCREEN_WIDTH,gameScreen.SCREEN_HEIGHT,this.gamecam);
        this.player = player;
        try{
            this.hud = new InstrumentHud(this.game.batch,this.player.getCurrentInstrument());
        }catch (InstrumentNotFoundException e){

        }

    }

    @Override
    public void show() {

    }

    public void handleInput(float dt){
        if(Gdx.input.justTouched()){
            try{
                this.player.getCurrentInstrument().updateProgess();
            }catch(InstrumentNotFoundException e){
                e.printStackTrace();
            }
            this.hud.update(dt);
        }
    }

    public void update(float dt){
        handleInput(dt);
    }

    @Override
    public void render(float delta) {
        update(delta);

        Gdx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        this.game.batch.setProjectionMatrix(this.gamecam.combined);
        this.game.batch.begin();
        try{
            this.game.batch.draw(player.getCurrentInstrument().getImg(),0,0);
        }catch(InstrumentNotFoundException e){
            this.player.addInstrument(new Piano());
        }
        this.game.batch.end();

        this.game.batch.setProjectionMatrix(this.hud.stage.getCamera().combined);
        this.hud.stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        this.gamePort.update(width,height);
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
        this.hud.dispose();
    }
}
