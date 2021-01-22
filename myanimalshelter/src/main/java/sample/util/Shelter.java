package sample.util;

import sample.models.Animal;
import sample.interfaces.Observer;
import sample.interfaces.Subject;

import java.util.ArrayList;
import java.util.List;

public class Shelter implements Subject {

    private static Shelter shelter = new Shelter();

    private Shelter(){

    }
    public static Shelter getInstance(){
        return shelter;
    }

    //factory pattern

    public List<Observer> observers = new ArrayList<>();
    public List<Animal> animals = new ArrayList<>();

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


    public void addAnimal(Animal a) {
        animals.add(a);
        System.out.println(a.toString());
        allNotify();
    }
}
