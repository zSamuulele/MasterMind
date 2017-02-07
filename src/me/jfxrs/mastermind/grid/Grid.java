package me.jfxrs.mastermind.grid;

import com.sun.istack.internal.Nullable;
import eu.iamgio.libfx.api.JavaFX;
import javafx.scene.layout.Pane;
import me.jfxrs.mastermind.circles.CircleType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jfxrs on 07/02/2017.
 */
public class Grid {

    private Slot[] slots = new Slot[4 * 12];

    public Grid() {
        int i = 0;
        for(int y = 70; y <= 70 + (40 * 11); y += 40) {
            for(int x = 120; x <= 120 + (60 * 3); x += 60) {
                slots[i] = new Slot(x, y);
                i++;
            }
        }
    }

    /**
     * Sets a circle to the corresponding slot
     * @param vLine Vertical line (1-4)
     * @param hLine Horizontal line (1-12)
     */
    public boolean setCircle(CircleType type, int vLine, int hLine) {
        Slot slot = slotAt(vLine, hLine);
        if(slot == null)
            return false;

        String id = "circle_" + slot.getX() + "_" + slot.getY();
        if(JavaFX.fromId(id) != null)
            ((Pane) JavaFX.getRoot()).getChildren().remove(JavaFX.fromId(id));
        ((Pane) JavaFX.getRoot()).getChildren().add(type.getCircle(slot));
        return true;
    }

    /**
     * @param hLine Horizontal line
     * @return Next avaible slot
     */
    public @Nullable Slot nextAvaibleSlot(int hLine) {
        for(int i = 1; i <= 4; i++) {
            Slot slot = slotAt(i, hLine);
            if(slot != null && slot.isEmpty())
                return slot;
        }
        return null;
    }

    /**
     * @param hLine Horizontal line
     * @return Circles in the line
     */
    public Slot[] usedSlots(int hLine) {
        List<Slot> s = new ArrayList<>();
        for(Slot slot : this.slots) {
            if(Math.round((slot.getY() - 40) / 40) == hLine && !slot.isEmpty()) {
                s.add(slot);
            }
        }
        Slot[] slots = new Slot[s.size()];
        for(int i = 0; i < s.size(); i++)
            slots[i] = s.get(i);
        return slots;
    }

    /**
     * @param vLine Vertical line (1-4)
     * @param hLine Horizontal line (1-12)
     * @return Corresponding slot
     */
    public Slot slotAt(int vLine, int hLine) {
        for(Slot slot : slots)
            if(Math.round((slot.getX() - 60) / 60) == vLine && Math.round((slot.getY() - 40) / 40) == hLine)
                return slot;
        return null;
    }
}
