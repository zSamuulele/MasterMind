package me.jfxrs.mastermind.listeners;

import eu.iamgio.customevents.api.EventHandler;
import eu.iamgio.customevents.api.Listener;
import eu.iamgio.libfx.api.JavaFX;
import me.jfxrs.mastermind.MasterMind;
import me.jfxrs.mastermind.events.CircleClickEvent;
import me.jfxrs.mastermind.game.Game;
import me.jfxrs.mastermind.grid.Grid;

/**
 * Created by jfxrs on 07/02/2017.
 */
public class CircleListener implements Listener {

    public static CircleListener instance;

    @EventHandler
    public void onCircleClick(CircleClickEvent e) {
        Game game = MasterMind.getGame();
        Grid grid = game.getGrid();

        if(grid.usedSlots(game.getActualLine()).length != 4) {
            grid.setCircle(e.getCircleType(),
                    grid.nextAvaibleSlot(game.getActualLine()).getVerticalLine(),
                    game.getActualLine());
        }

        JavaFX.fromId("confirm_btn").setOpacity(grid.usedSlots(game.getActualLine()).length == 4 ? 1 : 0);
    }
}
