package ru.geekbrains.lesson7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        performTask7();
    }
    
    static void performTask7(){
        final int MAXFOOD = 1200;
        System.out.println("Initial block");
        Cat[] cats = initCatArray();
        Plate plate = new Plate((new Random().nextInt(MAXFOOD)));
        plate.getInfo();
        System.out.println();
        System.out.println("Feeding block");
        feedCats(cats, plate);
        System.out.println();
        System.out.println("Plate total after cats:");
        plate.getInfo();
        System.out.println();
        System.out.println("Let's checking every cat fill.");
        System.out.println();
        checkCatsFill(cats);
    }

    static void checkCatsFill(Cat[] cats){
        for (int i = 0; i < cats.length; i++) {
            System.out.println(cats[i].toStringExtend());
        }
    }
    
    static void feedCats(Cat[] cats, Plate plate){
        for (int i = 0; i < cats.length; i++) {
            cats[i].getInfo();
            cats[i].eat(plate);
            plate.getInfo();
        }
    }
    
    static Cat[] initCatArray(){
        final int MAXAPPETITE = 495;
        Random random = new Random();
        Cat[] cats = new Cat[(random.nextInt(10) + 5)];
        int randomIndex;
        List nameList = new ArrayList<>(Arrays.asList("Crookshanks",
                "Mrs. Norris", "Galadriel", "Frodo", "Darth Vader", "Skywalker",
                "Fluffy", "Weasley", "Marvolo", "Riddle", "Filch", "Gandalf",
                "Gimli", "Aragorn", "Elendil", "Hedwig", "Salazar", "Godric",
                "Dracula", "Graf", "Woof"));
        for (int i = 0; i < cats.length; i++) {
            randomIndex = random.nextInt(nameList.size());
            cats[i] = new Cat((String) nameList.get(randomIndex),
                                 random.nextInt(MAXAPPETITE));
            nameList.remove(randomIndex); //Чтобы клички не повторялись
        }
        return cats;
    }
}
