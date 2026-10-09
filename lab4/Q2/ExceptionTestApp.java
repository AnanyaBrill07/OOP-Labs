package lab4.Q2;
import java.util.Scanner;

public class ExceptionTestApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        System.out.print("Enter GPA: ");
        double gpa = scanner.nextDouble();

        try {
            
            UndergradStudent undergrad = new UndergradStudent(age, gpa);
            GradStudent grad = new GradStudent(age, gpa);

            System.out.println("\nSuccessfully created student objects!");
            System.out.println("Undergrad Age: " + undergrad.getAge() + ", GPA: " + undergrad.getGpa());
            System.out.println("Grad Age: " + grad.getAge() + ", GPA: " + grad.getGpa());

        } catch (IllegalArgumentException e) {
            
            System.out.println("\nError: " + e.getMessage());
        }

        scanner.close();
    }
}