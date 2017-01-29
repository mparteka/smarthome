package pl.parteka.smarthome;

import pl.parteka.smarthome.core.Driver;
import pl.parteka.smarthome.core.Pin;
import pl.parteka.smarthome.core.device.receiver.Light;
import pl.parteka.smarthome.core.device.sensor.TemperatureSensor;
import pl.parteka.smarthome.mqtt.MqttBroker;
import pl.parteka.smarthome.mqtt.intercepthandlers.ClientMessageHandler;
import pl.parteka.smarthome.mqtt.intercepthandlers.DriverMessageHandler;
import pl.parteka.smarthome.opi.PinDefinition;
import pl.parteka.view.RoomView;

/**
 * Created by Michal on 2017-01-14.
 */
public class SmartHome {

    private final static String clientId = "44355039074e2800006d";

    public static void main(String[] args) throws Exception {
        final MqttBroker broker = new MqttBroker();
        Driver driver = new Driver(clientId, broker);
        DriverMessageHandler driverMessageHandler = new DriverMessageHandler();
        driverMessageHandler.registerListener(driver);

        broker.addInterceptHandler(driverMessageHandler);
        broker.addInterceptHandler(new ClientMessageHandler());

        //TODO: move it to core initialization and read definition from DB or property file
        Light light1 = new Light(driver, "Biuro light", new Pin(PinDefinition.PA13));
        Light light2 = new Light(driver, "Pokój light", new Pin(PinDefinition.PA14));
        TemperatureSensor temp1 = new TemperatureSensor(driver, "Biuro", "28-80000004920e");

        RoomView roomView = new RoomView();
        roomView.addLight(light1);
        roomView.addLight(light2);
        roomView.addTemperatureSensor(temp1);
        roomView.start();
    }
}
