package pl.parteka.smarthome.opi.mqtt.intercepthandlers.message;

/**
 * Created by Michal on 2017-01-15.
 */
public abstract class AbstractMessage {
    protected String deviceId;

    protected Object updatedValue;

    public AbstractMessage(String payload) {
        parsePayload(payload);
    }

    protected abstract void parsePayload(String payload);

    public final String getDeviceId() {
        return deviceId;
    }

    public final Object getUpdatedValue() {
        return updatedValue;
    }
}
