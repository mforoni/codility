package codility.lesson06;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import codility.lesson06.MaxProductOfThree;

public class MaxProductOfThreeTest {

	private static final int[] A1 = { -3, 1, 2, -2, 5, 6 };
	private static final int SOL1 = 60;

	private static final int[] A2 = { 6, 5, 4, 3, 2, 1 };
	private static final int SOL2 = 120;

	private static final int[] A3 = { -100, -50, 1, 2, 3, 4, 5 };
	private static final int SOL3 = 25_000;

	private static final int[] A4 = { -3, -2, -1, 10, 20 };
	private static final int SOL4 = 120;

	@Test
	public void testSolution() {
		final MaxProductOfThree maxProductOfThree = new MaxProductOfThree();
		assertEquals(SOL1, maxProductOfThree.solution(A1));
		assertEquals(SOL2, maxProductOfThree.solution(A2));
		assertEquals(SOL3, maxProductOfThree.solution(A3));
		assertEquals(SOL4, maxProductOfThree.solution(A4));
	}

	@Test
	public void testExhaustiveSearch() {
		assertEquals(SOL1, MaxProductOfThree.exhaustiveSearch(A1));
		assertEquals(SOL2, MaxProductOfThree.exhaustiveSearch(A2));
		assertEquals(SOL3, MaxProductOfThree.exhaustiveSearch(A3));
		assertEquals(SOL4, MaxProductOfThree.exhaustiveSearch(A4));
	}
}
