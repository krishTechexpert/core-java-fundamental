import java.util.Arrays;
class CharExample{
    public static char display()  
    {  
          
        return 'a';  
    }  

  public static void main(String[] args){
    char a='A';
    char b = 'B';
    System.out.println(a);
    System.out.println(b);

    // implict typecasting
    char ch1 = 65;
    char ch2 = 97;
    System.out.println("char1:"+ch1);//A
    System.out.println("char2:"+ch2);//a

    //explicity typecasting
    int num1=97;
    int num2=65;

    char ch3 =(char) num1;
    char ch4=(char)num2;

    System.out.println("char3:"+ch3);//a
    System.out.println("char4:"+ch4);//A

    char ch5='A';
    char ch6 =(char)(ch5+1);
    System.out.println(ch6); // B

    String str="javatpoint";
    int len = str.length();
    char[] chArr=new char[len];

    for(int i=0;i<len;i++){
      chArr[i]=str.charAt(i);
    }
    System.out.println(chArr);// javatpoint


    String str1 = "javatpoint";
    char[] vw = str1.toCharArray();//javatpoint
    System.out.println(Arrays.toString(vw));//[j,a,v,a,t,p,o,i,n,t]

  //CharExample che = new CharExample();
  System.out.println(CharExample.display());


  }

  
}