package lab3.Q4;
public class AdvancedPaymentModuleTest {
    public static void main(String[] args) {
        AdvancedPaymentModule module = new AdvancedPaymentModule(0);

        Employee[] employees = new Employee[] {
            new Fulltimer("Alice", 3000),
            new Hourly("Bob", 20, 100),
            new Manager("Carla", 4000, 5),
            new Manager("Dave", 4000, 12)
        };

        module.payment(employees); 

        System.out.println("Total pay after processing array: " + module.getTotalPay());
        System.out.println("Expected: 3000 + 2000 + 20000 + 96000 = 121000");

        module.payment(new Hourly("Eve", 15, 10));
        System.out.println("After one more Hourly employee: " + module.getTotalPay());
    }
}