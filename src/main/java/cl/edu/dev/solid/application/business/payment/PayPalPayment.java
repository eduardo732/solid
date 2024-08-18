package cl.edu.dev.solid.application.business.payment;

public class PayPalPayment implements PaymentMethod{
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing paypal payment...");
    }
}
