package main.java.com.worldline.interview;

import java.util.Arrays;

public class InternalCombustionEngine extends EngineBasic{

    private static final int BATCH_SIZE = 8;

    public InternalCombustionEngine(FuelType fuelType) {
    	initialize(fuelType,BATCH_SIZE);
    	checkFuelType(Arrays.asList(FuelType.DIESEL,FuelType.PETROL));
    }
}
