package pl.parteka.smarthome.core;

/**
 * Created by Michal on 2017-01-15.
 */
public interface TemperatureListener extends DriverStateListener{
    void updateTemperature(float value);
}
