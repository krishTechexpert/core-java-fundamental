package ExceptionHandlingDemo;

// Custom exception class
class CheckAdharCardAgeException extends Exception{

    //constructor
    public CheckAdharCardAgeException(String message){
        super(message); // Passing the exception message to the parent class
       // super(message); // Calling the parent class (Exception) constructor

        //The super keyword is used to call a constructor of the parent class (in this case, Exception).
        //Here, it passes the message string to the parent class's constructor (Exception), which stores it as the detail message of the exception.

        /*
        * Why Use super?
        The Exception class in Java already has constructors that accept a message string. By calling super(message), you pass that message to the parent class, enabling it to store the message and make it available when the exception is thrown.

        This message can later be retrieved using the getMessage() method.
        * */

    }
}

public class ThrowCustomExceptionExample {
    public static void validateAge(int age) throws CheckAdharCardAgeException{
        if(age< 18) {
            //throw new RuntimeException("Age must be 18 or above to vote\"")//without custom exception
            throw new CheckAdharCardAgeException("Age must be 18 or above to vote");
        }
        System.out.println("Age is valid. you can vote");
    }

    public static void main(String[] args) {
        try{
            validateAge(16); // This will throw an exception
        }catch(CheckAdharCardAgeException e){
            // Handling the custom exception
            System.out.println("Exception caught: " + e.getMessage());
            //When you call e.getMessage(), it retrieves the stored message from the
            // Exception class.
        }

        try{
            validateAge(20); // This will not throw an exception
        }catch(CheckAdharCardAgeException e){
            // Handling the custom exception
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}

/*
Why Not Handle the Message Directly in the Subclass?
Instead of reimplementing message storage and retrieval in every custom exception class,
 the parent Exception class already provides these capabilities. Using super(message)
 allows you to leverage the existing functionality of the parent class, reducing code
 duplication.

Example Without super(message) (Less Efficient)
If you don't use super(message), you'd have to handle message storage and retrieval yourself:

class InvalidAgeException extends Exception {
    private String message; // Field to store the message

    public InvalidAgeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message; // Custom implementation to return the message
    }
}
This approach works, but it's unnecessary because the Exception class already does this for you.
*/

