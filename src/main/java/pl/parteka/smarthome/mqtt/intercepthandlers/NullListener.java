package pl.parteka.smarthome.mqtt.intercepthandlers;

import pl.parteka.smarthome.core.device.DeviceId;
import pl.parteka.smarthome.core.device.DriverMessageListener;
import pl.parteka.smarthome.mqtt.message.DriverMessage;

/**
 * Created by Michal on 2017-01-29.
 */
public class NullListener implements DriverMessageListener {

    @Override
    public void notify(DriverMessage payload) {

    }

    @Override
    public DeviceId getDeviceId() {
        return null;
    }
}
