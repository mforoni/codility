package codility.lesson10;

import codility.util.MoreInts;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountFactorsTest {

	public static final int NUM_TESTS = 80;
	private static final int MAX_N = Integer.MAX_VALUE - 1;
	
	private static final int N1 = 24;
	private static final int SOL1 = 8;

	private static final int N2 = 1;
	private static final int SOL2 = 1;

	@Test
	public void solution() {
		CountFactors countFactors = new CountFactors();
		assertEquals(SOL1, countFactors.solution(N1));
		assertEquals(SOL2, countFactors.solution(N2));
	}

	@Test
	public void countingDivisors() {
		assertEquals(SOL1, CountFactors.countingDivisors(N1));
		assertEquals(SOL2, CountFactors.countingDivisors(N2));
	}

	@Test
	public void exhaustiveSearch() {
		assertEquals(SOL1, CountFactors.exhaustiveSearch(N1));
		assertEquals(SOL2, CountFactors.exhaustiveSearch(N2));
	}

	@Test
	public void solutionRandomInput() {
		final CountFactors countFactors = new CountFactors();
		for (int t = 0; t < NUM_TESTS; t++) {
			final int n = MoreInts.newRandom(1, 5_000_000);
			assertEquals(CountFactors.exhaustiveSearch(n), countFactors.solution(n));
		}
	}

	@Test
	public void countingDivisorsRandomInput() {
		for (int t = 0; t < NUM_TESTS; t++) {
			final int n = MoreInts.newRandom(1, 5_000_000);
			assertEquals(CountFactors.exhaustiveSearch(n), CountFactors.countingDivisors(n));
		}
	}

	@Test
	public void solutionRandomInputMaxN() {
		final CountFactors countFactors = new CountFactors();
		for (int t = 0; t < NUM_TESTS; t++) {
			final int n = MoreInts.newRandom(1, MAX_N);
			assertEquals(CountFactors.countingDivisors(n), countFactors.solution(n));
		}
	}
}
