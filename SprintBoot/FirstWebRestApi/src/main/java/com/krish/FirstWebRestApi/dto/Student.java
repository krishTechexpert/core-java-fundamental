package com.krish.FirstWebRestApi.dto;

// suppose this class interact with database and perform some db opeartion which retrun data from DB

public class Student {
    private int id;
    private String name;
    private String address;
    private String course;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", course='" + course + '\'' +
                '}';
    }

    public Student(int id, String name, String address, String course) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.course = course;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getCourse() {
        return course;
    }

}
