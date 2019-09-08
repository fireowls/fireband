package fr.fireowls.fireband.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import fr.fireowls.fireband.instruments.Instruments;
import fr.fireowls.fireband.util.Constant;

public class InstrumentHud implements Disposable {

    public static final float SCREEN_WIDTH = Gdx.graphics.getWidth();
    public static final float SCREEN_HEIGHT = Gdx.graphics.getHeight();

    private Instruments instrument;
    public Stage stage;
    private Viewport viewport;

    private Label nameLabel;
    private Label tierLabel;
    private Label levelLabel;
    private Label progressLabel;
    private Label pourcentLabel;

    public InstrumentHud(SpriteBatch batch,Instruments instrument){
        this.instrument = instrument;

        this.viewport = new FitViewport(InstrumentHud.SCREEN_WIDTH,InstrumentHud.SCREEN_HEIGHT,new OrthographicCamera());
        this.stage = new Stage(this.viewport,batch);
        this.stage.addActor(initLabel());
    }

    private Table initLabel(){
        Table table = new Table();
        table.top();
        table.setFillParent(true);

        Label.LabelStyle labelStyle = new Label.LabelStyle(new BitmapFont(),Color.WHITE);

        this.nameLabel = new Label(this.instrument.getName(),labelStyle);
        this.tierLabel = new Label("Tier : "+this.instrument.getTier(),labelStyle);
        this.levelLabel = new Label("Niveau : "+this.instrument.getLevel(),labelStyle);
        this.progressLabel = new Label(this.instrument.getProgress().toString(),labelStyle);
        this.pourcentLabel = new Label(this.instrument.getPourcentage(),labelStyle);

        table.add(nameLabel).expandX().padTop(10);
        table.add(tierLabel).expandX().padTop(10);
        table.add(levelLabel).expandX().padTop(10);
        table.row();
        table.add(progressLabel).expandX();
        table.add(pourcentLabel).expandX();

        return table;
    }

    public Instruments getInstrument(){return this.instrument;}

    public void setInstrument(Instruments instru) {this.instrument = instru;}

    @Override
    public void dispose() {
        stage.dispose();
    }
}
