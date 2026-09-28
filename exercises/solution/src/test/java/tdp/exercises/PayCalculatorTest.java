package tdp.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class PayCalculatorTest  {
    @Test
    void subtractsTheDeduction()  {
        assertEquals(8000, new PayCalculator().calculateNetPay(10000, 2000));
    }
    @Test
    void rejectsNegativeGross()  {
        assertThrows(IllegalArgumentException.class, () -> new PayCalculator().calculateNetPay(-1, 0));
    }
    @Test
    void rejectsNegativeDeduction()  {
        assertThrows(IllegalArgumentException.class, () -> new PayCalculator().calculateNetPay(100, -1));
    }
    @Test
    void rejectsDeductionAboveGross()  {
        assertThrows(IllegalArgumentException.class, () -> new PayCalculator().calculateNetPay(100, 101));
    }
    @Test
    void allowsZeroNetPay()  {
        assertEquals(0, new PayCalculator().calculateNetPay(100, 100));
    }
    @Test
    void allowsZeroInputs()  {
        assertEquals(0, new PayCalculator().calculateNetPay(0, 0));
    }
}
