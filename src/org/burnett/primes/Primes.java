package org.burnett.primes;

import java.util.ArrayList;
import java.util.List;

public class Primes {
    
    public List<Integer> getSingleDigitPrimes() {
        ArrayList<Integer> primes = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    public List<Integer> findPrimesIn(List<Integer> candidates) {
        List<Integer> primes = new ArrayList<Integer>();
        for (Integer candidate : candidates) {
            if (isPrime(candidate)) {
                primes.add(candidate);
            }
        }
        return primes;
    }

    public boolean isPrime(int candidate) {
        if (candidate == 0 || candidate == 1) {
            return false;
        }

        for (int possibleFactor = 2; possibleFactor <= maxFactorToCheck(candidate); possibleFactor++) {
            if (candidate % possibleFactor == 0)
                return false;
        }
        return true;
    }

    private int maxFactorToCheck(int candidate) {
        return (int) Math.sqrt((double) candidate);
    }

}
