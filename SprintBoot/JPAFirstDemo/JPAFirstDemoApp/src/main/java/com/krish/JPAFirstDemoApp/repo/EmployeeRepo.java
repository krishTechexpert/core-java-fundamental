package com.krish.JPAFirstDemoApp.repo;


/*
* Let see JPA Magic no need to write any code which interact with DB.
* JPA will do for us by using interface JpaRepository which will give lots of predefined methods such as FindAll,
* */

import com.krish.JPAFirstDemoApp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/* Notes: Interface parameters
kis class ki repository bna rehy ho mention here inside interface  first parameter

primary id kis type ki hai mention here inside interface second parameter
*/

@Repository
public interface EmployeeRepo  extends JpaRepository<Employee,Integer> {
}

/*
* run time per JPA eski (EmployeeRepo) implementation class bna ker dega and insert ker dega object in Employee class inside entity directory
* */

/*------ Methods in JPS mostly used ----------
*
* save(object)
* saveAll(<Iterable<Entity>)
* findById(id)
* findAll()
* Count();
*
* existById(id)// user already exist in db
* deleteById(id)
* deleteAll()
* updateById(id)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             )
*-----------------------------
*
* WE CAN WRITE native query (mysql ki query which is very long and complex)
*
* */