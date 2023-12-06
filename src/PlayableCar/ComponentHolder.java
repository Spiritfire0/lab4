package PlayableCar;

import WhatIsACar.*;
import java.util.ArrayList;

public class ComponentHolder {
    public ArrayList<Car> components = new ArrayList<>();

    private void addCar (Car car) {
        //adds a car to the list and sets the postition to be in a column of five cars
        car.setPosition ((150 * ((components.size() >= 5)? 1 : 0)), (100 * (components.size() % 5)));
        components.add(car);
    }
    public void addVolvo240(){addCar(CarFactory.createVolvo240());
    }
    public void addSaab95(){
        addCar(CarFactory.createSaab95());
    }
    public void addScania(){addCar(CarFactory.createScania());}
    public void addFordL9000(){
        addCar(CarFactory.createFordL9000());
    }


}
