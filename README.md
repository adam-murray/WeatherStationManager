# WeatherStationManager

## Description
A simple Java application designed to run on a Raspberry Pi, which takes scheduled readings from a number of sensors (currently mocked) and saves them to a local SQLite database.

## Goals
* Implement real sensors, ideally low power ones which use bluetooth
* Ability to sniff for bluetooth packets and parse data
* Ability to trigger a Lambda function? and pass data since last upload to it, allowing for periods of dropped network connection
* ~Check if single thread scheduling is going to be an issue in the long run~
