package codility.lesson11;

import codility.util.MoreInts;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CountSemiprimesTest {

    public static final int NUM_TESTS = 100;
    private static final int MIN_N = 1;
    private static final int MAX_N = 50_000;
    private static final int MIN_M = 1;
    private static final int MAX_M = 30_000;

    private final int N1 = 26;
    private final int[] P1 = { 1, 4, 16};
    private final int[] Q1 = { 26, 10, 20 };
    private final int[] SOL1 = { 10, 4, 0};

    @Test
    public void solution() {
        CountSemiprimes countSemiprimes = new CountSemiprimes();
        assertArrayEquals(SOL1, countSemiprimes.solution(N1, P1, Q1));
    }

    @Test
    public void subOptimal() {
        CountSemiprimes.SubOptimal subOptimal = new CountSemiprimes.SubOptimal();
        assertArrayEquals(SOL1, subOptimal.solution(N1, P1, Q1));
    }

    @Test
    public void exhaustiveSearch() {
        CountSemiprimes.ExhaustiveSearch exhaustiveSearch = new CountSemiprimes.ExhaustiveSearch();
        assertArrayEquals(SOL1, exhaustiveSearch.solution(N1, P1, Q1));
    }

    @Test
    public void solutionRandomInput() {
        final CountSemiprimes countSemiprimes = new CountSemiprimes();
        final CountSemiprimes.ExhaustiveSearch exhaustiveSearch = new CountSemiprimes.ExhaustiveSearch();
        for (int t = 0; t < NUM_TESTS; t++) {
            final int N = MoreInts.newRandom(MIN_N, 1_000);
            final int m = MoreInts.newRandom(MIN_M, MAX_M);
            final int[] P = new int[m];
            final int[] Q = new int[m];
            for (int i = 0; i < m; i++) {
                P[i] = MoreInts.newRandom(1, N);
                Q[i] = MoreInts.newRandom(P[i], N);
            }
            final int[] expected = countSemiprimes.solution(N, P, Q);
            final int[] actual = exhaustiveSearch.solution(N, P, Q);
            if (!Arrays.equals(expected, actual)) {
                System.out.printf("N = %d, P = [%s], Q = [%s]%n", N, Arrays.toString(P), Arrays.toString(Q));
            }
            assertArrayEquals(expected, actual);
        }
    }

    @Test
    public void solutionRandomInputMaxN() {
        final CountSemiprimes countSemiprimes = new CountSemiprimes();
        final CountSemiprimes.SubOptimal subOptimal = new CountSemiprimes.SubOptimal();
        for (int t = 0; t < NUM_TESTS; t++) {
            final int N = MoreInts.newRandom(MIN_N, MAX_N);
            final int m = MoreInts.newRandom(MIN_M, MAX_M);
            final int[] P = new int[m];
            final int[] Q = new int[m];
            for (int i = 0; i < m; i++) {
                P[i] = MoreInts.newRandom(1, N);
                Q[i] = MoreInts.newRandom(P[i], N);
            }
            final int[] expected = countSemiprimes.solution(N, P, Q);
            final int[] actual = subOptimal.solution(N, P, Q);
            if (!Arrays.equals(expected, actual)) {
                System.out.printf("N = %d, P = [%s], Q = [%s]%n", N, Arrays.toString(P), Arrays.toString(Q));
            }
            assertArrayEquals(expected, actual);
        }
    }
}