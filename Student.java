class Student{
  
 public static void main(String[] args){
    String name="krishna";
    int len=name.length();
    String str="";
    for(int i=0;i<len;i++){
      if(name.charAt(i) != 's'){
        str+=name.charAt(i);
      }
    
    }
      System.out.println(str);//krihna
 }
}

