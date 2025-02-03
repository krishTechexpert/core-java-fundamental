import java.lang.reflect.*;
// to calculate how many class present in java.lang.String package //148 class

class Test{
  public static void main(String[] args) throws Exception{
    int count=0;
    //Class c = Class.forName("Student");//2
    Class c = Class.forName("java.lang.String"); // 148
    Method [] m = c.getDeclaredMethods();
    for(Method m1:m){
      count++;
      System.out.println(m1.getName());
    }
    System.out.println("the number of method: " + count );
  }
}