//concept varaible arguments method (var-arg method)
class VaraibleArgsMethod_12 {
  
  // 2 arguments passsed
  public static void sum(int a,int b){
    System.out.println(a+b);
  }
  // 3 args
  public static void sum(int a,int b,int c){
    System.out.println(a+b+c);
  }
  // 4 args
  public static void sum(int a,int b,int c,int d){
    System.out.println(a+b+c+d);
  }
  // 5 args
  public static void sum(int a,int b,int c,int d, int e){
    System.out.println(a+b+c+d+e);
  }
  //until 1.4 version we can declare method with varaible number of arguments if there is chnage in number of arguments compulasory we should go for new method it increase length of code readablity to overcome this problem , some people introduce from 1.5 version, we can declare method which can take varaible number of arhuments such type of methods are called (var-args method) such as m1(int... x)

  //we can call this method by passing any number of int values including 0 number
  //m1()// valid
  //m1(10)//valid
  //m1(10,20)//valid
  //m1(10,20,30,40)//valid

  public static void m1(int... x){ //treated as int[] x;
    System.out.println("var-arg method");
    int total=0;
    for(int x1:x){
      total =total + x1;
    }
    System.out.println("The sum:"+total);
  }

  public static void m3(int[]... x){ // it contain array[0] which point to arrar a and array[1] which point to array b
    for(int[] x1: x){ // loop run 2 times 
      System.out.println(x1[0]);//1,4
    }
  }

  public static void main(String[] args){
    m1();//0
    m1(10);//10
    m1(10,20);//30
    m1(10,20,30);//60
    //m2(int x, int... y) valid
    //m2(string s, bouble...,y) valid
    //m2(int... x, double..., d) invalid only one ... is valid
    int [] a={1,2,3};
    int [] b={4,5,6};
    m3(a,b);
  }
}