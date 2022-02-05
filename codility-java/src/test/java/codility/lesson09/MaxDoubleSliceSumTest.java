package codility.lesson09;

import codility.util.MoreInts;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxDoubleSliceSumTest {

	public static final int NUM_TESTS = 100;
	private static final int MIN_N = 3;
	private static final int MAX_N = 100_000;
	private static final int MIN_INT = -10_000;
	private static final int MAX_INT = 10_000;
	
	private static final int[] A1 = { 3, 2, 6, -1, 4, 5, -1, 2 };
	private static final int SOL1 = 17;

	private static final int[] A2 = { 3, 2, 6, };
	private static final int SOL2 = 0;

	@Test
	public void solution() {
		MaxDoubleSliceSum maxDoubleSliceSum = new MaxDoubleSliceSum();
		assertEquals(SOL1, maxDoubleSliceSum.solution(A1));
		assertEquals(SOL2, maxDoubleSliceSum.solution(A2));
	}

	@Test
	public void exhaustiveSearch() {
		assertEquals(SOL1, MaxDoubleSliceSum.exhaustiveSearch(A1));
		assertEquals(SOL2, MaxDoubleSliceSum.exhaustiveSearch(A2));
	}
	
	@Test
	public void solutionRandomInput() {
		final MaxDoubleSliceSum maxDoubleSliceSum = new MaxDoubleSliceSum();
		for (int t = 0; t < NUM_TESTS; t++) {
			final int N = MoreInts.newRandom(MIN_N, MAX_N / 200);
			final int[] A = MoreInts.newRandomArray(N, MIN_INT, MAX_INT);
			assertEquals(MaxDoubleSliceSum.exhaustiveSearch(A), maxDoubleSliceSum.solution(A));
		}
	}
}
