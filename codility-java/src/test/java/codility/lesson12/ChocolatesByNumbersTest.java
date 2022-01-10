package codility.lesson12;

import codility.util.MoreInts;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChocolatesByNumbersTest {

	public static final int NUM_TESTS = 80;
	private static final int MIN_N_AND_M = 1;
	private static final int MAX_N_AND_M = 1_000_000_000;

	private static final int N1 = 10;
	private static final int M1 = 4;
	private static final int SOL1 = 5;

	@Test
	public void testSolution() {
		final ChocolatesByNumbers chocolatesByNumbers = new ChocolatesByNumbers();
		assertEquals(SOL1, chocolatesByNumbers.solution(N1, M1));
	}

	@Test
	public void testExhaustiveSearch() {
		assertEquals(SOL1, ChocolatesByNumbers.exhaustiveSearch(N1, M1));
	}

	@Test
	public void testSolutionRandomInput() {
		final ChocolatesByNumbers chocolatesByNumbers = new ChocolatesByNumbers();
		for (int t = 0; t < NUM_TESTS; t++) {
			final int n = MoreInts.newRandom(MIN_N_AND_M, 250_000);
			final int m = MoreInts.newRandom(MIN_N_AND_M, 250_000);
			assertEquals(ChocolatesByNumbers.exhaustiveSearch(n, m), chocolatesByNumbers.solution(n, m));
		}
	}
}
