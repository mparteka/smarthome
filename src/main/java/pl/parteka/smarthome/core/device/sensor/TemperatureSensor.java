package pl.parteka.smarthome.core.device.sensor;

import pl.parteka.smarthome.core.Driver;
import pl.parteka.smarthome.core.device.DeviceId;

/**
 * Created by Michal on 2017-01-15.
 */
public class TemperatureSensor extends AbstractSensor {

    private float value;

    public TemperatureSensor(Driver driver, String name, String serialNumber) {
        super(driver, name, new DeviceId(serialNumber));
    }

    @Override
    public String getStatus() {
        return "Temperature " + getName() + ": " + getValue();
    }

    @Override
    public Float getValue() {
        return new Float(value);
    }

    @Override
    public void notify(String payload) {
        this.value = Float.valueOf(payload);
    }
}
