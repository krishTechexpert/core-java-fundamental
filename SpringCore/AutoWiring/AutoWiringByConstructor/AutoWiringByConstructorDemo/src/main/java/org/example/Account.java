package org.example;

//📌 Step 2: Create Account Class (Prototype)

public class Account {
    private Bank bank; // association relationship,without bank account can not open so bank and account depends to each other.
    private String  accountHolder;

    // Constructor Injection
    public Account(Bank bank,String accountHolder){
        System.out.println("Account constructor...");
        this.accountHolder= accountHolder;
        this.bank=bank;
    }

    public void showAccountDetails() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Bank Name: " + bank.getBankName());
    }
}
//🔹 Each Account belongs to a single Bank instance.
//🔹 Each Account has a different account holder name.