package pl.parteka.smarthome.core.command;

import pl.parteka.smarthome.core.Pin;

/**
 * Created by Michal on 2017-01-14.
 */
public abstract class Command {

    protected Pin pin;
    protected String action;

    public abstract String getCommandString();

}
