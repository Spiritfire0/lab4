package PlayableCar;

public class Main {
    public static void main(String[] args) {
        ComponentHolder componentHolder = new ComponentHolder();
        componentHolder.addVolvo240();
        componentHolder.addSaab95();
        componentHolder.addScania();

        // Instance of this class
        DrawPanel dp = new DrawPanel(800,560,componentHolder);


        // Start a new view and send a reference of self
        new DrawWindow("CarSim 1.0", dp);

        // Start the timer
        //CarUpdate.timer.start();
    }
}
