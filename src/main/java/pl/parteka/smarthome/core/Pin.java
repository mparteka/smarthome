package pl.parteka.smarthome.core;

/**
 * Created by Michal on 2017-01-14.
 */
public class Pin {

    public static final int PIN_ON = 1;
    public static final int PIN_OFF = 0;


    private final int pin;
    private int value;

    public Pin(int pin) {
        this.pin = pin;

    }

    public Pin(int pin, int value) {
        this.pin = pin;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(pin);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pin pin1 = (Pin) o;

        return pin == pin1.pin;
    }

    @Override
    public int hashCode() {
        return pin;
    }
}
