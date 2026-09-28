package tdp.exercises;

public class PayCalculator {
    public long calculateNetPay(long grossCents, long deductionCents) {
        if (grossCents < 0 || deductionCents < 0 || deductionCents > grossCents) {
            throw new IllegalArgumentException("Invalid pay inputs");
        }
        return grossCents - deductionCents;
    }
}
