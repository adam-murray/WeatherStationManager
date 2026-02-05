package org.amurray.weatherstationmanager.sensors.mock;

import org.amurray.weatherstationmanager.models.SensorReading;
import org.amurray.weatherstationmanager.models.SensorType;
import org.amurray.weatherstationmanager.models.SensorUnit;

public class MockHumiditySensor  extends MockSensor{
    private double humidity;
    public MockHumiditySensor(String id, double startHumidity) {
        super(id, SensorType.HUMIDITY);
        this.humidity = startHumidity;
    }
    @Override
    public SensorReading read() {
        humidity += random.nextGaussian() * 0.5;
        humidity = Math.max(0, Math.min(100, humidity));
        return reading(humidity, SensorUnit.PERCENT);
    }
}
