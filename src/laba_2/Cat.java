package laba_2;

public class Cat extends Animal {
    private String foodType;

    public Cat(String name, int age, String foodType) {
        super(name, age);
        this.foodType = foodType;
    }

    public void makeSound() {
        System.out.println("Мяу");
    }

    public String getInfo() {
        return super.getInfo() + ", Корм: " + foodType;
    }
}