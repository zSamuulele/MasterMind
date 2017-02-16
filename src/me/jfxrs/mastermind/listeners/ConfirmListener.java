package me.jfxrs.mastermind.listeners;

import eu.iamgio.customevents.api.EventHandler;
import eu.iamgio.customevents.api.Listener;
import eu.iamgio.libfx.api.JavaFX;
import javafx.scene.control.Label;
import me.jfxrs.mastermind.MasterMind;
import me.jfxrs.mastermind.events.ConfirmClickEvent;
import me.jfxrs.mastermind.game.Game;
import me.jfxrs.mastermind.grid.Grid;

/**
 * Created by jfxrs on 13/02/2017.
 */
public class ConfirmListener implements Listener {

    @EventHandler
    public void onConfirm(ConfirmClickEvent e) {
        if(JavaFX.fromId("confirm_btn").getOpacity() == 0)
            return;
        Game game = MasterMind.getGame();
        Grid grid = game.getGrid();

        int red = game.getRedAndWhite()[0];
        int white = game.getRedAndWhite()[1];

        Label redLabel = ((Label) JavaFX.fromId("red_" + game.getActualLine()));
        redLabel.setText(red + "");
        redLabel.setOpacity(1);

        Label whiteLabel = ((Label) JavaFX.fromId("white_" + game.getActualLine()));
        whiteLabel.setText(white + "");
        whiteLabel.setOpacity(1);

        JavaFX.fromId("confirm_btn").setOpacity(0);

        if(red == 4) {
            game.end(true, true);
            return;
        }
        else if(game.getActualLine() == 12) {
            game.end(false, true);
            return;
        }

        game.setActualLine(game.getActualLine() + 1);
    }
}
