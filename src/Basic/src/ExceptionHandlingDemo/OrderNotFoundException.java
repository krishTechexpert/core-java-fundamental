package Basic.src.ExceptionHandlingDemo;
//public class OrderNotFoundException extends RuntimeException it consider runtime exception or unchecked exception
//public class OrderNotFoundException extends Exception it consider Checked Exception

//custom exception demo
public class OrderNotFoundException extends Exception{
    public OrderNotFoundException(String msg){
        super(msg);
    }
}

class Test {
    public void getOrder(int orderId) throws OrderNotFoundException{
        if(orderId == 101){
            try{
                throw new OrderNotFoundException("order id not found " +orderId);
            }catch(OrderNotFoundException e){
                System.out.println(e.getMessage());
            }
        }else {
            System.out.println("order done");
        }
    }

    public static void main(String[] args) throws OrderNotFoundException {
        Test t=new Test();
        t.getOrder(101);
    }
}
