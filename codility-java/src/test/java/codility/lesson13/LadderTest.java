package codility.lesson13;

import codility.util.MoreInts;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    private static final int[] A1 = { 4, 4, 5, 5, 1 };
    private static final int[] B1 = { 3, 2, 4, 3, 1 };
    private static final int[] SOL1 = { 5, 1, 8, 0, 1 };

    /**
     * L is an integer within the range [1..50,000];
     * each element of array A is an integer within the range [1..L];
     * each element of array B is an integer within the range [1..30].
     */
    private static int MIN_L = 1;
    private static int MAX_L = 50_000;
    private static int MAX_B = 30;
    private static final int NUM_TESTS = 200;

    @Test
    void solution() {
        final Ladder ladder = new Ladder();
        assertArrayEquals(SOL1, ladder.solution(A1, B1));
    }

    @Test
    void solutionRandomInput() {
        final Ladder ladder = new Ladder();
        final Ladder.ExhaustiveSearchOptimized exhaustiveSearch = new Ladder.ExhaustiveSearchOptimized();
        for (int t = 0; t < NUM_TESTS; t++) {
            final int L = MoreInts.newRandom(MIN_L, MAX_L / 10);
            final int[] A = MoreInts.newRandomArray(L, 1, L);
            final int[] B = MoreInts.newRandomArray(L, 1, MAX_B);
            final int[] expected = exhaustiveSearch.solution(A, B);
            final int[] actual = ladder.solution(A, B);
            if (!Arrays.equals(expected, actual)) {
                System.out.printf("A = %s, B = %s", Arrays.toString(A), Arrays.toString(B));
            }
            assertArrayEquals(expected, actual);
        }
    }

    @Nested
    class ExhaustiveSearchOptimizedTest {
        private final Ladder.ExhaustiveSearchOptimized target = new Ladder.ExhaustiveSearchOptimized();

        @Test
        void exhaustiveSearch() {
            assertArrayEquals(SOL1, target.solution(A1, B1));
        }

        @Test
        void solutionRandomInput() {
            for (int t = 0; t < NUM_TESTS; t++) {
                final int L = MoreInts.newRandom(MIN_L, MAX_L / 10);
                final int[] A = MoreInts.newRandomArray(L, 1, L);
                final int[] B = MoreInts.newRandomArray(L, 1, MAX_B);
                final int[] sol = target.solution(A, B);
                for (int i = 0; i < sol.length; i++) {
                    assertTrue(sol[i] >= 0);
                }
            }
        }
    }

    @Nested
    class ExhaustiveSearchTest {
        private final Ladder.ExhaustiveSearch target = new Ladder.ExhaustiveSearch();

        @Test
        void exhaustiveSearch() {
            assertArrayEquals(SOL1, target.solution(A1, B1));
        }

        @Test
        void solutionRandomInput() {
            for (int t = 0; t < NUM_TESTS; t++) {
                final int L = MoreInts.newRandom(MIN_L, MAX_L / 100);
                final int[] A = MoreInts.newRandomArray(L, 1, L);
                final int[] B = MoreInts.newRandomArray(L, 1, MAX_B);
                final int[] sol = target.solution(A, B);
                for (int i = 0; i < sol.length; i++) {
                    assertTrue(sol[i] >= 0);
                }
            }
        }
    }

    @Nested
    class NumberOfWaysToClimbTheLadderTest {

        private static final int N1 = 4;
        private static final int SOL1 = 5;

        private static final int N2 = 5;
        private static final int SOL2 = 8;

        final Ladder.NumberOfWaysToClimbTheLadder target = new Ladder.NumberOfWaysToClimbTheLadder();

        @Test
        void recursiveSolution() {
            assertEquals(SOL1, target.recursiveSolution(N1));
            assertEquals(SOL2, target.recursiveSolution(N2));
        }

        @Test
        void iterativeSolution() {
            assertEquals(SOL1, target.iterativeSolution(N1));
            assertEquals(SOL2, target.iterativeSolution(N2));
        }
    }

    @Nested
    class FibonacciTest {

        private static final int N1 = 4;
        private static final int SOL1 = 3;

        private static final int N2 = 5;
        private static final int SOL2 = 5;

        private static final int N3 = 15;
        private static final int SOL3 = 610;

        final Ladder.Fibonacci target = new Ladder.Fibonacci();

        @Test
        void recursive() {
            assertEquals(SOL1, target.recursive(N1));
            assertEquals(SOL2, target.recursive(N2));
            assertEquals(SOL3, target.recursive(N3));
        }

        @Test
        void iterative() {
            assertEquals(SOL1, target.iterative(N1));
            assertEquals(SOL2, target.iterative(N2));
            assertEquals(SOL3, target.iterative(N3));
        }

        @Test
        void iterativeNoOverflow() {
            assertEquals(BigInteger.valueOf(SOL1), target.iterativeNoOverflow(N1));
            assertEquals(BigInteger.valueOf(SOL2), target.iterativeNoOverflow(N2));
            assertEquals(BigInteger.valueOf(SOL3), target.iterativeNoOverflow(N3));
            assertTrue(target.iterativeNoOverflow(50_000).signum() >= 0);
        }

        @Test
        void optimal() {
            assertEquals(SOL1, target.optimal(N1));
            assertEquals(SOL2, target.optimal(N2));
            assertEquals(SOL3, target.optimal(N3));
        }

        @Test
        void optimalLong() {
            assertEquals(SOL1, target.optimalLong(N1));
            assertEquals(SOL2, target.optimalLong(N2));
            assertEquals(SOL3, target.optimalLong(N3));
            assertFalse(target.optimalLong(50_000) >= 0);
        }

        @Test
        void optimalNoOverflow() {
            assertEquals(BigInteger.valueOf(SOL1), target.optimalNoOverflow(N1));
            assertEquals(BigInteger.valueOf(SOL2), target.optimalNoOverflow(N2));
            assertEquals(BigInteger.valueOf(SOL3), target.optimalNoOverflow(N3));
            assertTrue(target.optimalNoOverflow(50_000).signum() >= 0);
        }
    }
}