package pl.parteka.smarthome;

import pl.parteka.smarthome.core.Driver;
import pl.parteka.smarthome.core.Pin;
import pl.parteka.smarthome.core.receiver.Light;
import pl.parteka.smarthome.core.sensor.TemperatureSensor;
import pl.parteka.smarthome.mqtt.MqttBroker;
import pl.parteka.smarthome.opi.mqtt.intercepthandlers.PinStatusHandler;
import pl.parteka.smarthome.opi.mqtt.intercepthandlers.TemperatureHandler;
import pl.parteka.view.RoomView;

/**
 * Created by Michal on 2017-01-14.
 */
public class SmartHome {

    private final static String clientId = "44355039074e2800006d";

    public static void main(String[] args) throws Exception {
        final MqttBroker broker = new MqttBroker();
        Driver driver = new Driver(clientId, broker);

        PinStatusHandler pinStatusHandler = new PinStatusHandler();
        broker.addInterceptHandler(pinStatusHandler);
        TemperatureHandler temperatureHandler = new TemperatureHandler();
        broker.addInterceptHandler(temperatureHandler);

        Light light1 = new Light(driver, "Biuro light", new Pin(Pin.PA13));
        Light light2 = new Light(driver, "Pokój light", new Pin(Pin.PA14));
        pinStatusHandler.registerListener(light1);
        pinStatusHandler.registerListener(light2);

        TemperatureSensor temp1 = new TemperatureSensor(driver, "Biuro temp", "28-80000004920e");
        temperatureHandler.registerListener(temp1);

        RoomView roomView = new RoomView();
        roomView.addLight(light1);
        roomView.addLight(light2);
        roomView.addTemperatureSensor(temp1);
        roomView.start();
    }
}
