public class EmployeeTest {
    public static void main(String[] args) {
        System.out.println("=== Requirement 1: Testing Encapsulation & Validation ===");
        
        
        Employee emp1 = new Employee("Hailey", "Guzman");
        System.out.printf("Initial state: %s %s, Monthly Salary: $%.2f%n", 
                emp1.getFirstName(), emp1.getLastName(), emp1.getMonthlySalary());

        
        emp1.setFirstName("Hailey");
        emp1.setLastName("Guzman");

        
        emp1.setMonthlySalary(-500.0);
        System.out.printf("After trying negative salary (-500): $%.2f%n", emp1.getMonthlySalary());

        emp1.setMonthlySalary(0.0);
        System.out.printf("After trying zero salary (0): $%.2f%n", emp1.getMonthlySalary());

        
        emp1.setMonthlySalary(3000.0);
        System.out.printf("Updated state: %s %s, Monthly Salary: $%.2f%n%n", 
                emp1.getFirstName(), emp1.getLastName(), emp1.getMonthlySalary());

        
        System.out.println("=== Requirement 2: Two Employees & Initial Yearly Salaries ===");
        
        
        Employee emp2 = new Employee("Ananya", "Brill", 4000.00);
        Employee emp3 = new Employee("Sophia", "Idonknow", 5500.00);

        System.out.printf("%s %s's Yearly Salary: $%.2f%n", 
                emp2.getFirstName(), emp2.getLastName(), emp2.getYearlySalary());
        System.out.printf("%s %s's Yearly Salary: $%.2f%n%n", 
                emp3.getFirstName(), emp3.getLastName(), emp3.getYearlySalary());

        
        System.out.println("=== Requirement 3: Applying 10% Raise ===");
        
        
        emp2.applyRaise(10);
        emp3.applyRaise(10);

        System.out.printf("%s %s's Yearly Salary after 10%% raise: $%.2f%n", 
                emp2.getFirstName(), emp2.getLastName(), emp2.getYearlySalary());
        System.out.printf("%s %s's Yearly Salary after 10%% raise: $%.2f%n", 
                emp3.getFirstName(), emp3.getLastName(), emp3.getYearlySalary());
    }
}