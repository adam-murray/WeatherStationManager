package org.amurray.weatherstationmanager.sensors;

import org.amurray.weatherstationmanager.models.SensorReading;
import org.amurray.weatherstationmanager.models.SensorType;

public interface Sensor {
    String getId();

    SensorType getType();

    SensorReading read();
}
