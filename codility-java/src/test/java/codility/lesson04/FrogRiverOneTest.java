package codility.lesson04;

import codility.util.MoreInts;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class FrogRiverOneTest {

	private static final int NUM_TESTS = 10;
	private static final int MIN_N_AND_X = 1;
	private static final int MAX_N_AND_X = 100_000;

	private static final int[] A1 = { 1, 3, 1, 4, 2, 3, 5, 4 };
	private static final int X1 = 5;
	private static final int SOL1 = 6;

	private static final int[] A2 = { 1, 3, 1, 4, 2, 3, 5, 4 };
	private static final int X2 = 7;
	private static final int SOL2 = -1;

	private static final int[] A3 = { 1 };
	private static final int X3 = 1;
	private static final int SOL3 = 0;

	private static final int[] A4 = { 1, 2 };
	private static final int X4 = 2;
	private static final int SOL4 = 1;

	private static final int[] A5 = { 2, 1 };
	private static final int X5 = 2;
	private static final int SOL5 = 1;

	@Test
	public void solution() {
		final FrogRiverOne frogRiverOne = new FrogRiverOne();
		assertEquals(SOL1, frogRiverOne.solution(X1, A1));
		assertEquals(SOL2, frogRiverOne.solution(X2, A2));
		assertEquals(SOL3, frogRiverOne.solution(X3, A3));
		assertEquals(SOL4, frogRiverOne.solution(X4, A4));
		assertEquals(SOL5, frogRiverOne.solution(X5, A5));
	}

	@Test
	public void elegantSolution() {
		assertEquals(SOL1, FrogRiverOne.elegantSolution(X1, A1));
		assertEquals(SOL2, FrogRiverOne.elegantSolution(X2, A2));
		assertEquals(SOL3, FrogRiverOne.elegantSolution(X3, A3));
		assertEquals(SOL4, FrogRiverOne.elegantSolution(X4, A4));
		assertEquals(SOL5, FrogRiverOne.elegantSolution(X5, A5));
	}

	@Test
	public void exhaustiveSearch() {
		assertEquals(SOL1, FrogRiverOne.exhaustiveSearch(X1, A1));
		assertEquals(SOL2, FrogRiverOne.exhaustiveSearch(X2, A2));
		assertEquals(SOL3, FrogRiverOne.exhaustiveSearch(X3, A3));
		assertEquals(SOL4, FrogRiverOne.exhaustiveSearch(X4, A4));
		assertEquals(SOL5, FrogRiverOne.exhaustiveSearch(X5, A5));
	}

	@Test
	public void ensureSoundness() {
		assertTrue(FrogRiverOne.ensureSoundness(X1, A1, SOL1));
		assertFalse(FrogRiverOne.ensureSoundness(X2, A2, SOL2));
		assertTrue(FrogRiverOne.ensureSoundness(X3, A3, SOL3));
		assertTrue(FrogRiverOne.ensureSoundness(X4, A4, SOL4));
		assertTrue(FrogRiverOne.ensureSoundness(X5, A5, SOL5));
	}

	@Test
	public void solutionRandomInput() {
		final FrogRiverOne frogRiverOne = new FrogRiverOne();
		for (int t = 0; t < NUM_TESTS; t++) {
			final int x = MoreInts.newRandom(MIN_N_AND_X, MAX_N_AND_X);
			final int n = MoreInts.newRandom(x, MAX_N_AND_X);
			final int[] a = MoreInts.newRandomArray(n, 1, x);
			final int expected = FrogRiverOne.exhaustiveSearch(x, a);
			final int actual = frogRiverOne.solution(x, a);
			if (expected != actual) {
				System.out.printf("X = %d, A = %s.%n", x, Arrays.toString(a));
			}
			assertEquals(expected, actual);
		}
	}

	@Test
	public void elegantSolutionRandomInput() {
		for (int t = 0; t < NUM_TESTS; t++) {
			final int x = MoreInts.newRandom(MIN_N_AND_X, MAX_N_AND_X);
			final int n = MoreInts.newRandom(x, MAX_N_AND_X);
			final int[] a = MoreInts.newRandomArray(n, 1, x);
			final int expected = FrogRiverOne.exhaustiveSearch(x, a);
			final int actual = FrogRiverOne.elegantSolution(x, a);
			if (expected != actual) {
				System.out.printf("X = %d, A = %s.%n", x, Arrays.toString(a));
			}
			assertEquals(expected, actual);
		}
	}
}
