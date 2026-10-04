package lab3.Q3;
public class PaymentModule {

    protected double totalPay;

    public PaymentModule(double totalPay) {
        this.totalPay = totalPay;
    }

    public void payment(Employee e) {
        double pay = e.computePay();

    
        if (e instanceof Manager) {
            Manager mgr = (Manager) e;
            if (mgr.getWorkYear() > 10) {
                pay = pay * 2;
            }
        }

        totalPay += pay;
    }

    public double getTotalPay() {
        return totalPay;
    }
}