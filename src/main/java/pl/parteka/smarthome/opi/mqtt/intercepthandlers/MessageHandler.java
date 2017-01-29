package pl.parteka.smarthome.opi.mqtt.intercepthandlers;

import io.moquette.interception.messages.InterceptPublishMessage;
import pl.parteka.smarthome.opi.mqtt.intercepthandlers.message.PinStateMessage;
import pl.parteka.smarthome.opi.mqtt.intercepthandlers.message.TemperatureMessage;

/**
 * Created by Michal on 2017-01-29.
 */
public class MessageHandler extends AbstractMessageHandler {
    @Override
    public void onPublish(InterceptPublishMessage msg) {
        if (handlePinStatusMessage(msg)) return;

        if (handleTemperatureMessage(msg)) return;
    }

    private boolean handleTemperatureMessage(InterceptPublishMessage msg) {
        if (!TopicType.TEMPERATURE.toString().equals(msg.getTopicName())) {
            return false;
        }
        String value = new String(msg.getPayload().array());
        TemperatureMessage message = new TemperatureMessage(value);
        notify(msg.getClientID(), message);

        return true;
    }

    private boolean handlePinStatusMessage(InterceptPublishMessage msg) {
        if (!TopicType.PIN_STATUS.toString().equals(msg.getTopicName())) {
            return false;
        }
        String message = new String(msg.getPayload().array());
        PinStateMessage pinStateMessage = new PinStateMessage(message);

        notify(msg.getClientID(), pinStateMessage);
        return true;
    }
}
