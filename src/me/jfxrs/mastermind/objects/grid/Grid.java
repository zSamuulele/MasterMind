package me.jfxrs.mastermind.objects.grid;

/**
 * Created by gioga on 07/02/2017.
 */
public class Grid {

    private Slot[] slots = new Slot[4*12];

    public Grid() {
        int i = 0;
        for(int y = 70; y <= 70 + (40*11); y += 40) {
            for(int x = 120; x <= 120 + (60 * 3); x += 60) {
                slots[i] = new Slot(x, y);
                i++;
            }
        }
    }

    /**
     * @return Slots of the grid
     */
    public Slot[] getSlots() {
        return slots;
    }
}
