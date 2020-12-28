package ru.geekbrains.lesson5;

import javax.sound.midi.Soundbank;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        execute();
    }

    static void execute(){
        Employee[] employes = initEmployeeArray(5);
        System.out.println("These're full data:");
        printArray(employes);
        System.out.println("\n=================================\n");
        System.out.printf("These are employees over %d:\n", 40);
        selectGreaterAge(40,employes);
    }


    static void selectGreaterAge(int greaterAge, Employee[] employes){
        for (int i = 0; i < employes.length; i++) {
            if (employes[i].getAge() > greaterAge) {
                employes[i].getInfo();
            }
        }
    }

    static void printArray(Employee[] employes){
        for (int i = 0; i < employes.length; i++) {
            employes[i].getInfo();
        }
    }

    static Employee[] initEmployeeArray(int count){
        Employee[] employes = new Employee[count];
        for (int i = 0; i < count; i++) {
            employes[i] = initEmployee();
        }
        return employes;
    }

    static Employee initEmployee(){
        Random random = new Random();
        int targetNumber = random.nextInt(10);
        String[] names = new String[]{"Albus", "Harry", "Sirius", "Ronald",
                "Draco"};
        String[] families = new String[]{"Dumbledore", "Black", "Potter",
                "Malfoy", "Weasley"};
        String[] positions = new String[]{"Ministry", "Auror", "Head teacher",
                "Artifactor", "Analyst"};
        String hostMail = "@wizard.hog";
        String[] loginMails = new String[]{"blood", "fire", "water", "rock",
                "power"};
        String[] phones = new String[]{"90122456789", "90211987654",
                "90133123456", "90177321654", "90533789456"};
        return new Employee(families[random.nextInt(5)],
                names[random.nextInt(5)],
                positions[random.nextInt(5)],
                loginMails[random.nextInt(5)] + hostMail,
                phones[random.nextInt(5)],
                random.nextInt(100) + 1,
                random.nextInt(200000)
        );
    }

}


