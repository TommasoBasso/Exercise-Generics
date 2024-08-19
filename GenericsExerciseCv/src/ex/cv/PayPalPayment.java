package ex.cv;

/**
 * Represents a PayPal payment with details specific to PayPal transactions.
 * Extends AbstractPayment to include PayPal-specific attributes and behavior.
 */
public class PayPalPayment extends AbstractPayment {

    private String emailAddress; // The email address associated with the PayPal account
    private String transactionId; // The unique transaction ID for the PayPal payment

    /**
     * Constructor to initialize a PayPalPayment with the specified amount, email address, and transaction ID.
     * @param amount The amount of the payment
     * @param emailAddress The email address associated with the PayPal account
     * @param transactionId The unique transaction ID
     */
    public PayPalPayment(double amount, String emailAddress, String transactionId) {
        super(amount);
        this.emailAddress = emailAddress;
        this.transactionId = transactionId;
    }

    /**
     * Gets the email address associated with the PayPal account.
     * @return The email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the email address associated with the PayPal account.
     * @param emailAddress The email address to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Gets the unique transaction ID for the PayPal payment.
     * @return The transaction ID
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Sets the unique transaction ID for the PayPal payment.
     * @param transactionId The transaction ID to set
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * Returns a string representation of the payment details including amount, transaction ID, and email address.
     * @return A formatted string with payment details
     */
    @Override
    public String getPaymentDetails() {
        return """
                Amount: %.2f
                Transaction N.: %s
                Account: %s
                """.formatted(getAmount(), transactionId, emailAddress);
    }
}

