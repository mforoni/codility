package codility.lesson10;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import codility.util.MoreInts;

public class CountFactorsTest {

	private static final int MAX_N = 1_500_000; //Integer.MAX_VALUE - 1;
	
	private static final int N1 = 24;
	private static final int SOL1 = 8;
	private static final int A2 = 1;
	private static final int SOL2 = 1;

	@Test
	public void testSolution() {
		CountFactors countFactors = new CountFactors();
		assertEquals(SOL1, countFactors.solution(N1));
		assertEquals(SOL2, countFactors.solution(A2));
	}

	@Test
	public void testExhaustiveSearch() {
		assertEquals(SOL1, CountFactors.exhaustiveSearch(N1));
		assertEquals(SOL2, CountFactors.exhaustiveSearch(A2));
	}
	
	@Test
	public void testMassive() {
		final CountFactors countFactors = new CountFactors();
		final int ntest = 500;
		for (int t = 0; t < ntest; t++) {
			final int n = MoreInts.newRandom(1, MAX_N);
			assertEquals(CountFactors.exhaustiveSearch(n), countFactors.solution(n));
		}
	}
}
