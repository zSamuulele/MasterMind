package me.jfxrs.mastermind.objects.grid;

/**
 * Created by gioga on 07/02/2017.
 */
public class Slot {

    private double x, y;

    public Slot(double x, double y) {
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
}
