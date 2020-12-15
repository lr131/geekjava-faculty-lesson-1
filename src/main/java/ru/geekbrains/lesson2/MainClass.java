package ru.geekbrains.lesson2;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Math.abs;

public class MainClass {

    public static void main(String[] args) {
        invertArray(); //task 1
        setProgression(); //task 2
        multiplyLessSix();
        doDiagonalMatrix(); //task4
        doTwoDiagonalMatrix(); //Крестиком :)
        findMinAndMaxElements(); //task 5
        printBalanceStatus(); //task 6
        printShift(); //task 7
    }

    /**
     * Задать целочисленный массив, состоящий из элементов 0 и 1.
     * Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
     * С помощью цикла и условия заменить 0 на 1, 1 на 0;
     */
    public static void invertArray(){
        System.out.println("\nTask 1. Invert element value:\n");
        int[] array;
        int len = 7;
        System.out.println("Please, enter array length (default value is 7):");
        // ввод, пока не введут правильно
        do {
            try {
                len = (new Scanner(System.in)).nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("It's not an whole number! Please, try again:");
            }
        } while (true);
        array = generateZeroOneArray(len); //массив исходный генерируется
        printArray(array);
        for (int i = 0; i < array.length; i++) {
             array[i] = (array[i] == 0) ? 1 : 0; // тройной оператор, эквивалентно этому:
//            if (array[i] == 0) {
//                array[i] = 1;
//            } else {
//                array[i] = 0;
//            }
        }
        printArray(array);
    }

    private static int[] generateZeroOneArray(int len) {
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) ( Math.random() * 2 );
        }
        return array;
    }

    /**
     * Задать пустой целочисленный массив размером 8.
     * С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
     */
    public static void setProgression() {
        int[] arr = new int[8];
        arr[0] = 0;
        System.out.println("\nTask 2. Arithmetic progression:\n");
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i-1] + 3;
        }
        printArray(arr);
    }

    /**
     * Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
     * пройти по нему циклом, и числа меньшие 6 умножить на 2;
     */
    public static void multiplyLessSix(){
       int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
       System.out.println("\nTask 3. Multiply if element is less 6:\n");
       printArray(array);
       for (int i = 0; i < array.length; i++){
           if (array[i] < 6) {
               array[i] = array[i]*2;
           }
       }
       printArray(array);
    }

    /**
     * Создать квадратный двумерный целочисленный массив
     * (количество строк и столбцов одинаковое),
     * и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
     */
    public static void doDiagonalMatrix(){
        int n = 5;
        int[][] matrix = new int[n][n];
        System.out.println("\nTask 4 with main diagonal:\n");
        for (int i = 0; i < n; i++) {
            matrix[i][i] = 1;
        }
        printMatrix(matrix);
    }

    /**
     * Создать квадратный двумерный целочисленный массив
     * (количество строк и столбцов одинаковое),
     * и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
     */
    public static void doTwoDiagonalMatrix(){
        int n = 5;
        int[][] matrix = new int[n][n];
        System.out.println("\nTask 4 with main and side diagonals:\n");
        for (int i = 0; i < n; i++) {
            matrix[i][i] = 1;
            matrix[n-i-1][i] = 1;
        }
        printMatrix(matrix);
    }

    /**
     * ** Задать одномерный массив и
     * найти в нем минимальный и максимальный элементы (
     * без помощи интернета);
     */
    public static void findMinAndMaxElements() {
        int[] array = {10, 5, 3, 2, 11, 4, -255, 5, 2, 4, 8, 9, 1};
        System.out.println("\nTask 5. Find Min and Max elements:\n");
        printArray(array);
        int maxElement = array[0];
        int minElement = array[0];
        int indexMaxElement = 0;
        int indexMinElement = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxElement) {
                maxElement = array[i];
                indexMaxElement = i;
            }
            if (array[i] < minElement) {
                minElement = array[i];
                indexMinElement = i;
            }
        };
        System.out.printf("Max element is array[%d] with value %d\n", indexMaxElement, maxElement);
        System.out.printf("Min element is array[%d] with value %d\n", indexMinElement, minElement);
    }

    /**
     * ** Написать метод, в который передается не пустой одномерный
     * целочисленный массив, метод должен вернуть true, если в массиве есть место,
     * в котором сумма левой и правой части массива равны.
     * Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
     * checkBalance([1, 1, 1, || 2, 1]) → true,
     * граница показана символами ||, эти символы в массив не входят.
     */
    public static void printBalanceStatus(){
        System.out.println("\nTask 6. Balance\n");
        int[] arr = {2, 2, 2, 1, 2, 2, 10, 1};
        printArray(arr);
        if (checkBalance(arr)) {
            System.out.println("This array is balanced");
        } else {
            System.out.println("This array isn't balansed");
        }

    }

    private static boolean checkBalance(int[] array){
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < array.length - 1; i++) {
            leftSum = leftSum + array[i];
            rightSum = getRightSum(array, i + 1);
            if (leftSum == rightSum) {
                return true;
            }
        }
        return false;
    }

    private static int getRightSum(int[] array, int startIndex){
        int sum = 0;
        for (int i = startIndex; i < array.length; i++) {
            sum = sum + array[i];
        }
        return sum;
    }

    /**
     * **** Написать метод, которому на вход подается
     * одномерный массив и число n
     * (может быть положительным, или отрицательным),
     * при этом метод должен сместить все элементы массива на n позиций.
     * Элементы смещаются циклично.
     * Для усложнения задачи нельзя пользоваться вспомогательными массивами.
     * Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) ->
     * [ 3, 1, 2 ];
     * [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
     * При каком n в какую сторону сдвиг можете выбирать сами.
     */
    public static void printShift(){
        System.out.println("\nTask 7. Shift\n");
        System.out.println("Positive n for shift to the right");
        System.out.println("Nezative n for shift to the left");
        int[] arr = {1, 2, 3, 4 , 5};
        printArray(arr);
        System.out.println("if N = 2:");
        doShift(arr, 2);
        printArray(arr);
        int[] arr2 = {1, 2, 3, 4 , 5};
        System.out.println("if N = -2:");
        doShift(arr2, -2);
        printArray(arr2);
    }

    private static int[] doShift(int[] arr, int shift){
        if (abs(shift) > arr.length) {
            shift = shift % arr.length;
        }
        if (shift == 0) {
            return arr; //при сдвиге 0 просто выходим, экономим ресурсы
        }
        int valuePrev;
        int valueCurrent;
        int n = 1;

        if (shift > 0) {
            while (n <= shift) {
                valuePrev = arr[0];
                for(int i = 1; i <= arr.length; i++) {
                    if (i >= arr.length) {
                        valueCurrent = arr[i - arr.length];
                        arr[i - arr.length] = valuePrev;
                    } else{
                        valueCurrent = arr[i];
                        arr[i] = valuePrev;
                    }
                    valuePrev = valueCurrent;
                }
                n++;
            }
            return arr;
        }

        n = -1;
        while (n>=shift){
            valuePrev = arr[arr.length - 1];
            for (int i = arr.length - 2; i >= -1; i--) {
                if (i == -1) {
                    valueCurrent = arr[arr.length + i];
                    arr[arr.length + i] = valuePrev;
                } else{
                    valueCurrent = arr[i];
                    arr[i] = valuePrev;
                }
                valuePrev = valueCurrent;
            }
            n--;
        }

        return arr;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

    }

    public static void printMatrix(int[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

}
