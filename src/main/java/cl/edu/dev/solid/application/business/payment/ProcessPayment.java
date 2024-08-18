package cl.edu.dev.solid.application.business.payment;

public class ProcessPayment {
    private final CreditCardPayment creditCardPayment;
    private final PayPalPayment payPalPayment;

    ProcessPayment(CreditCardPayment creditCardPayment, PayPalPayment payPalPayment) {
        this.creditCardPayment = creditCardPayment;
        this.payPalPayment = payPalPayment;
    }

    public String choicePaymentMethod(int paymentType, double amount) {
       switch (paymentType) {
           case 1: this.processTransaction(this.creditCardPayment, amount);
           case 2: this.processTransaction(this.payPalPayment,amount);
           default:
               break;
        }
        return "OK";
    }

    private void processTransaction(PaymentMethod paymentMethod, double amount) {
        paymentMethod.processPayment(amount);
    }
}
