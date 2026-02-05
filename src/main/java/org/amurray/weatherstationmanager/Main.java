package org.amurray.weatherstationmanager;

import org.amurray.weatherstationmanager.models.SensorReading;
import org.amurray.weatherstationmanager.sensors.Sensor;
import org.amurray.weatherstationmanager.sensors.SensorRegistry;
import org.amurray.weatherstationmanager.sensors.mock.MockPressureSensor;
import org.amurray.weatherstationmanager.sensors.mock.MockTemperatureSensor;

public class Main {
    private static SensorReading reading;

    public static void main(String[] args) {
        SensorRegistry registry = new SensorRegistry();
        registry.register(new MockPressureSensor("pressure-1", 0.9));
        registry.register(new MockTemperatureSensor("temp-1", 5));
        for (Sensor sensor: registry.getAll()){
            SensorReading reading = sensor.read();

            System.out.println(reading);
        }
    }
}