package ExceptionHandlingDemo;
/*
order of exception is matter like
child first then parent..
exception should be in the last
we can put parent exception,runtimeexception first , then Arithmatic etc..not allowed give error
 */

public class ArithmeticExceptionExample extends Throwable {


    public static void main(String[] args) {

        try{
           int a=10;
           int b=0;
           System.out.println(a/b); //5/0 gives infinity
           System.out.println("end programme");
       }
        catch(ArithmeticException e) { //
             //it is good practise to catch releated error to coding
            System.out.println(e.toString()); //java.lang.ArithmeticException: / by zero

        }
        catch(Exception e) {
            // Exception is the parent class of all runtime exception,IOEceptopn,SQLException etcc.
            //so it can contain child class object as we learned in parent child releationshiop
              // such as Parent p = new Child();
            //it above no one catch then Exception e definately catch error

            //3 ways to print exception
           e.printStackTrace(); //java.lang.ArithmeticException: / by zero
           //at ExceptionHandlingDemo.ArithmeticExceptionExample.main(

            System.out.println(e.getMessage()); /// by zero

           System.out.println(e.toString());// covert exception object into string format
           //java.lang.ArithmeticException: / by zero
       }
        finally{
            //it wil be used to cleanup resource such as DB connection will close if any error in db
            System.out.println("exception aya ya na aye it will execute in any case. we can stop finally if jvm sutdown using System.exit(0) .");
        }
    }
}
