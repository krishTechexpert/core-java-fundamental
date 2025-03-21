package com.StudentAppdemo.studentApp.model;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(generator="address_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name="address_gen",sequenceName = "address_seq",initialValue = 10, allocationSize = 1)
    // address_id=10, city=bangalore,state=karnatka, id 10 sy start hogi and increment by one as allocationSize=1
    private Integer addressId;
    private String city;
    private String state;

    public Address(){
        super();
        System.out.println("Address default constructor");
    }

    public Address(String city, String state) {
        this.city = city;
        this.state = state;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
