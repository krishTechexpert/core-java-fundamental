//------ What is component ----------
/* java class which contains business logic is called a component
* example: Controller, Services, Dao(Data Access Object)
*
* let us see example how application work in sprintboot
* 1.) suppose user send request for getting resources by browser,postman,UI
*
* 2.) SprintBoot application contains 3 layer
* a.) Controller layer: it check kon si service call kerni hai
* b.) Service: layer: esmy hum dao ka used kerty hai
* c.) Dao(Data Access Object) layer: es sy hum data ko db m send ker det hai
*
* request come  first here to Controller  then forward to service layer and then
* forward to Dao layer and finally interact with DB
*
*3.) database
* */

public class ComponentDemo {
}
