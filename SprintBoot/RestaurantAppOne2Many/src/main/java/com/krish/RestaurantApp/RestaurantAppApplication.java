package com.krish.RestaurantApp;

import com.krish.RestaurantApp.model.Item;
import com.krish.RestaurantApp.model.Restaurant;
import com.krish.RestaurantApp.service.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@SpringBootApplication
public class RestaurantAppApplication  {

	public static void main(String[] args) {

		SpringApplication.run(RestaurantAppApplication.class, args);
	}

	/*
	@Autowired
	private IRestaurantService restaurantService;

	@Override
	public void run(String... args) throws Exception{
		Item itemOne = new Item("Dosa","Breakfast","SI",100);
		Item itemTwo = new Item("FriedRice","MainCourse","Chinese",200);
		Item itemThree = new Item("Noodles","MainCourse","Chinese",300);

		List<Item> itemList=Arrays.asList(itemOne,itemTwo,itemThree);

		Set<Item>  items=new HashSet<>(itemList);
		//Set<Item>  items=new HashSet<>(Arrays.asList(itemOne,itemTwo,itemThree)); //another way


		Restaurant restaurant1 = new Restaurant("Taj","non-veg","Bangalore",items);

		Item itemFour = new Item("alooParatha","Breakfast","NI",50);
		Item itemFive = new Item("KariRice","MainCourse","Indian",100);
		Item itemSix = new Item("Chowmin","MainCourse","Chinese",120);

		List<Item> itemList2=Arrays.asList(itemFour,itemFive,itemSix);

		Set<Item>  items2=new HashSet<>(itemList2);


		Restaurant restaurant2 = new Restaurant("Krish","veg","Meerut",items2);

		restaurantService.addRestaurant(restaurant1);
		restaurantService.addRestaurant(restaurant2);

	   Set<Item> i2=	restaurant2.getItems();

	}*/

}
