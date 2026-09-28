package tdp.banking;

public class TransactionService {
    private final PaymentGateway paymentGateway;

    public TransactionService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public String processTransaction(String accountNumber, double amount) {
        try {
            boolean success = paymentGateway.processPayment(accountNumber, amount);
            if (success) {
                return "Transaction Successful";
            } else {
                return "Transaction Failed";
            }
        } catch (PaymentException exception) {
            return "Transaction Failed due to an error: " + exception.getMessage();
        }
    }
}
