package com.FindTrain.FindTrainProject.repo;

import com.FindTrain.FindTrainProject.entity.TrainSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainScheduleRespository extends JpaRepository<TrainSchedule,Long> {
    
    /* ashwani query
    * select * from train_schedule ts 
    * join station source ON ts.source_station_id=source.id
    * join station destination ON ts.destination_station_id=source.id;
      where source.station_code="NDLC" AND destination.station_code="BCT"
     *
     *my query:
     * select t.name,t.train_number, s.station_name, d.station_name,  arrival_time,departure_time from train_schedule ts
        Join station s on ts.source_station_id= s.id
        join station d on ts.destination_station_id=d.id
        join train t on ts.train_id=t.id;
     *
     *
     *
     * ----------------------------
     * 📌 JPA automatically converts this method into SQL like:
    * */
    
    //here all above join, JPA simplify for us , jpa write internally above query for us
    //this is JPA query
    //method is like sql query jo jpa internally likega for us
    List<TrainSchedule> findBySource_StationCodeAndDestination_StationCode(String sourceCode,String destinationCode);

    /*
    * What it does:

     * findBy--used to select
    * check Train schedule entity and you will find Source varaible such as private Station source; //station object
    * and Station object (entity) has  stationCode varaible so combines all these findBySource_StationCode
    *
    * so you can write same for Destination and combine with AND operator
    *
        Finds trains where:

        source.stationCode = sourceCode

        destination.stationCode = destinationCode
    * */



    /*
    * 💡 How Does JPA Understand This?
Spring Data JPA reads method names and automatically converts them into SQL queries based
* on naming conventions.

It recognizes findBySource_StationCodeAndDestination_StationCode:

findBy → Indicates a SELECT query.

Source_StationCode & Destination_StationCode → Maps to columns in related tables.

And → Combines conditions using AND.


    *
    * */




    /* 🤔 What If You Need a Custom Query?
        If method names become too complex, you can use JPQL or native SQL:

        @Query("SELECT ts FROM TrainSchedule ts WHERE ts.source.stationCode = :sourceCode AND ts.destination.stationCode = :destinationCode")
    List<TrainSchedule> searchByStationCodes(@Param("sourceCode") String sourceCode, @Param("destinationCode") String destinationCode);
    */



    List<TrainSchedule> findBySource_StationNameAndDestination_StationName(String sourceName, String destinationName);
}

/*
* 💡 Benefit: By extending JpaRepository, we don't need to manually write CRUD operations
* like save(), findById(), delete(), etc. Spring Data JPA provides them automatically.


 * */