package pl.parteka.smarthome.opi.mqtt.intercepthandlers.message;

import pl.parteka.smarthome.core.Pin;

/**
 * Created by Michal on 2017-01-15.
 */
public class PinStateMessage extends AbstractMessage {

    public PinStateMessage(String payload) {
        super(payload);

    }

    @Override
    protected void parsePayload(String payload) {
        Pin pin = getPinFromValue(payload);
        this.deviceId = pin.toString();
        this.updatedValue = pin;
    }

    private Pin getPinFromValue(String value) {
        String[] parts = value.split(" ");
        Integer pin = -1;
        Integer pinValue = -1;
        if (parts.length == 2) {
            pin = Integer.valueOf(parts[0]);
            pinValue = Integer.valueOf(parts[1]);

        } else {
            //invalid pin value
        }
        return new Pin(pin, pinValue);
    }

}
