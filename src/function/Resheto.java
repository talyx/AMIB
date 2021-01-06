package function;

import java.util.Arrays;
import java.util.Scanner;

public class Resheto {
    boolean[] primes;

    public boolean[] Eratosfen(int n) {
        primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i < primes.length; ++i) {
            if (primes[i]) {
                for (int j = 2; i * j < primes.length; ++j) {
                    primes[i * j] = false;
                }
            }
        }
        return primes;
    }


}

