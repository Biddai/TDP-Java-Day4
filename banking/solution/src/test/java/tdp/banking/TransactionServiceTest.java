package tdp.banking;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {

    @Mock
    private PaymentGateway paymentGateway;

    @InjectMocks
    private TransactionService transactionService;

    @Test
    void testProcessTransactionSuccess() throws PaymentException {
        // Arrange
        when(paymentGateway.processPayment("12345", 100.0)).thenReturn(true);

        // Act
        String result = transactionService.processTransaction("12345", 100.0);

        // Assert
        assertEquals("Transaction Successful", result);
        verify(paymentGateway, times(1)).processPayment("12345", 100.0);
    }

    @Test
    void testProcessTransactionFailure() throws PaymentException {
        // Arrange
        when(paymentGateway.processPayment("12345", 100.0)).thenReturn(false);

        // Act
        String result = transactionService.processTransaction("12345", 100.0);

        // Assert
        assertEquals("Transaction Failed", result);
        verify(paymentGateway, times(1)).processPayment("12345", 100.0);
    }

    @Test
    void testProcessTransactionException() throws PaymentException {
        // Arrange
        when(paymentGateway.processPayment("12345", 100.0)).thenThrow(new PaymentException("Insufficient Funds"));

        // Act
        String result = transactionService.processTransaction("12345", 100.0);

        // Assert
        assertEquals("Transaction Failed due to an error: Insufficient Funds", result);
        verify(paymentGateway, times(1)).processPayment("12345", 100.0);
    }
}
