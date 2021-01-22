package sample.util;

import sample.interfaces.Observer;
import sample.models.Product;
import sample.interfaces.Subject;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Subject {
    private static Shop shop = new Shop();
    public List<Product> products = new ArrayList<>();
    public List<Observer> observers = new ArrayList<>();

    private Shop(){

    }
    public static Shop getInstance(){
        return shop;
    }


    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product p) {
        products.add(p);
        allNotify();
    }

    public void attach(Observer o){
        observers.add(o);
    }

    public void detach(Observer o){
        observers.remove(o);
    }
    public void allNotify(){
        for (Observer o: observers){
            o.update();
        }
    }


}
