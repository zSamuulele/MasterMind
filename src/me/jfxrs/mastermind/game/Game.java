package me.jfxrs.mastermind.game;

import eu.iamgio.libfx.api.FXML;
import eu.iamgio.libfx.api.JavaFX;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import me.jfxrs.mastermind.MasterMind;
import me.jfxrs.mastermind.circles.CircleType;
import me.jfxrs.mastermind.events.CircleClickEvent;
import me.jfxrs.mastermind.events.ConfirmClickEvent;
import me.jfxrs.mastermind.grid.Grid;
import me.jfxrs.mastermind.listeners.CircleListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by jfxrs on 05/02/2017.
 */
public class Game {

    private GameMode mode;
    private Grid grid;
    private CircleType[] combination;
    private int hLine;
    private boolean doubleColors;

    public Game(GameMode mode, boolean doubleColors) {
        this.mode = mode;
        grid = new Grid();
        hLine = 1;
        this.doubleColors = doubleColors;
        combination = new CircleType[4];
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
                List<CircleType> colors = new ArrayList<>();
                for(int i = 0; i <= 4; i++) {
                    Random random = new Random();
                    CircleType type = CircleType.values()[random.nextInt(CircleType.values().length)];
                    while(!doubleColors && colors.contains(type))
                        type = CircleType.values()[random.nextInt(CircleType.values().length)];
                    colors.add(type);
                }
                for(int i = 0; i < 4; i++)
                    combination[i] = colors.get(i);
                System.out.println(Arrays.toString(combination));
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
                        new CircleClickEvent(CircleType.valueOf(n.getId().split("_")[0].toUpperCase()), ((Circle) n))));
            }
        }

        JavaFX.fromId("confirm_btn").setOnMouseReleased(ev -> JavaFX.getEventManager().callEvent(new ConfirmClickEvent()));
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
     * @return Current combination
     */
    public CircleType[] getCombination() {
        return combination;
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
