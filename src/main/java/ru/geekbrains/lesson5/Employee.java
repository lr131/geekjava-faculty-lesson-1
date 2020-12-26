package ru.geekbrains.lesson5;

public class Employee {
    private String lname;
    private String nname;
    private String position;
    private String email;
    private String phone;
    private float salary;
    private int age;

    public Employee(String lname, String nname, String position,
                    String email, String phone, int age, float salary) {
        this.lname = lname;
        this.nname = nname;
        this.phone = phone;
        this.position = position;
        this.email = email;
        this.age = age;
        this.salary = salary;
    }

    /**
     * Метод выводит в консоль информацию о сотруднике
     */
    public void getInfo(){
        System.out.println(toString());
        System.out.println();
    }
    
    public String toString(){
        return String.format("Employee fullname: %s, %s.\n" +
                        "email: %s\nposition: %s\nphone: %s\nsalary: %.2f \n" +
                        "age: %d.\n", lname, nname, email, position, phone,
                salary, age);
    }

    /**
     * Возвращает возраст сотрудника
     * @return возраст сотрудника
     */
    public int getAge(){
        return age;
    }

    /**
     * Устанавливает возраст сотрудника
     * @param age
     *        Возраст сотрудника
     */
    public void setAge(int age) {
        if (age < 0) {
            System.out.println("Age must be greater zero!");
        } else {
            this.age = age;
        }
    }




}
