package com.krish.RestaurantApp.repository;

import com.krish.RestaurantApp.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRestaurantRepository extends JpaRepository<Restaurant,Integer> {

   List<Restaurant> findByCity(String city);
   List<Restaurant> findByType(String type);

   /* how to handle custom query
   * This happens because Spring Data JPA looks for itemName inside Restaurant,
   * but itemName actually exists inside Item (which is a separate table).
    * */

   /*
   * ❌ Why Doesn't getByItemName(String itemName) Work?
You are trying to find a Restaurant by itemName, but itemName is inside Item, not Restaurant.

Spring Data JPA only understands direct properties in method queries.

Solution: We need to "link" Restaurant and Item in the database using JOIN.

   If you ask "Find me the Restaurant that serves 'Dosa'",
   * we need to look in the Item table first and then link it to the Restaurant using restaurant_id.

   🛠 Decision Process:
✔ A Restaurant has many Items (OneToMany relationship).
✔ Item belongs to a Restaurant (ManyToOne relationship).
✔ Since Item contains restaurant_id, we JOIN Restaurant with Item.


   * */

   //advance
   /*
   * 📌 Why Does This Work?
JPQL is object-oriented, so it doesn't use table names (restaurant, item).

Instead, it uses entity names (Restaurant, Item) and their mapped fields.

JOIN r.items i tells Hibernate to use the mapped Set<Item> relationship.


   * */

   @Query("select r from Restaurant r JOIN r.items i where i.itemName=:itemName")
   // basic query for beginner
  // @Query("select r from restaurant r JOIN item i ON r.restaurant_id = i.restaurant_id where i.itemName='Dosa'")
   List<Restaurant> getByItemName(@Param("itemName") String itemName); //dosa

   @Query("select r from Restaurant r JOIN r.items i where i.cuisine=:cuisine5")
   List<Restaurant> getByCuisine(@Param("cuisine5") String cuisine);

}


/* explain step by step
*
* @Query("SELECT r FROM Restaurant r JOIN r.items i WHERE i.itemName = :itemName")
This is a JPQL (Java Persistence Query Language) query used in Spring Data JPA.
* Let's understand it step by step:

   * 1.)  @Query - What Is It?
      @Query is used to write custom queries in Spring Data JPA.

It allows us to define our own SQL-like queries instead of relying on method names like findBy....


* 2.) SELECT r FROM Restaurant r - What Are We Selecting?
SELECT r → We are selecting a Restaurant (r).

FROM Restaurant r → We are selecting from the Restaurant table, giving it an alias r.

* 3.) JOIN r.items i - What Is JOIN Doing?

      JOIN r.items i → We are joining the Restaurant table with the Item table.

      r.items refers to the Set<Item> inside the Restaurant entity
       (because a restaurant has multiple items).

      i is the alias for the Item entity, so we can refer to its fields (i.itemName, i.cuisine, etc.).


* 4.)  WHERE i.itemName = :itemName - Filtering the Results
*
*        WHERE is used to filter the results.

         i.itemName = :itemName means:

               We only select restaurants that have an item matching the given itemName.
               :itemName is a placeholder (parameter) that will be replaced with actual
               values at runtime.


🔍 Full Explanation in Simple Words
Find all restaurants (r) that serve a specific food item (i.itemName).

Look inside the restaurant's item list (r.items).

If the food item name matches :itemName, return that restaurant.







 *
* */