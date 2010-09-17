package org.burnett.primes;

import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LeftTruncatablePrimesTests {

    private LeftTruncatablePrimes calculator;

    @Before
    public void setup() {
        calculator = new LeftTruncatablePrimes();
    }


    @Test
    public void getThirdLTP() {
        assertEquals(5, calculator.forIndex(3));
    }

    @Test
    public void get10thLtp() {
        assertEquals(47, calculator.forIndex(10));
    }

    @Test
    public void get20thLtp() {
        assertEquals(197, calculator.forIndex(20));
    }

    @Test
    public void getOneHundredthLeftTruncatablePrime() {
        assertEquals(5167, calculator.forIndex(100));
    }

    @Test
    public void getOneThousandthLeftTruncatablePrime() {
        assertEquals(8391283, calculator.forIndex(1000));
    }


    @Test
    public void getHighOrderLtpInUnder500ms() {
        long timeTaken = getTimeForCalculatingLeftTruncatablePrime(Console.MAX_INDEX);
        assertTrue("took too long: " + timeTaken, timeTaken < 500);
    }

    private long getTimeForCalculatingLeftTruncatablePrime(int order) {
        long startTime = System.currentTimeMillis();
        calculator.forIndex(order);
        return System.currentTimeMillis() - startTime;
    }


}
