package sample.models;

import sample.interfaces.ISellable;

import java.io.Serializable;

public abstract class Animal implements ISellable, Serializable {


    private String name;
    private Gender gender;
    private String reservedBy;



    private double price;

    public Animal(String name, Gender gender){
        this.name = name;
        this.gender = gender;
    }

    public void setReservedBy(String name){
     this.reservedBy = name;
    }

    public String toString()
    {
        String reserved = "not reserved";
        if (this.reservedBy != null)
        {
            reserved = "reserved by: " + reservedBy;
        }
        return this.name + " " + this.gender + " " + this.getPrice() + " " + reserved;
    }


    public String getName() {
        System.out.println(name);
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getReservedBy() {
        return reservedBy;
    }

}