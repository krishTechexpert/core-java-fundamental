package com.FindTrain.FindTrainProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

//This will print a list of all registered Beans, including trainController.

@Component
public class BeanChecker {
    @Autowired
    private ApplicationContext context;
    public BeanChecker(){
        System.out.println("Print All Beans in IoC Container");
    }
    public void showBeans(){
       String[] beanNames  =context.getBeanDefinitionNames();
       for(String beanName:beanNames){
           System.out.println(beanName);
       }
    }

    //you ca check here these below Beans using in my project
    //beanChecker

    //test
    //trainController
    //trainSearchController

    // trainSearchService
    //trainService

    //stationRepository
    //trainScheduleRespository
    //trainRepository
}
