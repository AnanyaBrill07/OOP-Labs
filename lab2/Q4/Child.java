package Q4;
public class Child {

    private Person guardian;
    private int age;
    private int height;
    private double weight;

    public Child(int age, int height, double weight) {
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public void setGuardian(Person guardian) {
        this.guardian = guardian;
    }

    public Person getGuardian() {
        return guardian;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }
}