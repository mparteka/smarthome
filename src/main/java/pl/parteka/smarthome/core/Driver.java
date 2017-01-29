package pl.parteka.smarthome.core;

import pl.parteka.smarthome.core.command.Command;
import pl.parteka.smarthome.core.device.AbstractDriverDevice;
import pl.parteka.smarthome.core.device.DeviceId;
import pl.parteka.smarthome.core.device.DriverMessageListener;
import pl.parteka.smarthome.mqtt.message.DriverMessage;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Michal on 2017-01-14.
 */
public class Driver implements DriverMessageListener {
    private final DeviceId id;
    private final Broker broker;
    private Map<DeviceId, AbstractDriverDevice> devices = new HashMap<>();

    public Driver(String id, Broker broker) {
        this.id = new DeviceId(id);
        this.broker = broker;
    }

    public DeviceId getId() {
        return id;
    }

    public void sendCommand(Command command) {
        broker.publish(this, command);
    }

    public void registerDevice(AbstractDriverDevice device) {
        devices.put(device.getDeviceId(), device);
    }

    @Override
    public void notify(DriverMessage message) {
//        if (devices.containsKey(message.getDeviceId())) {
            devices.get(message.getDeviceId()).notify(message.getValue());
//        }
    }

    @Override
    public DeviceId getDeviceId() {
        return id;
    }
}
