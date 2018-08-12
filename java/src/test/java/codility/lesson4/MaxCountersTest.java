package codility.lesson4;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MaxCountersTest {
	
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
	}

	@Test
	public void testSuboptimal() {
		assertArrayEquals(SOL1, MaxCounters.suboptimal(N1, A1));
		assertArrayEquals(SOL2, MaxCounters.suboptimal(N2, A2));
	}

	@Test
	public void testMaxCounter() {
		
	}

}
