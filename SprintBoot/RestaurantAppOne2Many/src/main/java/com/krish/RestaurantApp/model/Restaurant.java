package com.krish.RestaurantApp.model;

import jakarta.persistence.*;

import java.util.Set;

/* // OneToMany relationship based project
*
* In one to many, uniqueness should be present

one department have many employee
one customer have many account
one shopping cart have many items
one student have many assignment
one teacher teach many student
one restaurant have many food items
for example: Taj restuarant have special taj dosa,taj tea, burger,pizza..
and all items belongs to one Taj restaurant..in case resutrant , all these foods items found only in Taj restaurant

In one to many relationship, foreign key is added on many side,,

so in our Restaurant project,

if we add food item foreign key in taj restaurant table then duplicate row will be added which contains items id so it will not work

		--------TajRestaurant Table----------
such as 1 taj-hotel 	meerut non-vej 10(foodItemId)
		1 taj-hotel 	meerut non-vej 20(foodItemId)
		1 taj-hotel 	meerut non-vej 30(foodItemId)
		2 krish-hotel   meerut vej   40(foodItemId)

you can see here row cotains duplicate data except foodItemId

that's why we will added taj restaurant id(FK) inside food items table




*
* */



@Entity
public class Restaurant {
    @Id
    @GeneratedValue(generator="restaurant_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name="restaurant_gen", sequenceName = "restaurant_sequence",
                        initialValue = 100, allocationSize = 1)
    private Integer restaurantId;

    @Column(length=30)
    private String restaurantName;

    @Column(length=10)
    private String type; // veg or non-veg

    @Column(length=20)
    private String city;

//    1️⃣ Add orphanRemoval = true
    //Without this, if you remove an item from Set<Item>, it won't be deleted from the database.

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true) // many food items belongs to one restaurant
    // to avoid Intermediate table
    @JoinColumn(name="restaurant_id") // this column name will be added in Item table as foreign key


            //internally 3 table will create
            //.1) item table
            //2.) Restaurant
            //3.) restaurant_items[items is the instance member defined in restaurant.java)
            // --------- very imp notes---------

    // restaurant_items(known as junction table or intermediate table automatically created
    // which contans  two columns suchas restaurant_restaurant_id and items_item_id like below)

 //Hibernate: create table restaurant_items (items_item_id integer not null, restaurant_restaurant_id
    // integer not null, primary key (items_item_id, restaurant_restaurant_id)) engine=InnoDB
    // knowns as junction table or intermediate table

    Set<Item> items; // list of unique food item name

    /* If you don't want intermediate table automatically then
    you can add restaurant_id as foreign key in Item table
    * then you can also do that by using
    @JoinColumn(name="restaurant_id") // this column name will be added in Item table as foreign key
    *  */


    public Restaurant(){
        super();
    }

    public Restaurant(String restaurantName, String type, String city, Set<Item> items) {
        this.restaurantName = restaurantName;
        this.type = type;
        this.city = city;
        this.items = items;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId=" + restaurantId +
                ", restaurantName='" + restaurantName + '\'' +
                ", type='" + type + '\'' +
                ", city='" + city + '\'' +
                ", items=" + items +
                '}';
    }
}

