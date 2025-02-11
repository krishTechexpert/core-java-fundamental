package Basic.src.ExceptionHandlingDemo;

public class FinallyInterviewQues {

    public static int divide(int a,int b){
        try{
            return a/b;
        }catch(ArithmeticException e){
            return 2;
        }
        finally{
            return 3;
        }

    }

    public static void main(String[] args) {
        //inside try  return 1 then finally run then return 3 and function can retrun only one value at time

        System.out.println(FinallyInterviewQues.divide(10,10));//3
        //when exception raise then go to catch return 2 then finally run then return 3 and function can retrun only one value at time
        System.out.println(FinallyInterviewQues.divide(10,0));//3

    }
}
