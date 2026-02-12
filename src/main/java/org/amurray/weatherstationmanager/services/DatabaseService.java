package org.amurray.weatherstationmanager.services;

import org.amurray.weatherstationmanager.config.Config;
import org.amurray.weatherstationmanager.models.SensorReading;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {
    private static final String dbUrl = Config.get("db.url");
    private static final String user = Config.get("db.username");
    private static final String password = Config.get("db.password");

    public static void connect() {
        try (var conn = DriverManager.getConnection(dbUrl, user, password)){
            System.out.println("Connection to PostgreSQL has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createTable() {
        var sql = "CREATE TABLE IF NOT EXISTS readings (" +
                "reading_id TEXT NOT NULL," +
                "sensor_id TEXT NOT NULL," +
                "sensor_type TEXT NOT NULL," +
                "sensor_unit TEXT NOT NULL," +
                "value REAL NOT NULL," +
                "time_stamp BIGINT NOT NULL" +
                ");";
        try (var conn = DriverManager.getConnection(dbUrl, user, password);
            var stmt = conn.createStatement()){
            stmt.execute(sql);
            } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void createRow(SensorReading reading){
        String statement = "INSERT INTO readings (reading_id, sensor_id, sensor_type, sensor_unit, value, time_stamp)"
                + "VALUES(?,?,?,?,?,?)";

        try (var conn = DriverManager.getConnection(dbUrl, user, password);
        var pstmt = conn.prepareStatement(statement)){
            pstmt.setString(1, reading.readingId());
            pstmt.setString(2, reading.sensorId());
            pstmt.setString(3, reading.type().toString());
            pstmt.setString(4, reading.unit().toString());
            pstmt.setDouble(5, reading.value());
            pstmt.setDouble(6, reading.timestamp().toEpochMilli());
            System.out.println(reading.timestamp().toEpochMilli());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Couldn't write to DB");
            System.out.println(e);
        }
    }
}
