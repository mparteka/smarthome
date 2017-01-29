package pl.parteka.smarthome.core.device;

import pl.parteka.smarthome.mqtt.message.DriverMessage;

/**
 * Created by Michal on 2017-01-15.
 */
public interface DriverMessageListener {

    void notify(DriverMessage payload);

    DeviceId getDeviceId();
}
