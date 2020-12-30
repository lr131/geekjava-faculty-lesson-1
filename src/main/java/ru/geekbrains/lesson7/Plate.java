package ru.geekbrains.lesson7;

public class Plate {
    private int food;
    public Plate(int food) {
        if (food > 0) {
            this.food = food;
        } else {
            System.out.println("FOOD must be greatest zero!" +
                    "The default value is set. Foot is 100");
            this.food = 100;
        }
    }
    public void getInfo() {
        System.out.println(toString());
    }
    
    public String toString(){
        return "plate: " + food;
    }

    public void decreaseFood(int n) throws PlateBalanceException {
        if (food >= n) {
            food -= n;
        } else {
            throw new PlateBalanceException(n, food);
        }
    }
    
    public void increaseFood(int n) {
        if (n > 0) {
            food +=n;
        }
    }

}
