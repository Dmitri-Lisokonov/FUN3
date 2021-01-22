package sample.models;

import sample.interfaces.ISellable;

import java.io.Serializable;

public class Product implements ISellable, Serializable {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    public String toString() {

        return this.name + " " + this.price ;
    }










}
