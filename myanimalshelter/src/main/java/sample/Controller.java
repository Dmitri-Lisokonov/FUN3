package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import sample.interfaces.Observer;
import sample.models.*;
import sample.util.Serialisation;
import sample.util.Shelter;
import sample.util.Shop;

import java.util.ResourceBundle;
import java.net.URL;

import static java.lang.Double.parseDouble;

public class Controller implements Observer, Initializable {
    @FXML
    public ChoiceBox cbSpecies;
    @FXML
    public RadioButton rbMale;
    @FXML
    public RadioButton rbFemale;
    @FXML
    public TextField tbBadHabits;
    @FXML
    public TextField tbName;
    @FXML
    public ListView lbAnimals;
    @FXML
    public TextField tbNameReserve;
    @FXML
    public ListView lbProducts;
    @FXML
    public TextField tbProductName;
    @FXML
    public TextField tbProductPrice;


    Shelter shelter;
    Serialisation serialisation;
    Shop shop;

    public Controller() {
        serialisation = new Serialisation("C:/Users/root/Documents/Git/FHICT/fun3/myanimalshelter/src/main/java/sample/");
        shelter = Shelter.getInstance();
        shop = Shop.getInstance();
        shelter.attach( this);
        shop.attach(this);
    }

    @Override
    public void initialize(URL url, ResourceBundle resources) {
        cbSpecies.getItems().addAll("Cat", "Dog");
        for (Animal animal : serialisation.deSerialiseAnimals()) {
            lbAnimals.getItems().add(animal);
        }
        for (Product product : serialisation.deSerialiseProducts()) {
            lbProducts.getItems().add(product);
        }
        shelter.animals = serialisation.deSerialiseAnimals();
        shop.products = serialisation.deSerialiseProducts();

    }

    public void btnReserve(ActionEvent actionEvent) {
       Animal animal = (Animal) lbAnimals.getSelectionModel().getSelectedItem();
       animal.setReservedBy(tbNameReserve.getText());
       update();
    }

    public void btnAddProduct(ActionEvent actionEvent) {
        System.out.println(parseDouble(tbProductPrice.getText()));
        Product product = new Product(tbProductName.getText(), parseDouble(tbProductPrice.getText()));
        shop.addProduct(product);
    }

    public void btnBuyProduct(ActionEvent actionEvent) {
    }

    public void btnAddAnimal(ActionEvent actionEvent) {
        String species = cbSpecies.getValue().toString();
        String name = tbName.getText();
        String badHabits = tbBadHabits.getText();
        Calculator calculator = new Calculator();
        Dog dog;
        Cat cat;

        if (species == "Dog") {
            if (rbFemale.isSelected()) {
                dog = new Dog(name, Gender.Female);
            } else {
               dog = new Dog(name, Gender.Male);
            }
            calculator.calculateAnimalPricing(dog, shelter);
            shelter.addAnimal(dog);
        }
        else {
            if (rbFemale.isSelected()) {
                cat = new Cat(name, Gender.Female, badHabits);
            } else {
                cat = new Cat(name, Gender.Male, badHabits);
            }
            calculator.calculateAnimalPricing(cat, shelter);
            shelter.addAnimal(cat);
        }
    }

    @FXML
    public void setFemale() {
        rbMale.setSelected(false);
        rbFemale.setSelected(true);
    }

    @FXML
    public void setMale() {
        rbMale.setSelected(true);
        rbFemale.setSelected(false);
    }



    public void ClearForm() {
        tbName.setText("");
        rbMale.setSelected(false);
        rbFemale.setSelected(false);
        tbBadHabits.setText("");
        tbNameReserve.setText("");
        cbSpecies.getSelectionModel().selectFirst();
        lbAnimals.getItems().clear();
        lbProducts.getItems().clear();
    }

    @Override
    public void update() {
        serialisation.serialiseAnimals(shelter.animals);
        serialisation.serialiseProducts(shop.products);
        ClearForm();
        for (Animal animal : shelter.animals) {
            lbAnimals.getItems().add(animal);
        }
        for(Product product : shop.products){
            lbProducts.getItems().add(product);
        }
    }
}
