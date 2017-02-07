package me.jfxrs.mastermind.objects;

import eu.iamgio.libfx.api.FXML;
import eu.iamgio.libfx.api.JavaFX;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import me.jfxrs.mastermind.MasterMind;
import me.jfxrs.mastermind.events.CircleClickEvent;
import me.jfxrs.mastermind.listeners.CircleListener;
import me.jfxrs.mastermind.objects.grid.Grid;

/**
 * Created by jfxrs on 05/02/2017.
 */
public class Game {

    private GameMode mode;
    private Grid grid;
    private int hLine;

    public Game(GameMode mode) {
        this.mode = mode;
        grid = new Grid();
        hLine = 1;
    }

    /**
     * Starts the game
     */
    public void start() {
        Parent root = FXML.load(MasterMind.class, "assets/scenes/GameScene.fxml");
        Scene scene = new Scene(root, 900, 600);
        MasterMind.stage.show(scene, "MasterMind - v" + MasterMind.VERSION, false);

        CircleListener.instance = new CircleListener();
        JavaFX.getEventManager().registerEvents(CircleListener.instance);

        switch(mode) {
            case SINGLEPLAYER:
                //TODO
                break;
            case LOCAL:
                //TODO
                break;
            case ONLINE:
                //TODO
                break;
        }

        for(Node n : JavaFX.getRoot().getChildrenUnmodifiable()) {
            if(n.getId() != null && n.getId().contains("_circle")) {
                n.setOnMouseReleased(e -> JavaFX.getEventManager().callEvent(
                        new CircleClickEvent(CircleType.valueOf(n.getId().split("_")[0].toUpperCase()))));
            }
        }
    }

    /**
     * Ends the game
     */
    public void end() {
        JavaFX.getEventManager().unregisterEvents(CircleListener.instance);
        //TODO
    }

    /**
     * @return Current gamemode
     */
    public GameMode getGameMode() {
        return mode;
    }

    /**
     * @return Current grid
     */
    public Grid getGrid() {
        return grid;
    }

    /**
     * @return Current horizontal line
     */
    public int getActualLine() {
        return hLine;
    }

    /**
     * Sets the horizontal line
     * @param hLine New line
     */
    public void setActualLine(int hLine) {
        this.hLine = hLine;
    }
}
