package lab3.Q4;
public class AdvancedPaymentModule extends PaymentModule {

    public AdvancedPaymentModule(double totalPay) {
        super(totalPay);
    }

    
    public void payment(Employee[] employees) {
        for (Employee e : employees) {
            super.payment(e);
        }
    }
}