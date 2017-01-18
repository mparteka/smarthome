package pl.parteka.smarthome.opi.mqtt.intercepthandlers;

import io.moquette.interception.messages.InterceptPublishMessage;
import pl.parteka.smarthome.core.PinStatusListener;
import pl.parteka.smarthome.opi.mqtt.intercepthandlers.message.PinStateMessage;

/**
 * Created by Michal on 2017-01-14.
 */
public class PinStatusHandler extends AbstractMessageHandler<PinStatusListener> {

    @Override
    public void onPublish(InterceptPublishMessage msg) {
        if (!TopicType.PIN_STATUS.toString().equals(msg.getTopicName())) {
            return;
        }
        String message = new String(msg.getPayload().array());
        PinStateMessage pinStateMessage = new PinStateMessage(message);

        notify(msg.getClientID(), pinStateMessage);
    }


}
