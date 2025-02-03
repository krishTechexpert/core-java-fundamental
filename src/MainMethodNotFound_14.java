// concept of there is no main method

//jdk1.6 till and below , compile successfully and print static block and not give any error run succesfully when you run java MainMethodNotFound_14 But
class MainMethodNotFound_14{
  static{
    System.out.println("static blocks");
    System.exit(0); // shutdown jvm
  }
}
//jdk1.7 and above version , compile successfully and 
//when we run java MainMethodNotFound_14 then 
//static block will not print and give runtime error such as Error: Main method not found in class MainMethodNotFound_14, please define the main method as:
