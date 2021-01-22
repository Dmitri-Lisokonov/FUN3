package sample.models;
import java.time.LocalDate;

public class Dog extends Animal {

    private LocalDate lastWalk;

    public Boolean needsWalk() {
        return (LocalDate.now().isAfter(lastWalk));
    }


    public Dog(String name, Gender gender) {
        super(name, gender);
        this.lastWalk = LocalDate.now();
    }

    public String toString() {
        return super.toString() + " last walk: " + this.lastWalk.toString();
    }
    @Override
    public String getName() {
        return null;
    }

    public LocalDate getLastWalk() {
        return lastWalk;
    }

    public void setLastWalk(LocalDate lastWalk) {
        this.lastWalk = lastWalk;
    }
}
