package Q4;
public class FamilyTest {
    public static void main(String[] args) {
        Mother m = new Mother();
        m.setFirstName("Alice");
        System.out.println(m.getFirstName()); 
        Father f = new Father(m);
        f.setFirstName("Bob");
        System.out.println(f.getFirstName()); 

        Person p = new Person();
        p.setFirstName("John");
        System.out.println(p.getFirstName()); 

        Child child = new Child(5, 110, 40.5);
        child.setGuardian(f);
        f.setChild(child);
        System.out.println("Child's guardian first name: " + child.getGuardian().getFirstName());
        System.out.println("Father's child age: " + f.getChild().getAge());
        System.out.println("Father's wife first name: " + f.getWife().getFirstName());
    }
}