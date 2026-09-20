
public class Account_Test{
    public static void main(String[] args) {
        System.out.println("=== 1. Testing Valid Initialization & Reading Properties ===");
        Account acc1 = new Account("Alice", 500.00);
        System.out.printf("Account Name: %s, Balance: $%.2f%n%n", acc1.getName(), acc1.getBalance());

        System.out.println("=== 2. Testing Non-Positive Initialization (0 or Negative) ===");
        Account acc2 = new Account("Bob", -150.00);
        System.out.printf("Account Name: %s, Initial Balance (Negative input): $%.2f%n", acc2.getName(), acc2.getBalance());

        Account acc3 = new Account("Charlie", 0.0);
        System.out.printf("Account Name: %s, Initial Balance (Zero input): $%.2f%n%n", acc3.getName(), acc3.getBalance());

        System.out.println("=== 3. Testing Modifying Name ===");
        acc1.setName("Alice Smith");
        System.out.printf("Updated Name: %s%n%n", acc1.getName());

        System.out.println("=== 4. Testing Deposit Method ===");
        System.out.printf("Initial Balance for %s: $%.2f%n", acc1.getName(), acc1.getBalance());

        
        acc1.deposit(250.00);
        System.out.printf("After depositing $250.00: $%.2f%n", acc1.getBalance());

       
        acc1.deposit(-100.00);
        System.out.printf("After attempting deposit of -$100.00: $%.2f%n", acc1.getBalance());

        
        acc1.deposit(0.0);
        System.out.printf("After attempting deposit of $0.00: $%.2f%n", acc1.getBalance());
    }
}