package codility.lesson05;

import codility.util.MoreInts;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinAvgTwoSliceTest {

	private static final int NUM_TESTS = 50;

	private static final int MIN_N = 2;
	private static final int MAX_N = 100_000;
	private static final int MIN_INT = -10_000;
	private static final int MAX_INT = 10_000;
	
	private static final int[] A1 = { 4, 2, 2, 5, 1, 5, 8 };
	private static final int SOL1 = 1;

	private static final int[] A2 = { -4, 2, 2 };
	private static final int SOL2 = 0;

	@Test
	public void solution() {
		final MinAvgTwoSlice minAvgTwoSlice = new MinAvgTwoSlice();
		assertEquals(SOL1, minAvgTwoSlice.solution(A1));
		assertEquals(SOL2, minAvgTwoSlice.solution(A2));
	}

	@Test
	public void exhaustiveSearchOptimized() {
		assertEquals(SOL1, MinAvgTwoSlice.exhaustiveSearchOptimized(A1));
		assertEquals(SOL2, MinAvgTwoSlice.exhaustiveSearchOptimized(A2));
	}

	@Test
	public void exhaustiveSearch() {
		assertEquals(SOL1, MinAvgTwoSlice.exhaustiveSearch(A1));
		assertEquals(SOL2, MinAvgTwoSlice.exhaustiveSearch(A2));
	}

	@Test
	public void solutionRandomInput() {
		final MinAvgTwoSlice minAvgTwoSlice = new MinAvgTwoSlice();
		for (int t = 0; t < NUM_TESTS; t++) {
			final int N = MoreInts.newRandom(MIN_N, 5_000);
			final int[] A = MoreInts.newRandomArray(N, MIN_INT, MAX_INT);
			assertEquals(MinAvgTwoSlice.exhaustiveSearchOptimized(A), minAvgTwoSlice.solution(A));
		}
	}
}
