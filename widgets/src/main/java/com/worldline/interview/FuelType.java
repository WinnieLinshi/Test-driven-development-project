package main.java.com.worldline.interview;

public enum FuelType {
	
    PETROL(9.00),
    DIESEL(12.00), 
    WOOD(4.35), 
    COAL(5.65);	
	
    private double costPerBatch;

    private FuelType(double costPerBatch) {
        this.costPerBatch = costPerBatch;
    }
    
    public double getValue() {
        return costPerBatch;
    }
}
