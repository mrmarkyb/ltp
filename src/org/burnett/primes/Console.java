package org.burnett.primes;

public class Console {
    public static final String USAGE = "Usage: pass argument that is an index between 0 and 2166";
    public static final int MAX_INDEX = 2166;

    public static void main(String... arguments) {
        try {
            int index = Integer.parseInt(arguments[0]);
            if (0 < index && index <= MAX_INDEX) {
                int ltpForIndex = new LeftTruncatablePrimes().forIndex(index);
                System.out.println(ltpForIndex);
                return;
            }
        }
        catch (Exception e) {
        }
        System.out.println(USAGE);
    }
}
