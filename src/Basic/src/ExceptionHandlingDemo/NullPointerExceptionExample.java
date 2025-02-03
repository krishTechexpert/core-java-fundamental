package ExceptionHandlingDemo;
/*
String s=null;
System.out.println(s.length());//NullPointerException  */

public class NullPointerExceptionExample {

    public static void main(String[] args) {
        String str =null;
        try{
            int length = str.length();
            System.out.println("Length of the String "+ length);

        }catch(NullPointerException e){
            System.out.println(e.toString());
        }
    }
}
