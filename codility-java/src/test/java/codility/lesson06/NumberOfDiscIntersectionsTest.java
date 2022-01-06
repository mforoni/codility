package codility.lesson06;

import codility.util.MoreInts;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfDiscIntersectionsTest {

	public static final int NUM_TEST = 100;
	private static final int MIN_N = 0;
	private static final int MAX_N = 100_000; // original = 100_000;
	private static final int MIN_INT = 0;
	private static final int MAX_INT = Integer.MAX_VALUE - 1;

	private static final int[] A1 = { 1, 5, 2, 1, 4, 0 };
	private static final int SOL1 = 11;

	private static final int[] A2 = {};
	private static final int SOL2 = 0;

	private static final int[] A3 = { 0, 0, 0 };
	private static final int SOL3 = 0;

	private static final int[] A4 = { 0, 1, 0 };
	private static final int SOL4 = 2;

	private static final int[] A5 = { 1, 0 };
	private static final int SOL5 = 1;

	@Test
	public void testSolution() {
		final NumberOfDiscIntersections numberOfDiscIntersections = new NumberOfDiscIntersections();
		assertEquals(SOL1, numberOfDiscIntersections.solution(A1));
		assertEquals(SOL2, numberOfDiscIntersections.solution(A2));
		assertEquals(SOL3, numberOfDiscIntersections.solution(A3));
		assertEquals(SOL4, numberOfDiscIntersections.solution(A4));
		assertEquals(SOL5, numberOfDiscIntersections.solution(A5));
	}

	@Test
	public void testExhaustiveSearch() {
		assertEquals(SOL1, NumberOfDiscIntersections.exhaustiveSearch(A1));
		assertEquals(SOL2, NumberOfDiscIntersections.exhaustiveSearch(A2));
		assertEquals(SOL3, NumberOfDiscIntersections.exhaustiveSearch(A3));
		assertEquals(SOL4, NumberOfDiscIntersections.exhaustiveSearch(A4));
		assertEquals(SOL5, NumberOfDiscIntersections.exhaustiveSearch(A5));
	}

	@Test
	public void testElegantSolution() {
		assertEquals(SOL1, NumberOfDiscIntersections.elegantSolution(A1));
		assertEquals(SOL2, NumberOfDiscIntersections.elegantSolution(A2));
		assertEquals(SOL3, NumberOfDiscIntersections.elegantSolution(A3));
		assertEquals(SOL4, NumberOfDiscIntersections.elegantSolution(A4));
		assertEquals(SOL5, NumberOfDiscIntersections.elegantSolution(A5));
	}

	@Test
	public void testSolutionRandomInput() {
		final NumberOfDiscIntersections numberOfDiscIntersections = new NumberOfDiscIntersections();
		for (int t = 0; t < NUM_TEST; t++) {
			final int N = MoreInts.newRandom(MIN_N, MAX_N);
			final int[] A = MoreInts.newRandomArray(N, MIN_INT, MAX_INT);
			try {
				assertEquals(NumberOfDiscIntersections.exhaustiveSearch(A), numberOfDiscIntersections.solution(A));
			} catch (AssertionError e) {
				System.out.println(MoreInts.toString(A));
				throw e;
			}
		}
	}

	@Test
	public void testElegantSolutionRandomInput() {
		for (int t = 0; t < NUM_TEST; t++) {
			final int N = MoreInts.newRandom(MIN_N, MAX_N);
			final int[] A = MoreInts.newRandomArray(N, MIN_INT, MAX_INT);
			try {
				assertEquals(NumberOfDiscIntersections.exhaustiveSearch(A), NumberOfDiscIntersections.elegantSolution(A));
			} catch (AssertionError e) {
				System.out.println(MoreInts.toString(A));
				throw e;
			}
		}
	}
}
