package PlayableCar;

import WhatIsACar.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
* This class represents the Controller part in the MVC pattern.
* Its responsibilities are to listen to the View and responds in an appropriate manner by
* modifying the model state and the updating the view.
 **/

public class CarController {
    // member fields:
    private int gasAmount = 0;
    private int brakeAmount = 0;

    //methods:
    void setGasBrakeAmount(int amount) {
        gasAmount = brakeAmount = amount;
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : componentHolder.components) {
            car.gas(gas);
        }
    }
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : componentHolder.components) {
            car.brake(brake);}
    }

    void raiseTrailers(ArrayList<Car> cars) {
        for(Car car : cars){
            if (car.getClass() == Scania.class){
                ((Scania) car).raiseTrailer(5);
            }
        }
    }
    void lowerTrailers(ArrayList<Car> cars) {
        for(Car car : cars){
            if (car.getClass() == Scania.class){
                ((Scania) car).lowerTrailer(5);
            }
        }
    }

    void setTurbosOn(ArrayList<Car> cars) {
        for (Car car : cars) {
            if (car.getClass() == Saab95.class) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void setTurbosOff(ArrayList<Car> cars) {
        for (Car car : cars) {
            if (car.getClass() == Saab95.class) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void startEngines(ArrayList<Car> cars) {
        for(Car car : cars) {
            car.startEngine();
        }
    }

    void stopEngines(ArrayList<Car> cars) {
        for(Car car : cars) {
            car.stopEngine();
        }
    }
}