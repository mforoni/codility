package codility.lesson06;

import codility.util.MoreInts;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {

	private static final int NUM_TESTS = 200;
	private static final int MIN_N = 0;
	private static final int MAX_N = 100_000;
	private static final int MIN_INT = Integer.MIN_VALUE;
	private static final int MAX_INT = Integer.MAX_VALUE -1;

	private static final int[] A1 = { 10, 2, 5, 1, 8, 20 };
	private static final int SOL1 = 1;

	private static final int[] A2 = { 10, 50, 5, 1 };
	private static final int SOL2 = 0;

	private static final int[] A3 = { 1, 2, 3 };
	private static final int SOL3 = 0;

	private static final int[] A4 = { 4, 2, 3 };
	private static final int SOL4 = 1;

	private static final int[] A5 = {};
	private static final int SOL5 = 0;

	@Test
	public void solution() {
		final Triangle triangle = new Triangle();
		assertEquals(SOL1, triangle.solution(A1));
		assertEquals(SOL2, triangle.solution(A2));
		assertEquals(SOL3, triangle.solution(A3));
		assertEquals(SOL4, triangle.solution(A4));
		assertEquals(SOL5, triangle.solution(A5));
	}

	@Test
	public void subOptimal() {
		assertEquals(SOL1, Triangle.subOptimal(A1));
		assertEquals(SOL2, Triangle.subOptimal(A2));
		assertEquals(SOL3, Triangle.subOptimal(A3));
		assertEquals(SOL4, Triangle.subOptimal(A4));
		assertEquals(SOL5, Triangle.subOptimal(A5));
	}

	@Test
	public void exhaustiveSearch() {
		assertEquals(SOL1, Triangle.exhaustiveSearch(A1));
		assertEquals(SOL2, Triangle.exhaustiveSearch(A2));
		assertEquals(SOL3, Triangle.exhaustiveSearch(A3));
		assertEquals(SOL4, Triangle.exhaustiveSearch(A4));
		assertEquals(SOL5, Triangle.exhaustiveSearch(A5));
	}

	@Test
	public void solutionRandomInput() {
		final Triangle triangle = new Triangle();
		for (int t = 0; t < NUM_TESTS; t++) {
			final int N = MoreInts.newRandom(MIN_N, MAX_N);
			final int[] A = MoreInts.newRandomArray(N, MIN_INT, MAX_INT);
			assertEquals(Triangle.exhaustiveSearch(A), triangle.solution(A));
		}
	}
}
