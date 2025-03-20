package com.FindTrain.FindTrainProject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Station {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String stationName;
    private String stationCode;

    public Station() {

    }

    public Station(String stationName, String stationCode) {
        this.stationName = stationName;
        this.stationCode = stationCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

}