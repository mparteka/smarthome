package pl.parteka.smarthome.core;

import pl.parteka.smarthome.core.command.Command;
import pl.parteka.smarthome.mqtt.CommandMessage;

/**
 * Created by Michal on 2017-01-14.
 */
public class Driver {
    private final String id;
    private final Broker broker;

    public Driver(String id, Broker broker) {
        this.id = id;
        this.broker = broker;
    }

    public String getId() {
        return id;
    }


    public void sendCommand(Command command) {
        CommandMessage message = new CommandMessage(this, command);
        broker.publish(message);
    }
}
