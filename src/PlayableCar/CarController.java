package PlayableCar;

import WhatIsACar.*;

/**
* This class represents the Controller part in the MVC pattern.
* Its responsibilities are to listen to the View and responds in an appropriate manner by
* modifying the model state and the updating the view.
 **/

public class CarController {
    // member fields:
    private int gasAmount = 0;
    private int brakeAmount = 0;

    ComponentHolder componentHolder;

    public CarController(ComponentHolder ch) {
        this.componentHolder = ch;
    }

    //methods:
    void setGasBrakeAmount(int amount) {
        gasAmount = brakeAmount = amount;
    }

    // Calls the gas method for each car once
    void gas() {
        double gas = ((double) gasAmount) / 100;
        for (Car car : componentHolder.components) {
            car.gas(gas);
        }
    }
    void brake() {
        double brake = ((double) brakeAmount) / 100;
        for (Car car : componentHolder.components) {
            car.brake(brake);}
    }

    void raiseTrailers() {
        for(Car car : componentHolder.components){
            if (car instanceof CarWithTrailer){
                ((CarWithTrailer) car).raiseTrailer(5);
            }
        }
    }
    void lowerTrailers() {
        for(Car car : componentHolder.components){
            if (car instanceof CarWithTrailer){
                ((CarWithTrailer) car).lowerTrailer(5);
            }
        }
    }

    void setTurbosOn() {
        for (Car car : componentHolder.components) {
            if (car instanceof CarWithTurbo) {
                ((CarWithTurbo) car).setTurboOn();
            }
        }
    }

    void setTurbosOff() {
        for (Car car : componentHolder.components) {
            if (car instanceof CarWithTurbo) {
                ((CarWithTurbo) car).setTurboOff();
            }
        }
    }

    void startEngines() {
        for(Car car : componentHolder.components) {
            car.startEngine();
        }
    }

    void stopEngines() {
        for(Car car : componentHolder.components) {
            car.stopEngine();
        }
    }
    void addRandomCar() {
        if(componentHolder.components.size() < 10){
            double random = (Math.random()*AvailableCars.values().length);
            addCarFromNumber((int) Math.round(random));
        }
        else
            System.out.println("To many cars");
    }
    void addCarFromNumber(int x){
        switch (x){
            case 1:
                componentHolder.addVolvo240();
                break;
            case 2:
                componentHolder.addSaab95();
                break;
            case 3:
                componentHolder.addScania();
                break;
            case 4:
                componentHolder.addFordL9000();
                break;


        }
    }
    void removeCar(){
        //remove last car from list
        if(!componentHolder.components.isEmpty()){
            componentHolder.components.remove(componentHolder.components.size() - 1);
        }
        else
            System.out.println("No cars to remove");
    }
}