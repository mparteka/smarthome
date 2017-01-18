package pl.parteka.smarthome.core;

/**
 * Created by Michal on 2017-01-14.
 */
public interface Broker {
    void publish(Message message);
}
