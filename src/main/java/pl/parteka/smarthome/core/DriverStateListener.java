package pl.parteka.smarthome.core;

/**
 * Created by Michal on 2017-01-15.
 */
public interface DriverStateListener {
    Driver getDriver();

    void updateValue(Object updatedValue);

    String getDeviceId();
}
