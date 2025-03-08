package org.example;

//------------ AutoWiring by Constructor ----------------

/*
* Sure! Let’s take a Bank and Account example, where:
    Bank is a singleton (since a bank is a single entity).
    Account is a prototype (since each customer has a different account).
    We will use constructor-based autowiring with XML.
*
* */

//1️⃣ Example: Bank (Singleton) and Account (Prototype)
//Every time we request an Account, a new instance is created.
//All Account instances share the same Bank instance.

//📌 Step 1: Create Bank Class (Singleton Dependency)

public class Bank {
    private String bankName;

    public Bank(String name){
        System.out.println(name+ " constructor calling...");
        this.bankName=name;
    }

    public String getBankName(){
        return bankName;
    }
}
//🔹 The Bank class has a constructor that accepts a bank name.