package testPackage;

public class Human {
    private String name;
    private int age;
    public String nickname = "Fake";

    public Human(String name) {
        this.name = name;
    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Human(int age) {
        this.age = age;
    }

    public Human() {

    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void hello() {
        System.out.println("Hello world!");
    }

    private void bye() {
        System.out.println("Bye");
    }
}
