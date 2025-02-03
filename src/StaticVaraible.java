class StaticVaraible{
  static int x=10;
  public static void main(String[] args){
    System.out.println(x); // 10
    StaticVaraible st=new StaticVaraible();
    System.out.println(st.x); //10 yes it will worked but if you are using static then try to call with className which is good appraoch
    System.out.println(StaticVaraible.x); //10

    st.x=1000;// memory get once at class loading..so it will replace value from 10 to 1000
    System.out.println(StaticVaraible.x); // 1000

  }
}