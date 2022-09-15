package test.java.com.worldline.interview;

import static org.assertj.core.api.Assertions.fail;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import main.java.com.worldline.interview.Engine;
import main.java.com.worldline.interview.FuelType;
import main.java.com.worldline.interview.InternalCombustionEngine;

/**
 * @author Winnie
 *
 */
public class EngineBasicUnitTest {
    private Engine engine;

    @Test
    public void engineUsingPetrolWithValidValues() {
        engine = new InternalCombustionEngine(FuelType.PETROL);

        assertThat(engine.getFuelType()).isEqualTo(FuelType.PETROL);
        assertThat(engine.getFuelLevel()==0).isTrue();
        assertThat(engine.getBatchSize()).isEqualTo(8);
        assertThat(engine.getFuelType().getValue()).isEqualTo(9.0);
        assertThat(engine.isRunning()).isFalse();
    }

    @Test
    public void engineUsingDieselWithValidValues() {
        engine = new InternalCombustionEngine(FuelType.DIESEL);

        assertThat(engine.getFuelType()).isEqualTo(FuelType.DIESEL);
        assertThat(engine.getFuelLevel()==0).isTrue();
        assertThat(engine.getBatchSize()).isEqualTo(8);
        assertThat(engine.getFuelType().getValue()).isEqualTo(12.0);
        assertThat(engine.isRunning()).isFalse();
    }

    @Test(expected = IllegalStateException.class)
    public void notAllowToGiveInvalidFuelType() {
        engine = new InternalCombustionEngine(FuelType.COAL);
        
        fail("shouldn't reach here");
    }
    
    @Test(expected = IllegalStateException.class)
    public void notAllowToStartTheEngineWhenIsEmpty() {
    	Engine petrolEngine = new InternalCombustionEngine(FuelType.DIESEL);
    	petrolEngine.start();
    	
    	fail("shouldn't reach here");
    }

    @Test
    public void fillEngineWithValidValues() {
        Engine engine = new InternalCombustionEngine(FuelType.PETROL);
        engine.fill(50);
        
        assertThat(engine.getFuelLevel()).isEqualTo(50);
    }
    
    @Test
    public void notAllowToFillEngineWhenIsFull() {
        Engine engine = new InternalCombustionEngine(FuelType.DIESEL);
        engine.fill(150);
        
        assertThat(engine.getFuelLevel()).isEqualTo(100);
    }

    @Test
    public void notAllowNegativeFilling() {
        Engine petrolEngine = new InternalCombustionEngine(FuelType.PETROL);
        petrolEngine.fill(-1);
        
        assertThat(petrolEngine.getFuelLevel()).isEqualTo(0);
    }

    @Test
    public void startTheEngineWhenIsNotEmpty() {
        Engine petrolEngine = new InternalCombustionEngine(FuelType.DIESEL);
        petrolEngine.fill(25);
        petrolEngine.start();
        
        assertThat(petrolEngine.isRunning()).isTrue();
    }

    @Test
    public void allowToStopTheEngineWhenIsRunning() {
        Engine petrolEngine = new InternalCombustionEngine(FuelType.PETROL);
        petrolEngine.fill(25);
        petrolEngine.start();
        petrolEngine.stop();

        assertThat(petrolEngine.isRunning()).isFalse();
    }
}