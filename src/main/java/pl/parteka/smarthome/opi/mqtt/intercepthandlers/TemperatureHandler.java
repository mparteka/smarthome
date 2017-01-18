package pl.parteka.smarthome.opi.mqtt.intercepthandlers;

import io.moquette.interception.messages.InterceptPublishMessage;
import pl.parteka.smarthome.core.TemperatureListener;
import pl.parteka.smarthome.opi.mqtt.intercepthandlers.message.TemperatureMessage;

/**
 * Created by Michal on 2017-01-14.
 */
public class TemperatureHandler extends AbstractMessageHandler<TemperatureListener> {

    @Override
    public void onPublish(InterceptPublishMessage msg) {
        if(!TopicType.TEMPERATURE.toString().equals(msg.getTopicName())) {
            return;
        }
        String value = new String(msg.getPayload().array());
        TemperatureMessage message = new TemperatureMessage(value);
        notify(msg.getClientID(), message);
    }


}
