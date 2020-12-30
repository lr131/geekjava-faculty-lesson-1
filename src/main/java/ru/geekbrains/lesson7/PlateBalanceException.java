package ru.geekbrains.lesson7;

public class PlateBalanceException extends Exception {
    
    public PlateBalanceException(int n, int food) {
        super(String.format("There is not enough feed " +
                "on the plat balance. " +
                "Plate balance: %d. Must be: %d", food, n));
    }
    
    
    
    
    
}
