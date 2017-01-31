package pl.parteka.smarthome.mqtt.intercepthandlers;

import io.moquette.interception.AbstractInterceptHandler;
import io.moquette.interception.messages.InterceptPublishMessage;
import pl.parteka.smarthome.core.device.DeviceId;
import pl.parteka.smarthome.core.device.DriverMessageListener;
import pl.parteka.smarthome.mqtt.message.DriverMessage;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Michal on 2017-01-29.
 */
public class DriverMessageHandler extends AbstractInterceptHandler {

    private Map<DeviceId, DriverMessageListener> listeners = new HashMap<>();

    @Override
    public void onPublish(InterceptPublishMessage msg) {
        //if comes from driver
        String payload = new String(msg.getPayload().array());
        DriverMessage driverMessage = new DriverMessage(payload);
        DeviceId deviceId = new DeviceId(msg.getClientID());
        if (!listeners.containsKey(deviceId)) {
            listeners.get(deviceId).notify(driverMessage);
        }
    }

    public void registerListener(DriverMessageListener listener) {
        listeners.put(listener.getDeviceId(), listener);
    }

}
