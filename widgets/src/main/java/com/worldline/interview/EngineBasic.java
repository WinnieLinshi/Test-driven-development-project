package main.java.com.worldline.interview;

import java.util.List;

public class EngineBasic implements Engine{

	private int batchSize;
    private boolean running;
    private int fuelLevel;
    private FuelType fuelType;
    
    /**
     * initialize a new Engine
     *
     * @param fuelType  the fuel type
     * @param batchSize the batch size
     * @return 
     */
    public void initialize(FuelType fuelType, int batchSize) {
        this.fuelType = fuelType;
        this.batchSize = batchSize;
    }
    
    /**
     * initialize a new Engine
     *
     * @param supportedFuelTypes the fuel types which the engine supports
     * @param batchSize 		 the batch size
     * @return 
     */
    public void checkFuelType(List<FuelType> supportedFuelTypes) {
    	if(!supportedFuelTypes.contains(fuelType)) {
            throw new IllegalStateException("This engine doesn't support this fuel.");
    	}
    }
    
    @Override
	public void start() {
        if (fuelLevel != 0) {
            running = true;
        } else {
            throw new IllegalStateException("Not able to start engine.");
        }		
	}

	@Override
	public void stop() {
        running = false;
	}

	@Override
	public boolean isRunning() {
        return running;
	}

	@Override
	public void fill(int fuelLevel) {
        if (fuelLevel >= 0 && fuelLevel <= 100) {
            this.fuelLevel = fuelLevel;
        }
        else if (fuelLevel > 100) {
            this.fuelLevel = 100;
        }
        else {
            this.fuelLevel = 0;
        }
	}
	
	@Override
	public FuelType getFuelType() {
        return fuelType;
	}
	
	@Override
    public int getBatchSize() {
        return batchSize;
    }
	
	@Override
	public int getFuelLevel() {
		return fuelLevel;
	}
}
