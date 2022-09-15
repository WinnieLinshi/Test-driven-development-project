package main.java.com.worldline.interview;

public class WidgetMachine {
    private final Engine engine;
    
    /**
     * Instantiates a Widget machine.
     *
     * @param engine the engine
     */
    public WidgetMachine(final Engine engine) {
        this.engine = engine;
    }
    
    public double produceWidgets(int quantity) {
        engine.start();
        double cost = 0;

        if (engine.isRunning()) {
            cost = produce(quantity);
        }

        engine.stop();

        return cost;
    }

    private double produce(int quantity) {
    	final int batchSize = engine.getBatchSize();
        final double costPerBatch = engine.getFuelType().getValue();
        
        int batch = 0;
        int batchCount = 0;

        while (batch < quantity) {
            batch += batchSize;
            batchCount++;
        }

        return batchCount * costPerBatch;
    }


}
