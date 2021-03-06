package codility.lesson03;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.common.primitives.Ints;

import codility.lesson03.TapeEquilibrium;
import codility.util.MoreInts;

public class TapeEquilibriumTest {

	private static final int MIN_N = 2;
	private static final int MAX_N  = 100_000;
	private static final int MIN_INT = -1_000;
	private static final int MAX_INT = 1_000;
	private static final int[] A1 = new int[] { 3, 1, 2, 4, 3 };
	private static final int SOL1 = 1;
	private static final int[] A2 = new int[] { 20, 1, 2, 3, 4, 5 };
	private static final int SOL2 = 5;
	private static final int[] A3 = new int[] { 20, 1};
	private static final int SOL3 = 19;
	private static final int[] A4 = new int[] { 1, 10};
	private static final int SOL4 = 9;
	

	@Test
	public void testSolution() {
		final TapeEquilibrium tapeEquilibrium = new TapeEquilibrium();
		assertEquals(SOL1, tapeEquilibrium.solution(A1));
		assertEquals(SOL2, tapeEquilibrium.solution(A2));
		assertEquals(SOL3, tapeEquilibrium.solution(A3));
		assertEquals(SOL4, tapeEquilibrium.solution(A4));
	}

	@Test
	public void testMin() {
		assertEquals(1, TapeEquilibrium.min(A1, 1));
		assertEquals(2, TapeEquilibrium.min(A1, 2));
	}

	@Test
	public void testExaustiveSearch() {
		assertEquals(SOL1, TapeEquilibrium.exhausitveSearch(A1));
		assertEquals(SOL2, TapeEquilibrium.exhausitveSearch(A2));
		assertEquals(SOL3, TapeEquilibrium.exhausitveSearch(A3));
		assertEquals(SOL4, TapeEquilibrium.exhausitveSearch(A4));

	}
	

	public void testMassive() {
		final TapeEquilibrium tapeEquilibrium = new TapeEquilibrium();
		final int ntest = 20000;
		for (int t = 0; t < ntest; t++) {
			final int n = MoreInts.newRandom(MIN_N, MAX_N);
			final int[] a = MoreInts.newRandomArray(n, MIN_INT, MAX_INT);
			final int sol1 = TapeEquilibrium.exhausitveSearch(a);
			final int sol2 = tapeEquilibrium.solution(a);
			if (sol1 != sol2) {
				System.out.println(Ints.join(", ", a));
			}
			assertEquals(sol1, sol2);
		}
	}

}
