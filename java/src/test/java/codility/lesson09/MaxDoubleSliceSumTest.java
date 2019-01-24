package codility.lesson09;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import codility.lesson09.MaxDoubleSliceSum;
import codility.util.MoreInts;

public class MaxDoubleSliceSumTest {

	private static final int MIN_N = 3;
	private static final int MAX_N = 1_000; //100_000;
	private static final int MIN_INT = -10_000;
	private static final int MAX_INT = 10_000;
	
	private static final int[] A1 = { 3, 2, 6, -1, 4, 5, -1, 2 };
	private static final int SOL1 = 17;
	private static final int[] A2 = { 3, 2, 6, };
	private static final int SOL2 = 0;

	@Test
	public void testSolution() {
		MaxDoubleSliceSum maxDoubleSliceSum = new MaxDoubleSliceSum();
		assertEquals(SOL1, maxDoubleSliceSum.solution(A1));
		assertEquals(SOL2, maxDoubleSliceSum.solution(A2));
	}

	@Test
	public void testExhaustiveSearch() {
		assertEquals(SOL1, MaxDoubleSliceSum.exhaustiveSearch(A1));
		assertEquals(SOL2, MaxDoubleSliceSum.exhaustiveSearch(A2));
	}
	
	@Test
	public void testMassive() {
		final MaxDoubleSliceSum maxDoubleSliceSum = new MaxDoubleSliceSum();
		final int ntest = 200;
		for (int t = 0; t < ntest; t++) {
			final int N = MoreInts.newRandom(MIN_N, MAX_N);
			final int[] A = MoreInts.newRandomArray(N, MIN_INT, MAX_INT);
			assertEquals(MaxDoubleSliceSum.exhaustiveSearch(A), maxDoubleSliceSum.solution(A));
		}
	}
}
