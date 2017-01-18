package pl.parteka.smarthome.mqtt;

import io.moquette.parser.proto.messages.PublishMessage;
import pl.parteka.smarthome.core.Driver;
import pl.parteka.smarthome.core.Message;
import pl.parteka.smarthome.core.command.Command;

import java.nio.ByteBuffer;

/**
 * Created by Michal on 2017-01-14.
 */
public class CommandMessage extends PublishMessage implements Message {


    private static final String TOPIC_NAME = "command";

    public CommandMessage(Driver driver, Command command) {
        setClientId(driver.getId());
        setQos(QOSType.EXACTLY_ONCE);
        setTopicName(TOPIC_NAME);
        setPayload(ByteBuffer.wrap(command.getCommandString().getBytes()));
    }
}
