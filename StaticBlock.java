class StaticBlock {
  //static block
  static {
    // this will run first because it will load on class loading
    System.out.println("static block");
  }
  //default Constructor
  StaticBlock(){
    System.out.println("Default Constructor");
  }
  public static void main(String[] args){
    new StaticBlock();
  }
}

// output
//static block
//default Constructor