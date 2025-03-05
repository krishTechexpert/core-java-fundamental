package org.example;

//KSeries engine , Maruti ka hai

public class KSeries implements Engine{
    public KSeries(){
        System.out.println("KSeries default constructor");
    }
    @Override
    public int start() {
        System.out.println("Start KSeries Engine");
        return 1;
    }
}
