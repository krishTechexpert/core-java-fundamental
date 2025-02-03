package Abstraction;

//Explanation: If a subclass does not implement all abstract methods of an abstract class,
// it must be declared abstract itself, otherwise, a compile-time error occurs.


public abstract class Bank {
   abstract int getInterestRates();

}

class SBI extends Bank{
    int getInterestRates(){
        return 3;
    }
}

class PNB extends Bank{
    int getInterestRates(){
        return 4;
    }
}

class TestBank{
    public static void main(String[] args) {
        Bank b;
         b = new SBI();
        System.out.println(b.getInterestRates());
        b = new PNB();
        System.out.println(b.getInterestRates());
    }
}