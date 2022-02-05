package codility.lesson09;

import codility.util.MoreInts;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxProfitTest {

	public static final int NUM_TESTS = 80;
	private static final int MIN_N = 0;
	private static final int MAX_N = 400_000;
	private static final int MIN_INT = 0;
	private static final int MAX_INT = 200_000;

	public static final int[] A1 = { 23_171, 21_011, 21_123, 21_366, 21_013, 21_367 };
	public static final int SOL1 = 356;

	@Test
	public void solution() {
		final MaxProfit maxProfit = new MaxProfit();
		assertEquals(SOL1, maxProfit.solution(A1));
	}

	@Test
	public void subOptimal() {
		assertEquals(SOL1, MaxProfit.subOptimal(A1));
	}

	@Test
	public void exhaustiveSearch() {
		assertEquals(SOL1, MaxProfit.exhaustiveSearch(A1));
	}

	@Test
	public void solutionRandomInput() {
		final MaxProfit maxProfit = new MaxProfit();
		for (int t = 0; t < NUM_TESTS; t++) {
			final int N = MoreInts.newRandom(MIN_N, MAX_N / 100);
			final int[] A = MoreInts.newRandomArray(N, MIN_INT, MAX_INT);
			assertEquals(MaxProfit.exhaustiveSearch(A), maxProfit.solution(A));
		}
	}

	@Test
	public void solutionRandomInputMaxN() {
		final MaxProfit maxProfit = new MaxProfit();
		for (int t = 0; t < NUM_TESTS; t++) {
			final int N = MoreInts.newRandom(MIN_N, MAX_N);
			final int[] A = MoreInts.newRandomArray(N, MIN_INT, MAX_INT);
			assertEquals(MaxProfit.subOptimal(A), maxProfit.solution(A));
		}
	}

	@Test
	public void subOptimalRandomInput() {
		for (int t = 0; t < NUM_TESTS; t++) {
			final int N = MoreInts.newRandom(MIN_N, MAX_N / 100);
			final int[] A = MoreInts.newRandomArray(N, MIN_INT, MAX_INT);
			assertEquals(MaxProfit.exhaustiveSearch(A), MaxProfit.subOptimal(A));
		}
	}
}
