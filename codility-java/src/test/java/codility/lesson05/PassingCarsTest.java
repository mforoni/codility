package codility.lesson05;

import codility.util.MoreInts;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PassingCarsTest {
	
	private static final int MAX_N = 100_000;

	private static final int[] A1 = { 0, 1, 0, 1, 1 };
	private static final int SOL1 = 5;

	private static final int[] A2 = { 0 };
	private static final int SOL2 = 0;
	
	private static final int[] A3 = { 0, 1 };
	private static final int SOL3 = 1;

	@Test
	public void testSolution() {
		final PassingCars passingCars = new PassingCars();
		assertEquals(SOL1, passingCars.solution(A1));
		assertEquals(SOL2, passingCars.solution(A2));
		assertEquals(SOL3, passingCars.solution(A3));
	}
	
	@Test
	public void testMassive() {
		final PassingCars passingCars = new PassingCars();
		int ntest = 200;
		for (int i = 0; i < ntest; i++) {
			final int[] a = MoreInts.newRandomArray(MAX_N, 0, 1);
			assertTrue(passingCars.solution(a) >= -1);
		}
	}
}
