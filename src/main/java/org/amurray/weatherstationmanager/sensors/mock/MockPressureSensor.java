package org.amurray.weatherstationmanager.sensors.mock;

import org.amurray.weatherstationmanager.models.SensorReading;
import org.amurray.weatherstationmanager.models.SensorType;
import org.amurray.weatherstationmanager.models.SensorUnit;

public class MockPressureSensor extends MockSensor{
    private double value;

    public MockPressureSensor(String id, double startPressure) {
        super(id, SensorType.PRESSURE);
        this.value = startPressure;
    }

    @Override
    public SensorReading read() {
        value += random.nextGaussian() * 0.3;

        return reading(value, SensorUnit.BAR);
    }
}
