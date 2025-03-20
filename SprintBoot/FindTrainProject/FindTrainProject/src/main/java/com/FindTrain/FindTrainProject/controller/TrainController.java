package com.FindTrain.FindTrainProject.controller;

import com.FindTrain.FindTrainProject.entity.Train;
import com.FindTrain.FindTrainProject.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trains") //base url
public class TrainController {

    //@Autowired
    private TrainService trainService; // we have one varaible here and we are using constrcutor injection so no need to add @Autowired

    // Constructor Injection (No need for @Autowired)
    public TrainController(TrainService ts){

        this.trainService=ts;
    }

    //@GetMapping("/all")
    @GetMapping //if someone is calling get method on /trains then it will call automatically
    /// This will map to "/trains" by default
    public List<Train> getAllTrains(){
        return trainService.getAllTrains();
    }

    @PostMapping
    public Train addNewTrain(@RequestBody Train t){
        return trainService.addNewTrain(t);
    }
}
