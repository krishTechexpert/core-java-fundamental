package com.FindTrain.FindTrainProject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class TrainSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="train_id") //Creates a foreign key column in TrainSchedule table
    @JsonManagedReference // trian schedule table is responsible to send json for all FK columns
    private Train train;


    @ManyToOne
    @JoinColumn(name="source_station_id")//FK, source ko join ker degy es id sy
    private Station source; //station object

    @ManyToOne
    @JoinColumn(name="destination_station_id") //FK destination ko join ker degy es id sy
    private Station destination; //station Object

    /*
    * IMP Notes
    * This means:
        . source and destination store Station objects, not just an ID.
        . JPA (Hibernate) automatically manages the foreign keys.
        * When you save a TrainSchedule,  such as
        *
        * TrainSchedule sc1= new TrainSchedule(rajdhani,delhi,mumbai,"06:00","14:00"); //delhi and mumbai are station object toh enki id store ho jte gi in DB
        //JPA will automatically extract the IDs and save them as foreign keys in the database.
        *
        *
        * it stores the station's ID internally in the source_station_id and
        * destination_station_id columns.
    * */


    private String departureTime;
    private String arrivalTime;

    public TrainSchedule(){

    }

    public TrainSchedule( Train train, Station source, Station destination, String departureTime, String arrivalTime) {

        this.train = train;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Station getSource() {
        return source;
    }

    public void setSource(Station source) {
        this.source = source;
    }

    public Station getDestination() {
        return destination;
    }

    public void setDestination(Station destination) {
        this.destination = destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}


/* Train schedule obj
*
* [
    {
        "id": 1,
        "train": {
            "id": 1,
            "name": "Rajdhani Express",
            "trainNumber": "12345"
        },
        "source": {
            "id": 2,
            "stationName": "delhi central",
            "stationCode": "NDLS"
        },
        "destination": {
            "id": 3,
            "stationName": "Mumbai central",
            "stationCode": "CST"
        },
        "departureTime": "06:00",
        "arrivalTime": "14:00"
    }
]
*
*
*  */



