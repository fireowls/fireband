package fr.fireowls.fireband.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import fr.fireowls.fireband.FireBand;
import fr.fireowls.fireband.player.Player;

public class PlayerHud implements Hud, Disposable {

    public Stage stage;
    private Viewport port;

    private Player player;

    Table table;

    Label nameLbl;
    Button settingsBtn;

    public PlayerHud(FireBand game, Player player) {
        this.port = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), new OrthographicCamera());
        this.stage = new Stage(this.port, game.batch);
        this.player = player;
        this.stage.addActor(initTable());
    }

    private Table initTable() {
        table = new Table();
        table.top();
        table.setFillParent(true);

        Label.LabelStyle style = new Label.LabelStyle(new BitmapFont(), Color.WHITE);

        nameLbl = new Label(player.getName(), style);
        settingsBtn = new Button();

        table.add(nameLbl);

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
