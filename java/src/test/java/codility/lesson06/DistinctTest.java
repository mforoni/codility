package codility.lesson06;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import codility.lesson06.Distinct;
import codility.util.MoreInts;

public class DistinctTest {

	private static final int MIN_N = 0;
	private static final int MAX_N = 100_000;
	private static final int MIN_INT = -1_000_000;
	private static final int MAX_INT = 1_000_000;

	public static final int[] A1 = { 2, 1, 1, 2, 3, 1 };
	public static final int SOL1 = 3;

	public static final int[] A2 = {};
	public static final int SOL2 = 0;

	@Test
	public void testSolution() {
		final Distinct distinct = new Distinct();
		assertEquals(SOL1, distinct.solution(A1));
		assertEquals(SOL2, distinct.solution(A2));
	}

	@Test
	public void testChecker() {
		assertEquals(SOL1, Distinct.checker(A1));
		assertEquals(SOL2, Distinct.checker(A2));
	}

	@Test
	public void testMassive() {
		final Distinct distinct = new Distinct();
		final int ntest = 200;
		for (int t = 0; t < ntest; t++) {
			final int N = MoreInts.newRandom(MIN_N, MAX_N);
			final int[] A = MoreInts.newRandomArray(N, MIN_INT, MAX_INT);
			assertEquals(Distinct.checker(A), distinct.solution(A));
		}
	}
}