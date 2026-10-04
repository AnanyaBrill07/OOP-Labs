package lab3.Q3;
public class PaymentModuleTest {
    public static void main(String[] args) {
        PaymentModule module = new PaymentModule(0);

        Fulltimer fulltimer = new Fulltimer("Alice", 3000);
        Hourly hourly = new Hourly("Bob", 20, 100);
        Manager juniorManager = new Manager("Carla", 4000, 5);   
        Manager seniorManager = new Manager("Dave", 4000, 12);   

        module.payment(fulltimer);
        System.out.println("After Fulltimer: " + module.getTotalPay()); 

        module.payment(hourly);
        System.out.println("After Hourly: " + module.getTotalPay()); 

        module.payment(juniorManager);
        System.out.println("After junior Manager: " + module.getTotalPay());

        module.payment(seniorManager);
        System.out.println("After senior Manager: " + module.getTotalPay()); 
    }
}