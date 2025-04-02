package com.krish.RestaurantApp.service;

import com.krish.RestaurantApp.model.Restaurant;
import com.krish.RestaurantApp.repository.IRestaurantRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements IRestaurantService{

    private IRestaurantRepository restaurantRepository;

    @Autowired
    public void setRestaurantRepository(IRestaurantRepository restaurantRepository){
            this.restaurantRepository=restaurantRepository;
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    // ------------- save() method -------------
    // it will check first Id and If Id is not available then auto generate the Id and create
    // new row in database table
    //But
    //If id is available already then it will check whether the ID is available in database table
    //if it is not available in the database table it will insert that particular object as a new row
    //if the ID  is available already in database table then it will update the existing row
    // that is the purpose of the save method that's why we are using  the same save() method in both
    // for insert and update.

    @Override
    public Restaurant updateRestaurant(Restaurant updateRestaurant,int id) {
       Optional<Restaurant> existingRestaurantOpt =restaurantRepository.findById(id);
        if(existingRestaurantOpt.isPresent()){
              Restaurant existingRestaurant=  existingRestaurantOpt.get(); // Retrieve existing Restaurant

            // ✅ Explicitly set the ID to prevent null overwrites
            updateRestaurant.setRestaurantId(id);

            // ✅ Copy only non-ID, non-collection fields

     BeanUtils.copyProperties(updateRestaurant,existingRestaurant,"id","items");
     // Copy all fields except ID and Items

//"id" is excluded because we don’t want to modify the primary key.
//"items" is excluded because we update it manually to avoid Hibernate issues.
//✅ Prevents issues when updateRestaurant.getItems() is null
//If updateRestaurant.getItems() is null (or empty), it may remove all items unintentionally.

            // Handle items properly
            if (updateRestaurant.getItems() != null) {
                existingRestaurant.getItems().clear();
                existingRestaurant.getItems().addAll(updateRestaurant.getItems());
            }

            return restaurantRepository.save(existingRestaurant);
        }
        else {
            throw new RuntimeException("Restaurant not found with ID: " + id);
        }
    }

    @Override
    public void deleteRestaurant(int restaurantId) {
        restaurantRepository.deleteById(restaurantId);
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        List<Restaurant> restAll = restaurantRepository.findAll();
        return restAll;
    }

    @Override
    public Restaurant getById(int restaurantId) {
        Optional<Restaurant> restOpt= restaurantRepository.findById(restaurantId);
        if(restOpt.isPresent()){
           return  restOpt.get();
        }
        return null;
    }

    @Override
    public List<Restaurant> getByCity(String city) {
      return  restaurantRepository.findByCity(city);
    }

    @Override
    public List<Restaurant> getByType(String type) {
        return restaurantRepository.findByType(type);
    }

    @Override
    public List<Restaurant> getByItemName(String itemName) {
        return restaurantRepository.getByItemName(itemName);
    }

    @Override
    public List<Restaurant> getByCuisine(String cuisine) {
        return restaurantRepository.getByCuisine(cuisine);
    }
}
