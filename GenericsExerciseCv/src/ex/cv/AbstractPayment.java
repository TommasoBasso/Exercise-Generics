package ex.cv;

 //Abstract class representing a generic payment.
public abstract class AbstractPayment {

    // The amount of money involved in the payment
    private double amount;

    // The current status of the payment
    private PaymentStatus status;

    /**
     * Constructor to initialize the payment with a specific amount.
     * @param amount The amount of the payment
     */
    public AbstractPayment(double amount) {
        this.amount = amount;
        this.status = PaymentStatus.PENDING; // Set initial status to PENDING
    }

    /**
     * Updates the status of the payment and prints the new status.
     * @param status The new status to set for the payment
     */
    public void updateStatus(PaymentStatus status) {
        this.status = status;
        System.out.println("Payment status: " + status);
    }

    /**
     * Gets the current status of the payment.
     * @return The current status of the payment
     */
    public PaymentStatus getStatus() {
        return status;
    }

    /**
     * Gets the amount of the payment.
     * @return The amount of the payment
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Abstract method to get the details of the payment.
     * Subclasses must implement this method to provide specific payment details.
     * @return A string containing the payment details
     */
    public abstract String getPaymentDetails();
}

