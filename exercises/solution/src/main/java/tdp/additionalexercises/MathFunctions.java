package tdp.additionalexercises;

public class MathFunctions {
    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        // Use long arithmetic so divisor * divisor cannot overflow an int.
        for (long divisor = 2; divisor * divisor <= number; divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    public static long factorial(int number) {
        if (number < 0 || number > 20) {
            throw new IllegalArgumentException("Supported range: 0..20");
        }
        long result = 1;
        for (int factor = 2; factor <= number; factor++) {
            result = result * factor;
        }
        return result;
    }

    public static long fibonacci(int number) {
        if (number < 0 || number > 92) {
            throw new IllegalArgumentException("Supported range: 0..92");
        }
        if (number == 0) {
            return 0;
        }
        long previous = 0;
        long current = 1;
        for (int position = 2; position <= number; position++) {
            long next = previous + current;
            previous = current;
            current = next;
        }
        return current;
    }
}
