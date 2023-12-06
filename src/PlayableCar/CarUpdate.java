package PlayableCar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CarUpdate {

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    private ArrayList<CarObserver> observers = new ArrayList<CarObserver>();
    public CarUpdate() {
        timer.start();
    }

    //ComponentHolder componentHolder;

    void addObserver(CarObserver observer) {
        observers.add(observer);
    }

    void removeObserver(CarObserver observer) {
        observers.remove(observer);
    }

    void notifyObservers() {
        for (CarObserver observer : observers) {
            observer.update();
        }
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            notifyObservers();
        }
    }

}
