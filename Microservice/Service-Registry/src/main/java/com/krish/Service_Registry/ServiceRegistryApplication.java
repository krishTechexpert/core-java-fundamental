package com.krish.Service_Registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/* step add dependency in pom.xml file

* some baby step in case of microservice ( Real time industry work)
1.) first Discovery server bna lo and add dependency such as

		i.) web, spring-cloud-starter-netflix-eureka-server (server) in pom.xml
		ii.) @EnableEurekaServer add this anontation in ServiceRegistryApplication.java
		iii.) add default port 8761 in application.properties file
run application successfully and you will see http://localhost:8761/ in chrome

2.) Admin server bna lo and add dependency such as
		i)  web, codecentric's Spring Boot Admin (Server) Ops in pom.xml
		http://localhost:1111/applications
		ii.) @EnableAdminServer , add this anontation in AdminServerApplication.java
		iii.) add default port 1111 in application.properties file
run application successfully and you will see http://localhost:1111/ in chrome

IMP Notes:
kitny instance chl rhy hai of MS, y bi admin server check kerta hai

suppose one Greet-API microservice running on different-2 port such as 9092,9093,9094
it means same Greet-API k 3 instance running ho rehy hai


3.) Zipkin server
	download zipkin jar file and put in your working folder
	open cmd and Microservice ->  java -jar zipkin-server-3.5.0-exec.jar then enter
	zipkin server start and check it on http://127.0.0.1:9411/zipkin/

	it will search some traceId for Microservice which are running on it.
	basically Y trace kerta hai ki microservice kha s aa rehi hai kitna time l rehi hai etc
	such as microservice A -> Microservce B -> MC C (communicate to each other)

	Kon si API kitna time l rehi hai ziplin bata tah hai
---------------------------------------------------------------------

4.) Now all server set up done and we create Greet-API spring boot app for MS
now try to make some Simple Microservice(Spring boot application we are taking)by java code

 5.) making Greet-API Microservice

 IMP Notes: Greet API Microservice ki details Discovery server and admin server k pass
 			jani chiye toh we need some dependency such as
 			a.) Eureka Discovery Client,
 			b.) codecentric's Spring Boot Admin (Client)
			c.) web,
			d.) Spring Boot Actuator Ops
			e.) Zipkin Observability, (API Logs likny k liye)


and if we want to check microservice health then we need also Spring Boot Actuator Ops

f.) try to not add this f.) and g.) step
 spring cloud sleuth zipkin (May be Optional dependency)
if zepkin server was not showing get request then remove f.) and g.)
may be not compatible with sprint boot 3.0
-------------------------------------------------------
har ek log ki unique ID bna deta hai sleuth-zipkin
			spring cloud sleuth zipkin maven s download kerna and add in pom.xml
			<!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-sleuth-zipkin -->
			<dependency>
				<groupId>org.springframework.cloud</groupId>
				<artifactId>spring-cloud-sleuth-zipkin</artifactId>
				<version>3.1.11</version>
			</dependency>

g.) Spring Cloud Starter Zipkin:
----------------------------------
			<!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-zipkin -->
	<dependency>
		<groupId>org.springframework.cloud</groupId>
		<artifactId>spring-cloud-starter-zipkin</artifactId>
		<version>2.2.8.RELEASE</version>
	</dependency>

h.) add @EnableDiscoveryClient anontation in GreetApiApplication.java
-------------------------- Finally All config done --------------------------------------------

A.) after doing all Greet-API Microservice config, it run successfully

http://localhost:8080/greet
result: Good Morning , I am from Greet-API MS
---------------------------------------------
B.) now check Discover server will show/register my Greet-API
IMP Notes: all server should be running

. first check http://localhost:8761/ , you will find Greet-API MS has registered
on discovery server (discovery server work well till now)
-------------------------------------------------------------
C.) now check Admin server will show my Microservice instance
for this we need to first some config in Greet-API application.properties file such as

#Admin server
spring.boot.admin.client.url=http://localhost:1111/
management.endpoints.web.exposure.include=*

#It is used in Spring Boot (especially in Spring Boot Actuator) to expose
# all actuator endpoints over the web. such as /actuator/health,/actuator/beans,
# /actuator/metrics,/actuator/info,/actuator/env etc

Now Test: http://localhost:1111/applications and you will find that
			Greet-API 1 instance running succesfully and you can also check
			health for Greet-API as well
			http://localhost:9090/actuator/health
			http://localhost:9090/actuator/metrics
			http://localhost:9090/actuator/beans
			http://localhost:9090/actuator/env etc,

--------------------------------------------------------

d.) Now check Zipkin server
	start zipkin server on cmd
	krishna@krishna-software-developer:~/code-25/core-java-fundamental/Microservice$
	java -jar zipkin-server-3.5.0-exec.jar

	check in chrome http://localhost:9411/zipkin/

	first hit Greet api http://localhost:9090/greet
	then check in chrome http://localhost:9411/zipkin/

	we need doing some config for zipkin server in Greet-API applicaion.properties

	 and final result is like in zeplin
	 greet-api: http get /greet  6 minutes ago (04/06 19:01:50:069)

--------------------------------------------------
Finally our 3 server working well.


6.) Making Welcome API: add dependency such as

			a.) Eureka Discovery Client,
 			b.) codecentric's Spring Boot Admin (Client)
			c.) web,
			d.) Spring Boot Actuator Ops
			e.) OpenFeign Spring Cloud Routing

			add config in application.properties of Welcome
			http://localhost:8081/welcome

			result is: Hi, I am from Welcome API

* */


/* how to consume api or communicate with api microservice

	suppose we are trying to consume of Greet API data inside Welcome API
	then there are 2 type to do this.
	1.) Rest Template
	2.) Open Feign client

	// way-1: Rest Template to consume Greet API
    // but In Rest Template, we need to provide fixed Url
    //such as String greetMsg =  restTemplate.getForObject("http://localhost:9090/greet",String.class);
    suppose welcome API MS running on different -2 port like 8081,8082,8083 multiple instance
    it is very difficult to send request one by one,
     how to decide where to send request
     that i.e disadvantage
-----------------------------------------
     When consuming an API like Greet API from Welcome API,
     RestTemplate has certain disadvantages compared to something like OpenFeign,
     especially in a microservices environment with multiple instances and
     service discovery. Let's break it down clearly.

🔴 Disadvantages of RestTemplate
-------------------------------------
1. Hardcoded URL

String greetMsg = restTemplate.getForObject("http://localhost:9090/greet", String.class);
You have to manually set the base URL.

It doesn't adapt dynamically if the service (Greet API) is deployed on different
hosts or behind a load balancer.

2. No Service Discovery Integration
RestTemplate doesn’t know how many instances of Greet API are running.

It can’t fetch available service instances from a service registry
like Eureka, Consul, etc.

3. No Load Balancing
It cannot distribute the requests automatically among different instances of Greet API.

If you have multiple instances like localhost:9090, localhost:9091, localhost:9092,
you have to write custom logic to handle it — very manual and error-prone.

4. More Boilerplate Code
You need to handle headers, request body, error handling, retries manually.

No declarative way to define clients — everything is done programmatically.

-------------------------------------------------------------

Way 2:  OpenFeign : Y discovery server k sath hi chalta hai..manadatory/majboori hai

add this anontation @EnableFeignClients

// feign client , discovery server s pochega ki do you have Grret API Microservice
then it will return the url of greet API MS ka

✅ Why OpenFeign is Better than RestTemplate
1. Service Discovery Support
Works easily with Eureka. You can just provide the service name.

@FeignClient(name = "greet-service")
public interface GreetClient {
    @GetMapping("/greet")
    String getGreetMessage();
}
2. Built-in Load Balancing
It uses Ribbon or Spring Cloud LoadBalancer under the hood to balance requests
among multiple instances automatically.

3. Less Code, More Declarative
Just an interface and annotations — no need to write HTTP call logic.

4. Better Integration with Spring Cloud
Easily integrates with circuit breakers (like Resilience4J), retries, fallbacks, etc.

---------------------------------------------

🧠 Summary
Feature				RestTemplate		OpenFeign
Hardcoded URL			❌ Yes			✅ No
Service Discovery		❌ No			✅ Yes
Load Balancing			❌ No			✅ Yes
Code Simplicity			❌ Verbose		✅ Declarative
Spring Cloud Integration	❌ Manual	✅ Tight integration


*
* */


@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistryApplication.class, args);
	}

}
