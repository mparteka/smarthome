package pl.parteka.smarthome.core.receiver;

import pl.parteka.smarthome.core.AbstractDriverDevice;
import pl.parteka.smarthome.core.Driver;
import pl.parteka.smarthome.core.Pin;
import pl.parteka.smarthome.core.PinStatusListener;

/**
 * Created by Michal on 2017-01-15.
 */

public abstract class Receiver extends AbstractDriverDevice implements PinStatusListener {
    protected final String name;
    protected final Pin pin;
    protected final Driver driver;

    public Receiver(Driver driver, String name, Pin pin) {
        super(driver);
        this.driver = driver;
        this.name = name;
        this.pin = pin;
    }

    public String getName() {
        return name;
    }

    public Pin getPin() {
        return pin;
    }

    @Override
    public void updateValue(Object updatedValue) {
        this.pin.setValue(((Pin) updatedValue).getValue());

    }
}

