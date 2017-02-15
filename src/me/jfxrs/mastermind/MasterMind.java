package me.jfxrs.mastermind;

import eu.iamgio.libfx.api.FXML;
import eu.iamgio.libfx.api.JavaFX;
import eu.iamgio.libfx.api.animations.Animation;
import eu.iamgio.libfx.api.elements.SimpleStage;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import me.jfxrs.mastermind.events.MenuButtonClickEvent;
import me.jfxrs.mastermind.game.Game;
import me.jfxrs.mastermind.game.GameMode;
import me.jfxrs.mastermind.listeners.CircleListener;
import me.jfxrs.mastermind.listeners.ConfirmListener;
import me.jfxrs.mastermind.listeners.MenuListener;

public class MasterMind extends Application {

    public static final String VERSION = "0.0.1";

    public static SimpleStage stage;
    public static Scene scene;
    private static Game game;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXML.load(getClass(), "assets/scenes/MenuScene.fxml");
        scene = new Scene(root, 900, 600);

        stage = new SimpleStage(primaryStage);
        stage.show(scene, "MasterMind - v" + VERSION, false);
        stage.setIcon(getClass(), "assets/images/mastermind.png");

        playMenuAnimation();
        JavaFX.getEventManager().registerEvents(new MenuListener());
        JavaFX.getEventManager().registerEvents(new ConfirmListener());
        JavaFX.getEventManager().registerEvents(new CircleListener());
    }

    /**
     * Plays the menu animation
     */
    public static void playMenuAnimation() {
        Node image = JavaFX.fromId("mastermind_image");
        Animation scaleXAnim = new Animation(Animation.Type.SCALE_X, 0.45, Duration.seconds(0.3), false);
        Animation scaleYAnim = new Animation(Animation.Type.SCALE_Y, 0.45, Duration.seconds(0.3), false);
        scaleXAnim.play(image);
        scaleYAnim.play(image);

        scaleXAnim.setOnAnimationCompleted(() -> {
            Node singleplayer = JavaFX.fromId("singleplayer_btn");
            Node local = JavaFX.fromId("local_btn");
            Node online = JavaFX.fromId("online_btn");

            singleplayer.setOnMouseReleased(e -> JavaFX.getEventManager().callEvent(new MenuButtonClickEvent(GameMode.SINGLEPLAYER)));
            local.setOnMouseReleased(e -> JavaFX.getEventManager().callEvent(new MenuButtonClickEvent(GameMode.LOCAL)));
            online.setOnMouseReleased(e -> JavaFX.getEventManager().callEvent(new MenuButtonClickEvent(GameMode.ONLINE)));

            scaleXAnim.play(singleplayer);
            scaleYAnim.play(singleplayer);

            scaleXAnim.setOnAnimationCompleted(() -> {
                scaleXAnim.play(local);
                scaleYAnim.play(local);

                scaleXAnim.setOnAnimationCompleted(() -> {
                    scaleXAnim.play(online);
                    scaleYAnim.play(online);
                });
            });
        });
    }

    public static void main(String...args) {
        launch(args);
    }

    /**
     * @return Current game
     */
    public static Game getGame() {
        return game;
    }

    /**
     * Sets the game
     * @param game New game
     */
    public static void setGame(Game game) {
        MasterMind.game = game;
        if(game != null) {
            game.start();
        }
    }
}
