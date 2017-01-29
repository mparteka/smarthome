package pl.parteka.smarthome;

import pl.parteka.smarthome.core.Driver;
import pl.parteka.smarthome.core.Pin;
import pl.parteka.smarthome.core.device.receiver.Light;
import pl.parteka.smarthome.core.device.sensor.TemperatureSensor;
import pl.parteka.smarthome.mqtt.MqttBroker;
import pl.parteka.smarthome.opi.mqtt.intercepthandlers.MessageHandler;
import pl.parteka.view.RoomView;

/**
 * Created by Michal on 2017-01-14.
 */
public class SmartHome {

    private final static String clientId = "44355039074e2800006d";

    public static void main(String[] args) throws Exception {
        final MqttBroker broker = new MqttBroker();
        Driver driver = new Driver(clientId, broker);

        MessageHandler messageHandler = new MessageHandler();
        broker.addInterceptHandler(messageHandler);

        //TODO: move it to core initialization and read definition from DB
        Light light1 = new Light(driver, "Biuro light", new Pin(Pin.PA13));
        Light light2 = new Light(driver, "Pokój light", new Pin(Pin.PA14));
        messageHandler.registerListener(light1);
        messageHandler.registerListener(light2);
        TemperatureSensor temp1 = new TemperatureSensor(driver, "Biuro temp", "28-80000004920e");
        messageHandler.registerListener(temp1);

        RoomView roomView = new RoomView();
        roomView.addLight(light1);
        roomView.addLight(light2);
        roomView.addTemperatureSensor(temp1);
        roomView.start();
    }
}
