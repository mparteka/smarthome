package pl.parteka.smarthome.mqtt.message;

import pl.parteka.smarthome.core.device.DeviceId;

/**
 * Created by Michal on 2017-01-29.
 */
public class DriverMessage {
    private final DeviceId deviceId;
    private final String value;

    public DriverMessage(String payload) {
        this.deviceId = extractDeviceId(payload);
        this.value = extractValue(payload);
    }

    private String extractValue(String payload) {
        return payload.substring(getDeviceId().toString().length() + 1);
    }

    private DeviceId extractDeviceId(String payload) {
        String[] parts = payload.split(" ");
        if (parts.length > 0) {
            return new DeviceId(parts[0]);
        }
        return new DeviceId("");
    }

    public DeviceId getDeviceId() {
        return deviceId;
    }

    public String getValue() {
        return value;
    }
}
