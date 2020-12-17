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
     * Игра "Угадай число". Программа загадывает случайное число от 0 до 9
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
        System.out.println("Enter an integer between 0 and 9 inclusive:");
        for (int attempt = 0; attempt < 3; attempt++) {
            userValue = getUserValue();
            if (userValue == targetNumber) {
                resultMessage = "You are winner!";
                break;
            }
            if (userValue > targetNumber) {
                System.out.println("Your number is greater than the target. " +
                        "Let's try again:\n");
            } else {
                System.out.println("Your number is less than the target. " +
                        "Let's try again:\n");
            }
        }
        getResultPlayDigit(resultMessage, targetNumber);
    }

    /**
     * Выводит в консоль результат игры в "Угадай число". Предлагает сыграть
     * снова. Если пользователь выбирает играть, то вызывает метод playDigit().
     *
     * @param resultMessage
     *        сообщение с итогами игры.
     * @param targetNumber
     *        загаданное программой число
     */
    private static void getResultPlayDigit(String resultMessage, int targetNumber) {
        System.out.printf("%s Target number: %d. Play again? 1 - Yes, 0 - No\n",
                resultMessage, targetNumber);

        int userDecision = getUserDecision();
        if (userDecision == 1) {
            System.out.println("Well done! Let's go!");
            playDigit(); //используем рекурсию
        } else {
            System.out.println("Game over. Good luck to your offline and " +
                    "come back! :)");
        }
    }

    /**
     * Возвращает ответ пользователя и производит проверку на соответствие
     * заданному алфавиту (0 или 1).
     *
     * @return ответ пользователя.
     */
    private static int getUserDecision(){
        int userDecision;
        do {
            userDecision = getUserIntValue();
            if (userDecision != 0 && userDecision != 1 ){
                System.out.println("Unknown answer. Please, enter one of two " +
                        "digits: 1 - Yes, 0 - No\n");
            } else {
                return userDecision;
            }
        } while (true);
    }

    /**
     * Возвращает число, которое ввел пользователь с проверкой на тип введенного
     * значения.
     *
     * @return число, введенное пользователем.
     */
    private static int getUserIntValue(){
        int userValue;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                userValue = sc.nextInt();
                return userValue;
            } catch (InputMismatchException e) {
                System.out.println("It's not an whole number! " +
                        "Please, try again:\n");
            }
        } while (true);
    }

    /**
     * Возвращает число, которое ввел пользователь с проверкой на вхождение в
     * диапазон [0, 10).
     *
     * @return число, введенное пользователем.
     */
    private static int getUserValue(){
        int userValue;
        do {
            userValue = getUserIntValue();
            if (userValue < 0 || userValue > 9) {
                System.out.println("Not accepted. Please, enter an integer " +
                        "between 0 and 9 inclusive:");
            }
        } while(userValue < 0 || userValue > 9);
        return  userValue;
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
        String targetWord = words[targetIndex];
        String userWord;
        System.out.println("Please, select and enter the word from current " +
                "array:\n");
        printArray(words);
        userWord = getUserWordWithCheck(words);
        checkUserWord(words, userWord, targetWord);
    }

    /**
     * Выводит в консоль строковый массив.
     *
     * @param array
     *        строковый массив.
     */
    private static void printArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }

    /**
     * Возвращает строку, которую ввел пользователь.
     *
     * @return строку, введенную пользователем.
     */
    private static String getUserStringValue(){
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

    /**
     * Возвращает слово, которое ввел пользователь с проверкой на наличие
     * в массиве этого слова в принципе.
     *
     * @param words
     *        массив слов.
     * @return слово, введенное пользователем.
     */
    private static String getUserWordWithCheck(String[] words){
        String userWord;
        boolean isWordCorrect;
        do {
            userWord = getUserStringValue();
            isWordCorrect = isContinueWords(words, userWord);
            if (!isWordCorrect) {
                System.out.println("Unknown word. \nPlease, select and enter " +
                        "the word from current array:");
                printArray(words);
            }
        } while (!isWordCorrect);
        return userWord;
    }

    /**
     * Проверяет, входит ли слово в массив слов.
     *
     * @param words
     *        массив слов.
     * @param word
     *        слово, которое нужно проверить.
     * @return {@code true} слово есть в массиве.
     *         {@code false} слова в массиве нет.
     */
    private static boolean isContinueWords (String[] words, String word) {
        return Arrays.asList(words).contains(word);
    }

    /**
     * Проверяет, угадал ли пользователь слово, и если не угадал, печатает
     * угаданные буквы и рекурсивно вызывает метод - до тех пор, пока
     * пользователь не угадает.
     *
     * @param words
     *        строковый массив.
     * @param userWord
     *        слово, введенное пользователем.
     * @param targetWord
     *        слово, загаданное программой.
     */
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
