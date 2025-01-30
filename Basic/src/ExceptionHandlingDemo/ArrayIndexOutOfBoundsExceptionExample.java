package ExceptionHandlingDemo;
/*
* int a[]=new int[5];
  a[10]=50; //ArrayIndexOutOfBoundsException
* */
public class ArrayIndexOutOfBoundsExceptionExample {
    public static void main(String[] args) {
        int[] num = {1,2,3,4,5};
        try{
            System.out.println(num[10]);
            System.out.println("array end");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.toString());
        }
    }
}
