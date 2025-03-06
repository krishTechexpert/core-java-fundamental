package org.example;

public class MHawk implements Engine{
    public MHawk(){
        System.out.println("MHawk default constructor");
    }
    @Override
    public int start() {
        System.out.println("Start MHawk Engine");
        return 1;
    }
}
