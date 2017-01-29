package pl.parteka.smarthome.core.device;

import pl.parteka.smarthome.core.Driver;

/**
 * Created by Michal on 2017-01-15.
 */
public abstract class AbstractDriverDevice implements DriverStateListener {
    protected final Driver driver;
    protected final String name;
    protected final String deviceId;

    public AbstractDriverDevice(Driver driver, String name, String deviceId) {
        this.driver = driver;
        this.name = name;
        this.deviceId = deviceId;
    }

    public Driver getDriver() {
        return driver;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getDeviceId() {
        return deviceId;
    }
}
