package pl.parteka.view;

import pl.parteka.smarthome.core.receiver.Light;
import pl.parteka.smarthome.core.sensor.TemperatureSensor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Michal on 2017-01-15.
 */
public class RoomView {
    private List<Light> lights = new ArrayList<>();
    private List<TemperatureSensor> temperatureSensors = new ArrayList<>();

    public void addLight(Light light) {
        this.lights.add(light);
    }

    public void addTemperatureSensor(TemperatureSensor sensor) {
        this.temperatureSensors.add(sensor);
    }

    public void start() {
        printMenu();
    }

    private void printMenu() {
        System.out.println("\n");
        System.out.println("\n ---- MENU ----\n");
        System.out.println("1 - List lights");
        System.out.println("2 - Turn on light");
        System.out.println("3 - Turn off light");
        System.out.println("4 - Turn on all");
        System.out.println("5 - Turn off all");
        System.out.println("6 - Show temperature");
        int i = readChar();
        switch (i) {
            case 1:
                listLights();
                break;
            case 2:
                turnOnLight();
                break;
            case 3:
                turnOffLight();
                break;
            case 4:
                turnOnAll();
                break;
            case 5:
                turnOffAll();
                break;
            case 6:
                showTemperature();
            default:
                printMenu();

        }

    }

    private void showTemperature() {
        for(TemperatureSensor temperatureSensor : temperatureSensors) {
            System.out.println(temperatureSensor.getName() + ": " + temperatureSensor.getValue());
        }
    }

    private void turnOnAll() {
        lights.forEach(l -> l.turnOn());
        printMenu();
    }

    private void turnOffAll() {
        lights.forEach(l -> l.turnOff());
        printMenu();
    }

    private void turnOnLight() {
        System.out.println("Choose the light:");
        int i = readChar();
        if(this.lights.size() > i-1) {
            this.lights.get(i - 1).turnOn();
        }
        printMenu();
    }

    private void turnOffLight() {
        System.out.println("Choose the light:");
        int i = readChar();
        if(this.lights.size() > i-1) {
            this.lights.get(i - 1).turnOff();
        }
        printMenu();
    }

    private void listLights() {
        int index = 1;
        System.out.println("Light list:");
        for (Light light : lights) {
            System.out.println(String.valueOf(index) + " - " + light.getName() + ": " + light.getStatus());
            index++;
        }
        printMenu();
    }

    private int readChar() {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        System.out.println("\b");
        return i;
    }

}
