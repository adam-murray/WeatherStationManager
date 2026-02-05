package org.amurray.weatherstationmanager.sensors.mock;

import org.amurray.weatherstationmanager.models.SensorReading;
import org.amurray.weatherstationmanager.models.SensorType;
import org.amurray.weatherstationmanager.models.SensorUnit;

public class MockTemperatureSensor extends MockSensor{
    private double currentTemp;

    public MockTemperatureSensor(String id, double startTemp) {
        super(id, SensorType.TEMPERATURE);
        this.currentTemp = startTemp;
    }

    @Override
    public SensorReading read() {
        // Small Drift
        currentTemp += random.nextGaussian() * 0.2;
        return reading(currentTemp, SensorUnit.CELSIUS);
    }
}
