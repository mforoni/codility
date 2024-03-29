package codility.lesson08;

import codility.util.MoreInts;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DominatorTest {

	public static final int NUM_TESTS = 80;
	private static final int MIN_N = 0;
	private static final int MAX_N = 100_000;
	private static final int MIN_INT = Integer.MIN_VALUE;
	private static final int MAX_INT = Integer.MAX_VALUE - 1;

	private static final int[] A1 = { 3, 4, 3, 2, 3, -1, 3, 3 };
	private static final int SOL1 = 0;

	private static final int[] A2 = { 2 };
	private static final int SOL2 = 0;

	private static final int[] A3 = { 1, 2 };
	private static final int SOL3 = -1;

	private static final int[] A4 = { };
	private static final int SOL4 = -1;

	@Test
	public void solution() {
		final Dominator dominator = new Dominator();
		assertEquals(SOL1, dominator.solution(A1));
		assertEquals(SOL2, dominator.solution(A2));
		assertEquals(SOL3, dominator.solution(A3));
		assertEquals(SOL4, dominator.solution(A4));
	}

	@Test
	public void exhaustiveSearch() {
		assertEquals(SOL1, Dominator.exhaustiveSearch(A1));
		assertEquals(SOL2, Dominator.exhaustiveSearch(A2));
		assertEquals(SOL3, Dominator.exhaustiveSearch(A3));
		assertEquals(SOL4, Dominator.exhaustiveSearch(A4));
	}

	@Test
	public void solutionRandomInput() {
		final Dominator dominator = new Dominator();
		for (int t = 0; t < NUM_TESTS; t++) {
			final int N = MoreInts.newRandom(MIN_N, MAX_N);
			final int[] A = MoreInts.newRandomArray(N, MIN_INT, MAX_INT);
			assertEquals(Dominator.exhaustiveSearch(A), dominator.solution(A));
		}
	}
}
