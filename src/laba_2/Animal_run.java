package laba_2;

public class Animal_run {
    public static void main(String[] args) {
        Animal[] animals = {new Dog("Бобик", 3, "Овчарка"), new Cat("Мурка", 2, "Сухой корм"), new Bird("Кеша", 1, true)};

        for (Animal animal : animals) {
            System.out.println(animal.getInfo());
            animal.makeSound();
            System.out.println();
        }
    }
}
