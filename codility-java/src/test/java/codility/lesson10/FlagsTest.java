package codility.lesson10;

import codility.util.MoreInts;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlagsTest {

	public static final int NUM_TESTS = 100;
	private static final int MIN_N = 1;
	private static final int MAX_N = 400_000;
	private static final int MIN_INT = 0;
	private static final int MAX_INT = 1_000_000_000;

	private static final int[] A1 = { 1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2 };
	private static final int SOL1 = 3;

	private static final int[] A2 = { 3, 2, 6, };
	private static final int SOL2 = 0;

	private static final int[] A3 = { 3, 8, 6, };
	private static final int SOL3 = 1;
	
	@Test
	public void testSolution() {
		final Flags flags = new Flags();
		assertEquals(SOL1, flags.solution(A1));
		assertEquals(SOL2, flags.solution(A2));
		assertEquals(SOL3, flags.solution(A3));
	}

	@Test
	public void testExhaustiveSearch() {
		final Flags.ExhaustiveSearch exhaustiveSearch = new Flags.ExhaustiveSearch();
		assertEquals(SOL1, exhaustiveSearch.solution(A1));
		assertEquals(SOL2, exhaustiveSearch.solution(A2));
		assertEquals(SOL3, exhaustiveSearch.solution(A3));
	}

	@Test
	public void testSolutionRandomInput() {
		final Flags flags = new Flags();
		final Flags.ExhaustiveSearch exhaustiveSearch = new Flags.ExhaustiveSearch();
		for (int t = 0; t < NUM_TESTS; t++) {
			final int N = MoreInts.newRandom(MIN_N, 5_000);
			final int[] A = MoreInts.newRandomArray(N, MIN_INT, MAX_INT);
			assertEquals(exhaustiveSearch.solution(A), flags.solution(A));
		}
	}
}
