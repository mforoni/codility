package codility.lesson05;

import codility.util.MoreInts;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PassingCarsTest {

	public static final int NUM_TESTS = 100;
	private static final int MAX_N = 100_000;

	private static final int[] A1 = { 0, 1, 0, 1, 1 };
	private static final int SOL1 = 5;

	private static final int[] A2 = { 0 };
	private static final int SOL2 = 0;
	
	private static final int[] A3 = { 0, 1 };
	private static final int SOL3 = 1;

	@Test
	public void solution() {
		final PassingCars passingCars = new PassingCars();
		assertEquals(SOL1, passingCars.solution(A1));
		assertEquals(SOL2, passingCars.solution(A2));
		assertEquals(SOL3, passingCars.solution(A3));
	}

	@Test
	public void exhaustiveSearch() {
		assertEquals(SOL1, PassingCars.exhaustiveSearch(A1));
		assertEquals(SOL2, PassingCars.exhaustiveSearch(A2));
		assertEquals(SOL3, PassingCars.exhaustiveSearch(A3));
	}
	
	@Test
	public void solutionRandomInput() {
		final PassingCars passingCars = new PassingCars();
		for (int i = 0; i < NUM_TESTS; i++) {
			final int[] A = MoreInts.newRandomArray(5_000, 0, 1);
			final int actual = passingCars.solution(A);
			final int expected = PassingCars.exhaustiveSearch(A);
			assertTrue(actual >= -1);
			assertEquals(expected, actual);
		}
	}
}
