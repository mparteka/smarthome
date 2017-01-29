package pl.parteka.smarthome.core.command;

import pl.parteka.smarthome.core.Pin;

/**
 * Created by Michal on 2017-01-14.
 */
public class SwitchCommand extends Command {

    private final static String COMMAND_NAME = "SWITCH";
    private final int value;

    public SwitchCommand(Pin pin) {
        this.pin = pin;
        this.action = SwitchCommandAction.SWITCH.toString();
        this.value = -1;
    }

    public SwitchCommand(Pin pin, int value) {
        this.pin = pin;
        this.value = value;
        this.action = SwitchCommandAction.SET.toString();
    }

    @Override
    public String getCommandString() {
        StringBuilder sb = new StringBuilder();
        sb.append(COMMAND_NAME);
        sb.append(" ").append(action);
        sb.append(" ").append(pin.toString());
        sb.append(" ").append(String.valueOf(value));

        return sb.toString();
    }

    private enum SwitchCommandAction {
        SWITCH, SET
    }
}
