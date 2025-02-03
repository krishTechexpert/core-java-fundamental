package ExceptionHandlingDemo;
//Custom exception with throw keyword

/**
 * The throw keyword in Java is used to explicitly throw an exception from a method
 * or a block of code. You can throw either predefined exceptions (e.g., IllegalArgumentException,
 * NullPointerException, etc.) or custom exceptions.
 *You can throw only one exception at a time using the throw keyword.
 * */
public class ThrowDemo {
    public static int divide(int a,int b){
        if(b==0){
            throw new ArithmeticException("Divison by zero is not allowed, thanks krishna handling it"); // Throwing an exception
        }
        return a/b;
    }
    public static void main(String[] args) {
        try{
            int res = divide(20,10);
            System.out.println("the result is="+res);
            // Invalid division (will throw an exception)
            res = divide(10,0);
            System.out.println("the result is="+res);
        }catch(ArithmeticException e){
            // Handling the exception
            System.out.println("Exception caught: " + e.getMessage());
        }

    }
}
