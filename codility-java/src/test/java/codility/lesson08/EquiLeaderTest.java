package codility.lesson08;

import codility.util.MoreInts;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EquiLeaderTest {

    public static final int NUM_TESTS = 20;
    private static final int MIN_N = 1;
    private static final int MAX_N = 10_000; // original = 100_000;
    private static final int MIN_INT = -1_000_000_000;
    private static final int MAX_INT = 1_000_000_000;

    private static final int[] A1 = new int[] { 4, 3, 4, 4, 4, 2 };
    private static final int SOL1 = 2;

    private static final int[] A2 = new int[] { 1, 2 };
    private static final int SOL2 = 0;

    @Test
    public void testSolution() {
        final EquiLeader equiLeader = new EquiLeader();
        assertEquals(SOL1, equiLeader.solution(A1));
        assertEquals(SOL2, equiLeader.solution(A2));
    }

    @Test
    public void testExhaustiveSearch() {
        assertEquals(SOL1, EquiLeader.exhaustiveSearch(A1));
        assertEquals(SOL2, EquiLeader.exhaustiveSearch(A2));
    }

    @Test
    public void testSolutionRandomInput() {
        final EquiLeader equiLeader = new EquiLeader();
        for (int t = 0; t < NUM_TESTS; t++) {
            final int N = MoreInts.newRandom(MIN_N, MAX_N);
            final int[] A = MoreInts.newRandomArray(N, MIN_INT, MAX_INT);
            assertEquals(EquiLeader.exhaustiveSearch(A), equiLeader.solution(A));
        }
    }
}