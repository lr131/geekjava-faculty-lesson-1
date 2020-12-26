package ru.geekbrains.lesson6;

public class Cat extends Animal{
    private String name;
    private static final float MAXRUNDISTANCE = 200;
    private static final float MAXSWIMDISTANCE = 0;
    private static int count = 0;

    public Cat(String name) {
        super(name, MAXRUNDISTANCE, MAXSWIMDISTANCE);
        this.count++;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public void run(float distance) {
        if (canRun(distance)){
            System.out.printf("I did it! I'm cool, I've going for %.1f m.",
                    distance);
            System.out.println();
        } else {
            System.out.println("Meow! No, it's too much, too far for meeeow!");
        }
    }

    @Override
    public void swim(float distance) {
        System.out.println("Meeeeeoooowwww!\nAre you kidding me? Let's looking " +
                "at canSwim() with me;)");
    }
}
