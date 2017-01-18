package pl.parteka.smarthome.opi.mqtt.intercepthandlers;

import io.moquette.interception.AbstractInterceptHandler;
import pl.parteka.smarthome.core.DriverStateListener;
import pl.parteka.smarthome.opi.mqtt.intercepthandlers.message.AbstractMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Michal on 2017-01-15.
 */
public abstract class AbstractMessageHandler<T extends DriverStateListener> extends AbstractInterceptHandler {
    private Map<String, List<T>> listeners = new HashMap<>();

    public void registerListener(T listener) {
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

        for (T listener : listeners.get(driverId)) {
            if (listener.getDeviceId().equals(msg.getDeviceId())) {
                listener.updateValue(msg.getUpdatedValue());
            }
        }
    }
}
