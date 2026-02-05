package org.amurray.weatherstationmanager.sensors.mock;

import org.amurray.weatherstationmanager.sensors.SensorRegistry;

public class MockSensorFactory {
    public static SensorRegistry createDefault() {
            SensorRegistry registry = new SensorRegistry();

            registry.register(new MockTemperatureSensor("temp-1", 15.0));
            registry.register(new MockHumiditySensor("hum-1", 55.0));
            registry.register(new MockPressureSensor("press-1", 1012.0));
            registry.register(new MockWindSpeedSensor("wind-1"));
            return registry;
        }
    }
