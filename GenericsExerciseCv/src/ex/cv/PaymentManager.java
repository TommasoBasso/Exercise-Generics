package ex.cv;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages payments of type T, where T extends AbstractPayment.
 * Provides methods to add, process, filter, and print payments.
 * Also includes functionality for refunding payments.
 */
public class PaymentManager<T extends AbstractPayment> {

    private List<T> payments; // List to hold all payments
    private PaymentProcessor<T> processor; // Processor to handle payment operations

    /**
     * Constructs a PaymentManager with a specific PaymentProcessor.
     * @param processor The processor to be used for payment operations
     */
    public PaymentManager(PaymentProcessor<T> processor) {
        this.payments = new ArrayList<>();
        this.processor = processor;
    }

    /**
     * Adds a payment to the list if it is validated by the processor.
     * @param payment The payment to be added
     */
    public void addPayment(T payment) {
        if (processor.validatePayment(payment)) {
            payments.add(payment);
            System.out.println("Payment accepted");
        } else {
            System.out.println("Payment denied");
        }
    }

    /**
     * Processes all payments in the list using the processor.
     */
    public void processAllPayment() {
        for (T payment : payments) {
            processor.processPayment(payment);
        }
    }

    /**
     * Retrieves a list of payments with a specific status.
     * @param status The status to filter payments by
     * @return A list of payments with the specified status
     */
    public List<T> getPaymentsByStatus(PaymentStatus status) {
        List<T> filteredPayments = new ArrayList<>();
        for (T payment : payments) {
            if (payment.getStatus().equals(status)) {
                filteredPayments.add(payment);
            }
        }
        return filteredPayments;
    }

    /**
     * Prints the details of the provided list of payments.
     * @param payments The list of payments to print
     */
    public void printPayments(List<T> payments) {
        if (payments.isEmpty()) {
            System.out.println("No payments to display");
        } else {
            for (T payment : payments) {
                System.out.println(payment.getPaymentDetails());
            }
        }
    }

    /**
     * Refunds a payment using the processor's refund method.
     * @param payment The payment to be refunded
     */
    public void refundPayment(T payment) {
        processor.refundPayment(payment);
    }
}

