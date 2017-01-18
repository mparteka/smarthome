package pl.parteka.smarthome.core.sensor;

import pl.parteka.smarthome.core.Driver;
import pl.parteka.smarthome.core.TemperatureListener;

/**
 * Created by Michal on 2017-01-15.
 */
public class TemperatureSensor extends AbstractSensor implements TemperatureListener {

    private float value;
    private final String name;
    private final String serialNumber;

    public TemperatureSensor(Driver driver, String name, String serialNumber) {
        super(driver);
        this.name = name;
        this.serialNumber = serialNumber;
    }

    @Override
    public void updateTemperature(float value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    @Override
    public void updateValue(Object updatedValue) {
        this.value = (Float) updatedValue;
    }

    @Override
    public String getDeviceId() {
        return this.serialNumber;
    }

    @Override
    public Float getValue() {
        return new Float(value);
    }
}
