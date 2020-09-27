public class Cat {
    String color;
    int age;
    String name;

    Cat(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    Cat() {}

    String meow(String food) {
        return "Meow! Ya hochu " + food;
    }
    void meow() {
        System.out.println("Meow2! Menya zovut " + name);
    }
}
