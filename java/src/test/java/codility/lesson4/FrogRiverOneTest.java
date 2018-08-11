package codility.lesson4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FrogRiverOneTest {

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
	public void testSolution() {
		final FrogRiverOne frogRiverOne = new FrogRiverOne();
		assertEquals(SOL1, frogRiverOne.solution(X1, A1));
		assertEquals(SOL2, frogRiverOne.solution(X2, A2));
		assertEquals(SOL3, frogRiverOne.solution(X3, A3));
		assertEquals(SOL4, frogRiverOne.solution(X4, A4));
		assertEquals(SOL5, frogRiverOne.solution(X5, A5));
	}

	@Test
	public void testExhaustiveSearch() {
		assertEquals(SOL1, FrogRiverOne.exhaustiveSearch(X1, A1));
		assertEquals(SOL2, FrogRiverOne.exhaustiveSearch(X2, A2));
		assertEquals(SOL3, FrogRiverOne.exhaustiveSearch(X3, A3));
		assertEquals(SOL4, FrogRiverOne.exhaustiveSearch(X4, A4));
		assertEquals(SOL5, FrogRiverOne.exhaustiveSearch(X5, A5));
	}

	public void testEnsureSoundness() {
		assertTrue(FrogRiverOne.ensureSoundness(X1, A1, SOL1));
		assertTrue(FrogRiverOne.ensureSoundness(X2, A2, SOL2));
		assertTrue(FrogRiverOne.ensureSoundness(X3, A3, SOL3));
		assertTrue(FrogRiverOne.ensureSoundness(X4, A4, SOL4));
		assertTrue(FrogRiverOne.ensureSoundness(X5, A5, SOL5));
	}

}
