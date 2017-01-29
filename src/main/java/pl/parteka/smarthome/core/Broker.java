package pl.parteka.smarthome.core;

import pl.parteka.smarthome.core.command.Command;

/**
 * Created by Michal on 2017-01-14.
 */
public interface Broker {
    void publish(Message message);

    void sendCommand(Driver driver, Command command);
}
