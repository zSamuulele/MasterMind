package me.jfxrs.mastermind.listeners;

import eu.iamgio.customevents.api.EventHandler;
import eu.iamgio.customevents.api.Listener;
import eu.iamgio.libfx.api.JavaFX;
import eu.iamgio.libfx.api.animations.Animation;
import javafx.util.Duration;
import me.jfxrs.mastermind.MasterMind;
import me.jfxrs.mastermind.events.MenuButtonClickEvent;
import me.jfxrs.mastermind.game.Game;

/**
 * Created by jfxrs on 05/02/2017.
 */
public class MenuListener implements Listener {

    @EventHandler
    public void onMenuClick(MenuButtonClickEvent e) {
        if(MasterMind.getGame() == null) {
            Animation animation = new Animation(Animation.Type.MOVEMENT_Y, -1000, Duration.seconds(0.3), false);
            JavaFX.getRoot().getChildrenUnmodifiable().forEach(n -> {
                if(!(n.getId() != null && n.getId().equals("mastermind"))) {
                    animation.play(n);
                }
                else new Animation(Animation.Type.OPACITY, 0, Duration.seconds(0.2), false).play(JavaFX.fromId("mastermind"));
            });
            animation.setOnAnimationCompleted(() -> MasterMind.setGame(new Game(e.getGameMode(), true)));
        }
    }
}
