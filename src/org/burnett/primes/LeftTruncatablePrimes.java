package org.burnett.primes;

import java.util.ArrayList;
import java.util.List;

public class LeftTruncatablePrimes {


    Primes primes = new Primes();
    int indexForSet;
    public List<Integer> currentValues;

    public int forIndex(int oneBasedIndex) {
        initialiseIndexFromOneBasedIndex(oneBasedIndex);
        getFirstSetOfValues();
        while (!currentSetContainsIndex()) {
            getNextSetOfValues();
        }
        return getValueForIndex();
    }

    private void initialiseIndexFromOneBasedIndex(int oneBasedIndex) {
        indexForSet = oneBasedIndex - 1;
    }

    private void getFirstSetOfValues() {
        currentValues = primes.getSingleDigitPrimes();
    }

    private boolean currentSetContainsIndex() {
        return currentValues.size() > indexForSet;
    }

    private void getNextSetOfValues() {
        indexForSet -= currentValues.size();
        currentValues = primes.findPrimesIn(getNextOrderOfCandidates(currentValues));
    }

    private Integer getValueForIndex() {
        return currentValues.get(indexForSet);
    }

    private List<Integer> getNextOrderOfCandidates(List<Integer> rightSideDigits) {
        List<Integer> candidates = new ArrayList<Integer>();
        for (int leftDigit = 1; leftDigit < 10; leftDigit++) {
            for (Integer rightSideValue : rightSideDigits) {
                candidates.add(addLeftSideDigit(leftDigit, rightSideValue));
            }
        }
        return candidates;
    }

    private int addLeftSideDigit(Integer leftDigit, Integer rightSideValue) {
        return Integer.parseInt(leftDigit.toString() + rightSideValue.toString());
    }


}
