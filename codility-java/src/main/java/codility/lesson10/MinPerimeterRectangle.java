package codility.lesson10;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * An integer N is given, representing the area of some rectangle.
 *
 * The area of a rectangle whose sides are of length A and B is A * B, and the perimeter is 2 * (A + B).
 *
 * The goal is to find the minimal perimeter of any rectangle whose area equals N. The sides of this rectangle should be only integers.
 *
 * For example, given integer N = 30, rectangles of area 30 are:
 *
 * (1, 30), with a perimeter of 62,
 * (2, 15), with a perimeter of 34,
 * (3, 10), with a perimeter of 26,
 * (5, 6), with a perimeter of 22.
 * Write a function:
 *
 * class Solution { public int solution(int N); }
 *
 * that, given an integer N, returns the minimal perimeter of any rectangle whose area is exactly equal to N.
 *
 * For example, given an integer N = 30, the function should return 22, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..1,000,000,000].
 * </pre>
 *
 * @see <a href="https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/min_perimeter_rectangle/">
 *     app.codility.com/programmers/lessons/10-prime_and_composite_numbers/min_perimeter_rectangle</a>
 *
 * @author Marco Foroni
 */
public class MinPerimeterRectangle {

    /**
     * Idea: Find all divisors of N till SQRT(N), compute the other divisor and the perimeter. Find the minimum value
     * for the perimeter.<br>
     * <br>
     * Time complexity is O(SQRT(N))
     * Space complexity is O(SQRT(N))
     *
     * @see <a href="https://app.codility.com/demo/results/training7WEHJN-KN8/">
     *     app.codility.com/demo/results/training7WEHJN-KN8</a>
     */
    public int solution(int N) {
        final List<Integer> divisors = divisors(N);
        int min = Integer.MAX_VALUE;
        for (int divisor : divisors) {
            int perimeter = 2 * (divisor + N / divisor);
            min = Math.min(min, perimeter);
        }
        return min;
    }

    private static List<Integer> divisors(final int n) {
        final List<Integer> divisors = new ArrayList<>();
        int i = 1;
        for (; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                divisors.add(i);
            }
        }
        if (i * i == n) {
            divisors.add(i);
        }
        return divisors;
    }
}
