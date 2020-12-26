package ru.geekbrains.lesson6;

public class Dog extends Animal{
    private String name;
    private static final float MAXRUNDISTANCE = 500;
    private static final float MAXSWIMDISTANCE = 10;
    private  static int count = 0;
    
    public Dog(String name){
        super(name, MAXRUNDISTANCE, MAXSWIMDISTANCE);
        this.count++;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public void run(float distance) {
        if (canRun(distance)) {
            System.out.printf("Woof! I'm going, going %.2f m! I like going so " +
                    "much!", distance);
            System.out.println();
        } else {
            System.out.println("Aww... I'm so sorry, Man, but I can't go so far.");
        }
    }

    @Override
    public void swim(float distance) {
        if (canSwim(distance)) {
            System.out.printf("Woof! I'm swimming %.1f! The water is great!",
                    distance);
            System.out.println();
        } else {
            System.out.println("Aww... I'm so sorry, Man, but I have to sleep. " +
                    "I can't swim so far.");
        }
    }
}
