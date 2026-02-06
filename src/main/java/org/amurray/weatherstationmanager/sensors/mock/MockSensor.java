package org.amurray.weatherstationmanager.sensors.mock;

import org.amurray.weatherstationmanager.models.SensorReading;
import org.amurray.weatherstationmanager.models.SensorType;
import org.amurray.weatherstationmanager.models.SensorUnit;
import org.amurray.weatherstationmanager.sensors.Sensor;

import java.time.Instant;
import java.util.Random;

public abstract class MockSensor implements Sensor {
    protected final String id;
    protected final SensorType type;
    protected final Random random = new Random();
    protected MockSensor(String id, SensorType type) {
        this.id = id;
        this.type = type;
    }
    @Override
    public String getId(){
        return id;
    };
    @Override
    public SensorType getType(){
        return type;
    };

    protected SensorReading reading(double value, SensorUnit unit) {
        return new SensorReading(
                id + "@" + Instant.now().toString(),
                id,
                type,
                value,
                unit,
                Instant.now()
        );
    }
}
