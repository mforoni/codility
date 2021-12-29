package codility.lesson05;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import codility.lesson05.MinAvgTwoSlice;
import codility.util.MoreInts;

public class MinAvgTwoSliceTest {

	private static final int MIN_N = 2;
	private static final int MAX_N = 10_000; // original = 100_000;
	private static final int MIN_INT = -10_000;
	private static final int MAX_INT = 10_000;
	
	private static final int[] A1 = { 4, 2, 2, 5, 1, 5, 8 };
	private static final int SOL1 = 1;

	private static final int[] A2 = { -4, 2, 2 };
	private static final int SOL2 = 0;

	@Test
	public void testSolution() {
		final MinAvgTwoSlice minAvgTwoSlice = new MinAvgTwoSlice();
		assertEquals(SOL1, minAvgTwoSlice.solution(A1));
		assertEquals(SOL2, minAvgTwoSlice.solution(A2));
	}

	@Test
	public void testExhausitveSearchOptimized() {
		assertEquals(SOL1, MinAvgTwoSlice.exhausitveSearchOptimized(A1));
		assertEquals(SOL2, MinAvgTwoSlice.exhausitveSearchOptimized(A2));
	}

	@Test
	public void testExhausitveSearch() {
		assertEquals(SOL1, MinAvgTwoSlice.exhausitveSearch(A1));
		assertEquals(SOL2, MinAvgTwoSlice.exhausitveSearch(A2));
	}

	@Test
	public void testMassive() {
		final MinAvgTwoSlice minAvgTwoSlice = new MinAvgTwoSlice();
		int ntest = 50;
		for (int t = 0; t < ntest; t++) {
			final int N = MoreInts.newRandom(MIN_N, MAX_N);
			final int[] A = MoreInts.newRandomArray(N, MIN_INT, MAX_INT);
			assertEquals(MinAvgTwoSlice.exhausitveSearchOptimized(A), minAvgTwoSlice.solution(A));
		}
	}
}
