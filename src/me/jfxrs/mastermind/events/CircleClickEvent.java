package me.jfxrs.mastermind.events;

import eu.iamgio.customevents.api.Event;
import me.jfxrs.mastermind.objects.CircleType;

/**
 * Created by gioga on 07/02/2017.
 */
public class CircleClickEvent extends Event {

    private CircleType type;

    public CircleClickEvent(CircleType type) {
        this.type = type;
    }

    /**
     * @return Current type
     */
    public CircleType getCircleType() {
        return type;
    }
}