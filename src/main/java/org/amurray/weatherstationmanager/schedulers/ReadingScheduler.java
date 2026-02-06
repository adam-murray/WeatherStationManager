package org.amurray.weatherstationmanager.schedulers;

import org.amurray.weatherstationmanager.models.SensorReading;
import org.amurray.weatherstationmanager.sensors.Sensor;
import org.amurray.weatherstationmanager.sensors.SensorRegistry;
import org.amurray.weatherstationmanager.sensors.mock.MockPressureSensor;
import org.amurray.weatherstationmanager.sensors.mock.MockTemperatureSensor;
import org.amurray.weatherstationmanager.services.DatabaseService;

import java.util.TimerTask;

// TODO: TimerTask only runs on one thread, is this actually a problem?
public class ReadingScheduler extends TimerTask {
    private final String executionId;
    public ReadingScheduler(String executionId){
        this.executionId = executionId;
    }
    @Override
    public void run() {
        SensorRegistry registry = new SensorRegistry();
        registry.register(new MockPressureSensor("pressure-1", 0.9));
        registry.register(new MockTemperatureSensor("temp-1", 5));
        for (Sensor sensor: registry.getAll()){
            SensorReading reading = sensor.read();
            System.out.println(reading);
            DatabaseService.createRow(reading);
        }
    }
}
