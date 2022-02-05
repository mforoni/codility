package codility.lesson14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * You are given integers K, M and a non-empty array A consisting of N integers. Every element of the array is not
 * greater than M.
 *
 * You should divide this array into K blocks of consecutive elements. The size of the block is any integer between 0
 * and N. Every element of the array should belong to some block.
 *
 * The sum of the block from X to Y equals A[X] + A[X + 1] + ... + A[Y]. The sum of empty block equals 0.
 *
 * The large sum is the maximal sum of any block.
 *
 * For example, you are given integers K = 3, M = 5 and array A such that:
 *   A[0] = 2
 *   A[1] = 1
 *   A[2] = 5
 *   A[3] = 1
 *   A[4] = 2
 *   A[5] = 2
 *   A[6] = 2
 *
 * The array can be divided, for example, into the following blocks:
 * [2, 1, 5, 1, 2, 2, 2], [], [] with a large sum of 15;
 * [2], [1, 5, 1, 2], [2, 2] with a large sum of 9;
 * [2, 1, 5], [], [1, 2, 2, 2] with a large sum of 8;
 * [2, 1], [5, 1], [2, 2, 2] with a large sum of 6.
 *
 * The goal is to minimize the large sum. In the above example, 6 is the minimal large sum.
 *
 * Write a function:
 *
 * class Solution { public int solution(int K, int M, int[] A); }
 *
 * that, given integers K, M and a non-empty array A consisting of N integers, returns the minimal large sum.
 *
 * For example, given K = 3, M = 5 and array A such that:
 *   A[0] = 2
 *   A[1] = 1
 *   A[2] = 5
 *   A[3] = 1
 *   A[4] = 2
 *   A[5] = 2
 *   A[6] = 2
 * the function should return 6, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 * - N and K are integers within the range [1..100,000];
 * - M is an integer within the range [0..10,000];
 * - each element of array A is an integer within the range [0..M].
 * </pre>
 *
 * @see <a href="https://app.codility.com/programmers/lessons/14-binary_search_algorithm/min_max_division/">
 *     app.codility.com/programmers/lessons/14-binary_search_algorithm/min_max_division</a>
 *
 * @author Marco Foroni
 */
public class MinMaxDivision {

    /**
     * Idea:
     * <ul>
     *  <li>if K = 1 return the sum of all elements in A</li>
     *  <li>if K = N return the max elements of array A</li>
     * </ul>
     * Use binary search on the possible solutions MaxA,...,SumA<br>
     * <br>
     * Time complexity is (logN*M + N)<br>
     * Space complexity is O(1)
     *
     * @see <a href="https://app.codility.com/demo/results/training2GYSCK-36R/">
     *     app.codility.com/demo/results/training2GYSCK-36R</a>
     */
    public int solution(int K, int M, int[] A) {
        final int maxA = max(A);
        final int sumA = sum(A);
        System.out.printf("A = %s, K = %d, M = %d, maxA = %d, sumA = %d%n", Arrays.toString(A), K, M, maxA, sumA);
        int begin = maxA;
        int end = sumA;
        int result = -1;
        while (begin <= end) {
            int middle = (begin + end) / 2;
            if (checkSolution(A, middle) <= K) {
                end = middle - 1;
                result = middle;
            } else {
                begin = middle + 1;
            }
        }
        return result;
    }

    private int checkSolution(final int[] A, final int sol) {
        int maxSum = 0;
        int sum = 0;
        int groups = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] + sum > sol) {
                sum = A[i];
                maxSum = Math.max(sum, maxSum);
                groups++;
            } else {
                sum += A[i];
                maxSum = Math.max(sum, maxSum);
            }
        }
        System.out.printf("Checking sol = %d, groups = %d, maxSum=%d%n", sol, groups, maxSum);
        return groups;
    }

    private static int max(final int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        return max;
    }

    private static int sum(final int[] array) {
        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    /**
     * Note:
     * <pre>
     *  N-2 1 1
     *  N-3 2 1
     *  ...
     *
     * </pre>
     * @see <a href="https://math.stackexchange.com/questions/1908701/integer-partition-of-n-into-k-parts-recurrence">
     *     Integer partition of n into k parts recurrence</a>
     */
    static int partition(int N, int K) {
        if (N == 0) {
            System.out.printf("N = %d, K = %d, sol = %d%n", N, K, 0);
            return 0;
        }
        if (N < K) {
            System.out.printf("N = %d, K = %d, sol = %d%n", N, K, 0);
            return 0;
        }
        if (N == K) {
            System.out.printf("N = %d, K = %d, sol = %d%n", N, K, 0);
            return 1;
        }
        if (K == 0) {
            System.out.printf("N = %d, K = %d, sol = %d%n", N, K, 0);
            return 0;
        }
        if (K == 1) {
            System.out.printf("N = %d, K = %d, sol = %d%n", N, K, 1);
            return 1;
        }
        final int sol = partition(N - 1, K - 1) + partition(N - K, K);
        System.out.printf("N = %d, K = %d, sol = %d%n", N, K, sol);
        return sol;
    }
}
