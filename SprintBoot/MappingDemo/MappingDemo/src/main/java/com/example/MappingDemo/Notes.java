package com.example.MappingDemo;

public class Notes {
}

/* -------- Mapping Notes ------------
*
* Types of Relationship Mapping in Java (JPA/Hibernate)
----------------------------------------------------
When designing a database schema in Spring Boot using JPA (Java Persistence API),
* we need to define relationships between different entities (tables).
* JPA provides annotations to map these relationships.

https://chatgpt.com/c/67d279a0-bae4-8008-8f1a-0a4be7337a17


1. One-to-One (@OneToOne)

2. One-to-Many (@OneToMany)

3. Many-to-One (@ManyToOne)

4. Many-to-Many (@ManyToMany)  :
* it was very degenerous relationship which create recursive problem in java,
* try to using becarefully) b'coz

because ek alg sy table bnanani padt hai jo contain kerta hai productId columns and
* customerId Column such below as

            productsId		   			customerId
        first product(1)  ----  second customer sy(2)
        second prodcut(2) ---- first customer sy(2) etc.
                        1-----1
                        2----1
                        1--3
                        2-----3



How to design schema in development
-----------------------------------

1.) collecting the requirement


	-> CodeForSuccess(CFS) has multiple students
	-> CFS has multiple batches
	-> 1 batch have multiple students
	-> every batch have 1 teacher
	-> every batch has multiple class
	-> for every students in each class have attendance

	Now try to find entity(noun) in java sothat we can create classes in java according
	* to entity

	entity: students,batches,teacher,class,attendance are our entities

	Note: DBMS does not allowed to store multivalued such as list of students,
	* list of products instead of we can store studentsId, productsId


	Many students can join 1 java batch (many To one)
	1 java batch have many students ( one to many)
-----------------------------------------------------------------------------

	how to find relationship in java see other example we consider kgf movie

		1 kgf movie   --running--- many kgf show 12:00pm 4:00pm 900:pm in 1 day

		1 show ------- 1 movie -- 1 show mai 1 movie hi chaligi

---------------------------------------------------------------------------------

		student ---teacher relationship create kerty hai for better understanding..
		* yha per hum batch k respect m bath ker rehy hai


		1 student --- 1 teacher (means 1 student ka 1 hi teacher hoga)
		* [one to one relationship]

		many student--- 1 teacher (means 1 teacher bhut sary baccho ko pada reha hoga]
		* [many to one]

		1 student --- 1 attandance (one 2 one)

------------------------------------------------------------------------------------------------

Many 2 many relationship in ecommerecne (it was very degenerous relationship which
* create recursive problem in java, try to using be carefully) b'coz

because ek alg sy table bnanani padt hai jo contain kerta hai productId columns
* and customerId Column such below as

	productsId		   customerId
first product(1)  ----  second customer sy(2)
second productt(2) ---- first customer sy(2) etc.
				1-----1
				2----1
				1--3
				2-----3


customer-------products (many customer have many products) (many to many)


1 customer can buy many products (1 to many)

Many Students → Many Courses


--------------------------------------------------------------------


@Transactional annontation(Ensures Consistency):

. it follows ACIP properties
. Instead of calling multiple APIs one by one, we wrap them inside a single
* transaction to reduce HTTP requests.

. it works as proxy(DTO data transfer object) in which we send single http request
* for multiple resource 	instead of creating 3 api request one by one manually
*
    such as  1 api--- /orderplace
             2 api--- /emailnotify
             3 api--- / invoice
.In proxy, suppose user will call only /placeorder api then other 3 api will be
* called by proxy automatically which provide abstraction to user.

    user----call /placeorderapi---which goes to further request to
    proxy design pattern----which call other 3 api automatically

. it will be either commit or rollback in case of any failure

		dirty read and dirty write (you can read as well)

* */