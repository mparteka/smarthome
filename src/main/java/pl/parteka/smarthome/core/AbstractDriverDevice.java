package pl.parteka.smarthome.core;

/**
 * Created by Michal on 2017-01-15.
 */
public abstract class AbstractDriverDevice {
    protected Driver driver;

    public AbstractDriverDevice(Driver driver) {
        this.driver = driver;
    }

    public Driver getDriver() {
        return driver;
    }


}
