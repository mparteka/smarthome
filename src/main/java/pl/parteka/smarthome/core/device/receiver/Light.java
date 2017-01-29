package pl.parteka.smarthome.core.device.receiver;

import pl.parteka.smarthome.core.Driver;
import pl.parteka.smarthome.core.Pin;
import pl.parteka.smarthome.core.command.SwitchCommand;
import pl.parteka.smarthome.core.device.AbstractDriverDevice;
import pl.parteka.smarthome.core.device.DeviceId;

/**
 * Created by Michal on 2017-01-15.
 */
public class Light extends AbstractDriverDevice {
    protected final Pin pin;

    public Light(Driver driver, String name, Pin pin) {
        super(driver, name, new DeviceId(pin.toString()));
        this.pin = pin;
    }

    protected void setPinState(int pinState) {
        SwitchCommand command = new SwitchCommand(pin, pinState);
        driver.sendCommand(command);

    }

    public void turnOn() {
        setPinState(Pin.PIN_ON);
    }

    public boolean isOn() {
        return pin.getValue() == Pin.PIN_ON;
    }

    public String getStatus() {
        if (isOn()) {
            return "Light is ON";
        } else {
            return "Light is OFF";
        }
    }

    public void turnOff() {
        setPinState(Pin.PIN_OFF);
    }

    @Override
    public void notify(String payload) {
        this.pin.setValue(Integer.valueOf(payload));
    }
}
