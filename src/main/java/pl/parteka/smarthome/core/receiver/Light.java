package pl.parteka.smarthome.core.receiver;

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


    public void sendPinState(int pinState) {
        SwitchCommand command = new SwitchCommand(pin, pinState);
        driver.sendCommand(command);

    }

    public void turnOn() {
        sendPinState(Pin.PIN_ON);
    }

    public void switchLight() {
        int newValue = 0;
        if (this.pin.getValue() == Pin.PIN_ON) {
            newValue = Pin.PIN_OFF;
        } else {
            newValue = Pin.PIN_ON;
        }
        sendPinState(newValue);
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
        sendPinState(Pin.PIN_OFF);
    }

    @Override
    public String getDeviceId() {
        return pin.toString();
    }
}
