package main.java.com.worldline.interview;

import java.util.Arrays;

public class SteamEngine extends EngineBasic{

    private static final int BATCH_SIZE = 2;

    public SteamEngine(FuelType fuelType) {
    	initialize(fuelType,BATCH_SIZE);
    	checkFuelType(Arrays.asList(FuelType.WOOD,FuelType.COAL));
    }
}
