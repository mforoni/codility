package codility.lesson11;

import codility.util.MoreInts;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CountNonDivisibleTest {

	public static final int NUM_TESTS = 100;
	private static final int MIN_N = 1;
	private static final int MAX_N = 50_000;
	private static final int MIN_INT = 1;
	private static final int MAX_INT = 100_000;

	private static final int[] A1 = { 3, 1, 2, 3, 6 };
	private static final int[] SOL1 = { 2, 4, 3, 2, 0 };

	private static final int[] A2 = { 1, 1, 4, 1 };
	private static final int[] SOL2 = { 1, 1, 0, 1};

	private static final int[] A3 = { 3, 4, 5, 2, 3, 3, 4, 4 };
	private static final int[] SOL3 = { 5, 4, 7, 7, 5, 5, 4, 4 };
	
	@Test
	public void solution() {
		final CountNonDivisible countNonDivisible = new CountNonDivisible();
		assertArrayEquals(SOL1, countNonDivisible.solution(A1));
		assertArrayEquals(SOL2, countNonDivisible.solution(A2));
		assertArrayEquals(SOL3, countNonDivisible.solution(A3));
	}

	@Test
	public void exhaustiveSearch() {
		assertArrayEquals(SOL1, CountNonDivisible.exhaustiveSearch(A1));
		assertArrayEquals(SOL2, CountNonDivisible.exhaustiveSearch(A2));
		assertArrayEquals(SOL3, CountNonDivisible.exhaustiveSearch(A3));
	}

	@Test
	public void solutionRandomInput() {
		final CountNonDivisible countNonDivisible = new CountNonDivisible();
		for (int t = 0; t < NUM_TESTS; t++) {
			final int N = MoreInts.newRandom(MIN_N, 2_000);
			final int[] A = MoreInts.newRandomArray(N, MIN_INT, MAX_INT);
			assertArrayEquals(CountNonDivisible.exhaustiveSearch(A), countNonDivisible.solution(A));
		}
	}
}
