package PlayableCar;

import WhatIsACar.*;
import java.util.ArrayList;

public class ComponentHolder {
    public ArrayList<Car> components = new ArrayList<>();

    public void addVolvo240(){
        components.add(CarFactory.createVolvo240());
    }
    public void addSaab95(){
        components.add(CarFactory.createSaab95());
    }
    public void addScania(){
        components.add(CarFactory.createScania());
    }
    public void addFordL9000(){
        components.add(CarFactory.createFordL9000());
    }


}
