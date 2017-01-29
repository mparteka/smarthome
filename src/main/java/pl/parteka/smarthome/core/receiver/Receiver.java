package pl.parteka.smarthome.core.receiver;

import pl.parteka.smarthome.core.AbstractDriverDevice;
import pl.parteka.smarthome.core.Driver;
import pl.parteka.smarthome.core.Pin;

/**
 * Created by Michal on 2017-01-15.
 */

public abstract class Receiver extends AbstractDriverDevice {
    protected final Pin pin;

    public Receiver(Driver driver, String name, Pin pin) {
        super(driver, name, pin.toString());
        this.pin = pin;
    }

    @Override
    public void updateValue(Object updatedValue) {
        this.pin.setValue(((Pin) updatedValue).getValue());

    }
}

