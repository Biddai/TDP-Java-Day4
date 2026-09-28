package tdp.additionalexercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
class MathFunctionsTest  {
    @ParameterizedTest @CsvSource({"-1,false", "0,false", "1,false", "2,true", "3,true", "4,false", "9,false", "25,false", "97,true"})
    void classifiesPrimes(int n, boolean expected)  {
        assertEquals(expected, MathFunctions.isPrime(n));
    }
    @ParameterizedTest @CsvSource({"0,1", "1,1", "5,120", "20,2432902008176640000"})
    void computesFactorial(int n, long expected)  {
        assertEquals(expected, MathFunctions.factorial(n));
    }
    @ParameterizedTest @ValueSource(ints={-1,21})
    void rejectsUnsupportedFactorialInputs(int n)  {
        assertThrows(IllegalArgumentException.class, () -> MathFunctions.factorial(n));
    }
    @ParameterizedTest @CsvSource({"0,0", "1,1", "2,1", "10,55", "92,7540113804746346429"})
    void computesFibonacci(int n, long expected)  {
        assertEquals(expected, MathFunctions.fibonacci(n));
    }
    @ParameterizedTest @ValueSource(ints={-1,93})
    void rejectsUnsupportedFibonacciInputs(int n)  {
        assertThrows(IllegalArgumentException.class, () -> MathFunctions.fibonacci(n));
    }
}
