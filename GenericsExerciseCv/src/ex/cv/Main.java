package ex.cv;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create instances of payment processors
        CreditCardProcessor creditCardProcessor = new CreditCardProcessor();
        PayPalProcessor payPalProcessor = new PayPalProcessor();

        // Create payment managers for CreditCardPayment and PayPalPayment
        PaymentManager<CreditCardPayment> creditCardManager = new PaymentManager<>(creditCardProcessor);
        PaymentManager<PayPalPayment> payPalManager = new PaymentManager<>(payPalProcessor);

        // Create some credit card payments
        CreditCardPayment cardPayment1 = new CreditCardPayment(100.00, "John Doe", "1234567812345678", "12/25", "123");
        CreditCardPayment cardPayment2 = new CreditCardPayment(200.00, "Jane Doe", "9876543210987654", "11/24", "456");

        // Create some PayPal payments
        PayPalPayment payPalPayment1 = new PayPalPayment(150.00, "john.doe@example.com", "TX123456");
        PayPalPayment payPalPayment2 = new PayPalPayment(250.00, "jane.doe@example.com", "TX654321");

        // Add payments to the managers
        creditCardManager.addPayment(cardPayment1);
        creditCardManager.addPayment(cardPayment2);

        payPalManager.addPayment(payPalPayment1);
        payPalManager.addPayment(payPalPayment2);

        // Process all payments
        creditCardManager.processAllPayment();
        payPalManager.processAllPayment();

        // Print all completed payments
        System.out.println("Completed Credit Card Payments:");
        List<CreditCardPayment> completedCardPayments = creditCardManager.getPaymentsByStatus(PaymentStatus.COMPLETED);
        creditCardManager.printPayments(completedCardPayments);

        System.out.println("Completed PayPal Payments:");
        List<PayPalPayment> completedPayPalPayments = payPalManager.getPaymentsByStatus(PaymentStatus.COMPLETED);
        payPalManager.printPayments(completedPayPalPayments);

        // Test refunding completed payments
        System.out.println("Processing refunds for completed payments:");

        // Refund the first completed credit card payment
        if (!completedCardPayments.isEmpty()) {
            CreditCardPayment paymentToRefund = completedCardPayments.get(0);
            creditCardManager.refundPayment(paymentToRefund);
        }

        // Refund the first completed PayPal payment
        if (!completedPayPalPayments.isEmpty()) {
            PayPalPayment paymentToRefund = completedPayPalPayments.get(0);
            payPalManager.refundPayment(paymentToRefund);
        }

        // Print all refunded payments
        System.out.println("Refunded Credit Card Payments:");
        List<CreditCardPayment> refundedCardPayments = creditCardManager.getPaymentsByStatus(PaymentStatus.REFUNDED);
        creditCardManager.printPayments(refundedCardPayments);

        System.out.println("Refunded PayPal Payments:");
        List<PayPalPayment> refundedPayPalPayments = payPalManager.getPaymentsByStatus(PaymentStatus.REFUNDED);
        payPalManager.printPayments(refundedPayPalPayments);
    }
}


