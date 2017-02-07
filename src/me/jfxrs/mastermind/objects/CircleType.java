package me.jfxrs.mastermind.objects;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import me.jfxrs.mastermind.objects.grid.Slot;

/**
 * Created by jfxrs on 07/02/2017.
 */
public enum CircleType {

    RED("ff1f1f"), ORANGE("ff7921"), YELLOW("ffdf00"), GREEN("00d70b"), BLUE("2170ff"), PINK("ff5969"), GRAY("a1a1a1");

    private Paint color;
    CircleType(String color) {
        this.color = Paint.valueOf(color);
    }

    /**
     * @param x X
     * @param y Y
     * @return Generated circle
     */
    public Circle getCircle(double x, double y) {
        Circle circle = new Circle(x, y, 15, color);
        circle.setStrokeWidth(1);
        circle.setStroke(Paint.valueOf("000"));
        circle.setId("circle_" + x + "_" + y);
        return circle;
    }

    /**
     * @param slot Grid slot
     * @return Generated circle
     */
    public Circle getCircle(Slot slot) {
        return getCircle(slot.getX(), slot.getY());
    }
}
