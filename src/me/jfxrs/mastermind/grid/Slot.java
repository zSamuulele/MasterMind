package me.jfxrs.mastermind.grid;

import eu.iamgio.libfx.api.JavaFX;
import javafx.scene.Node;
import javafx.scene.shape.Circle;
import me.jfxrs.mastermind.circles.CircleType;

/**
 * Created by jfxrs on 07/02/2017.
 */
public class Slot {

    private double x, y;

    Slot(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return Current x
     */
    public double getX() {
        return x;
    }

    /**
     * @return Current y
     */
    public double getY() {
        return y;
    }

    /**
     * @return Horizontal line (1-12)
     */
    public int getHorizontalLine() {
        return ((int) (y - 40) / 40);
    }

    /**
     * @return Vertical line (1-4)
     */
    public int getVerticalLine() {
        return ((int) (x - 60) / 60);
    }

    /**
     * @return True if the slot is empty
     */
    public boolean isEmpty() {
        for(Node n : JavaFX.getRoot().getChildrenUnmodifiable()) {
            if(n instanceof Circle) {
                Circle circle = ((Circle) n);
                if(circle.getCenterX() == x && circle.getCenterY() == y)
                    return false;
            }
        }
        return true;
    }

    /**
     * @return Corresponding circle type
     */
    public CircleType getCircle() {
        for(Node n : JavaFX.getRoot().getChildrenUnmodifiable()) {
            if(n instanceof Circle) {
                Circle circle = ((Circle) n);
                if(circle.getCenterX() == x && circle.getCenterY() == y) {
                    for(CircleType type : CircleType.values()) {
                        if(type.getColor().toString().equals(circle.getFill().toString())) {
                            return type;
                        }
                    }
                }
            }
        }
        return null;
    }
}
