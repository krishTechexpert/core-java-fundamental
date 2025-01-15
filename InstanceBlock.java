class InstanceBlock{
 // check which will run 
  static {
    // this will be run first b'coz it will get memory on class laoding
    System.out.println("Static block");
  }
  // instance block
  {
    // this will be run  when object is create but before run any constructor that'w why it will be showing before default constructor
    System.out.println("Instance block");
  }
  // default constructor
  InstanceBlock(){
    System.out.println("Default Constructor");
  }
  public static void main(String[] args){
    new InstanceBlock();
  }
}
// output
//Static block
//Instace block
// default constructor