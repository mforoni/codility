package codility.lesson13;

import codility.util.MoreInts;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibFrogTest {

	private static final int NUM_TESTS = 200;
	private static final int MIN_N = 0;
	private static final int MAX_N = 100_000;
	private static final int MIN_INT = 0;
	private static final int MAX_INT = 1;

	private static final int[] A1 = { 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0 };
	private static final int SOL1 = 3;
	private static final List<Integer> MIN_FIB_JUMP_SEQ1 = Arrays.asList(5 , 2 , 5);

	private static final int[] A2 = {}; // 1 jump = Fib(1) = 1
	private static final int SOL2 = 1;
	private static final List<Integer> MIN_FIB_JUMP_SEQ2 = Arrays.asList(1);

	private static final int[] A3 = { 1 }; // 1 jump = Fib(2) = 2
	private static final int SOL3 = 1;
	private static final List<Integer> MIN_FIB_JUMP_SEQ3 = Arrays.asList(2);

	private static final int[] A4 = { 0 }; // 1 jump = Fib(2) = 2
	private static final int SOL4 = 1;
	private static final List<Integer> MIN_FIB_JUMP_SEQ4 = Arrays.asList(2);

	private static final int[] A5 = { 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0 };
	private static final int SOL5 = -1;
	private static final List<Integer> MIN_FIB_JUMP_SEQ5 = Collections.emptyList();

	private static final int[] A6 = { 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1 };
	private static final int SOL6 = 3;
	private static final List<Integer> MIN_FIB_JUMP_SEQ6 = Arrays.asList(13, 2, 5);

	@Test
	public void testSolution() {
		final FibFrog fibFrog = new FibFrog();
		assertEquals(SOL1, fibFrog.solution(A1));
		assertEquals(SOL2, fibFrog.solution(A2));
		assertEquals(SOL3, fibFrog.solution(A3));
		assertEquals(SOL4, fibFrog.solution(A4));
		assertEquals(SOL5, fibFrog.solution(A5));
		assertEquals(SOL6, fibFrog.solution(A6));
	}

	@Test
	public void testExhaustiveSearch() {
		final FibFrog.ExhaustiveSearch exhaustiveSearch = new FibFrog.ExhaustiveSearch();
		assertEquals(SOL1, exhaustiveSearch.solution(A1));
		assertEquals(SOL2, exhaustiveSearch.solution(A2));
		assertEquals(SOL3, exhaustiveSearch.solution(A3));
		assertEquals(SOL4, exhaustiveSearch.solution(A4));
		assertEquals(SOL5, exhaustiveSearch.solution(A5));
		assertEquals(SOL6, exhaustiveSearch.solution(A6));
	}

	@Test
	public void testMinFibJumSequence() {
		final FibFrog.MinFibJumpSequence minFibJumpSequence = new FibFrog.MinFibJumpSequence();
		assertEquals(MIN_FIB_JUMP_SEQ1, minFibJumpSequence.solution(A1));
		assertEquals(MIN_FIB_JUMP_SEQ2, minFibJumpSequence.solution(A2));
		assertEquals(MIN_FIB_JUMP_SEQ3, minFibJumpSequence.solution(A3));
		assertEquals(MIN_FIB_JUMP_SEQ4, minFibJumpSequence.solution(A4));
		assertEquals(MIN_FIB_JUMP_SEQ5, minFibJumpSequence.solution(A5));
		assertEquals(MIN_FIB_JUMP_SEQ6, minFibJumpSequence.solution(A6));
	}

	@Test
	public void testSolutionRandomInput() {
		final FibFrog fibFrog = new FibFrog();
		final FibFrog.ExhaustiveSearch exhaustiveSearch = new FibFrog.ExhaustiveSearch();
		for (int t = 0; t < NUM_TESTS; t++) {
			final int N = MoreInts.newRandom(MIN_N, 50);
			final int[] A = MoreInts.newRandomArray(N, MIN_INT, MAX_INT);
			final int expected = exhaustiveSearch.solution(A);
			final int actual = fibFrog.solution(A);
			if (expected != actual) {
				System.out.printf("N = %d, A = %s", N, Arrays.toString(A));
			}
			assertEquals(expected, actual);
		}
	}
}
