

import java.awt.*;
import java.util.ArrayList;

public class WorkShop<T> {
    private final Point pos;
    private ArrayList<T> carsInWorkshop;
    private final int capacity;

    public WorkShop(Point pos, int capacity) {
        this.pos = pos;
        this.capacity = capacity;
        this.carsInWorkshop = new ArrayList<>();
    }

    public Point getPos() {return pos;}

    public int getCapacity() {return capacity;}

    public ArrayList<T> getCarsInWorkshop() {return carsInWorkshop;}

    public void addToWorkshop(T item) {
        if (carsInWorkshop.size() >= capacity || carsInWorkshop.contains(item)) return;
        carsInWorkshop.add(item);
    }
    public T removeFromWorkshop(T item) {
        if (carsInWorkshop.contains(item)) {
            int i = carsInWorkshop.indexOf(item);
            T removedItem = carsInWorkshop.get(i);
            carsInWorkshop.remove(item);
            return removedItem;
        }
        return null;
    }
}


//Example: WorkShop<Car> shop = new WorkShop<Car>(new Point(1,1), 10);
