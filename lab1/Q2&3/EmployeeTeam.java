public class EmployeeTeam {
    private Employee boss;
    private Employee employee;

    // Constructor with two input arguments initializing boss and employee
    public EmployeeTeam(Employee boss, Employee employee) {
        this.boss = boss;
        this.employee = employee;
    }

    // 1. Print details of employee
    public void printEmployeeDetails() {
        System.out.printf("Employee: %s %s, Monthly Salary: $%.2f%n",
                employee.getFirstName(), employee.getLastName(), employee.getMonthlySalary());
    }

    // 2. Print details of both boss and employee
    public void printAllEmployeesDetails() {
        System.out.println("--- Team Details ---");
        System.out.printf("Boss: %s %s, Monthly Salary: $%.2f%n",
                boss.getFirstName(), boss.getLastName(), boss.getMonthlySalary());
        System.out.printf("Employee: %s %s, Monthly Salary: $%.2f%n",
                employee.getFirstName(), employee.getLastName(), employee.getMonthlySalary());
    }

    // 3. Update salary of Employee object(s) whose first name matches 'firstname'
    public void updateSalaryOfEmployee(String firstname, double newSalary) {
        if (newSalary > 0) {
            boolean updated = false;

            if (boss.getFirstName().equalsIgnoreCase(firstname)) {
                boss.setMonthlySalary(newSalary);
                updated = true;
            }
            if (employee.getFirstName().equalsIgnoreCase(firstname)) {
                employee.setMonthlySalary(newSalary);
                updated = true;
            }

            if (!updated) {
                System.out.printf("No employee found with first name '%s'. No changes made.%n", firstname);
            }
        } else {
            System.out.println("Update failed: new salary must be greater than 0.");
        }
    }

    // 4. Give a 10% raise to both boss and employee
    public void giveRaiseToAllEmployees() {
        boss.applyRaise(10);
        employee.applyRaise(10);
    }

    // Getters & Setters for encapsulation
    public Employee getBoss() {
        return boss;
    }

    public void setBoss(Employee boss) {
        this.boss = boss;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}