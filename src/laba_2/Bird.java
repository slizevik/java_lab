package laba_2;

public class Bird extends Animal {
    private boolean canFly;

    public Bird(String name, int age, boolean canFly) {
        super(name, age);
        this.canFly = canFly;
    }

    public void makeSound() {
        System.out.println("Чирик");
    }

    public String getInfo() {
        return super.getInfo() + ", Летает: " + canFly;
    }
}
