package codility.lesson04;

import codility.util.MoreInts;
import com.google.common.primitives.Ints;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MaxCountersTest {

	private static final int NUM_TESTS = 200;
	private static final int MIN_N_AND_M = 1;
	private static final int MAX_N_AND_M  = 100_000;

	private static final int[] A1 = {3, 4, 4, 6, 1, 4, 4};
	private static final int N1 = 5;
	private static final int[] SOL1 = {3, 2, 2, 4, 2};
	
	private static final int[] A2 = {3, 6, 4, 4, 6, 1, 4};
	private static final int N2 = 5;
	private static final int[] SOL2 = {4, 3, 3, 4, 3};
	
	@Test
	public void testSolution() {
		final MaxCounters maxCounters = new MaxCounters();
		assertArrayEquals(SOL1, maxCounters.solution(N1, A1));
		assertArrayEquals(SOL2, maxCounters.solution(N2, A2));
	}

	@Test
	public void testElegantSolution() {
		assertArrayEquals(SOL1, MaxCounters.elegantSolution(N1, A1));
		assertArrayEquals(SOL2, MaxCounters.elegantSolution(N2, A2));
	}

	@Test
	public void testSuboptimal() {
		assertArrayEquals(SOL1, MaxCounters.suboptimal(N1, A1));
		assertArrayEquals(SOL2, MaxCounters.suboptimal(N2, A2));
	}

	@Test
	public void testElegantSolutionRandomInput() {
		for (int t = 0; t < NUM_TESTS; t++) {
			final int n = MoreInts.newRandom(MIN_N_AND_M, MAX_N_AND_M);
			final int m = MoreInts.newRandom(n, MAX_N_AND_M);
			final int[] a = MoreInts.newRandomArray(m, 1, n + 1);
			final int[] expected = MaxCounters.suboptimal(n, a);
			final int[] actual = MaxCounters.elegantSolution(n, a);
			if (!Arrays.equals(expected, actual)) {
				System.out.println(Ints.join(", ", a));
			}
			assertArrayEquals(expected, actual);
		}
	}

	@Test
	public void testSolutionRandomInput() {
		MaxCounters maxCounters = new MaxCounters();
		for (int t = 0; t < NUM_TESTS; t++) {
			final int n = MoreInts.newRandom(MIN_N_AND_M, MAX_N_AND_M);
			final int m = MoreInts.newRandom(n, MAX_N_AND_M);
			final int[] a = MoreInts.newRandomArray(m, 1, n + 1);
			final int[] expected = MaxCounters.suboptimal(n, a);
			final int[] actual = maxCounters.solution(n, a);
			if (!Arrays.equals(expected, actual)) {
				System.out.println(Ints.join(", ", a));
			}
			assertArrayEquals(expected, actual);
		}
	}
}
