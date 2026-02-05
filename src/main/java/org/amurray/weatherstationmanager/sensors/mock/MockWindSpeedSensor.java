package org.amurray.weatherstationmanager.sensors.mock;

import org.amurray.weatherstationmanager.models.SensorReading;
import org.amurray.weatherstationmanager.models.SensorType;
import org.amurray.weatherstationmanager.models.SensorUnit;

public class MockWindSpeedSensor extends MockSensor {
    private double speed;
    // TODO: Add direction
    public MockWindSpeedSensor(String id) {
        super(id, SensorType.WIND_SPEED);
    }

    @Override
    public SensorReading read() {
        double windSpeed = Math.abs(random.nextGaussian() * 2.5);
        return reading(windSpeed, SensorUnit.KMPH);
    }
}
