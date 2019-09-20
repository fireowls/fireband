package fr.fireowls.fireband.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import fr.fireowls.fireband.FireBand;

public class ShopScreen implements Screen {

    private FireBand game;
    private OrthographicCamera gamecam;
    private Viewport gamePort;

    private ImageButton instrumentShop;

    public ShopScreen(FireBand game){
        this.game = game;
        this.gamecam = new OrthographicCamera();
        this.gamePort = new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(),this.gamecam);

        TextureRegionDrawable myTexture = new TextureRegionDrawable(new TextureRegion(new Texture("Guytare0.png")));
        this.instrumentShop = new ImageButton(myTexture);
        this.instrumentShop.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
               Gdx.app.log("","Button pressed");
            }
        });

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.game.batch.begin();
        this.instrumentShop.draw(this.game.batch,1);
        this.game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

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
