package codility.lesson09;

import codility.util.MoreInts;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MaxSliceSumTest {

	public static final int NUM_TESTS = 50;
	private static final int MIN_N = 1;
	private static final int MAX_N = 1_000_000;
	private static final int MIN_INT = -1_000_000;
	private static final int MAX_INT = 1_000_000;

	public static final int[] A1 = { 3, 2, -6, 4, 0 };
	public static final int SOL1 = 5;
	
	public static final int[] A2 = { 3, 2, -6, 4, 5, 0 };
	public static final int SOL2 = 9;

	public static final int[] A3 = { 1, 1 };
	public static final int SOL3 = 2;

	@Test
	public void solution() {
		final MaxSliceSum maxSliceSum = new MaxSliceSum();
		assertEquals(SOL1, maxSliceSum.solution(A1));
		assertEquals(SOL2, maxSliceSum.solution(A2));
		assertEquals(SOL3, maxSliceSum.solution(A3));
	}

	@Test
	public void exhaustiveSearch() {
		assertEquals(SOL1, MaxSliceSum.exhaustiveSearch(A1));
		assertEquals(SOL2, MaxSliceSum.exhaustiveSearch(A2));
		assertEquals(SOL3, MaxSliceSum.exhaustiveSearch(A3));
	}

	@Test
	public void solutionRandomInput() {
		final MaxSliceSum maxSliceSum = new MaxSliceSum();
		for (int t = 0; t < NUM_TESTS; t++) {
			final int N = MoreInts.newRandom(MIN_N, MAX_N / 100);
			final int[] A = MoreInts.newRandomArray(N, MIN_INT, MAX_INT);
			assertEquals(MaxSliceSum.exhaustiveSearch(A), maxSliceSum.solution(A));
		}
	}

	@Test
	public void solutionRandomInputMaxN() {
		final MaxSliceSum maxSliceSum = new MaxSliceSum();
		for (int t = 0; t < NUM_TESTS; t++) {
			final int N = MoreInts.newRandom(MIN_N, MAX_N);
			final int[] A = MoreInts.newRandomArray(N, MIN_INT, MAX_INT);
			final int actual = maxSliceSum.solution(A);
			if (N < 10_000) {
				assertEquals(MaxSliceSum.exhaustiveSearch(A), actual);
			} else {
				assertTrue(Integer.MIN_VALUE < actual);
				assertTrue(actual < Integer.MAX_VALUE);
			}
		}
	}
}
