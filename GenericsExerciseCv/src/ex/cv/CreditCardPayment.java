package ex.cv;

/**
 * Represents a credit card payment.
 * Extends AbstractPayment to include specific details related to credit card transactions.
 */
public class CreditCardPayment extends AbstractPayment {

    // The name of the cardholder
    private String cardHolderName;

    // The credit card number
    private String cardNumber;

    // The expiry date of the credit card in MM/YY format
    protected String expiryDate;

    // The card verification value (CVV) for the credit card
    private String cvv;

    /**
     * Constructor to initialize a credit card payment with specific details.
     * @param amount The amount of the payment
     * @param cardHolderName The name of the cardholder
     * @param cardNumber The credit card number
     * @param expiryDate The expiry date of the card (MM/YY format)
     * @param cvv The CVV of the credit card
     */
    public CreditCardPayment(double amount, String cardHolderName, String cardNumber, String expiryDate, String cvv) {
        super(amount);
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    /**
     * Gets the name of the cardholder.
     * @return The cardholder's name
     */
    public String getCardHolderName() {
        return cardHolderName;
    }

    /**
     * Sets the name of the cardholder.
     * @param cardHolderName The new name of the cardholder
     */
    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    /**
     * Gets the credit card number.
     * @return The credit card number
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Sets the credit card number.
     * @param cardNumber The new credit card number
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * Gets the expiry date of the credit card.
     * @return The expiry date in MM/YY format
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * Sets the expiry date of the credit card.
     * @param expiryDate The new expiry date in MM/YY format
     */
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * Gets the CVV of the credit card.
     * @return The CVV of the credit card
     */
    public String getCvv() {
        return cvv;
    }

    /**
     * Sets the CVV of the credit card.
     * @param cvv The new CVV of the credit card
     */
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    /**
     * Provides details of the credit card payment.
     * @return A formatted string with payment details
     */
    @Override
    public String getPaymentDetails() {
        return """
                Amount: %.2f
                Status: %s
                Name: %s
                Card N.: %s
                """.formatted(getAmount(), getStatus(), cardHolderName, cardNumber);
    }
}

