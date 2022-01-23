package codility.lesson03;

import codility.util.MoreInts;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TapeEquilibriumTest {

	private static final int NUM_TESTS = 50;
	private static final int MIN_N = 2;
	private static final int MAX_N  = 100_000;
	private static final int MIN_INT = -1_000;
	private static final int MAX_INT = 1_000;

	private static final int[] A1 = { 3, 1, 2, 4, 3 };
	private static final int SOL1 = 1;

	private static final int[] A2 = { 20, 1, 2, 3, 4, 5 };
	private static final int SOL2 = 5;

	private static final int[] A3 = { 20, 1};
	private static final int SOL3 = 19;

	private static final int[] A4 = { 1, 10};
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
	public void testExhaustiveSearch() {
		assertEquals(SOL1, TapeEquilibrium.exhaustiveSearch(A1));
		assertEquals(SOL2, TapeEquilibrium.exhaustiveSearch(A2));
		assertEquals(SOL3, TapeEquilibrium.exhaustiveSearch(A3));
		assertEquals(SOL4, TapeEquilibrium.exhaustiveSearch(A4));

	}
	
	@Test
	public void testSolutionRandomInput() {
		final TapeEquilibrium tapeEquilibrium = new TapeEquilibrium();
		for (int t = 0; t < NUM_TESTS; t++) {
			final int n = MoreInts.newRandom(MIN_N, 10_000);
			final int[] a = MoreInts.newRandomArray(n, MIN_INT, MAX_INT);
			final int expected = TapeEquilibrium.exhaustiveSearch(a);
			final int actual = tapeEquilibrium.solution(a);
			if (expected != actual) {
				System.out.println(Arrays.toString(a));
			}
			assertEquals(expected, actual);
		}
	}
	
	@Test
	public void testSolutionWithConstantSpaceRandomInput() {
		for (int t = 0; t < NUM_TESTS; t++) {
			final int n = MoreInts.newRandom(MIN_N, 10_000);
			final int[] a = MoreInts.newRandomArray(n, MIN_INT, MAX_INT);
			final int expected = TapeEquilibrium.exhaustiveSearch(a);
			final int actual = TapeEquilibrium.solutionWithConstantSpace(a);
			if (expected != actual) {
				System.out.println(Arrays.toString(a));
			}
			assertEquals(expected, actual);
		}
	}

	@Test
	public void testSolutionRandomInputMaxN() {
		final TapeEquilibrium tapeEquilibrium = new TapeEquilibrium();
		for (int t = 0; t < NUM_TESTS; t++) {
			final int n = MoreInts.newRandom(MIN_N, MAX_N);
			final int[] a = MoreInts.newRandomArray(n, MIN_INT, MAX_INT);
			final int expected = TapeEquilibrium.solutionWithConstantSpace(a);
			final int actual = tapeEquilibrium.solution(a);
			if (expected != actual) {
				System.out.println(Arrays.toString(a));
			}
			assertEquals(expected, actual);
		}
	}
}
