package WhatIsACar;

public class CarFactory {
    public static Car createVolvo240() {
        return new Volvo240();}
    public static  Car createSaab95(){
        return new Saab95();}
    public static Car createScania() {
        return new Scania();}
    public static  Car createFordL9000(){
        return new FordL9000();}
}
