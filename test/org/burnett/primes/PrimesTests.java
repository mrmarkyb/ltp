package org.burnett.primes;

import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PrimesTests {
    private Primes calculator;

    @Before
    public void setup() {
        calculator = new Primes();
    }

    @Test
    public void detectsTwoAsAPrime() {
        assertTrue(calculator.isPrime(2));
    }


    @Test
    public void detectsThreeAsAPrime() {
        assertTrue(calculator.isPrime(3));
    }

    @Test
    public void detectsFourAsAComposite() {
        assertFalse(calculator.isPrime(4));
    }

    @Test
    public void detectsOneAsANonPrime() {
        assertFalse(calculator.isPrime(1));
    }

    @Test
    public void detectsNineAsComposite() {
        assertFalse(calculator.isPrime(9));
    }


    @Test
    public void gets1DigitPrimes() {
        assertEquals(asList(2, 3, 5, 7), calculator.getSingleDigitPrimes());
    }

    @Test
    public void shouldFilterOutComposites() {
        assertEquals(asList(2, 3, 5, 7), calculator.findPrimesIn(asList(1, 2, 3, 4, 5, 6, 7, 8, 9)));
    }

    @Test
    public void detect43asPrime() {
        assertTrue(calculator.isPrime(43));
    }    
}
