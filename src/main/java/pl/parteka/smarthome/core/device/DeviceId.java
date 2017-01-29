package pl.parteka.smarthome.core.device;

/**
 * Created by Michal on 2017-01-29.
 */
public class DeviceId {
    private final String value;

    public DeviceId(String value) {

        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeviceId)) return false;

        DeviceId deviceId = (DeviceId) o;

        return value != null ? value.equals(deviceId.value) : deviceId.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
