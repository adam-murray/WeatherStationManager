package org.amurray.weatherstationmanager;

import org.amurray.weatherstationmanager.models.SensorReading;
import org.amurray.weatherstationmanager.schedulers.ReadingScheduler;
import org.amurray.weatherstationmanager.sensors.Sensor;
import org.amurray.weatherstationmanager.sensors.SensorRegistry;
import org.amurray.weatherstationmanager.sensors.mock.MockPressureSensor;
import org.amurray.weatherstationmanager.sensors.mock.MockTemperatureSensor;
import org.amurray.weatherstationmanager.services.DatabaseService;

import java.util.Timer;

public class Main {
    private static SensorReading reading;

    public static void main(String[] args) {
        DatabaseService.connect();
        DatabaseService.createTable();
        ReadingScheduler te1 = new ReadingScheduler("Reading Scheduler");
        Timer t = new Timer();
        t.scheduleAtFixedRate(te1, 0,10000);
    }
}