package com.krish.RestaurantApp.controller;

import com.krish.RestaurantApp.model.Restaurant;
import com.krish.RestaurantApp.repository.IRestaurantRepository;
import com.krish.RestaurantApp.service.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant") // base path
public class RestaurantController {
    private final IRestaurantService restaurantService;

    @Autowired
    public RestaurantController(IRestaurantService restaurantService){
        this.restaurantService=restaurantService;
    }
    @PostMapping("/create")
    public void createRestaurant(@RequestBody Restaurant res){
        restaurantService.addRestaurant(res);
    }
    @GetMapping("/findAll")
    public List<Restaurant> getAllRestaurants(){
       return  restaurantService.getAllRestaurant();
    }
    @GetMapping("/{id}")
    public Restaurant getById(@PathVariable int id){
        return restaurantService.getById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable int id){
        restaurantService.deleteRestaurant(id);
    }
    @PutMapping("/{id}")
    public Restaurant updateRestaurant(@RequestBody Restaurant restaurant, @PathVariable int id){
       return restaurantService.updateRestaurant(restaurant,id);
    }
    @GetMapping("/{city}")
    public List<Restaurant> getByCity(@PathVariable String city){
        return restaurantService.getByCity(city);
    }

    @GetMapping("/{type}")
    public List<Restaurant> getByType(@PathVariable String type){
        return restaurantService.getByType(type);
    }
    @GetMapping("/item/{itemName}")
    public List<Restaurant> getByItemName(@PathVariable String itemName){
        return restaurantService.getByItemName(itemName);
    }
    @GetMapping("/cuisine/{cuisine5}")
    public List<Restaurant> getByCuisine(@PathVariable String cuisine5){
        return restaurantService.getByCuisine(cuisine5);
    }
}
