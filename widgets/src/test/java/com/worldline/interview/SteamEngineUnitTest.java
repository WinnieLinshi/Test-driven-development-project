package test.java.com.worldline.interview;
import static org.junit.Assert.fail;

import org.junit.Test;
import main.java.com.worldline.interview.FuelType;
import main.java.com.worldline.interview.SteamEngine;

/**
 * @author Winnie
 * @date 2022/9/15
 */
public class SteamEngineUnitTest {
    @Test(expected = IllegalStateException.class)
    public void notAllowToCreateACombustionEngineWithPetrol() {
        new SteamEngine(FuelType.PETROL);

        fail("it shouldn't reach here");
    }

    @Test(expected = IllegalStateException.class)
    public void notAllowToCreateACombustionEngineWithDiesel() {
        new SteamEngine(FuelType.DIESEL);

        fail("it shouldn't reach here");

    }
}