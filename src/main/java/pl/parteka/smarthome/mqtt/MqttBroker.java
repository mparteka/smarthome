package pl.parteka.smarthome.mqtt;

import io.moquette.interception.InterceptHandler;
import io.moquette.parser.proto.messages.PublishMessage;
import io.moquette.server.Server;
import io.moquette.server.config.ClasspathResourceLoader;
import io.moquette.server.config.IConfig;
import io.moquette.server.config.IResourceLoader;
import io.moquette.server.config.ResourceLoaderConfig;
import pl.parteka.smarthome.core.Broker;
import pl.parteka.smarthome.core.Message;
import pl.parteka.smarthome.opi.mqtt.intercepthandlers.PinStatusHandler;
import pl.parteka.smarthome.opi.mqtt.intercepthandlers.TemperatureHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michal on 2017-01-14.
 */

public class MqttBroker implements Broker {

    private final Server server;
    private List<InterceptHandler> handlers = new ArrayList<>();


    public MqttBroker() {
        server = new Server();
        final IResourceLoader classpathLoader = new ClasspathResourceLoader();
        final IConfig classPathConfig = new ResourceLoaderConfig(classpathLoader);
        try {
            server.startServer(classPathConfig, handlers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void publish(Message message) {
        server.internalPublish((PublishMessage) message);
    }

    public boolean addInterceptHandler(InterceptHandler interceptHandler) {
        return server.addInterceptHandler(interceptHandler);
    }
}
