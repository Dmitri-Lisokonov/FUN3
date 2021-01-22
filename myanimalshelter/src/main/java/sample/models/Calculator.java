package sample.models;

import sample.util.Shelter;

public class Calculator {
    public void calculateAnimalPricing(Animal animal, Shelter shelter){
            double price = 0;
            int dogCount = 0;
            if (animal instanceof Cat) {
                price = 350 - (((Cat) animal).getBadHabits().length() * 20);
                if (price < 35) {
                    price = 35;

                }
            } else {
                for (Animal a : shelter.animals) {
                    if (a instanceof Dog) {
                        dogCount++;
                    }
                }
                price = 500 - (dogCount * 50);
                if (price < 50) {
                    price = 50;
                }
            }
            animal.setPrice(price);
    }
}
