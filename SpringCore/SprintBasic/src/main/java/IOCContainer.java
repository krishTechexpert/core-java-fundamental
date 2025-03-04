//----- IOC Container --------------

/* IOC Container:
*   1. IOC start for inversion of control
*   2. IOC is responsible for Dependency Injection in spring Application
*   3. Dependency Injection means creating bean and injection bean into target bean classes in spring application.
*
*   we have 2 IOC Container:
*   1.) Bean Factory (outdated)
*   2.) ApplicationContext (Recommended) we will learn this
*
*
* Note; IOC Container will manage life cycle os spring beans
* Note: we need to provide "java classes + bean configuration " as input to IOC then IOC will perform DI
*       and provides spring beans which are ready to use.
* */

/* ---------------- what is Spring Bean -----------
*   1. Any java class whose lifecycle (creation to destroy) is managed by IOC is called a spring bean
*   2. we can represent java class as spring bean in 2 ways
*       a.) XML-bean configuration
*               i.) <bean id="id1" class"full package.className" />
*        b.) Annotation based
*               i.) @Component, @Service, @Repository
*
*       Note:
*       1. In Spring, we can use both xml & annotation approaches
*
*       Note:
*       1. In Spring Boot will only play with annotation (no xml configuration need WOW)
* */

//----------------------------------------------------------
// Now all theory is done

/* --------- How to make Spring Application -----------*/

/* Pre-requisites: java,IDE, Dependency
    1.create maven project
*   2. Add spring context dependency in pom.xml file
        such as
        <!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>6.2.3</version>
        </dependency>

    spring application k pass ek IOC hota hai,Jo configuration context ko read kerta hai

    3. create required java classes
    4. create bean configuration file and bean defination such as
                    <?xml version="1.0" encoding="UTF-8"?>
        <beans xmlns="http://www.springframework.org/schema/beans"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="
                http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

            <!-- bean definitions here -->

        </beans>
    5. create main class and start IOC container such as
        ApplicationContext ap=new new ClassPathXmlApplicationContext("bean.xml"); //IOC reads bean.xml, creates beans, and injects dependencies.

        Car car = ap.getBean(Car.class)
* */





public class IOCContainer {
}
