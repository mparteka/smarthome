package pl.parteka.smarthome.core.sensor;

import pl.parteka.smarthome.core.AbstractDriverDevice;
import pl.parteka.smarthome.core.Driver;

/**
 * Created by Michal on 2017-01-15.
 */
public abstract class AbstractSensor extends AbstractDriverDevice {
    public AbstractSensor(Driver driver, String name, String deviceId) {
        super(driver, name, deviceId);
    }

    abstract Object getValue();
}
