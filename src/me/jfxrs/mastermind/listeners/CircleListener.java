package me.jfxrs.mastermind.listeners;

import eu.iamgio.customevents.api.EventHandler;
import eu.iamgio.customevents.api.Listener;
import me.jfxrs.mastermind.MasterMind;
import me.jfxrs.mastermind.events.CircleClickEvent;
import me.jfxrs.mastermind.objects.Game;
import me.jfxrs.mastermind.objects.grid.Grid;

/**
 * Created by gioga on 07/02/2017.
 */
public class CircleListener implements Listener {

    public static CircleListener instance;

    @EventHandler
    public void onCircleClick(CircleClickEvent e) {
        Game game = MasterMind.getGame();
        Grid grid = game.getGrid();

        if(grid.usedSlots(game.getActualLine()).length != 4) {
            grid.setCircle(e.getCircleType(), grid.nextAvaibleSlot(game.getActualLine()).getVerticalLine(), game.getActualLine());
        }
    }
}
