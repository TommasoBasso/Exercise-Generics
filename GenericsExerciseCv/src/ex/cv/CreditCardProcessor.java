package ex.cv;

import java.time.LocalDate;
import java.time.YearMonth;

/**
 * Processes credit card payments, including validation, creation, and refunding.
 * Implements the PaymentProcessor interface for CreditCardPayment.
 */
public class CreditCardProcessor implements PaymentProcessor<CreditCardPayment> {

    /**
     * Processes a credit card payment. Updates the payment status based on validation.
     * @param payment The CreditCardPayment to process
     */
    @Override
    public void processPayment(CreditCardPayment payment) {
        if (validatePayment(payment)) {
            System.out.println("Payment processed");
            payment.updateStatus(PaymentStatus.COMPLETED);
        } else {
            payment.updateStatus(PaymentStatus.FAILED);
            System.out.println(payment.getStatus() + ": Card not valid");
        }
    }

    /**
     * Validates a credit card payment by checking the expiry date.
     * @param payment The CreditCardPayment to validate
     * @return true if the payment is valid, false otherwise
     */
    @Override
    public boolean validatePayment(CreditCardPayment payment) {
        // Split the expiry date into month and year
        String[] parts = payment.getExpiryDate().split("/");

        int expiringMonth = Integer.parseInt(parts[0]);
        int expiringYear = Integer.parseInt("20" + parts[1]);
        LocalDate todayDate = LocalDate.now();
        YearMonth expiringDate = YearMonth.of(expiringYear, expiringMonth);

        // Check if the card has expired
        return !expiringDate.isBefore(YearMonth.from(todayDate));
    }

    /**
     * Creates a new CreditCardPayment with the specified amount and details from an existing payment.
     * @param amount The amount for the new payment
     * @param payment The existing CreditCardPayment to copy details from
     * @return A new CreditCardPayment with the specified amount and copied details
     */
    @Override
    public CreditCardPayment createPayment(double amount, CreditCardPayment payment) {
        return new CreditCardPayment(amount, payment.getCardHolderName(), payment.getCardNumber(), payment.getExpiryDate(), payment.getCvv());
    }

    /**
     * Processes a refund for a credit card payment. Updates the payment status to REFUNDED if the payment was completed.
     * @param payment The CreditCardPayment to refund
     */
    @Override
    public void refundPayment(CreditCardPayment payment) {
        if (payment.getStatus() == PaymentStatus.COMPLETED) {
            payment.updateStatus(PaymentStatus.REFUNDED);
            System.out.println("Payment refunded");
        } else {
            System.out.println("Refund failed: Payment not completed");
        }
    }
}
