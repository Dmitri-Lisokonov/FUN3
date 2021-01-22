package sample.util;

import sample.models.Animal;
import sample.models.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serialisation {

    private String path;

    public Serialisation(String path){
        this.path = path;
    }

    public void serialiseAnimals(List<Animal> animalList){
        try(FileOutputStream fileOut = new FileOutputStream(path + "animal.ser")){
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(animalList);
            out.close();
        } catch (Exception i){
            System.out.println(i);
        }
    }
    public ArrayList<Animal> deSerialiseAnimals(){
        ArrayList<Animal> animals = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();

        try(FileInputStream fileIn = new FileInputStream(path + "animal.ser")) {
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList<Animal> animalList = (ArrayList<Animal>) in.readObject();
            for (Animal animal : animalList){
                animals.add(animal);
            }
            in.close();
        }
        catch (Exception e) {
            System.out.println("deserialise");
        }
        return animals;
    }

    public void serialiseProducts(List<Product> productList){
        try(FileOutputStream fileOut = new FileOutputStream(path + "product.ser")){
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(productList);
            out.close();
        } catch (Exception i){
            System.out.println(i);
        }
    }
    public ArrayList<Product> deSerialiseProducts(){
        ArrayList<Product> products = new ArrayList<>();

        try(FileInputStream fileIn = new FileInputStream(path + "product.ser")) {
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList<Product> productList = (ArrayList<Product>) in.readObject();
            for (Product product : productList){
                products.add(product);
            }
            in.close();
        }
        catch (Exception e) {
            System.out.println("deserialise");
        }
        return products;
    }
}
