package codility.lesson15;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 * A non-empty array A consisting of N numbers is given. The array is sorted in non-decreasing order. The absolute
 * distinct count of this array is the number of distinct absolute values among the elements of the array.
 *
 * For example, consider array A such that:
 *   A[0] = -5
 *   A[1] = -3
 *   A[2] = -1
 *   A[3] =  0
 *   A[4] =  3
 *   A[5] =  6
 *
 * The absolute distinct count of this array is 5, because there are 5 distinct absolute values among the elements of
 * this array, namely 0, 1, 3, 5 and 6.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given a non-empty array A consisting of N numbers, returns absolute distinct count of array A.
 *
 * For example, given array A such that:
 *   A[0] = -5
 *   A[1] = -3
 *   A[2] = -1
 *   A[3] =  0
 *   A[4] =  3
 *   A[5] =  6
 *
 * the function should return 5, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 * - N is an integer within the range [1..100,000];
 * - each element of array A is an integer within the range [−2,147,483,648..2,147,483,647];
 * - array A is sorted in non-decreasing order.
 * </pre>
 * @see <a href="https://app.codility.com/programmers/lessons/15-caterpillar_method/abs_distinct/">
 *     app.codility.com/programmers/lessons/15-caterpillar_method/abs_distinct/</a>
 *
 * @author Marco Foroni
 */
public class AbsDistinct {


    /**
     * Idea: Use caterpillar method, i.e. two indexes s, e the first pointing at the beginning of array A while the
     * second pointing at the end. At each step we need to compare both indexes with the respective previous value to
     * ensure the absolute value is different and with each other:
     * abs(A[s]) != abs(A[s - 1])
     * abs(A[e]) != abs(A[e + 1])
     * abs(A[s]) != abs(A[e])
     *
     * Time complexity is O(N)<br>
     * Space complexity is O(1)
     *
     * @see <a href="https://app.codility.com/demo/results/trainingZC7FMM-D2S/">
     *     app.codility.com/demo/results/trainingZC7FMM-D2S/</a>
     */
    public int solution(int[] A) {
//        System.out.println(Arrays.toString(A));
        final int N = A.length;
        assert N >= 1;
        int sum = 0, s = 0, e = N - 1;
        for (;s <= e;) {
//            System.out.printf("s = %d, e = %d, sum = %d%n", s, e, sum);
            if (s == e) {
                if ((s == 0 || Math.abs(A[s]) != Math.abs(A[s - 1]))) {
                    sum += 1;
                }
                s++;
            } else {
                if (s > 0 && Math.abs(A[s]) == Math.abs(A[s - 1])) {
                    s++;
                }
                else if (e < N - 1 && Math.abs(A[e]) == Math.abs(A[e + 1])) {
                    e--;
                }
                else if (Math.abs(A[s]) == Math.abs(A[e])) {
                    sum += 1;
                    s++;
                    e--;
                }
                else if (A[s] == Integer.MIN_VALUE || Math.abs(A[s]) > Math.abs(A[e])) {
                    sum += 1;
                    s++;
                }
                else if (Math.abs(A[s]) < Math.abs(A[e])) {
                    sum += 1;
                    e--;
                }
            }
        }
        return sum;
    }

    /**
     * Idea: Use Set to count occurrences of absolute values in A.<br>
     * <br>
     * Time complexity is O(N)<br>
     * Space complexity is O(N)
     *
     * @see <a href="https://app.codility.com/demo/results/trainingUQPVYU-C9V/">
     *     app.codility.com/demo/results/trainingUQPVYU-C9V/</a>
     */
    public static int subOptimal(int[] A) {
        final Set<Integer> set = new HashSet<>();
        for (int a : A) {
            set.add(Math.abs(a));
        }
        return set.size();
    }
}
