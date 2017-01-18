package pl.parteka.smarthome.opi.mqtt.intercepthandlers.message;

/**
 * Created by Michal on 2017-01-15.
 */
public class TemperatureMessage extends AbstractMessage {
    public TemperatureMessage(String payload) {
        super(payload);
    }

    @Override
    protected void parsePayload(String payload) {
        String[] parts = payload.split(" ");
        this.deviceId = parts[0];
        this.updatedValue = Float.valueOf(parts[1]);
    }

}
