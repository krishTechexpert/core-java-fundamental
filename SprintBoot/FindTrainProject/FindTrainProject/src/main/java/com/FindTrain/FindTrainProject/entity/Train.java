package com.FindTrain.FindTrainProject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.data.domain.Example;

import java.util.List;

// Find the train between stations

@Entity
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String trainNumber;

    //One Train can have multiple Schedules
    // (Example: "Rajdhani Express" has different schedules for Agra, Delhi, etc.).

    //The OneToMany annotation is used in the Train entity to indicate that
    // one train is associated with multiple schedules.


    @OneToMany(mappedBy = "train",cascade = CascadeType.ALL)
    //@JsonIgnore // ✅ Prevents infinite recursion during JSON serialization
    @JsonBackReference
    //The mappedBy = "train" ensures that the Train table does not get a foreign key column.
    //The foreign key is only stored in the TrainSchedule table.
    private List<TrainSchedule> scheduleList; // One train can have multiple schedules


    public Train(){
        //default constructor
    }

    public Train( String name, String trainNumber, List<TrainSchedule> scheduleList) {

        this.name = name;
        this.trainNumber = trainNumber;
        this.scheduleList = scheduleList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public List<TrainSchedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<TrainSchedule> scheduleList) {
        this.scheduleList = scheduleList;
    }
}

/*
* @OneToMany(mappedBy = "train", cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    * a) mappedBy = "train"
This ensures that the foreign key is maintained in the Schedule table.

The Train table will NOT have an extra foreign key column for schedules.

The ownership of the relationship is maintained by the Schedule entity
* (which has a @ManyToOne relation to Train).

* -------------------------------------------
*
* b) cascade = CascadeType.ALL
Cascade operations ensure that whenever a Train entity is persisted, updated, or deleted,
* the corresponding Schedule entities will also be affected.

If a Train is deleted, all associated Schedules will also be deleted.

If a Train is saved, its Schedules will be saved automatically.
-----------------------------------------------
*
* c) fetch = FetchType.LAZY
* Default to FetchType.LAZY

Lazy Loading means that the Schedule list is not fetched from the database immediately
* when a Train object is retrieved.

The schedules will only be loaded when explicitly accessed.

This improves performance by reducing unnecessary database queries.

* It prevents unnecessary data loading and improves performance.

Example: If you fetch a Train, its Schedules are not loaded immediately.

Schedules will only be fetched when needed.
------------------
* fetch = FetchType.EAGER
* then Hibernate will immediately fetch all associated Schedule records
* whenever a Train is retrieved.

-------------------------------------------------
*
*
* 4. Database Schema (Tables)
After JPA mapping, the database will have:

Train Table:
id	name
1	Rajdhani Express
2	Shatabdi Express
--------------------------
Schedule Table
id	destination	departureTime	train_id (FK)
1	Agra	    10:00 AM	    1 (Rajdhani)
2	Delhi	    12:00 PM	    1 (Rajdhani)
3	Lucknow	    02:00 PM	    2 (Shatabdi)

 *
* */