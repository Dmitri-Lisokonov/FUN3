package sample.models;

public class Cat extends Animal {


    private String badHabits;

    public Cat(String name, Gender gender, String badHabits) {
        super(name, gender);
        this.badHabits = badHabits;
    }

    @Override
    public String toString(){
        return super.toString() + " bad habits: " + this.badHabits.toString();
    }

    @Override
    public String getName() {
        return null;
    }

    public String getBadHabits() {
        return badHabits;
    }

    public void setBadHabits(String badHabits) {
        this.badHabits = badHabits;
    }

}
