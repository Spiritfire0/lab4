package Tests;

import org.junit.Before;
import org.junit.Test;

public class TestSaab95 {
    private Saab95 TestSaab;

    @Before
    public void Setup() {
        TestSaab = new Saab95();

    }
    @Test
    public void TestSetTurboOn(){
        TestSaab.setTurboOn();

        assert TestSaab.turboOn;

    }
    @Test
    public void TestSetTurboOff(){
        TestSaab.setTurboOff();
        assert !TestSaab.turboOn;
    }


    @Test
    public void TestSpeedFactorTurboOn(){
        TestSaab.setTurboOn();
        assert TestSaab.speedFactor() == 125 * 0.01 * 1.3;


    }
    @Test
    public void TestSpeedFactorTurboOff(){
        TestSaab.setTurboOff();
        assert TestSaab.speedFactor() == 125 * 0.01 * 1.0;

    }
    @Test
    public void TestIncrementSpeedTurboOn(){
        TestSaab.setTurboOn();
        for (int i = 0; i<10; i++){
            TestSaab.gas(1);
        }
        // 0 + 125 * 0.01 * 1.3 * 10
        assert TestSaab.getCurrentSpeed() == 0 + 125 * 0.01 * 1.3 * 10;

    }
    @Test
    public void TestIncrementSpeedTurboOff(){
        TestSaab.setTurboOff();
        TestSaab.gas(1);
        // 0 + 125 * 0.01 * 1.0 * 10
        assert TestSaab.getCurrentSpeed() == 0 + 125 * 0.01 * 1.0 * 1;

    }
    @Test
    public void TestDecrementSpeedTurboOn(){
        TestSaab.setTurboOn();
        TestSaab.gas(1);
        TestSaab.brake(1);
        // (0 + 125 * 0.01 * 1.3 * 1) - (125 * 0.01 * 1.3 * 1)
        assert TestSaab.getCurrentSpeed() == (0 + 125 * 0.01 * 1.3 * 1) - (125 * 0.01 * 1.3 * 1);

    }
    @Test
    public void TestDecrementSpeedTurboOff(){
        TestSaab.gas(1);
        TestSaab.brake(1);
        // (0 + 125 * 0.01 * 1.3 * 10) - (125 * 0.01 * 1.3 * 5)
        assert TestSaab.getCurrentSpeed() == (0 + 125 * 0.01 * 1.0 * 1) - (125 * 0.01 * 1.0 * 1);

    }
}
