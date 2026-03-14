package laba_2;

public class Dog extends Animal{
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    public void makeSound() {
        System.out.println("Гав");
    }

    public String getInfo() {
        return super.getInfo() + ", Порода: " + breed;
    }
}
