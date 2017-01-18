package pl.parteka.smarthome.core;

/**
 * Created by Michal on 2017-01-14.
 */
public class Pin {

    public static final int PA1 = 1;
    public static final int PA0 = 0;
    public static final int PA3 = 3;
    public static final int PA19 = 19;
    public static final int PA7 = 7;
    public static final int PA8 = 8;
    public static final int PA9 = 9;
    public static final int PA10 = 10;
    public static final int PA20 = 20;
    public static final int PA13 = 13;
    public static final int PA14 = 14;
    public static final int PA2 = 2;
    public static final int PA21 = 21;
    public static final int PA18 = 18;
    public static final int PA12 = 12;
    public static final int PA11 = 11;
    public static final int PA6 = 6;

    public static final int PC0 = 64;
    public static final int PC1 = 65;
    public static final int PC2 = 66;
    public static final int PC4 = 68;
    public static final int PC7 = 71;
    public static final int PC3 = 67;

    public static final int PD14 = 110;

    public static final int PG8 = 200;
    public static final int PG9 = 201;
    public static final int PG6 = 198;
    public static final int PG7 = 199;

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
