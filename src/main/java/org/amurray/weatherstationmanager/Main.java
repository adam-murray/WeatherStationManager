package org.amurray.weatherstationmanager;

import org.amurray.weatherstationmanager.models.SensorReading;
import org.amurray.weatherstationmanager.schedulers.ReadingTask;
import org.amurray.weatherstationmanager.sensors.SensorRegistry;
import org.amurray.weatherstationmanager.sensors.mock.MockPressureSensor;
import org.amurray.weatherstationmanager.sensors.mock.MockTemperatureSensor;
import org.amurray.weatherstationmanager.services.DatabaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    private static SensorReading reading;

    public static void main(String[] args) {
        DatabaseService.connect();
        DatabaseService.createTable();
        SensorRegistry registry = new SensorRegistry();
        registry.register(new MockPressureSensor("pressure-1", 0.9));
        registry.register(new MockTemperatureSensor("temp-1", 5));
        try {
            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);
            scheduler.schedule(new ReadingTask(registry.getAll()), 5, TimeUnit.SECONDS);
        }
        catch(Exception e){
            System.out.println("Error in reading scheduler");
            log.error("e: ", e);
        }
    }
}