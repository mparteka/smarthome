package pl.parteka.smarthome.opi.mqtt.intercepthandlers;

import pl.parteka.smarthome.core.Driver;
import pl.parteka.smarthome.core.DriverStateListener;

/**
 * Created by Michal on 2017-01-29.
 */
public class NullListener implements DriverStateListener {
    @Override
    public Driver getDriver() {
        return null;
    }

    @Override
    public void updateValue(Object updatedValue) {

    }

    @Override
    public String getDeviceId() {
        return null;
    }
}
