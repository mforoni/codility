package codility.lesson09;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import codility.lesson09.MaxProfit;
import codility.util.MoreInts;

public class MaxProfitTest {

	public static final int NUM_TESTS = 50;
	private static final int MIN_N = 0;
	private static final int MAX_N = 400_000;
	private static final int MIN_INT = 0;
	private static final int MAX_INT = 200_000;

	public static final int[] A1 = { 23_171, 21_011, 21_123, 21_366, 21_013, 21_367 };
	public static final int SOL1 = 356;

	@Test
	public void testSolution() {
		final MaxProfit maxProfit = new MaxProfit();
		assertEquals(SOL1, maxProfit.solution(A1));
	}

	@Test
	public void testSubOptimal() {
		assertEquals(SOL1, MaxProfit.subOptimal(A1));
	}

	@Test
	public void testExhaustiveSearch() {
		assertEquals(SOL1, MaxProfit.exhaustiveSearch(A1));
	}

	@Test
	public void testSolutionRandomInput() {
		final MaxProfit maxProfit = new MaxProfit();
		for (int t = 0; t < NUM_TESTS; t++) {
			final int N = MoreInts.newRandom(MIN_N, 10_000);
			final int[] A = MoreInts.newRandomArray(N, MIN_INT, MAX_INT);
			assertEquals(MaxProfit.exhaustiveSearch(A), maxProfit.solution(A));
		}
	}

	@Test
	public void testSolutionRandomInputMaxN() {
		final MaxProfit maxProfit = new MaxProfit();
		for (int t = 0; t < NUM_TESTS; t++) {
			final int N = MoreInts.newRandom(MIN_N, MAX_N);
			final int[] A = MoreInts.newRandomArray(N, MIN_INT, MAX_INT);
			assertEquals(MaxProfit.subOptimal(A), maxProfit.solution(A));
		}
	}

	@Test
	public void testSubOptimalRandomInput() {
		for (int t = 0; t < NUM_TESTS; t++) {
			final int N = MoreInts.newRandom(MIN_N, 10_000);
			final int[] A = MoreInts.newRandomArray(N, MIN_INT, MAX_INT);
			assertEquals(MaxProfit.exhaustiveSearch(A), MaxProfit.subOptimal(A));
		}
	}
}
