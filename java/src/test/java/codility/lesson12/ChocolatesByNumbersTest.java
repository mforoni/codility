package codility.lesson12;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import codility.util.MoreInts;

public class ChocolatesByNumbersTest {

	private static final int MIN = 1;
	private static final int MAX = 1_000_000; //1_000_000_000;

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
	public void testMassive() {
		final ChocolatesByNumbers chocolatesByNumbers = new ChocolatesByNumbers();
		final int ntest = 200;
		for (int t = 0; t < ntest; t++) {
			final int n = MoreInts.newRandom(MIN, MAX);
			final int m = MoreInts.newRandom(MIN, MAX);
			assertEquals(ChocolatesByNumbers.exhaustiveSearch(n, m), chocolatesByNumbers.solution(n, m));
		}
	}
}
