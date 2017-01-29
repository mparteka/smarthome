package pl.parteka.smarthome.opi.mqtt.intercepthandlers;

import io.moquette.interception.AbstractInterceptHandler;
import pl.parteka.smarthome.core.device.DriverStateListener;
import pl.parteka.smarthome.opi.mqtt.intercepthandlers.message.AbstractMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Michal on 2017-01-15.
 */
public abstract class AbstractMessageHandler extends AbstractInterceptHandler {

    private Map<String, List<DriverStateListener>> listeners = new HashMap<>();

    public void registerListener(DriverStateListener listener) {
        if (!listeners.containsKey(listener.getDriver().getId())) {
            listeners.put(listener.getDriver().getId(), new ArrayList<>());
        }

        listeners.get(listener.getDriver().getId()).add(listener);
    }

    public void notify(String driverId, AbstractMessage msg) {
        if (!listeners.containsKey(driverId)) {
            System.err.println("No driver");
            return;
        }

        getListener(driverId, msg.getDeviceId()).updateValue(msg.getUpdatedValue());

    }

    public DriverStateListener getListener(final String driverId, final String deviceId) {
        if (listeners.containsKey(driverId)) {
            return listeners.get(driverId).stream().filter(listener -> listener.getDeviceId().equals(deviceId)).findFirst().orElse(new NullListener());
        }
        return new NullListener();
    }
}
