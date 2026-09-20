public class EmployeeTeamTest {
    public static void main(String[] args) {
        
        Employee bossEmp = new Employee("Ananya", "Brill", 8000.00);
        Employee staffEmp = new Employee("Hailey", "Guzman", 3500.00);

        
        EmployeeTeam team = new EmployeeTeam(bossEmp, staffEmp);

        System.out.println("=== 1. Testing printEmployeeDetails() ===");
        team.printEmployeeDetails();
        System.out.println();

        System.out.println("=== 2. Testing printAllEmployeesDetails() ===");
        team.printAllEmployeesDetails();
        System.out.println();

        System.out.println("=== 3. Testing updateSalaryOfEmployee() ===");
        System.out.println("> Updating Ananya's salary to $4200.00:");
        team.updateSalaryOfEmployee("Ananya", 4200.00);
        team.printAllEmployeesDetails();

        
        System.out.println("\n> Attempting to update Hailey's salary to -$1000.00:");
        team.updateSalaryOfEmployee("Hailey", -1000.00);
        
       
        System.out.println("\n> Attempting to update non-existent employee 'Alex':");
        team.updateSalaryOfEmployee("Alex", 5000.00);
        System.out.println();

        System.out.println("=== 4. Testing giveRaiseToAllEmployees() ===");
        System.out.println("> Applying 10% raise to all team members:");
        team.giveRaiseToAllEmployees();
        team.printAllEmployeesDetails();
    }
}