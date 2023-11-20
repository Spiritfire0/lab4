package Tests;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.Arrays;

public class TestCar {

    private Car testCar;

    @Before
    public void setup() {
        testCar = new Volvo240();
    }

    @Test
    public void testGetNrDoors() {
        assert 4 == testCar.getNrDoors();
    }

    @Test
    public void testGetEnginePower() {
        assert 100 == testCar.getEnginePower();
    }

    @Test
    public void testGetCurrentSpeed() {
        assert 0 == testCar.getCurrentSpeed();
    }

    @Test
    public void testGetPosition() {
        double[] position = {0,0};
        double[] getPos = testCar.getPosition();

        assert Arrays.equals(getPos,position);
    }

    @Test
    public void testGetColor() {

        assert Color.black == testCar.getColor();
    }

    @Test
    public void testSetColor() {
        testCar.setColor(Color.BLUE);
        assert testCar.getColor() == Color.BLUE;

    }

    @Test
    public void testStartEngine() {
        testCar.startEngine();
        assert testCar.getCurrentSpeed() == 0.1;
    }

    @Test
    public void testStopEngine() {
        testCar.startEngine();
        testCar.stopEngine();
        assert testCar.getCurrentSpeed() == 0;
    }

    @Test
    public void testGetDirection() {
        assert 0 == testCar.getDirection();
    }

    @Test
    public void testMove() {
        testCar.gas(1);
        double speed = testCar.getCurrentSpeed();
        double dir = testCar.getDirection();
        testCar.move();
        assert (testCar.getPosition()[1] == speed * Math.sin(dir)) &&
                (testCar.getPosition()[0] == speed * Math.cos(dir));
    }

    @Test
    public void testTurnRight() {
        double dir = testCar.getDirection();
        double turnAmount = Math.PI / 3;
        testCar.turnRight(turnAmount);
        assert dir - turnAmount == testCar.getDirection();

    }

    @Test
    public void testTurnLeft() {
        double dir = testCar.getDirection();
        double turnAmount = Math.PI / 3;
        testCar.turnLeft(turnAmount);
        assert dir + turnAmount == testCar.getDirection();
    }

    @Test
    public void testGasNegativeValue() {
        testCar.gas(-10);
        System.out.println(testCar.getCurrentSpeed());
        assert testCar.getCurrentSpeed() == 0;
    }

    @Test
    public void testGasTooHighValue() {
        testCar.gas(20);
        double speed = testCar.getCurrentSpeed();

        testCar.stopEngine();

        testCar.gas(1);

        assert speed == testCar.getCurrentSpeed();
    }

    @Test
    public void testGasLegalValue() {
        testCar.gas(0.5);
        double speed = testCar.getCurrentSpeed();

        testCar.stopEngine();

        testCar.gas(0.5);
        assert speed == testCar.getCurrentSpeed();
    }

    @Test
    public void testBrakeNegativeValues() {
        testCar.gas(1);
        testCar.brake(-10);
        assert testCar.getCurrentSpeed() == testCar.speedFactor();

    }

    @Test
    public void testBrakeTooHighValues() {
        testCar.gas(1);
        testCar.brake(20);
        assert testCar.getCurrentSpeed() == 0;
    }

    @Test
    public void testBrakeLegalValue() {
        testCar.gas(1);
        testCar.brake(0.5);
        double speed = testCar.getCurrentSpeed();

        testCar.stopEngine();
        testCar.gas(0.5);

        assert speed == testCar.getCurrentSpeed();
    }
}
