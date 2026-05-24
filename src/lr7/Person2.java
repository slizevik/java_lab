package lr7;
import java.io.Serializable;

public class Person2 implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private String email;

    public Person2(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return "Person2{name='" + name + "', age=" + age + ", email='" + email + "'}";
    }
}
