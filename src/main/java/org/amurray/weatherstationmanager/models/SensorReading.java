package org.amurray.weatherstationmanager.models;

import java.time.Instant;

public record SensorReading (
    String sensorId,
    SensorType type,
    double value,
    SensorUnit unit,
    Instant timestamp
) {}
