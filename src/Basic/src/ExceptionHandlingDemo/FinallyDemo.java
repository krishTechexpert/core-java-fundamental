package ExceptionHandlingDemo;

public class FinallyDemo {
// interview question with return statement

    public static int sum(){
        return 2+2;
    }

    public static void main(String[] args) {
        try{
            System.out.println("try");
            int a = sum();
            for(int i=0;i<3;i++){
                if(i==1){
                    System.out.println(i);
                    return; //always finally exceute
                }
            }

        }catch(Exception e){
            System.out.println(e);
        }finally{
            //always exceute
            System.out.println("finally runs");
        }
    }

}
