package com.FindTrain.FindTrainProject.controller;

import com.FindTrain.FindTrainProject.entity.Station;
import com.FindTrain.FindTrainProject.entity.Train;
import com.FindTrain.FindTrainProject.entity.TrainSchedule;
import com.FindTrain.FindTrainProject.repo.StationRepository;
import com.FindTrain.FindTrainProject.repo.TrainRepository;
import com.FindTrain.FindTrainProject.repo.TrainScheduleRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/* this controller is used to insert dummy data in DB  by api endpoint such as /test */

@RestController
@RequestMapping("/test")
public class Test {

    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private TrainScheduleRespository trainScheduleRespository;


    @GetMapping
    public void test(){
        //station save
        Station delhiSTObj=new Station("delhi central","NDLS");
        Station mumbaiSTObj=new Station("Mumbai central","CST");
        Station kolkataSTObj=new Station("kolkata central","KST");
        Station chennaiSTObj=new Station("chennai central","MAS");
        stationRepository.saveAll(List.of(delhiSTObj,mumbaiSTObj,kolkataSTObj,chennaiSTObj));

        // train save

        Train rajdhani = new Train("Rajdhani Express","12345",null);
        Train durunto = new Train("durunto Express","54789",null);
        Train shatabdi = new Train("shatabdi Express","90832",null);

        trainRepository.saveAll(List.of(rajdhani,durunto,shatabdi));

        //train schedule save

        TrainSchedule sc1= new TrainSchedule(rajdhani,delhiSTObj,mumbaiSTObj,"06:00","14:00");
        //JPA will automatically extract the IDs and save them as foreign keys in the database.

        TrainSchedule sc2= new TrainSchedule(durunto,mumbaiSTObj,kolkataSTObj,"08:00","09:00");
        TrainSchedule sc3= new TrainSchedule(shatabdi,kolkataSTObj,chennaiSTObj,"11:30","19:00");

        trainScheduleRespository.saveAll(List.of(sc1,sc2,sc3));

        System.out.println("data inserted...");
    }
}
