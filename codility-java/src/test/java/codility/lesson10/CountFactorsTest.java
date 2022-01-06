package codility.lesson10;

import codility.util.MoreInts;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountFactorsTest {

	public static final int NUM_TESTS = 100;
	private static final int MAX_N = Integer.MAX_VALUE - 1;
	
	private static final int N1 = 24;
	private static final int SOL1 = 8;

	private static final int N2 = 1;
	private static final int SOL2 = 1;

	private static final int N3 = 2_147_483_647;

	@Test
	public void testSolution() {
		CountFactors countFactors = new CountFactors();
		assertEquals(SOL1, countFactors.solution(N1));
		assertEquals(SOL2, countFactors.solution(N2));
	}

	@Test
	public void testCountingDivisors() {
		assertEquals(SOL1, CountFactors.countingDivisors(N1));
		assertEquals(SOL2, CountFactors.countingDivisors(N2));
	}

	@Test
	public void testExhaustiveSearch() {
		assertEquals(SOL1, CountFactors.exhaustiveSearch(N1));
		assertEquals(SOL2, CountFactors.exhaustiveSearch(N2));
	}

	@Test
	public void testSolutionRandomInput() {
		final CountFactors countFactors = new CountFactors();
		for (int t = 0; t < NUM_TESTS; t++) {
			final int n = MoreInts.newRandom(1, 10_000_000);
			assertEquals(CountFactors.exhaustiveSearch(n), countFactors.solution(n));
		}
	}

	@Test
	public void testCountingDivisorsRandomInput() {
		for (int t = 0; t < NUM_TESTS; t++) {
			final int n = MoreInts.newRandom(1, 10_000_000);
			assertEquals(CountFactors.exhaustiveSearch(n), CountFactors.countingDivisors(n));
		}
	}

	@Test
	public void testSolutionRandomInputMaxN() {
		final CountFactors countFactors = new CountFactors();
		for (int t = 0; t < NUM_TESTS; t++) {
			final int n = MoreInts.newRandom(1, MAX_N);
			assertEquals(CountFactors.countingDivisors(n), countFactors.solution(n));
		}
	}
}
