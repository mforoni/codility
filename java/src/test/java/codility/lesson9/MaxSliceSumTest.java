package codility.lesson9;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import codility.util.MoreInts;

public class MaxSliceSumTest {

	private static final int MIN_N = 1;
	private static final int MAX_N = 10_000; // original = 1_000_000;
	private static final int MIN_INT = -1_000_000;
	private static final int MAX_INT = 1_000_000;

	public static final int[] A1 = { 3, 2, -6, 4, 0 };
	public static final int SOL1 = 5;
	
	public static final int[] A2 = { 3, 2, -6, 4, 5, 0 };
	public static final int SOL2 = 9;

	@Test
	public void testSolution() {
		final MaxSliceSum maxSliceSum = new MaxSliceSum();
		assertEquals(SOL1, maxSliceSum.solution(A1));
		assertEquals(SOL2, maxSliceSum.solution(A2));
	}

	@Test
	public void testExhaustiveSearch() {
		assertEquals(SOL1, MaxSliceSum.exhaustiveSearch(A1));
		assertEquals(SOL2, MaxSliceSum.exhaustiveSearch(A2));
	}

	@Test
	public void testMassive() {
		final MaxSliceSum maxSliceSum = new MaxSliceSum();
		final int ntest = 5000;
		for (int t = 0; t < ntest; t++) {
			final int N = MoreInts.newRandom(MIN_N, MAX_N);
			final int[] A = MoreInts.newRandomArray(N, MIN_INT, MAX_INT);
			assertEquals(MaxSliceSum.exhaustiveSearch(A), maxSliceSum.solution(A));
		}
	}

}
