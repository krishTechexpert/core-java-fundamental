import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//--- Custom Annotation example 2 to calculate Exection Time:----
/*
Here are some real-world examples where custom annotations are useful:


* 1. Logging Execution Time
Use Case: Measure method execution time for performance monitoring.
👉 Benefit: Helps monitor performance without modifying method logic.

2. Role-Based Access Control
Use Case: Restrict method access based on user roles.
👉 Benefit: Enforces role-based security without modifying business logic.

3. Custom Validation in JavaBeans
Use Case: Validate fields in a Java class.
👉 Benefit: Helps automate data validation in a reusable way.





* */

// es LogExecutionTime annotation ko runtime per available kra do
@Retention(RetentionPolicy.RUNTIME)
//es LogExecutionTime annotation ko class k sath used kerna hai,ya phir method k sath used kerna hai etc.
@Target(ElementType.METHOD)
//@FunctionalInterface
 @interface LogEXecutionTime{ // i want to used this on readdata method
    /*
    * Why is @interface LogExecutionTime {} Empty?
Your custom annotation @LogExecutionTime is empty because it only serves as a marker.

A marker annotation is an annotation with no methods.
It is used to indicate that something special should be done, without needing any extra information.
* Your annotation is empty because you don’t need to pass any extra data.

    //It does not store any data (no methods inside).
    *
    * If you want to pass extra data, you can add methods inside the annotation.

        * @interface LogExecutionTime {
            String message() default "Execution Time:";
        }


    * */
}

public class LogExecutionTimeAnnotation1 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        DBOPeration1 db=new DBOPeration1();
        Method method=DBOPeration1.class.getMethod("readdata");
        if(method.isAnnotationPresent(LogEXecutionTime.class)){
          long startTime = System.currentTimeMillis();
          method.invoke(db);
          long endTime = System.currentTimeMillis();
            System.out.println("Exection Time: "+ (endTime-startTime));
        }
    }
}

class DBOPeration1{
    @LogEXecutionTime()
    public void readdata() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Task Completed!");
    }
}