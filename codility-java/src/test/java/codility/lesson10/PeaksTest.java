package codility.lesson10;

import codility.util.MoreInts;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PeaksTest {

	public static final int NUM_TESTS = 1_000;
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

	private static final int[] A4 = { 4, 9, 6, 2, 5, 3, 5, 10, 7, 0, 1, 8, 1, 5, 8, 10 };
	private static final int SOL4 = 2;

	private static final int[] A5 = { 5 };
	private static final int SOL5 = 0;

	private static final int[] A6 = { 3, 8, 8, 7, 0 };
	private static final int SOL6 = 0;

	@Test
	public void testSolution() {
		final Peaks peaks = new Peaks();
		assertEquals(SOL1, peaks.solution(A1));
		assertEquals(SOL2, peaks.solution(A2));
		assertEquals(SOL3, peaks.solution(A3));
		assertEquals(SOL4, peaks.solution(A4));
		assertEquals(SOL5, peaks.solution(A5));
		assertEquals(SOL6, peaks.solution(A6));
	}
	
	@Test
	public void testExhaustiveSearch() {
		final Peaks.ExhaustiveSearch exhaustiveSearch = new Peaks.ExhaustiveSearch();
		assertEquals(SOL1, exhaustiveSearch.solution(A1));
		assertEquals(SOL2, exhaustiveSearch.solution(A2));
		assertEquals(SOL3, exhaustiveSearch.solution(A3));
		assertEquals(SOL4, exhaustiveSearch.solution(A4));
		assertEquals(SOL5, exhaustiveSearch.solution(A5));
		assertEquals(SOL6, exhaustiveSearch.solution(A6));
	}

	@Test
	public void testSolutionRandomInput() {
		final Peaks peaks = new Peaks();
		final Peaks.ExhaustiveSearch exhaustiveSearch = new Peaks.ExhaustiveSearch();
		for (int t = 0; t < NUM_TESTS; t++) {
			final int N = MoreInts.newRandom(MIN_N, MAX_N);
			final int[] A = MoreInts.newRandomArray(N, MIN_INT, MAX_INT);
			final int expected = exhaustiveSearch.solution(A);
			final int actual = peaks.solution(A);
			if (expected != actual) {
				System.out.println(String.format("N = %d, A = %s", N, Arrays.toString(A)));
			}
			assertEquals(expected, actual);
		}
	}
}
