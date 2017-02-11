package me.jfxrs.mastermind.events;

import eu.iamgio.customevents.api.Event;
import javafx.scene.shape.Circle;
import me.jfxrs.mastermind.circles.CircleType;

/**
 * Created by jfxrs on 07/02/2017.
 */
public class CircleClickEvent extends Event {

    private CircleType type;
    private Circle circle;

    public CircleClickEvent(CircleType type, Circle circle) {
        this.type = type;
    }

    /**
     * @return Current type
     */
    public CircleType getCircleType() {
        return type;
    }

    /**
     * @return Current circle
     */
    public Circle getCircle() {
        return circle;
    }
}
