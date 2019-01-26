package codility.lesson10;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import codility.util.MoreInts;

public class PeaksTest {

	private static final int MIN_N = 1;
	private static final int MAX_N = 100_000;
	private static final int MIN_INT = 0;
	private static final int MAX_INT = 1_000_000_000;
	
	private static final int[] A1 = { 1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2 };
	private static final int SOL1 = 3;
	private static final int[] A2 = { 3, 2, 6, };
	private static final int SOL2 = 0;
	private static final int[] A3 = { 3, 8, 6, };
	private static final int SOL3 = 1;
	private static final int[] A4 = {4,9,6,2,5,3,5,10,7,0,1,8,1,5,8,10};
	private static final int SOL4 = 2;

	@Test
	public void testSolution() {
		Peaks peaks = new Peaks();
		assertEquals(SOL1, peaks.solution(A1));
		assertEquals(SOL2, peaks.solution(A2));
		assertEquals(SOL3, peaks.solution(A3));
		assertEquals(SOL4, peaks.solution(A4));
	}
	
	@Test
	public void testExhaustiveSearch() {
		assertEquals(SOL1, Peaks.exhaustiveSearch(A1));
		assertEquals(SOL2, Peaks.exhaustiveSearch(A2));
		assertEquals(SOL3, Peaks.exhaustiveSearch(A3));
		assertEquals(SOL4, Peaks.exhaustiveSearch(A4));
	}

	@Test
	public void testMassive() {
		final Peaks maxDoubleSliceSum = new Peaks();
		final int ntest = 1_200;
		for (int t = 0; t < ntest; t++) {
			final int N = MoreInts.newRandom(MIN_N, MAX_N);
			final int[] A = MoreInts.newRandomArray(N, MIN_INT, MAX_INT);
			assertEquals(Peaks.exhaustiveSearch(A), maxDoubleSliceSum.solution(A));
		}
	}
}
