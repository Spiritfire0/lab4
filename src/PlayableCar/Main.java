package PlayableCar;

public class Main {
    public static void main(String[] args) {
        ComponentHolder componentHolder = new ComponentHolder();
        componentHolder.addVolvo240();
        componentHolder.addSaab95();
        componentHolder.addScania();
        componentHolder.addFordL9000();

        // Instance of this class
        DrawPanel dp = new DrawPanel(DrawWindow.getXSize(), DrawWindow.getYSize()-240, componentHolder);

        // Start a new view and send a reference of self
        new DrawWindow("CarSim 1.0", dp);

        // Start the timer
        //CarUpdate.timer.start();
    }
}
