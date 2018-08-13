package codility.lesson4;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.common.primitives.Ints;

import codility.util.MoreInts;

public class MissingIntegerTest {

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
	public void testSolution() {
		final MissingInteger missingInteger = new MissingInteger();
		assertEquals(SOL1, missingInteger.solution(A1));
		assertEquals(SOL2, missingInteger.solution(A2));
		assertEquals(SOL3, missingInteger.solution(A3));
		assertEquals(SOL4, missingInteger.solution(A4));
	}

	@Test
	public void testSortAndFind() {
		assertEquals(SOL1, MissingInteger.sortAndFind(A1.clone()));
		assertEquals(SOL2, MissingInteger.sortAndFind(A2.clone()));
		assertEquals(SOL3, MissingInteger.sortAndFind(A3.clone()));
		assertEquals(SOL4, MissingInteger.sortAndFind(A4.clone()));
	}

	@Test
	public void testWithHashSet() {
		assertEquals(SOL1, MissingInteger.withHashSet(A1));
		assertEquals(SOL2, MissingInteger.withHashSet(A2));
		assertEquals(SOL3, MissingInteger.withHashSet(A3));
		assertEquals(SOL4, MissingInteger.withHashSet(A4));
	}

	@Test
	public void testMassive() {
		final MissingInteger missingInteger = new MissingInteger();
		final int ntest = 200;
		for (int t = 0; t < ntest; t++) {
			final int n = MoreInts.newRandom(1, N);
			final int[] a = MoreInts.newRandomArray(n, MIN, MAX);
			final int[] b = a.clone();
			final int expected = MissingInteger.withHashSet(a);
			final int sol1 = missingInteger.solution(a);
			final int sol2 = MissingInteger.sortAndFind(b);
			if (sol1 != expected) {
				System.out.println(String.format("Array contains expected value %s? %s", expected, Ints.contains(a, expected)));
				System.out.println(String.format("Array contains solution %s? %s", sol1, Ints.contains(a, sol1)));
			}
			if (sol2 != expected) {
				System.out.println(String.format("Array contains expected value %s? %s", expected, Ints.contains(a, expected)));
				System.out.println(String.format("Array contains solution %s? %s", sol2, Ints.contains(a, sol2)));
			}
			assertEquals(expected, sol1);
			assertEquals(expected, sol2);
			
		}
	}
}
