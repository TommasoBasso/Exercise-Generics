package ex.cv;
/**
 * Interface for handling payments of type {@code T} which extends {@code AbstractPayment}.
 * It includes methods for processing payments, validating them, creating new ones, and handling refunds.
 *
 * @param <T> The type of payment, extending {@code AbstractPayment}.
 */
public interface PaymentProcessor<T extends AbstractPayment> {

    /**
     * Processes the given payment.
     *
     * @param payment The payment to process.
     */
    void processPayment(T payment);

    /**
     * Checks if the payment is valid.
     *
     * @param payment The payment to check.
     * @return {@code true} if the payment is valid; {@code false} otherwise.
     */
    boolean validatePayment(T payment);

    /**
     * Creates a new payment with the specified amount based on the given payment details.
     *
     * @param amount The amount for the new payment.
     * @param payment The payment with details to copy.
     * @return A new payment with the given amount and details.
     */
    T createPayment(double amount, T payment);

    /**
     * Refunds the given payment if possible.
     *
     * @param payment The payment to refund.
     */
    void refundPayment(T payment);
}
