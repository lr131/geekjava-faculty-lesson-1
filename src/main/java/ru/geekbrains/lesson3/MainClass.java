package ru.geekbrains.lesson3;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        playDigit(); //task 1
        playWord(); //task 2
    }

    public static void playDigit() {
        Random random = new Random();
        int targetNumber = random.nextInt(10);
        String resultMessage = "Falied.";
        int userValue;
        System.out.println("Enter integer from 0 to 9");
        for (int attempt = 0; attempt < 3; attempt++) {
            userValue = getUserIntValue();
            if (userValue == targetNumber) {
                resultMessage = "You are winner!";
                break;
            }
            if (userValue > targetNumber) {
                System.out.println("Your number is greater than the target. Let's try again:\n");
            } else {
                System.out.println("Your number is less than the target. Let's try again:\n");
            }
        }
        System.out.printf("%s Target number: %d. Play again? 1 - Yes, 0 - No\n", resultMessage, targetNumber);

        int userDecision = getUserDecision();
        if (userDecision == 1) {
            System.out.println("Well done! Let's go!");
            playDigit(); //используем рекурсию
        } else {
            System.out.println("Game over. Good luck to your offline and come back! :)");
        }
    }

    private static int getUserDecision(){
        int userDecision;
        do {
            userDecision = getUserIntValue();
            if (userDecision != 0 && userDecision != 1 ){
                System.out.println("Unknown answer. Please, enter one of two digits: 1 - Yes, 0 - No\n");
            } else {
                return userDecision;
            }
        } while (true);
    }

    private static int getUserIntValue(){
        int userValue;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                userValue = sc.nextInt();
                return userValue;
            } catch (InputMismatchException e) {
                System.out.println("It's not an whole number! Please, try again:\n");
            }
        } while (true);
    }

    public static void playWord(){
        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
                "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin",
                "potato"};

    }
}
