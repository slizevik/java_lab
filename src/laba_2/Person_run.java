package laba_2;

public class Person_run {
    public static void main(String[] args) {
        Person person1 = new Person("Анна", 25, "женский");

        System.out.println("Имя: " + person1.getName());
        System.out.println("Возраст: " + person1.getAge());
        System.out.println("Пол: " + person1.getGender());

        person1.setAge(26);
        System.out.println("Новый возраст Анны: " + person1.getAge());

    }
}
