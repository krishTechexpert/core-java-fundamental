package com.krish.RestaurantApp.service;

import com.krish.RestaurantApp.model.Restaurant;

import java.util.List;

public interface IRestaurantService {

    //in built/predefined jpa respository method
    Restaurant addRestaurant(Restaurant restaurant);
    Restaurant updateRestaurant(Restaurant restaurant,int id);
    void deleteRestaurant(int restaurantId);
    List<Restaurant> getAllRestaurant();
    Restaurant getById(int restaurantId);

    //derived queries (b'coz city and type are instance member in restaurant.java)
    List<Restaurant> getByCity(String city);
    List<Restaurant> getByType(String type); //veg or non veg

    // ----------------------------------------------------------
    // getByCity --- comes from city instance varaible defined in Restaurant.java
    // getByType --- type instance varaible defined in Restaurant.java
    //-------------------------------------------------------------------

    //custom queries(there is no itemName and cuisine in Restautant.java)
    // so we have to write custom query by using join and itemName and cuisine present in Item.java

    List<Restaurant> getByItemName(String itemName); //dosa
    List<Restaurant> getByCuisine(String cuisine);



    // getByItemName --- itemName instance varaible defined in Item.java
    // getByCuisine ---  cuisine instance varaible defined in Item.java

    // note all above instance varaible first letter make it capital such as getByCity
}
