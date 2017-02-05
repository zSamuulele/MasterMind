package me.jfxrs.mastermind.events;

import eu.iamgio.customevents.api.Event;
import me.jfxrs.mastermind.objects.GameMode;

/**
 * Created by gioga on 05/02/2017.
 */
public class MenuButtonClickEvent extends Event {

    private GameMode mode;

    public MenuButtonClickEvent(GameMode mode) {
        this.mode = mode;
    }

    /**
     * @return Current game mode
     */
    public GameMode getGameMode() {
        return mode;
    }
}
