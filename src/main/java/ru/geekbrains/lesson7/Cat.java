package ru.geekbrains.lesson7;

public class Cat {
    private String name;

    private int appetite;

    private boolean fill;
    public Cat(String name, int appetite) {
        this.name = name;
        this.fill = false;
        if (appetite > 0) {
            this.appetite = appetite;
        } else {
            System.out.println("Appetite must be greatest zero!" +
                    "The default value is set. Foot is 10");
            this.appetite = 10;
        }
    }
    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean isFill() {
        return fill;
    }
    public void eat(Plate p) {
        if (!isFill()){
            try {
                p.decreaseFood(appetite);
                this.fill = true;
            } catch (PlateBalanceException e) {
                System.out.println(e);
            }    
        }
    }
    
    public void getInfo(){
        System.out.print(toString());
    }
    
   
    public String toString(){
        return String.format("This is cat %s. It's appetite is %d%n", 
                getName(), getAppetite());
    }

    public String toStringExtend(){
        String filling = isFill() ? "It's fill good" : "It's hungry (and angry!)";
        return String.format("This is cat %s. It's appetite is %d%n%s%n",
                getName(), getAppetite(), filling);
    }
    
    

}
