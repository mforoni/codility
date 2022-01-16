package codility.lesson13;

import java.math.BigInteger;

/**
 * <pre>
 * You have to climb up a ladder. The ladder has exactly N rungs, numbered from 1 to N. With each step, you can ascend
 * by one or two rungs. More precisely:
 * - with your first step you can stand on rung 1 or 2,
 * - if you are on rung K, you can move to rungs K + 1 or K + 2,
 * - finally you have to stand on rung N.
 *
 * Your task is to count the number of different ways of climbing to the top of the ladder.
 *
 * For example, given N = 4, you have five different ways of climbing, ascending by:
 * - 1, 1, 1 and 1 rung,
 * - 1, 1 and 2 rungs,
 * - 1, 2 and 1 rung,
 * - 2, 1 and 1 rungs, and
 * - 2 and 2 rungs.
 *
 * Given N = 5, you have eight different ways of climbing, ascending by:
 * - 1, 1, 1, 1 and 1 rung,
 * - 1, 1, 1 and 2 rungs,
 * - 1, 1, 2 and 1 rung,
 * - 1, 2, 1 and 1 rung,
 * - 1, 2 and 2 rungs,
 * - 2, 1, 1 and 1 rungs,
 * - 2, 1 and 2 rungs, and
 * - 2, 2 and 1 rung.
 *
 * The number of different ways can be very large, so it is sufficient to return the result modulo 2^P, for a given
 * integer P.
 *
 * Write a function:
 *
 * class Solution { public int[] solution(int[] A, int[] B); }
 *
 * that, given two non-empty arrays A and B of L integers, returns an array consisting of L integers specifying the
 * consecutive answers; position I should contain the number of different ways of climbing the ladder with A[I] rungs
 * modulo 2^(B[I]).
 *
 * For example, given L = 5 and:
 *     A[0] = 4   B[0] = 3
 *     A[1] = 4   B[1] = 2
 *     A[2] = 5   B[2] = 4
 *     A[3] = 5   B[3] = 3
 *     A[4] = 1   B[4] = 1
 *
 * the function should return the sequence [5, 1, 8, 0, 1], as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 * - L is an integer within the range [1..50,000];
 * - each element of array A is an integer within the range [1..L];
 * - each element of array B is an integer within the range [1..30].
 * </pre>
 * @see <a href="https://app.codility.com/programmers/lessons/13-fibonacci_numbers/ladder/">
 *     app.codility.com/programmers/lessons/13-fibonacci_numbers/ladder</a>
 *
 * @author Marco Foroni
 */
public class Ladder {
    /**
     * Idea: Be W(n) the number of ways to climb a ladder of n rungs. This is the same to compute the (n+1)-th
     * fibonacci number. Compute the max value in A and compute once fibonacci numbers till max.
     * <p>
     * Use BigInteger to avoid overflows.
     * </p>
     * Time complexity is O(L)<br>
     * Space complexity is O(L)
     * @see <a href="https://app.codility.com/demo/results/training24YF5C-HKZ/">
     *     app.codility.com/demo/results/training24YF5C-HKZ</a>
     */
    public int[] solution(int[] A, int[] B) {
        assert A.length == B.length;
        final int L = A.length;
        int max = A[0];
        for (int i = 1; i < L; i++) {
            max = Math.max(max, A[i]);
        }
        final BigInteger[] fib = fibonacci(max + 1);
        final int[] result = new int[L];
        for (int i = 0; i < L; i++) {
            BigInteger ways = fib[A[i] + 1];
            final int modulo = (int) Math.pow(2, B[i]); // 2^30 < Integer.MAX_VALUE
            ways = ways.mod(BigInteger.valueOf(modulo));
            result[i] = ways.intValue();
        }
        return result;
    }

    /**
     * Time complexity is O(N)<br>
     * Space complexity is O(N)
     *
     * @param n
     * @return
     */
    static BigInteger[] fibonacci(int n) {
        final BigInteger[] fib = new BigInteger[n + 1];
        fib[0] = BigInteger.ZERO;
        fib[1] = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            BigInteger result = fib[i - 1];
            result = result.add(fib[i - 2]);
            fib[i] = result;
        }
        return fib;
    }

    /**
     * Idea: Be W(n) the number of ways to climb a ladder of n rungs. This is the same to compute the (n+1)-th
     * fibonacci number.
     * <p>
     * Use BigInteger to avoid overflows.
     * </p>
     */
    static class ExhaustiveSearch {
        /**
         * Time complexity is O(L*N) where N is the maximum value in array A, therefore it is O(L^2)<br>
         * Space complexity is O(L)
         * @see <a href="https://app.codility.com/demo/results/training2NDAYE-4PG/">
         *     app.codility.com/demo/results/training2NDAYE-4PG</a>
         */
        public int[] solution(int[] A, int[] B) {
            assert A.length == B.length;
            final int L = A.length;
            final int[] result = new int[L];
            for (int i = 0; i < L; i++) {
                BigInteger ways = fibonacci(A[i] + 1);
                final int modulo = (int) Math.pow(2, B[i]); // 2^30 < Integer.MAX_VALUE
                ways = ways.mod(BigInteger.valueOf(modulo));
                result[i] = ways.intValue();
            }
            return result;
        }

        /**
         * Time complexity is O(N)<br>
         * Space complexity is O(1)
         */
        private BigInteger fibonacci(int n) {
            if (n == 0) {
                return BigInteger.ZERO;
            } else if (n == 1) {
                return BigInteger.ONE;
            }
            BigInteger fib0 = BigInteger.ZERO;
            BigInteger fib1 = BigInteger.ONE;
            BigInteger fib2 = fib1.add(fib0);
            for (int i = 2; i <= n; i++) {
                fib2 = fib1.add(fib0);
                fib0 = fib1;
                fib1 = fib2;
            }
            return fib2;
        }
    }

    /**
     * <pre>
     * Idea:
     * Be W(n) the number of ways to climb a ladder of n rungs.
     * W(0) = 0
     * W(1) = 1
     * W(2) = 2
     * W(3) = W(1) + W(2)
     * ...
     * W(n) = W(n-1) + W(n-2)
     * </pre>
     * This is the same to compute the (n+1)-th fibonacci number.
     */
    static class NumberOfWaysToClimbTheLadder {

        /**
         * Recursive approach to compute the fibonacci sequence till n equal to the number of rungs plus 1.
         * <p>
         * Time complexity is O(2^N)<br>
         * Space complexity is O(N)
         * </p>
         */
        public int recursiveSolution(final int rungs) {
            final Fibonacci fibonacci = new Fibonacci();
            return fibonacci.recursive(rungs + 1);
        }

        /**
         * Iterative approach to compute the fibonacci sequence till n equal to the number of rungs.
         * <p>
         * Time complexity is O(N)<br>
         * Space complexity is O(N)
         * </p>
         */
        public int iterativeSolution(final int rungs) {
            final Fibonacci fibonacci = new Fibonacci();
            return fibonacci.iterative(rungs + 1);
        }
    }

    /**
     * @see <a href="https://en.wikipedia.org/wiki/Fibonacci_number">en.wikipedia.org/wiki/Fibonacci_number</a>
     */
    static class Fibonacci {
        /**
         * Time complexity is O(2^N)<br>
         * Space complexity is O(N)
         */
        public int recursive(final int n) {
            if (n == 0) {
                return 0;
            } else if (n == 1) {
                return 1;
            } else {
                return recursive(n - 1) + recursive(n - 2);
            }
        }

        /**
         * Time complexity is O(N)<br>
         * Space complexity is O(N)
         */
        public int iterative(int n) {
            final int[] fib = new int[n + 1];
            fib[0] = 0;
            fib[1] = 1;
            for (int i = 2; i <= n; i++) {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
            return fib[n];
        }

        public BigInteger iterativeNoOverflow(int n) {
            final BigInteger[] fib = new BigInteger[n + 1];
            fib[0] = BigInteger.ZERO;
            fib[1] = BigInteger.ONE;
            for (int i = 2; i <= n; i++) {
                BigInteger result = fib[i - 1];
                result = result.add(fib[i - 2]);
                fib[i] = result;
            }
            return fib[n];
        }

        /**
         * Time complexity is O(N)<br>
         * Space complexity is O(1)
         */
        public int optimal(int n) {
            if (n <= 1) {
                return n;
            }
            int fib0 = 0;
            int fib1 = 1;
            int fib2 = fib1 + fib0;
            for (int i = 2; i <= n; i++) {
                fib2 = fib1 + fib0;
                fib0 = fib1;
                fib1 = fib2;
            }
            return fib2;
        }

        /**
         * Time complexity is O(N)<br>
         * Space complexity is O(1)
         */
        public long optimalLong(int n) {
            if (n <= 1) {
                return n;
            }
            long fib0 = 0;
            long fib1 = 1;
            long fib2 = fib1 + fib0;
            for (int i = 2; i <= n; i++) {
                fib2 = fib1 + fib0;
                fib0 = fib1;
                fib1 = fib2;
            }
            return fib2;
        }

        /**
         * Time complexity is O(N)<br>
         * Space complexity is O(1)
         */
        public BigInteger optimalNoOverflow(int n) {
            if (n == 0) {
                return BigInteger.ZERO;
            } else if (n == 1) {
                return BigInteger.ONE;
            }
            BigInteger fib0 = BigInteger.ZERO;
            BigInteger fib1 = BigInteger.ONE;
            BigInteger fib2 = fib1.add(fib0);
            for (int i = 2; i <= n; i++) {
                fib2 = fib1.add(fib0);
                fib0 = fib1;
                fib1 = fib2;
            }
            return fib2;
        }
    }
}
