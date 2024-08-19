package ex.cv;

/**
 * Processes PayPal payments, including validation, processing, and refunding.
 * Implements the PaymentProcessor interface for handling PayPalPayment objects.
 */
public class PayPalProcessor implements PaymentProcessor<PayPalPayment> {

    /**
     * Processes a PayPal payment. Validates the payment and updates its status to COMPLETED if valid, or FAILED if not.
     * @param payment The PayPal payment to be processed
     */
    @Override
    public void processPayment(PayPalPayment payment) {
        if (validatePayment(payment)) {
            System.out.println("Payment processed");
            payment.updateStatus(PaymentStatus.COMPLETED);
        } else {
            payment.updateStatus(PaymentStatus.FAILED);
            System.out.println(payment.getStatus() + "Invalid transaction ID");
        }
    }

    /**
     * Validates a PayPal payment by checking if the transaction ID is not null and not empty.
     * @param payment The PayPal payment to be validated
     * @return True if the transaction ID is valid; false otherwise
     */
    @Override
    public boolean validatePayment(PayPalPayment payment) {
        return payment.getTransactionId() != null && !payment.getTransactionId().isEmpty();
    }

    /**
     * Creates a new PayPal payment with the specified amount and details from an existing PayPal payment.
     * @param amount The amount for the new payment
     * @param payment The existing PayPal payment to copy details from
     * @return A new PayPalPayment object with the specified amount and copied details
     */
    @Override
    public PayPalPayment createPayment(double amount, PayPalPayment payment) {
        return new PayPalPayment(amount, payment.getEmailAddress(), payment.getTransactionId());
    }

    /**
     * Refunds a PayPal payment by updating its status to REFUNDED if it was previously COMPLETED.
     * @param payment The PayPal payment to be refunded
     */
    @Override
    public void refundPayment(PayPalPayment payment) {
        if (payment.getStatus() == PaymentStatus.COMPLETED) {
            payment.updateStatus(PaymentStatus.REFUNDED);
            System.out.println("Payment refunded");
        } else {
            System.out.println("Refund failed: Payment not completed");
        }
    }
}

