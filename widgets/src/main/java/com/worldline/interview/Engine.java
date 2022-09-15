package main.java.com.worldline.interview;

/**
 * The interface Engine.
 */
public interface Engine {

    void start();

    void stop();

    boolean isRunning();

    void fill(int fuelLevel);

    FuelType getFuelType();

    int getBatchSize();

    int getFuelLevel();
}
