package com.FindTrain.FindTrainProject.controller;

import com.FindTrain.FindTrainProject.entity.TrainSchedule;
import com.FindTrain.FindTrainProject.service.TrainSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation. * ;

import java.util.List;

@RestController@RequestMapping("/search") //base url hum search funcationality ko Train Controller k ander bi add ker sekty ty , not an issues
@CrossOrigin //cors issues fixing
public class TrainSearchController {

    //@Autowired
    private TrainSearchService trainSearchService;

    // Constructor Injection (No need for @Autowired)
    public TrainSearchController(TrainSearchService tsc) {
        this.trainSearchService = tsc;
    }

    @GetMapping("/by-code")
    public List < TrainSchedule > findTrainByStationCode(@RequestParam String sourceCode, @RequestParam String destinationCode) {
        return trainSearchService.findTrainByStationCode(sourceCode.toUpperCase(), destinationCode.toUpperCase());
    }
    @GetMapping("/by-name")
    public List < TrainSchedule > findTrainByStationName(@RequestParam String sourceName, @RequestParam String destinationName) {
        return trainSearchService.findTrainByStationName(sourceName.toUpperCase(), destinationName.toUpperCase());
    }
}