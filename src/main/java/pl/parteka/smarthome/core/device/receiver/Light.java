package pl.parteka.smarthome.core.device.receiver;

import pl.parteka.smarthome.core.Driver;
import pl.parteka.smarthome.core.Pin;
import pl.parteka.smarthome.core.command.SwitchCommand;

/**
 * Created by Michal on 2017-01-15.
 */
public class Light extends Receiver {


    public Light(Driver driver, String name, Pin pin) {
        super(driver, name, pin);
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

}
