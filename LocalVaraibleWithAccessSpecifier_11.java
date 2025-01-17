// concept of type of varaible
//instance varaible
//static varaible
//local varaible

class LocalVaraibleWithAccessSpecifier_11 {
  int p1=10; // default modifier
  static int p2=20; //default modifier
 // if we are not declare any modifer then by default it will be default modifier but the rule is applicable for instance and static varaible but not for local varaible

  int [] x;
  int [] z= new int[3];
  void test(){
    final int y=20;
    int p1=30; // p1 is local varaible so there is no default modifier for local varaible


  }

  public static void main(String[] args){
    // public int x=10;
    // private int x=10;
    // protected int x=10;
    // static int x=10;
    // transient int x=10;
    // volatile int x=10;
    //above 6 method give complie time error all these are local varaible with access modifier inside main which is not accepted only final is accepted as local varaible so all 6 these should be class level varaible

    // scope of local varaible is fixed inside method which are not access outside the method 

      LocalVaraibleWithAccessSpecifier t =new LocalVaraibleWithAccessSpecifier();
      System.out.println(t.x);//null default value will provided by jvm
      //System.out.println(t.x[0]); //error: null pointer exception

      System.out.println(t.z);//hash code value [I@1dbd16a6
      System.out.println(t.z[0]); // 0 b'coz int default value



     final int x=10;//10
     //System.out.println(y); // error can not find symbol 
     //y is only accessible inside test method it is local varaible

     //the only applicable  modifier for local varaible is final.

     //by misteak if you are trying any other modifer then we will get complie time error. 



     // if we are not declare any modifer then by default it will be default modifier


     // summary & conclusion
     //for instance and static varaible, jvm will provide default values and we are not required to perform initialization explicitly

     //but for local varaible jvm will not provide any default value so it will be compulsary to initialization explicitly before using the varaibles

     // instance and static varaible can be accessed by multiple threads simultaneously and hence these are not thread safe.

     //but in case of local varaible, for every thread, a sepearate copy will be created so local varaible is thread safe.

      //Array
     // once we create an Array every array element by default initailization will be default value respective of wheather it is instance array or static array or local array
  }
}