package codility.lesson07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FishTest {

	private static final int[] A1 = { 4, 3, 2, 1, 5 };
	private static final int[] B1 = { 0, 1, 0, 0, 0 };
	private static final int SOL1 = 2;

	private static final int[] A2 = { 6, 3, 2, 1, 5 };
	private static final int[] B2 = { 1, 1, 0, 0, 0 };
	private static final int SOL2 = 1;

	@Test
	public void testSolution() {
		final Fish fish = new Fish();
		assertEquals(SOL1, fish.solution(A1, B1));
		assertEquals(SOL2, fish.solution(A2, B2));
	}

}
