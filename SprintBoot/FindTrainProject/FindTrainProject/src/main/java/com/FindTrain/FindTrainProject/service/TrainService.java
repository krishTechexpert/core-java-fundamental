package com.FindTrain.FindTrainProject.service;

import com.FindTrain.FindTrainProject.entity.Train;
import com.FindTrain.FindTrainProject.repo.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {


    private TrainRepository trainRespository;

    // Constructor Injection (No need for @Autowired)
    public TrainService(TrainRepository t){
        this.trainRespository=t;
    }

    public List<Train> getAllTrains() {
          return  trainRespository.findAll();
    }

    public Train addNewTrain(Train t) {
       return trainRespository.save(t);
    }
}
