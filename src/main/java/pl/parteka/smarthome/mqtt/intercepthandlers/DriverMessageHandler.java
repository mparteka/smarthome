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
        String payload = new String(msg.getPayload().array());
        DriverMessage driverMessage = new DriverMessage(payload);
        notify(new DeviceId(msg.getClientID()), driverMessage);
    }

    public void registerListener(DriverMessageListener listener) {
        listeners.put(listener.getDeviceId(), listener);
    }

    protected void notify(DeviceId driverId, DriverMessage driverMessage) {
        getListener(driverId).notify(driverMessage);

    }

    private DriverMessageListener getListener(final DeviceId deviceId) {
        if (!listeners.containsKey(deviceId)) {
            return new NullListener();
        }
        return listeners.get(deviceId);
    }


}
