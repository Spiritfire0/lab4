

import org.junit.Before;
import org.junit.Test;

public class TestVolvo240 {
    private Volvo240 newVolvo;

    @Before
    public void Setup() {
        newVolvo = new Volvo240();

    }
    @Test
    public void TestSpeedFactor() {
        double spf = newVolvo.speedFactor();
        assert spf == 1.25;
    }

    @Test
    public void TestIncrementSpeedLessThanEnginePower() {
        newVolvo.gas(1);
        double current = newVolvo.getCurrentSpeed();
        assert current == 1.25;

    }
    @Test
    public void TestIncrementSpeedMoreThanEnginePower() {
        for (int i = 0; i<100; i++){
            newVolvo.gas(1);
        }

        double current = newVolvo.getCurrentSpeed();
        assert current == 100;
    }

    @Test
    public void TestDecrementSpeed() {
        for (int i = 0; i<10; i++){
            newVolvo.gas(1);
        }

        for (int i = 0; i<9; i++){
            newVolvo.brake(1);
        }

        double after = newVolvo.getCurrentSpeed();

        assert after == 1.25;
    }

}
