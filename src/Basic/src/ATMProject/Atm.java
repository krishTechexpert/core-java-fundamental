package ATMProject;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Arrays;
public class Atm {
    private double balance;
    private int pin;
    String[] recentTransaction = new String[3]; // 3 transaction will show
     int count=0;

    public void checkPinNumber(int code){
        pin = 1234;
        if(pin == code) {
            System.out.println("Congratulation, now you can access atm machine");
            menuScreen();
        }
        else {
            System.out.println("Invalid pin number");
        }
    }

    public void checkBalance(){
        System.out.print("Your account Balance is ");
        System.out.println(getBalance());
        menuScreen();
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double amt){
        this.balance += amt;
    }

    public void depositMoney(){
        System.out.println("How much amount you want to deposit");
        Scanner sc = new Scanner(System.in);
        double amt = sc.nextInt();
        if(amt > 0) {
            setBalance(amt);
            checkLast_3_transaction("+"+amt);
        } else {
            System.out.println("Invalid amount, should be > 0");
        }
        menuScreen();
    }

    public void withdrawalMoney(){
        System.out.println("How much amount you want to withdraw");
        Scanner sc = new Scanner(System.in);
        double amt = sc.nextInt();
        if(amt < 0) {
            System.out.println("Invalid amount, should be > 0");
        }
        if(amt <=balance ){
            balance -=amt;
            checkLast_3_transaction("-"+amt);

        }else {
            System.out.println("InSufficient account balance");
        }
        menuScreen();
    }

    public  void checkLast_3_transaction(String transaction) {
        for (int i = 0; i < recentTransaction.length; i++) {
           if( recentTransaction[i] == null){
               recentTransaction[i] = transaction;
               System.out.println(recentTransaction[i]);
               break;
           }
        }
   }

   public  void showMyRecentStatement() {
      ++count;
       if (count <= 3) {
           System.out.println("my recent transaction are " + Arrays.toString(recentTransaction));
           menuScreen();
       } else {
           System.out.println("one user can show transaction upto 3 times only");
       }
   }
    public void menuScreen(){
        System.out.println("Select your option");
        System.out.println("Enter 1 for check balance ");
        System.out.println("Enter 2 for deposit money");
        System.out.println("Enter 3 for withdrawal Money");
        System.out.println("Enter 4 for check last 3 transaction");
        System.out.println("For exist, enter 0");
        Scanner sc = new Scanner(System.in);
        int code = sc.nextInt();
        switch (code){
            case 1:
                checkBalance();
                break;
            case 2:
                depositMoney();
                break;
            case 3:
                withdrawalMoney();
                break;
            case 4:
                showMyRecentStatement();
                break;
            default:
                System.out.println("exit from Atm machine");
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to HDFC ATM Machine");
        System.out.println("Enter your Atm Pin number");
        Scanner sc = new Scanner(System.in);
        int code = sc.nextInt();
        Atm a1 = new Atm();
        a1.checkPinNumber(code);
    }

}
