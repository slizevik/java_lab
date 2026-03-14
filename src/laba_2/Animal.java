package laba_2;

public class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void makeSound() {
        System.out.println("Звук");
    }

    public String getInfo() {
        return "Имя: " + name + ", Возраст: " + age;
    }
}
