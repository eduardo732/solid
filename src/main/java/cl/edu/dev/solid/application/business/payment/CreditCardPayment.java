package cl.edu.dev.solid.application.business.payment;

public class CreditCardPayment implements PaymentMethod{
    @Override
    public void processPayment(double amount) {
        System.out.println("Process payment with credit card");
        //implement
    }
}
