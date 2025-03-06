//---------- Bean Scope -----------
/*
* In Spring, bean scope defines the lifecycle and visibility of a bean
* how and when a new instance of a bean is created and how long it lives.

* --------- Types of Bean Scopes in Spring ------------------
* 1.) Singleton scope:by default nature,when you create multiple bean object, then all time singleton object is created.
<bean id="car" class="" scope="singleton" />// it will default so don;t need to write scope="singleton"

* 2.) Prototype scope: for each request(ap.getBean(Car.class) yhi prototype request hai,),new object will created
* <bean id="car" class="" scope="prototype" />
*
* 3.) Request scope: used in web app for each request(http request get,post such as postman,user,browser) new object will create
*
* 4.) Session scope: new object for each session
*
* 5.) Application scope: one object for complete application
*
* 6.) web socket scope: it is new introduced with version sprint 4.0
 *
 *
 * Which Scope to Use?
Use singleton for shared components.
Use prototype for independent instances.
Use request/session/application for web-based applications.
*
* */

public class BeanScope {
}
