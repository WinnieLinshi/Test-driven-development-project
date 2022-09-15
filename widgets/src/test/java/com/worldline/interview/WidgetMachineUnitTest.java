package test.java.com.worldline.interview;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

import main.java.com.worldline.interview.WidgetMachine;
import main.java.com.worldline.interview.Engine;
import main.java.com.worldline.interview.FuelType;
import main.java.com.worldline.interview.InternalCombustionEngine;
import main.java.com.worldline.interview.SteamEngine;

/**
 * @author Winnie
 * @date 2022/9/15
 */
public class WidgetMachineUnitTest {
    private WidgetMachine widget;

    @Test
    public void returnTheExpectedValueWhenUsingInternalCombustionEnginePetrolFuel() {
        Engine engine = new InternalCombustionEngine(FuelType.PETROL);
        engine.fill(100);
        assertThat(initializeWidgetAndProduce(engine,2)).isEqualTo(9.0);
    }

    @Test
    public void returnTheExpectedValueWhenUsingInternalCombustionEngineDieselFuel() {
        Engine engine = new InternalCombustionEngine(FuelType.DIESEL);
        engine.fill(100);
        assertThat(initializeWidgetAndProduce(engine,50)).isEqualTo(84.0);
    }

    @Test
    public void returnTheExpectedValueWhenUsingSteamEngineAndWoodFuel() {
        Engine engine = new SteamEngine(FuelType.WOOD);
        engine.fill(100);
        assertThat(initializeWidgetAndProduce(engine,30)).isEqualTo(65.25);
    }

    @Test
    public void returnTheExpectedValueWhenUsingSteamEngineAndCoalFuel() {
        Engine engine = new SteamEngine(FuelType.COAL);
        engine.fill(100);
        assertThat(initializeWidgetAndProduce(engine,80)).isEqualTo(226.0);
    }
    
    //private test helpers
    /**
     * initialize a new widget and produce the demand quantity
     *
     * @param engine   the engine which the new widget uses
     * @param quantity the demand quantity
     * @return 
     */
    private double initializeWidgetAndProduce(final Engine engine, final int quantity) {
        widget = new WidgetMachine(engine);
        return widget.produceWidgets(quantity);
    }
}