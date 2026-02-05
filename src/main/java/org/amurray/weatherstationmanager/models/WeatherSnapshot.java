package org.amurray.weatherstationmanager.models;

import java.time.Instant;
import java.util.Map;

public class WeatherSnapshot {
    Map<SensorType, SensorReading> readings;
    Instant timestamp;

    public WeatherSnapshot get(){
        return new WeatherSnapshot();
    }
}
