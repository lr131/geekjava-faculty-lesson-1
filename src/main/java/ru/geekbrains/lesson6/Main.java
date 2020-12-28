package ru.geekbrains.lesson6;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        performTask();
        
    }
    
    static void performTask(){
        Animal[] animals = initAnimalArray();
        Random random = new Random();
        float runDistance;
        float swimDistance;

        for (int i = 0; i < animals.length; i++) {
            animals[i].getInfo();
            runDistance = random.nextFloat() * 100 + 120;
            System.out.printf("Please, run %.2f m", runDistance);
            System.out.println();
            animals[i].run(runDistance);
            swimDistance = random.nextFloat() * 20;
            System.out.printf("Please, swim %.1f m", swimDistance);
            System.out.println();
            animals[i].swim(swimDistance);
            System.out.println();
        }
        printCounts();
    }
    
    static void printCounts(){
        System.out.printf("Animals: %d copy\n", Animal.getAnimalsCount());
        System.out.printf("Cats: %d copy\n", Cat.getCount());
        System.out.printf("Dogs: %d copy\n", Dog.getCount());
    }
    static Animal[] initAnimalArray(){
        Animal[] animals = new Animal[5];
        String[] names = {"Crookshanks", "Mrs. Norris", "Galadriel", "Frodo",
                "Darth Vader"};
        Random random = new Random();
        for (int i = 0; i < animals.length; i++) {
            if (i % 2 == 0){
                animals[i] = new Cat(names[random.nextInt(names.length)]);
            } else{
                animals[i] = new Dog(names[random.nextInt(names.length)]);
            }
        }
        return animals;
    }
}
