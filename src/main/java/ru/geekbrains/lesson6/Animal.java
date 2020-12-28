package ru.geekbrains.lesson6;

public abstract class Animal {
    private String name;
    private float maxRunDistance;
    private float maxSwimmingDistance;
    private static int count = 0;
    
    
    public Animal(String name, float maxRunDistance, 
                  float maxSwimmingDistance){
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimmingDistance = maxSwimmingDistance;
        this.count++;
    }

    public static int getAnimalsCount() {
        return count;
    }

    public String toString(){
        String swimInfo = (getMaxSwimmingDistance() > 0) ? 
        String.format("It can swim max %.2f m. ", getMaxSwimmingDistance()) :
                "It can't swimming. ";
        return String.format("This is %s. It's named %s. " +
                "It can run max %.2f m. %s",
                this.getClass(), getName(), getMaxRunDistance(), swimInfo);
    }
    
    public void getInfo(){
        System.out.println(toString());
    }
    
    public abstract void run(float distance);
    
    public abstract void swim(float distance);

    protected boolean canRun(float runDistance) {
        return (runDistance <=
                getMaxRunDistance());
    }

    public boolean canSwim(float swimDistance) {
        return (getMaxSwimmingDistance() > 0 && swimDistance <=
                getMaxSwimmingDistance());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMaxRunDistance() {
        return maxRunDistance;
    }

    public float getMaxSwimmingDistance() {
        return maxSwimmingDistance;
    }
}
