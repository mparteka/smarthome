package pl.parteka.smarthome.mqtt.intercepthandlers;

import io.moquette.interception.AbstractInterceptHandler;
import io.moquette.interception.messages.InterceptPublishMessage;

/**
 * Created by Michal on 2017-01-29.
 */
public class ClientMessageHandler extends AbstractInterceptHandler {
    @Override
    public void onPublish(InterceptPublishMessage msg) {
        if (handleCommandMessage(msg)) return;
    }

    private boolean handleCommandMessage(InterceptPublishMessage msg) {
        return false;
    }

}
