import java.awt.*;

abstract public class Car implements Movable {
    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    public final String modelName; // The car model name
    private double direction;
    private double xPosition;
    private double yPosition;

    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
    }

    public int getNrDoors(){return nrDoors;} //Get number of doors
    public double getEnginePower(){return enginePower;} //Get Engine Power

    public double getCurrentSpeed(){return currentSpeed;}// Get Current Speed

    public Color getColor(){return color;}// Get Color

    public void setColor(Color clr){color = clr;} // Set Color

    public void startEngine(){currentSpeed = 0.1;} // Start Engine

    public void stopEngine(){currentSpeed = 0;}// Stops Engine

    public double getDirection(){return direction;}// Returns Direction

    public double[] getPosition(){
        return new double[]{xPosition,yPosition};}// Returns Position

    public void setPosition(double x, double y){
        xPosition = x;
        yPosition = y;
    }

    protected abstract double speedFactor();

    private void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    public void move() {
        xPosition += currentSpeed * Math.cos(direction);
        yPosition += currentSpeed * Math.sin(direction);
    }
    public void turnLeft(double radians) {
        direction += radians;
    }
    public void turnRight(double radians) {
        direction -= radians;
    }

    public void gas(double amount){
        if (amount > 0){
            incrementSpeed(Math.min(amount,1));
        }
    }
    public void brake(double amount){
        if (amount > 0) {
            decrementSpeed(Math.min(amount,1));
        }
    }
}

