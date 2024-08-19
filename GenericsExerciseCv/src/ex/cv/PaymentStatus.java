package ex.cv;


//Enum representing the different statuses of a payment
public enum PaymentStatus {

    //Payment has been created but not yet processed
    PENDING,

    // Payment has been successfully processed and completed.
    COMPLETED,

    //Payment failed due to an issue (e.g., invalid details, insufficient funds).
    FAILED,

    //Payment has been refunded and the funds have been returned to the payer.
    REFUNDED
}

