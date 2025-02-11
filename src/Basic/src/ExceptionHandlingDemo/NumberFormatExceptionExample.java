package ExceptionHandlingDemo;

/**
 * String s="abc";
 * int i=Integer.parseInt(s);//NumberFormatException
 *
 * Suppose we have a string variable that has characters; converting this variable into digit will cause NumberFormatException.
 */
public class NumberFormatExceptionExample {
    public static void main(String[] args) {
        String str="krish";
        try{
            int num = Integer.parseInt(str); // Attempting to parse a non-numeric string to an integer
            System.out.println("Parsed Number = "+num);
        }
        /* this order give error java: exception java.lang.NumberFormatException has already been caught
        so put exception in the last ti fixed error
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        catch(NumberFormatException e) {
            System.out.println(e.getMessage());
        }*/
        catch(NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
