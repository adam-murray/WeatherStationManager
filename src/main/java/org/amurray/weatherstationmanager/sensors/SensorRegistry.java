package org.amurray.weatherstationmanager.sensors;

import org.amurray.weatherstationmanager.models.SensorType;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SensorRegistry {
    private final Map<String, Sensor> registeredSensorsById = new ConcurrentHashMap<>();
    public void register(Sensor sensor){
        if (sensor == null){
            throw new IllegalArgumentException("Sensor must not be null");
        }
        Sensor existing = registeredSensorsById.putIfAbsent(sensor.getId(), sensor);
        if (existing != null) {
            throw new IllegalStateException("Sensor with id '" + sensor.getId() + "' is already registered");
        }
    }
    public void unregister(String sensorId){
        if (registeredSensorsById.containsKey(sensorId)) {
            registeredSensorsById.remove(sensorId);
        }
        else{
            throw new IllegalArgumentException("No sensor with id '" + registeredSensorsById.get(sensorId) + "' currently registered");
        }
    }

    public Optional<Sensor> getById(String sensorId) {
        return Optional.ofNullable(registeredSensorsById.get(sensorId));
    }

    public List<Sensor> getAll(){
        // TODO: Check if sending a copy is memory inefficient (RAM COSTS £900 now)
        return List.copyOf(registeredSensorsById.values());
    }
    public List<Sensor> getByType(SensorType type) {
        return registeredSensorsById.values()
                .stream()
                .filter(sensor -> sensor.getType() == type)
                .toList();
    }
    // check a sensor is registered
    public boolean contains(String sensorId) {
        return registeredSensorsById.containsKey(sensorId);
    }

    public void clear() {
        registeredSensorsById.clear();
    }

    public int size(){
        return registeredSensorsById.size();
    }
}
