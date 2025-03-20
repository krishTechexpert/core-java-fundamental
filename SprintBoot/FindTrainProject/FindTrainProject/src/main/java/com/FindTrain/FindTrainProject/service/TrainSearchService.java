package com.FindTrain.FindTrainProject.service;

import com.FindTrain.FindTrainProject.entity.TrainSchedule;
import com.FindTrain.FindTrainProject.repo.TrainScheduleRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainSearchService {

    //we are returing TrainSchedule in TrainSearchController
    @Autowired
    private TrainScheduleRespository trainScheduleRespository;

    public TrainSearchService(TrainScheduleRespository tsr){
        this.trainScheduleRespository=tsr;
    }

    public List<TrainSchedule> findTrainByStationCode(String sourceCode,String destinationCode){
        return trainScheduleRespository.findBySource_StationCodeAndDestination_StationCode(sourceCode,destinationCode);
    }

    public List<TrainSchedule> findTrainByStationName(String sourceName,String destinationName){
        return trainScheduleRespository.findBySource_StationNameAndDestination_StationName(sourceName,destinationName);
    }
}
