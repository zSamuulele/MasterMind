package me.jfxrs.mastermind;

import eu.iamgio.libfx.api.FXML;
import eu.iamgio.libfx.api.elements.SimpleStage;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MasterMind extends Application {

    private static final String VERSION = "0.0.1";

    private static SimpleStage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXML.load(getClass(), "scenes/MenuScene.fxml");
        Scene scene = new Scene(root, 900, 600);

        stage = new SimpleStage(primaryStage);
        stage.show(scene, "MasterMind - v" + VERSION, false);
    }

    public static void main(String...args) {
        launch(args);
    }
}
