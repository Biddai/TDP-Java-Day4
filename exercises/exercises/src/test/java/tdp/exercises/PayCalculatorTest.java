package tdp.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class PayCalculatorTest  {
    @Test
    void resultIsPositive()  {
        assertTrue(new PayCalculator().calculateNetPay(10000, 2000) > 0);
    }
    @Test
    void negativeInput()  {
        try  {
            new PayCalculator().calculateNetPay(-1, 0);
        }
        catch (IllegalArgumentException ignored)  {
        }
    }
}
