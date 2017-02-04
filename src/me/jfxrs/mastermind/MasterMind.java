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

public class MasterMind extends Application {

    private static final String VERSION = "0.0.1";

    private static SimpleStage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXML.load(getClass(), "assets/scenes/MenuScene.fxml");
        Scene scene = new Scene(root, 900, 600);

        stage = new SimpleStage(primaryStage);
        stage.show(scene, "MasterMind - v" + VERSION, false);
        stage.setIcon(getClass(), "assets/images/mastermind.png");

        playMenuAnimation();
    }

    /**
     * Plays the menu animation
     */
    private void playMenuAnimation() {
        Node image = JavaFX.fromId("mastermind_image");
        Animation scaleXAnim = new Animation(Animation.Type.SCALE_X, 0.45, Duration.seconds(0.3), false);
        Animation scaleYAnim = new Animation(Animation.Type.SCALE_Y, 0.45, Duration.seconds(0.3), false);
        scaleXAnim.play(image);
        scaleYAnim.play(image);

        scaleXAnim.setOnAnimationCompleted(() -> {
            Node singlePlayer = JavaFX.fromId("singleplayer_btn");
            Node multiplayer = JavaFX.fromId("multiplayer_btn");
            scaleXAnim.play(singlePlayer);
            scaleYAnim.play(singlePlayer);

            scaleXAnim.setOnAnimationCompleted(() -> {
                scaleXAnim.play(multiplayer);
                scaleYAnim.play(multiplayer);
            });
        });
    }

    public static void main(String...args) {
        launch(args);
    }
}
