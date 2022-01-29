package codility.lesson11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <pre>
 * A prime is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are
 * 2, 3, 5, 7, 11 and 13.
 *
 * A semiprime is a natural number that is the product of two (not necessarily distinct) prime numbers. The first few
 * semiprimes are 4, 6, 9, 10, 14, 15, 21, 22, 25, 26.
 *
 * You are given two non-empty arrays P and Q, each consisting of M integers. These arrays represent queries about the
 * number of semiprimes within specified ranges.
 *
 * Query K requires you to find the number of semiprimes within the range (P[K], Q[K]), where 1 ≤ P[K] ≤ Q[K] ≤ N.
 *
 * For example, consider an integer N = 26 and arrays P, Q such that:
 *     P[0] = 1    Q[0] = 26
 *     P[1] = 4    Q[1] = 10
 *     P[2] = 16   Q[2] = 20
 *
 * The number of semiprimes within each of these ranges is as follows:
 * (1, 26) is 10,
 * (4, 10) is 4,
 * (16, 20) is 0.
 *
 * Write a function:
 *
 * class Solution { public int[] solution(int N, int[] P, int[] Q); }
 *
 * that, given an integer N and two non-empty arrays P and Q consisting of M integers, returns an array consisting of
 * M elements specifying the consecutive answers to all the queries.
 *
 * For example, given an integer N = 26 and arrays P, Q such that:
 *     P[0] = 1    Q[0] = 26
 *     P[1] = 4    Q[1] = 10
 *     P[2] = 16   Q[2] = 20
 * the function should return the values [10, 4, 0], as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 * - N is an integer within the range [1..50,000];
 * - M is an integer within the range [1..30,000];
 * - each element of arrays P and Q is an integer within the range [1..N];
 * - P[i] ≤ Q[i].
 * </pre>
 * @see <a href="https://app.codility.com/programmers/lessons/11-sieve_of_eratosthenes/count_semiprimes/">
 *     app.codility.com/programmers/lessons/11-sieve_of_eratosthenes/count_semiprimes</a>
 *
 * @author Marco Foroni
 */
public class CountSemiprimes {

    /**
     * Idea: Use sieve of Eratosthenes for computing all prime numbers between 1 and N. For each prime number P1 less
     * than SQRT(N) and for each other prime factor P2 we have that P1*P2 is a semi-prime. Then use prefix sum to
     * retrieve the number of semi-primes for each slice in constant time.<br>
     * <br>
     * Time complexity is O(N*loglogN + SQRT(N)*N?)<br>
     * Space complexity is O(N)
     *
     * @see <a href="https://app.codility.com/demo/results/trainingS35BAS-3ZQ/">
     *     app.codility.com/demo/results/trainingS35BAS-3ZQ</a>
     */
    public int[] solution(int N, int[] P, int[] Q) {
        final boolean[] sieve = sieve(N);
        final boolean[] semiPrime = new boolean[N + 1];
        for (int i = 1; i <= Math.sqrt(N); i++) {
            if (sieve[i]) {
                for (int j = i; j * i <= N; j++) {
                    if (sieve[j]) {
                        semiPrime[i * j] = true;
                    }
                }
            }
        }
        //printSemiPrimes(semiPrime);
        final int[] semiPrimesPrefixSum = new int[N + 1];
        semiPrimesPrefixSum[0] = 0;
        for (int i = 1; i <= N; i++) {
            semiPrimesPrefixSum[i] = semiPrime[i] ? semiPrimesPrefixSum[i - 1] + 1 : semiPrimesPrefixSum[i - 1];
        }
        final int[] result = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            result[i] = semiPrimesPrefixSum[Q[i]] - semiPrimesPrefixSum[P[i] - 1];
        }
        return result;
    }

    /**
     * Idea: Use sieve of Eratosthenes for computing all prime numbers between 1 and N. Then for each couple of prime
     * number compute the semi-primes number till N. Use prefix sum to retrieve the number of semi-primes for each
     * slice in constant time.
     */
    static class SubOptimal {

        /**
         * Time complexity is O(N^2/logN^2 + N*loglogN)
         *
         * @see <a href="https://app.codility.com/demo/results/trainingBWJPPR-ZCK/">
         *     app.codility.com/demo/results/trainingBWJPPR-ZCK</a>
         */
        public int[] solution(int N, int[] P, int[] Q) {
            final boolean[] isSemiPrime = isSemiPrime(N);
            //printSemiPrimes(isSemiPrime);
            final int[] semiPrimes = new int[N + 1];
            semiPrimes[0] = 0;
            for (int i = 1; i <= N; i++) {
                semiPrimes[i] = isSemiPrime[i] ? semiPrimes[i - 1] + 1 : semiPrimes[i - 1];
            }
            //System.out.println(Arrays.toString(semiPrimes));
            final int m = P.length;
            final int[] result = new int[m];
            for (int i = 0; i < m; i++) {
                result[i] = semiPrimes[Q[i]] - semiPrimes[P[i] - 1];
            }
            return result;
        }

        /**
         * Time complexity is O(P^2) where P is the number of prime numbers between 1 and N. <br>
         * P is asymptotic to N / logN<br>
         * So the time complexity is O(N^2/logN^2)
         *
         * @see <a href="https://primes.utm.edu/howmany.html#pnt">The Prime Number Theorem</a>
         */
        private boolean[] isSemiPrime(final int N) {
            final boolean[] isSemiPrime = new boolean[N + 1];
            isSemiPrime[0] = false;
            isSemiPrime[1] = false;
            final List<Integer> primes = primes(N);
            for (int i = 0; i < primes.size(); i++) {
                for (int j = i; j < primes.size(); j++) {
                    final int p1 = primes.get(i);
                    final int p2 = primes.get(j);
                    final long result = (long) p1 * (long) p2;
                    if (result <= N) {
                        isSemiPrime[p1 * p2] = true;
                    } else {
                        break;
                    }
                }
            }
            return isSemiPrime;
        }
    }

    /**
     * Time complexity is O(N*loglogN)
     */
    private static List<Integer> primes(final int n) {
        final boolean[] sieve = sieve(n);
        final List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (sieve[i]) {
                primes.add(i);
            }
        }
        //System.out.println("Primes: " + primes);
        return primes;
    }

    /**
     * Time complexity is O(N*loglogN)
     */
    private static boolean[] sieve(final int n) {
        final boolean[] sieve = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            sieve[i] = true;
        }
        sieve[0] = false;
        sieve[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (sieve[i]) {
                int k = i * i;
                while (k <= n) {
                    sieve[k] = false;
                    k += i;
                }
            }
        }
        return sieve;
    }

    static class ExhaustiveSearch {

        /**
         * Time complexity is O(M*(N/logN)^4)
         * @see <a href="https://app.codility.com/demo/results/training687E7B-734/">app.codility.com/demo/results/training687E7B-734</a>
         */
        public int[] solution(int N, int[] P, int[] Q) {
            final boolean[] isSemiPrime = isSemiPrime(N);
            final int m = P.length;
            final int[] result = new int[m];
            for (int i = 0; i < m; i++) {
                result[i] = countSemiPrimes(P[i], Q[i], isSemiPrime);
            }
            return result;
        }

        /**
         * Time complexity is O((N/logN)^4)
         *
         */
        private int countSemiPrimes(final int min, final int max, final boolean[] isSemiPrime) {
            assert max < isSemiPrime.length;
            int counter = 0;
            for (int i = min; i <= max; i++) {
                if (isSemiPrime[i]) {
                    counter += 1;
                }
            }
            return counter;
        }

        /**
         * Time complexity is O((N/logN)^3)
         */
        private boolean[] isSemiPrime(final int N) {
            final List<Integer> primes = primes(N);
            final boolean[] isSemiPrime = new boolean[N + 1];
            isSemiPrime[0] = false;
            for (int i = 1; i <= N; i++) {
                isSemiPrime[i] = isSemiPrime(i, primes);
            }
            return isSemiPrime;
        }

        /**
         * Time complexity is O((N/logN)^2)
         */
        private boolean isSemiPrime(final int n, final List<Integer> primes) {
            for (int i = 0; i < primes.size(); i++) {
                for (int j = i; j < primes.size(); j++) {
                    if (primes.get(i) * primes.get(j) == n) {
                        return true;
                    }
                    if (primes.get(i) * primes.get(j) > n) {
                        break;
                    }
                }
            }
            return false;
        }
    }

    private static void printSemiPrimes(final boolean[] isSemiPrime) {
        for (int i = 0; i < isSemiPrime.length; i++) {
            if (isSemiPrime[i]) {
                System.out.print(i + ", ");
            }
        }
        System.out.println();
    }
}
