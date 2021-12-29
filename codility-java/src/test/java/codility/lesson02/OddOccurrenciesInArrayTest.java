package codility.lesson02;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import codility.lesson02.OddOccurrencesInArray;
import codility.util.MoreInts;

public class OddOccurrenciesInArrayTest {

	public static final int MIN_N = 1;
	public static final int MAX_N = 1_000_000;
	public static final int MIN_INT = 1;
	public static final int MAX_INT = 1_000_000_000;

	private static final int[] A1 = { 9, 3, 9, 3, 9, 7, 9 };
	private static final int SOL1 = 7;
	private static final int[] A2 = { 9 };
	private static final int SOL2 = 9;
	private static final int[] A3 = { 9, 9, 2, 4, 5, 6, 4, 5, 6 };
	private static final int SOL3 = 2;
	private static final int[] A4 = { 9, 3, 9, 3, 9, 7, 9, 7, 7 };
	private static final int SOL4 = 7;

	@Test
	public void testSolution() {
		final OddOccurrencesInArray occurrencesInArray = new OddOccurrencesInArray();
		assertEquals(SOL1, occurrencesInArray.solution(A1));
		assertEquals(SOL2, occurrencesInArray.solution(A2));
		assertEquals(SOL3, occurrencesInArray.solution(A3));
		assertEquals(SOL4, occurrencesInArray.solution(A4));
	}

	@Test
	public void testMoveUnpairedToTheEnd() {
		assertEquals(SOL1, OddOccurrencesInArray.moveUnpairedToTheEnd(A1.clone()));
		assertEquals(SOL2, OddOccurrencesInArray.moveUnpairedToTheEnd(A2.clone()));
		assertEquals(SOL3, OddOccurrencesInArray.moveUnpairedToTheEnd(A3.clone()));
		assertEquals(SOL4, OddOccurrencesInArray.moveUnpairedToTheEnd(A4.clone()));
	}

	@Test
	public void testWithMap() {
		assertEquals(SOL1, OddOccurrencesInArray.withMap(A1));
		assertEquals(SOL2, OddOccurrencesInArray.withMap(A2));
		assertEquals(SOL3, OddOccurrencesInArray.withMap(A3));
		assertEquals(SOL4, OddOccurrencesInArray.withMap(A4));
	}

	@Test
	public void testMassive() {
		int ntest = 20;
		for (int t = 0; t < ntest; t++) {
			final int halfN = MoreInts.newRandom(MIN_N, 1000 / 2 - 1);
			final int[] halfA = MoreInts.newRandomArray(halfN, MIN_INT, MAX_INT);
			final int[] A = new int[halfN * 2 + 1];
			A[halfN * 2] = MoreInts.newRandom(MIN_INT, MAX_INT);
			for (int i = 0; i < A.length - 1; i++) {
				A[i] = i >= halfN ? halfA[i % halfN] : halfA[i];
			}
			// TODO "unsort" A, "swapify" A
			assertEquals(OddOccurrencesInArray.withMap(A), OddOccurrencesInArray.moveUnpairedToTheEnd(A));
		}
	}

}
