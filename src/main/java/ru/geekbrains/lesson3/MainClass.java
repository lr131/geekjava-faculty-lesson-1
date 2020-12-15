package ru.geekbrains.lesson3;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        System.out.println("Please, choose a game: \n 1 - Guess the number\n" +
                " 2 - Guess the word\n other digits - exit");
        int userValue = getUserIntValue();
        switch (userValue){
            case 1:
                playDigit(); //task 1
                break;
            case 2:
                playWord(); //task 2
                break;
            default:
                System.out.println("Good bye!");

        }
    }

    /**
     * 1. Написать программу, которая загадывает случайное число от 0 до 9
     * и пользователю дается 3 попытки угадать это число. При каждой попытке
     * компьютер должен сообщить, больше ли указанное пользователем число,
     * чем загаданное, или меньше. После победы или проигрыша выводится запрос
     * – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
     */
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

    /**
     * * Создать массив из слов
     *
     * String[] words = {"apple", "orange", "lemon", "banana", "apricot",
     * "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon",
     * "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
     * "pear", "pepper", "pineapple", "pumpkin", "potato"}.
     * При запуске программы компьютер загадывает слово, запрашивает ответ у
     * пользователя, сравнивает его с загаданным словом и сообщает,
     * правильно ли ответил пользователь. Если слово не угадано, компьютер
     * показывает буквы, которые стоят на своих местах.
     * apple – загаданное
     * apricot - ответ игрока
     * ap############# (15 символов, чтобы пользователь не мог узнать длину
     * слова)
     * Для сравнения двух слов посимвольно можно пользоваться:
     * String str = "apple";
     * char a = str.charAt(0); - метод вернет char, который стоит в слове
     * str на первой позиции
     * Играем до тех пор, пока игрок не отгадает слово.
     * Используем только маленькие буквы.
     */
    public static void playWord(){
        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
                "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin",
                "potato"};
        Random random = new Random();
        int targetIndex = random.nextInt(words.length);
        boolean isWordCorrect;
        String targetWord = words[targetIndex];
        String userWord;
        System.out.println("Please, select and enter the word from current " +
                "array:\n");
        printArray(words);
        userWord = getUserWordWithCheck(words);
        checkUserWord(words, userWord, targetWord);
    }

    private static void printArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }

    private static String getUserValue(){
        String userValue;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                userValue = sc.next();
                return userValue;
            } catch (InputMismatchException e) {
                System.out.println("It's not an string! Please, try again:\n");
            }
        } while (true);
    }

    private static String getUserWordWithCheck(String[] words){
        //проверка на наличие в массиве этого слова в принципе
        String userWord;
        boolean isWordCorrect;
        do {
            userWord = getUserValue();
            isWordCorrect = isContinueWords(words, userWord);
            if (!isWordCorrect) {
                System.out.println("Unknown word. \nPlease, select and enter the word from current array:");
                printArray(words);
            }
        } while (!isWordCorrect);
        return userWord;
    }

    private static boolean isContinueWords (String[] words, String word) {
        return Arrays.asList(words).contains(word);
    }

    private static void checkUserWord(String[] words, String userWord,
                                      String targetWord) {
        char userTargetChar;
        char userWordChar;
        if (targetWord.equals(userWord)) {
            System.out.println("You are win! Congratulations!");
        } else {
            StringBuilder mockWord = new StringBuilder("###############");
            int len = Math.min(targetWord.length(), userWord.length());
            for (int i = 0; i < len; i++) {
                userTargetChar = targetWord.charAt(i);
                userWordChar = userWord.charAt(i);
                if (userTargetChar == userWordChar) {
                    mockWord.setCharAt(i, userWordChar);
                }
            }
            System.out.println("You guessed some letters:");
            System.out.println(mockWord);
            System.out.println("Please, try again:");
            userWord = getUserWordWithCheck(words);
            checkUserWord(words, userWord, targetWord);
        }
    }
}
