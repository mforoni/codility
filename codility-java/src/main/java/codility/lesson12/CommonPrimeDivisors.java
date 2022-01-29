package codility.lesson12;

import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 * A prime is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are
 * 2, 3, 5, 7, 11 and 13.
 *
 * A prime D is called a prime divisor of a positive integer P if there exists a positive integer K such that D * K = P.
 * For example, 2 and 5 are prime divisors of 20.
 *
 * You are given two positive integers N and M. The goal is to check whether the sets of prime divisors of integers N
 * and M are exactly the same.
 *
 * For example, given:
 * - N = 15 and M = 75, the prime divisors are the same: {3, 5};
 * - N = 10 and M = 30, the prime divisors aren't the same: {2, 5} is not equal to {2, 3, 5};
 * - N = 9 and M = 5, the prime divisors aren't the same: {3} is not equal to {5}.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A, int[] B); }
 *
 * that, given two non-empty arrays A and B of Z integers, returns the number of positions K for which the prime
 * divisors of A[K] and B[K] are exactly the same.
 *
 * For example, given:
 *     A[0] = 15   B[0] = 75
 *     A[1] = 10   B[1] = 30
 *     A[2] = 3    B[2] = 5
 *
 * the function should return 1, because only one pair (15, 75) has the same set of prime divisors.
 *
 * Write an efficient algorithm for the following assumptions:
 * - Z is an integer within the range [1..6,000];
 * - each element of arrays A and B is an integer within the range [1..2,147,483,647].
 * </pre>
 * @see <a href="https://app.codility.com/programmers/lessons/12-euclidean_algorithm/common_prime_divisors/">
 *     app.codility.com/programmers/lessons/12-euclidean_algorithm/common_prime_divisors</a>
 *
 * @author Marco Foroni
 */
public class CommonPrimeDivisors {

    /**
     * Time complexity is O(Z * logN) where Z is the length of arrays A and B and N is the maximum value in A and B.
     *
     * @see <a href="https://app.codility.com/demo/results/trainingTHZFUT-XWK/">
     *     app.codility.com/demo/results/trainingTHZFUT-XWK</a>
     */
    public int solution(int[] A, int[] B) {
        assert A.length == B.length;
        int counter = 0;
        for (int i = 0; i < A.length; i++) {
            if (hasCommonPrimeDivisor(A[i], B[i])) {
                //System.out.printf("%d and %d have common prime divisors%n", A[i], B[i]);
                counter += 1;
            }
        }
        return counter;
    }

    /**
     * Time complexity is O(log(A)+log(B))
     */
    private static boolean hasCommonPrimeDivisor(int a, int b) {
        if (a == b) {
            return true;
        }
        if (a == 1 || b == 1) {
            return false;
        }
        final int gcdAB = gcd(a, b);
        while (a != 1) {
            int gcdA = gcd(a, gcdAB);
            if (gcdA == 1) {
                break;
            }
            a = a / gcdA;
        }
        if (a != 1) {
            return false;
        }
        while (b != 1) {
            int gcdB = gcd(b, gcdAB);
            if (gcdB == 1) {
                break;
            }
            b = b / gcdB;
        }
        return b == 1;
    }

    /**
     * Euclidean algorithm by division.<br>
     * <br>
     * Time complexity is O(log(a + b))<br>
     * Space complexity is O(1)
     */
    private static int gcd(int a, int b) {
        final int modulo = a % b;
        return modulo == 0 ? b : gcd(b, modulo);
    }

    /**
     * Time complexity is O(Z * N*loglogN) where Z is the length of arrays A and B and N is the maximum value in arrays
     * A and B.<br>
     * Space complexity is O(N).
     *
     * @see <a href="https://app.codility.com/demo/results/trainingN3FDQF-F56/">
     *     app.codility.com/demo/results/trainingN3FDQF-F56</a>
     */
    public static int exhaustiveSearch(int[] A, int[] B) {
        assert A.length == B.length;
        int counter = 0;
        for (int i = 0; i < A.length; i++) {
            final Set<Integer> setA = primeDivisors(A[i]);
            final Set<Integer> setB = primeDivisors(B[i]);
            final boolean result = setA.equals(setB);
            //System.out.printf("i=%d, A[i]=%d, B[i]=%d, PD_A=%s, PD_B=%s, %s%n", i, A[i], B[i], setA, setB, result);
            if (result) {
                counter += 1;
            }
        }
        return counter;
    }

    /**
     * Time complexity is O(N + N*loglogN)<br>
     * Space complexity is O(N)
     */
    static Set<Integer> primeDivisors(final int n) {
        final boolean[] sieve = sieve(n);
        final Set<Integer> set = new HashSet<>();
        for (int i = 1; i < n; i++) {
            if (sieve[i] && n % i == 0) {
                set.add(i);
                final int factor = n / i;
                if (sieve[factor]) {
                    set.add(factor);
                }
            }
        }
        if (sieve[n]) {
            set.add(n);
        }
        return set;
    }

    /**
     * Time complexity is O(N*loglogN)<br>
     * Space complexity is O(N)
     */
    private static boolean[] sieve(final int n) {
        final boolean[] sieve = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            sieve[i] = true;
        }
        sieve[0] = false;
        sieve[1] = false; // 1 is not considered a prime number in mathematics
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
}
