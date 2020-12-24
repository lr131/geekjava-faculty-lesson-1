package ru.geekbrains.lesson4;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MainClass {
    public static final char DOT_X = 'X'; //User
    public static final char DOT_O = '0'; //Computer
    public static final char DOT_EMPTY = '-';

    public static void main(String[] args) {
        start();
    }

    static void start(){
        System.out.println("Hi! You've just started the game Tic Tac Toe." +
                "There're some rules:\n" +
                "We always play on a square field, and the required sequence " +
                "is always equal to the dimension of the field. \n" +
                "The dimension is always integer and  greater than zero.\n\n" +
                "\nPlease, enter field dimension:\n");

        int dimension = getUserValue();
        char[][] field = init(dimension);
        printArray(field);
        boolean draw = true;
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
                draw = false;
                break;
            }
        }
        if (draw) {
            System.out.println("It's standoff! Nothings and nobody win. " +
                    "Nothings and nobody failed.");
        }

    }

    /**
     * Метод проверяет, выиграл ли пользователь или компьютер после очередного хода.
     * @param field
     *        заполненное к текущему ходу игровое поле
     * @param n
     *        номер текущего хода
     * @return {@code true} если ходок выиграл.
     *         {@code false} если победы не обнаружено.
     */
    static boolean isWin(char[][] field, int n){
        if (isWinLine(field) || isWinColumn(field) ||
                isWinMainDiagonal(field) ||
                isWinReverseDiagonal(field) ) {
            if (n%2 == 0) {
                System.out.println("You are winner!");
            } else {
                System.out.println("Failed. Game over!");
            }
            return true;
        }
        return false;
    }

    /**
     * Метод проверяет, есть ли победа по строкам
     * @param field
     *        заполненное к текущему ходу игровое поле
     * @return {@code true} если ходок выиграл.
     *         {@code false} если победы не обнаружено.
     */
    static boolean isWinLine(char[][] field){
        boolean isWinFlag = false;
            for (int i = 0; i < field.length; i++) {
                if (isWinFlag) {
                    return true;
                }
                for (int j = 0; j < field.length-1; j++) {
                    if (field[i][j] != field[i][j+1]) {
                        isWinFlag = false;
                        break;
                    }
                    if (field[i][j] != DOT_EMPTY) {
                        isWinFlag = true;
                    }
                }
            }
        return false;
    }

    /**
     * Метод проверяет, есть ли победа по столбцам
     * @param field
     *        заполненное к текущему ходу игровое поле
     * @return {@code true} если ходок выиграл.
     *         {@code false} если победы не обнаружено.
     */
    static boolean isWinColumn(char[][] field){
        return isWinLine(transpose(field));
    }

    /**
     * Метод транспонирует поле
     * @param field
     *        заполненное к текущему ходу игровое поле
     * @return транспонированное игровое поле
     */
    private static char[][] transpose(char[][] field){
        char[][] transportField = new char[field.length][field[0].length];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                transportField[i][j] = field[j][i];
            }
        }
        return transportField;
    }

    /**
     * Метод проверяет, есть ли победа по главной диагонали
     * @param field
     *        заполненное к текущему ходу игровое поле
     * @return {@code true} если ходок выиграл.
     *         {@code false} если победы не обнаружено.
     */
    static boolean isWinMainDiagonal(char[][] field){
        boolean isWinFlag = false;
            for (int i = 0; i < field.length - 1; i++) {
                if (field[i][i] != field[i][i+1]) {
                    isWinFlag = false;
                    break;
                }
                if (field[i][i] != DOT_EMPTY) {
                    isWinFlag = true;
                }
            }
        return isWinFlag;
    }

    /**
     * Метод проверяет, есть ли победа в обратной диагонали
     * @param field
     *        заполненное к текущему ходу игровое поле
     * @return {@code true} если ходок выиграл.
     *         {@code false} если победы не обнаружено.
     */
    static boolean isWinReverseDiagonal(char[][]field){
        return isWinMainDiagonal(transpose(field));
    }

    /**
     * Заполняет выбранную пользователем ячейку
     * @param field
     *        заполненное к текущему ходу игровое поле
     * @return заполненное после хода пользователя игровое поле
     */
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
            if (field[userX][userY] != DOT_EMPTY) {
                System.out.println("The cell is already occupied. Please, try again.\n");
                printArray(field);
            }
        } while (field[userX][userY] != DOT_EMPTY);
        return refreshField(field,userX,userY,DOT_X);
    }

    /**
     * Заполняет выбранную компьютером ячейку
     * @param field
     *        заполненное к текущему ходу игровое поле
     * @return заполненное после хода пользователя игровое поле
     */
    static char[][] moveComputerBy0(char[][] field){
        int computerX;
        int computerY;
        do {
            Random random = new Random();
            computerX = random.nextInt(field.length);
            computerY = random.nextInt(field.length);
            //проверка на занятость ячейки
        } while (field[computerX][computerY] != DOT_EMPTY);
        System.out.println("Computer move:\n");
        return refreshField(field,computerX,computerY,DOT_O);
    }

    /**
     * Создает поле для начала игры.
     * @param n
     *        размерность поля
     * @return матрица, заполненная значениями {@code DOT_EMPTY}
     */
     private static char[][] init(int n){
        char[][] field = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                field[i][j] = DOT_EMPTY;
            }
        }
        return field;
    }

    /**
     * Обновляет значение ячейки в игровом поле
     * @param field
     *        заполненное к текущему ходу игровое поле
     * @param x
     *        номер строки целевой ячейки
     * @param y
     *        номер колонки целевой ячейки
     * @param userChar
     *        символ текущего игрока
     * @return
     *        заполненное после хода игровое поле
     */
    static char[][] refreshField(char[][] field, int x, int y, char userChar){
        field[x][y] = userChar;
        return field;
    }

    /**
     * Выводит игровое поле в консоль
     * @param field
     *        игровое поле
     */
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
        int userValue = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                userValue = sc.nextInt();
                if (userValue <= 0) {
                    System.out.println("Sorry, but you need the value " +
                            "greater than zero. Please, try again:\n");
                } else {
                    return userValue;
                }
            } catch (InputMismatchException e) {
                System.out.println("It's not an integer! " +
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
