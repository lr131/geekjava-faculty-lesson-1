package ru.geekbrains.lesson4;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        scanner.nextInt();
        char[][] field = init(3); //default value
        printArray(field);

    }

    static void start(){

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

    static char[][] refreshField(char[][] field){
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = '-';
            }
        }
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
}
