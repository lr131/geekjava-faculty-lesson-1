package ru.geekbrains.lesson1;

/**
 * Реализация домашнего задания курса Java. Уровень 1
 *
 * @author Kristina Retivykh
 */
public class MainApp {

    // 1. Создать пустой проект в IntelliJ IDEA и прописать метод main().
    public static void main(String[] args) {
        System.out.println("\nHello, my dear World! This is task number one.");
        createVariablres(); // task 2

        System.out.println("\nThis is task number 3 aka calculate (a * (b + (c / d))).");
        calculate(10,20.5565f,30.5f,40); // task 3
        calculate(10,20,30.05f,0); // task 3

        System.out.println("\nThis is task number 4 aka isPositiveOrNegative.");
        System.out.println(task10and20(10,5)); //task 4
        System.out.println(task10and20(10,50)); //task 4

        System.out.println("\nThis is task number 5 aka isPositiveOrNegative.");
        isPositiveOrNegative(4545); //task 5
        isPositiveOrNegative(-450598); //task 5

        System.out.println("\nThis is task number 6 aka isNegative.");
        System.out.println(isNegative(4846)); //task 6
        System.out.println(isNegative(-4846)); //task 6

        System.out.println("\nThis is task number 7 aka greetUserByName.");
        greetUserByName("William"); // task 7

        System.out.println("\nThis is task number 8 aka printYearLeapStatus.");
        printYearLeapStatus(2024); // task 8
        printYearLeapStatus(2000); // task 8
        printYearLeapStatus(2300); // task 8
    }

    /**
     * Создаёт переменные всех пройденных типов данных и
     * инициализирует их значения.
     */
    public static void createVariablres() {
        byte byteValue = 127;
        short shortValue = -32768;
        int intValue = 1;
        long longValue = 2550000L;
        float floatValue = 5.25f;
        double doubleValue = -5.26;
        char charValue = 'r';
        boolean boolValue = true;
    }

    /**
     * Возвращает результат выражения a * (b + (c / d))
     * переменные всех пройденных типов данных и
     * инициализирует их значение
     *
     * @return результат вычисления
     */
    public static float calculate(float a, float b, float c, float d) {
        if (d != 0)
            return (a * (b + (c / d)));
        System.out.println("\nYou try to divide by zero! Calculation failed, returned default value.\n");
        return 0;
    }

    /**
     * Проверяет, что сумма двух целых чисел лежит в пределах от 10 до 20 включительно.
     *
     * @return {@code true} сумма двух целых чисел лежит в пределах от 10 до 20 включительно.
     *         {@code false} сумма выходит за пределы диапазона.
     */
    public static boolean task10and20(int a, int b) {
        long sum = a + b; // long  случай суммирования больших чисел
        if (sum >= 10 && sum <=20) {
            return true;
        }
        return false;
    }

    /**
     * Выводит в консоль, какое число передали в качестве параметра.
     * 0 считать положительным значением.
     *
     */
    public static void isPositiveOrNegative(int a) {
        if (isNegative(a)) {
            System.out.println("Value is negative");
        } else {
            System.out.println("Value is positive");
        }
    }

    /**
     * Возвращает, какое число передали в качестве параметра.
     *
     * @return {@code true} число отрицательное.
     *         {@code false} число положительное или 0.
     */
    public static boolean isNegative(int a) {
        if (a < 0) return true;
        return false;
    }

    /**
     * Приветствует пользователя по введенному имени.
     * Приветствие выводит в консоль.
     *
     */
    public static void greetUserByName(String userName) {
        System.out.printf("Hello, %s!\n", userName);
    }

    /**
     * Выводит сообщение в консоль о том, является ли год високосным.
     * Каждый 4-й год является високосным, кроме кроме каждого 100-го.
     * При этом каждый 400-й – високосный.
     *
     * @param year
     *        год
     */
    public static void printYearLeapStatus(int year){
        if (isLeapYear(year)) {
            System.out.printf("Year %d is leap\n", year);
            return;
        } {
            System.out.printf("Year %d isn't leap\n", year);
        }
    }

    /**
     * Определяет, является ли год високосным.
     * Каждый 4-й год является високосным, кроме кроме каждого 100-го.
     * При этом каждый 400-й – високосный.
     *
     * @param year
     *        год
     * @return {@code true} год високосный.
     *         {@code false} год не високосный.
     */
    private static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        }
        return (year % 100 != 0) || (year % 400 == 0);
    }
}



