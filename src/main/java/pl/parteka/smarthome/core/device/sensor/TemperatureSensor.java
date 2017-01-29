package pl.parteka.smarthome.core.device.sensor;

import pl.parteka.smarthome.core.Driver;

/**
 * Created by Michal on 2017-01-15.
 */
public class TemperatureSensor extends AbstractSensor {

    private float value;

    public TemperatureSensor(Driver driver, String name, String serialNumber) {
        super(driver, name, serialNumber);
    }


    @Override
    public void updateValue(Object updatedValue) {
        this.value = (Float) updatedValue;
    }

    @Override
    public Float getValue() {
        return new Float(value);
    }

}
