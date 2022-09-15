package test.java.com.worldline.interview;

import static org.junit.Assert.fail;

import org.junit.Test;

import main.java.com.worldline.interview.FuelType;
import main.java.com.worldline.interview.InternalCombustionEngine;

/**
 * @author Winnie
 * @date 2022/9/15
 */
public class InternalCombustionEngineUnitTest {
    @Test(expected = IllegalStateException.class)
    public void notAllowToCreateACombustionEngineWithPetrol() {
        new InternalCombustionEngine(FuelType.WOOD);

        fail("it shouldn't reach here");
    }

    @Test(expected = IllegalStateException.class)
    public void notAllowToCreateACombustionEngineWithDiesel() {
        new InternalCombustionEngine(FuelType.COAL);

        fail("it shouldn't reach here");

    }
}