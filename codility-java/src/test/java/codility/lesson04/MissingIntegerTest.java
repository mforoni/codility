package codility.lesson04;

import codility.util.MoreInts;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MissingIntegerTest {

	public static final int NUM_TESTS = 200;
	private static final int MIN = -1_000_000;
	private static final int MAX = 1_000_000;
	private static final int N = 100_000;

	private static final int[] A1 = new int[] { 1, 3, 6, 4, 1, 2 };
	private static final int SOL1 = 5;

	private static final int[] A2 = new int[] {};
	private static final int SOL2 = 1;

	private static final int[] A3 = new int[] { 2 };
	private static final int SOL3 = 1;

	private static final int[] A4 = new int[] { 1 };
	private static final int SOL4 = 2;

	@Test
	public void solution() {
		final MissingInteger missingInteger = new MissingInteger();
		assertEquals(SOL1, missingInteger.solution(A1));
		assertEquals(SOL2, missingInteger.solution(A2));
		assertEquals(SOL3, missingInteger.solution(A3));
		assertEquals(SOL4, missingInteger.solution(A4));
	}

	@Test
	public void solutionBySorting() {
		assertEquals(SOL1, MissingInteger.solutionBySorting(A1.clone()));
		assertEquals(SOL3, MissingInteger.solutionBySorting(A3.clone()));
		assertEquals(SOL4, MissingInteger.solutionBySorting(A4.clone()));
	}

	@Test
	public void solutionWithHashSet() {
		assertEquals(SOL1, MissingInteger.solutionWithHashSet(A1));
		assertEquals(SOL2, MissingInteger.solutionWithHashSet(A2));
		assertEquals(SOL3, MissingInteger.solutionWithHashSet(A3));
		assertEquals(SOL4, MissingInteger.solutionWithHashSet(A4));
	}

	@Test
	public void solutionRandomInput() {
		final MissingInteger missingInteger = new MissingInteger();
		for (int t = 0; t < NUM_TESTS; t++) {
			final int n = MoreInts.newRandom(1, N);
			final int[] a = MoreInts.newRandomArray(n, MIN, MAX);
			final int expected = MissingInteger.solutionWithHashSet(a);
			final int actual = missingInteger.solution(a);
			if (actual != expected) {
				final List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
				System.out.printf("Array contains expected value %s? %s%n", expected, list.contains(expected));
				System.out.printf("Array contains solution %s? %s%n", actual, list.contains(actual));
			}
			assertEquals(expected, actual);
		}
	}
}
