package fr.fireowls.fireband.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import fr.fireowls.fireband.FireBand;
import fr.fireowls.fireband.instruments.Instruments;

public class InstrumentHud implements Hud, Disposable {

    public Stage stage;
    private Viewport port;

    private Instruments instrument;

    Table table;

    Label nameLbl;
    Label tierLbl;
    Label levelLbl;
    Label pourcentLbl;
    Label progressLbl;

    public InstrumentHud(FireBand game, Instruments instrument) {
        this.port = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), new OrthographicCamera());
        this.stage = new Stage(this.port, game.batch);
        this.instrument = instrument;
        this.stage.addActor(initTable());
    }

    private Table initTable() {
        table = new Table();
        table.top();
        table.setFillParent(true);

        Label.LabelStyle style = new Label.LabelStyle(new BitmapFont(), Color.WHITE);

        nameLbl = new Label(instrument.getName(), style);
        tierLbl = new Label("Tier : " + instrument.getTier(), style);
        levelLbl = new Label("Level : " + instrument.getCompetence().getLevel(), style);
        pourcentLbl = new Label(instrument.getPourcentage(), style);
        progressLbl = new Label(instrument.getCompetence().getProgress().toString(), style);

        table.add(nameLbl).expandX().colspan(2).padTop(10);
        table.row();
        table.add(tierLbl,levelLbl);
        table.row();
        table.add(pourcentLbl, progressLbl);

        return table;
    }

    public Table getTable() {
        return table;
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
