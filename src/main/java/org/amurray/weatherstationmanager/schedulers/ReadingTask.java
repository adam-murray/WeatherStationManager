package org.amurray.weatherstationmanager.schedulers;

import org.amurray.weatherstationmanager.models.SensorReading;
import org.amurray.weatherstationmanager.sensors.Sensor;
import org.amurray.weatherstationmanager.services.DatabaseService;

import java.util.List;

public class ReadingTask implements Runnable{
    private final List<Sensor> sensors;

    public ReadingTask(List<Sensor> sensors) {
        this.sensors = sensors;
    }
    public void run(){
        for (Sensor sensor: sensors){
            SensorReading reading = sensor.read();
            System.out.println(reading);
            DatabaseService.createRow(reading);
        }
    }
}
