package codility.lesson05;

import codility.util.MoreInts;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountDivTest {

	private static final int NUM_TESTS = 200;
	private static final int MIN_A_B = 0;
	private static final int MAX_A_B = 2_000_000_000; // A ≤ B
	private static final int MIN_K = 1;
	private static final int MAX_K = 2_000_000_000;

	private static final int A1 = 6;
	private static final int B1 = 11;
	private static final int K1 = 2;
	private static final int SOL1 = 3;
	
	private static final int A2 = 7;
	private static final int B2 = 7;
	private static final int K2 = 2;
	private static final int SOL2 = 0;
	
	private static final int A3 = 11;
	private static final int B3 = 345;
	private static final int K3 = 17;
	private static final int SOL3 = 20;
	
	private static final int A4 = 0;
	private static final int B4 = 0;
	private static final int K4 = 2;
	private static final int SOL4 = 1;

	@Test
	public void solution() {
		final CountDiv countDiv = new CountDiv();
		assertEquals(SOL1, countDiv.solution(A1, B1, K1));
		assertEquals(SOL2, countDiv.solution(A2, B2, K2));
		assertEquals(SOL3, countDiv.solution(A3, B3, K3));
		assertEquals(SOL4, countDiv.solution(A4, B4, K4));
	}
	
	@Test
	public void checker() {
		assertEquals(SOL1, CountDiv.checker(A1, B1, K1));
		assertEquals(SOL2, CountDiv.checker(A2, B2, K2));
		assertEquals(SOL3, CountDiv.checker(A3, B3, K3));
		assertEquals(SOL4, CountDiv.checker(A4, B4, K4));
	}
	
	@Test
	public void checkerOptimized() {
		assertEquals(SOL1, CountDiv.checkerOptimized(A1, B1, K1));
		assertEquals(SOL2, CountDiv.checkerOptimized(A2, B2, K2));
		assertEquals(SOL3, CountDiv.checkerOptimized(A3, B3, K3));
		assertEquals(SOL4, CountDiv.checkerOptimized(A4, B4, K4));
	}

	@Test
	public void solutionRandomInput() {
		final CountDiv countDiv = new CountDiv();
		for (int i = 0; i < NUM_TESTS; i++) {
			final int A = MoreInts.newRandom(MIN_A_B, 2_000_000);
			final int B = MoreInts.newRandom(A, 2_000_000);
			final int K = MoreInts.newRandom(MIN_K, MAX_K);
			final int expected = CountDiv.checkerOptimized(A, B, K);
			final int actual = countDiv.solution(A, B, K);
			if (expected != actual) {
				System.out.printf("A = %d, B = %d, K = %d%n", A, B, K);
			}
			assertEquals(expected, actual);
		}
	}
}
