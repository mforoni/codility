package codility.lesson15;

import codility.util.MoreInts;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AbsDistinctTest {

    private static final int NUM_TESTS = 200;
    private static final int MIN_N = 1;
    private static final int MAX_N = 100_000;
    private static final int MIN_INT = Integer.MIN_VALUE;
    private static final int MAX_INT = Integer.MAX_VALUE;

    private static final int[] A1 = { -5, -3, -1, 0, 3, 6};
    private static final int SOL1 = 5;

    private static final int[] A2 = { 100 };
    private static final int SOL2 = 1;

    private static final int[] A3 = { 1, 1 };
    private static final int SOL3 = 1;

    private static final int[] A4 = { -2147483648, -1, 0, 1 };
    private static final int SOL4 = 3;

    @Test
    void solution() {
        final AbsDistinct absDistinct = new AbsDistinct();
        assertEquals(SOL1, absDistinct.solution(A1));
        assertEquals(SOL2, absDistinct.solution(A2));
        assertEquals(SOL3, absDistinct.solution(A3));
        assertEquals(SOL4, absDistinct.solution(A4));
    }

    @Test
    void subOptimal() {
        assertEquals(SOL1, AbsDistinct.subOptimal(A1));
        assertEquals(SOL2, AbsDistinct.subOptimal(A2));
        assertEquals(SOL3, AbsDistinct.subOptimal(A3));
        assertEquals(SOL4, AbsDistinct.subOptimal(A4));
    }

    @Test
    void solutionRandomInput() {
        final AbsDistinct absDistinct = new AbsDistinct();
        for (int t = 0; t < NUM_TESTS; t++) {
            final int N = MoreInts.newRandom(MIN_N, MAX_N);
            final int[] A = MoreInts.newRandomArray(N, MIN_INT, MAX_INT - 1);
            Arrays.sort(A);
            final int expected = AbsDistinct.subOptimal(A);
            final int actual = absDistinct.solution(A);
            if (expected != actual) {
                System.out.printf("N = %d, A = %s", N, Arrays.toString(A));
            }
            assertEquals(expected, actual);
        }
    }
}