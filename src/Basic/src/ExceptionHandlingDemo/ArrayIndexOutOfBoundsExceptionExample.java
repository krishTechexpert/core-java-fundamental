package ExceptionHandlingDemo;
/*
* int a[]=new int[5];
  a[10]=50; //ArrayIndexOutOfBoundsException
* */
public class ArrayIndexOutOfBoundsExceptionExample {
    public static void main(String[] args) {
        int[] num = {1,2,3,4,5};
        //tru with multiple catch
        try{
            num[10]=10/0;//yha per do exception aa sekti gai first arithmatic and second is arrayIndexout
            //System.out.println(num[10]);
            System.out.println("array end");
        }
        catch(ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        catch(ArrayIndexOutOfBoundsException e){
            //ArrayIndexOutOfBoundsException is child class of IndexOutOfBoundsException
            //StringIndexoutOfboundsException is child class of IndexOutOfBoundsException
            System.out.println(e.toString());
        }
        /* we can also used that together
        catch(ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }*/

    }
}
