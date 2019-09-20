package fr.fireowls.fireband.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import fr.fireowls.fireband.FireBand;
import fr.fireowls.fireband.instruments.Instruments;
import fr.fireowls.fireband.player.Player;

public class GameHud implements Disposable {

    public Stage stage;
    private Viewport port;

    private Player player;
    private Instruments instrument;

    Label playerNameLbl;
    ImageButton settingsBtn;

    Label instrumentNameLbl;
    Label tierLbl;
    Label levelLbl;
    Label pourcentLbl;
    Label progressLbl;

    public GameHud(FireBand game, Instruments instrument, Player player) {
        this.port = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), new OrthographicCamera());
        this.stage = new Stage(this.port, game.batch);
        this.player = player;
        this.instrument = instrument;
        this.stage.addActor(initTable());
    }

    private Table initTable() {
        Table table = new Table();
        table.top();
        table.setFillParent(true);

        Label.LabelStyle style = new Label.LabelStyle(new BitmapFont(), Color.WHITE);

        playerNameLbl = new Label(player.getName(), style);
        Texture t = new Texture("setting.png");
        TextureRegion tr = new TextureRegion(t);
        TextureRegionDrawable trd = new TextureRegionDrawable(tr);
        settingsBtn = new ImageButton(new TextureRegionDrawable(trd));

        instrumentNameLbl = new Label(instrument.getName(), style);
        tierLbl = new Label("Tier : " + instrument.getTier(), style);
        levelLbl = new Label("Level : " + instrument.getCompetence().getLevel(), style);
        pourcentLbl = new Label(instrument.getPourcentage(), style);
        progressLbl = new Label(instrument.getCompetence().getProgress().toString(), style);

        table.add(playerNameLbl, settingsBtn);
        table.row();
        table.add(instrumentNameLbl).colspan(2).expandX().padTop(10);
        table.row();
        table.add(tierLbl,levelLbl);
        table.row();
        table.add(pourcentLbl, progressLbl);

        return table;
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
