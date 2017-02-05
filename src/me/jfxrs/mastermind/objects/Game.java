package me.jfxrs.mastermind.objects;

import eu.iamgio.libfx.api.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import me.jfxrs.mastermind.MasterMind;

/**
 * Created by gioga on 05/02/2017.
 */
public class Game {

    private GameMode mode;

    public Game(GameMode mode) {
        this.mode = mode;
    }

    /**
     * Starts the game
     */
    public void start() {
        Parent root = FXML.load(MasterMind.class, "assets/scenes/GameScene.fxml");
        Scene scene = new Scene(root, 900, 600);
        MasterMind.stage.show(scene, "MasterMind - v" + MasterMind.VERSION, false);
    }

    /**
     * Ends the game
     */
    public void end() {
        //TODO
    }
}
