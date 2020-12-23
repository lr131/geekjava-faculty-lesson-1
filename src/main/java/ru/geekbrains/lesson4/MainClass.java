package ru.geekbrains.lesson4;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MainClass {
    public static final char DOT_X = 'X';
    public static final char DOT_O = '0';

    public static void main(String[] args) {
        start();

    }

    static void start(){
//        Scanner scanner = new Scanner(System.in);
//        scanner.nextInt();
        char[][] field = init(3); //default value
        printArray(field);
        int needLineLenght = field.length;
        int freeCells = field.length * field.length;
        for (int i = 0; i < freeCells; i++) {
            if (i % 2 == 0) {
                field = moveUserByX(field);
                printArray(field);
            } else {
                field = moveComputerBy0(field);
                printArray(field);
            }
            if (isWin(field, i)){
                break;
            }
        }

    }

    static boolean isWin(char[][] field, int i){
        //TODO основные проверки по строкам, столбцам и диагоналям
        if (i%2 == 0) {
            System.out.println("You are winner!");
        } else {
            System.out.println("Failed. Game over!");
        }
        return false;
    }

    static char[][] moveUserByX(char[][] field){
        int userX;
        int userY;
        do{
            int lenField = field.length;
            System.out.printf("Your Move! \n" +
                            "Please, Enter number of line between %d and %d inclusive:\n",
                    1, lenField);
            userX = getUserCoordinateValue(1, lenField) - 1;
            System.out.printf("Your Move! \n" +
                            "Please, Enter number of line between %d and %d inclusive:\n",
                    1, lenField);
            userY = getUserCoordinateValue(1, lenField) - 1;
        } while (field[userX][userY] != '-');
        return refreshField(field,userX,userY,DOT_X);
    }

    static char[][] moveComputerBy0(char[][] field){
        int computerX;
        int computerY;
        do {
            Random random = new Random();
            computerX = random.nextInt(field.length);
            computerY = random.nextInt(field.length);
            //проверка на занятость ячейки
        } while (field[computerX][computerY] != '-');
        return refreshField(field,computerX,computerY,DOT_O);
    }

    static char[][] init(int n){
        char[][] field = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                field[i][j] = '-';
            }
        }
        return field;
    }

    static char[][] refreshField(char[][] field, int x, int y, char userChar){
        field[x][y] = userChar;
        return field;
    }

    static void printArray(char[][] field){
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Возвращает число, которое ввел пользователь с проверкой на тип введенного
     * значения.
     *
     * @return число, введенное пользователем.
     */
    private static int getUserValue(){
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
     * заданный диапазон включительно.
     *
     * @return число, введенное пользователем.
     */
    private static int getUserCoordinateValue(int from, int to){
        int userValue;
        do {
            userValue = getUserValue();
            if (userValue < from || userValue > to) {
                System.out.printf("Not accepted. Please, enter an integer " +
                        "between %d and %d inclusive:", from, to);
            }
        } while(userValue < from || userValue > to);
        return  userValue;
    }
}
