package me.jfxrs.mastermind.listeners;

import eu.iamgio.customevents.api.EventHandler;
import eu.iamgio.customevents.api.Listener;
import eu.iamgio.libfx.api.JavaFX;
import javafx.scene.control.Label;
import me.jfxrs.mastermind.MasterMind;
import me.jfxrs.mastermind.circles.CircleType;
import me.jfxrs.mastermind.events.ConfirmClickEvent;
import me.jfxrs.mastermind.game.Game;
import me.jfxrs.mastermind.grid.Grid;

/**
 * Created by jfxrs on 13/02/2017.
 */
public class ConfirmListener implements Listener {

    @EventHandler
    public void onConfirm(ConfirmClickEvent e) {
        Game game = MasterMind.getGame();
        Grid grid = game.getGrid();

        int red = 0;
        int white = 0;

        for(int i = 0; i < 4; i++) {
            CircleType type = grid.slotAt(i + 1, game.getActualLine()).getCircle();

            if(type == game.getCombination()[i]) {
                red++;
            }
        }

        white:
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                CircleType type = grid.slotAt(i + 1, game.getActualLine()).getCircle();
                if(type == game.getCombination()[j]) {
                    white++;
                    continue white;
                }
            }
        }
        white -= red;

        Label redLabel = ((Label) JavaFX.fromId("red_" + game.getActualLine()));
        redLabel.setText(red + "");
        redLabel.setOpacity(1);

        Label whiteLabel = ((Label) JavaFX.fromId("white_" + game.getActualLine()));
        whiteLabel.setText(white + "");
        whiteLabel.setOpacity(1);

        JavaFX.fromId("confirm_btn").setOpacity(0);

        game.setActualLine(game.getActualLine() + 1);
    }
}
