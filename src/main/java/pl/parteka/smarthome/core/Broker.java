package pl.parteka.smarthome.core;

import pl.parteka.smarthome.core.command.Command;

/**
 * Created by Michal on 2017-01-14.
 */
public interface Broker {
    void publish(Driver driver, Command command);
}
