package pl.parteka.smarthome.core.device;

import pl.parteka.smarthome.core.Driver;

/**
 * Created by Michal on 2017-01-15.
 */
public abstract class AbstractDriverDevice {

    protected final Driver driver;
    protected final String name;
    protected final DeviceId deviceId;

    public AbstractDriverDevice(Driver driver, String name, DeviceId deviceId) {
        this.driver = driver;
        this.name = name;
        this.deviceId = deviceId;
        driver.registerDevice(this);
    }

    public String getName() {
        return name;
    }

    public DeviceId getDeviceId() {
        return deviceId;
    }

    public abstract String getStatus();

    public abstract void notify(String message);
}
