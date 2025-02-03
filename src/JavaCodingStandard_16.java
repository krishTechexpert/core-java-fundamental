class JavaCodingStandard_16{
  // public int m1(int x,int y){
  //   return x+y // refactor code with meaningfull name
  // }
  public static int add(int number1,int number2){
    return number1 + number2;
  }
}

//1.) first define package like format package com.durgasoft.auth(module name)
//2.) class name always public with pascal case with meaning full name
//3.) m1 is instance method but we are not using any instance varaible insdie m1 so in that case
// public int m1(int x,int y){
//     return x+y // local varaible
//   }
// so in that case make it static such as
// public static int m1(int x,int y) {
//   return x+y;//// local varaible
// }


//coding standard for Interface start with uppercacse letter and second word also uppercase
//interface such as Runnable,Seraiblable,Comparable,RandomAccess


//coding standard for method such as camelcase
// single word start with lower case like print(),sleep(),run(),eat(),star(),main(),
//combineWord such as secondWord should be start with uppercase
//getName(),setSalary()

//for Varaible name coding standard , age, salary, mobileNumber


//constant standard name  such as MAX_VALUE,MAX_PRIORITY,


// public class StudentBean {
//   private String name;
//   public  void setName(String name){
//     this.name=name;
//   }
//   public String getName(){
//     return name;
//   }
// }


//coding standard for method with parameter a is correct format

//a.) public void addMyActionListener(myActionListener l)(correct)
      //public void removeMyActionListener(myActionListenerl)(correct)

//b.) public void registerMyActionListener(myActionListener l) (wrong)

//c.) Public void addMyActionListener(ActionListener l) (wrong)
