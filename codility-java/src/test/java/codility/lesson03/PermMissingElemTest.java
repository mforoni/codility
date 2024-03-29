package codility.lesson03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PermMissingElemTest {

	private static final int[] A1 = {2, 3, 1, 5};
	private static final int SOL1 = 4;

	private static final int[] A2 = {};
	private static final int SOL2 = 1;
	
	@Test
	public void testSolution() {
		final PermMissingElem permMissingElem = new PermMissingElem();
		assertEquals(SOL1, permMissingElem.solution(A1));
		assertEquals(SOL2, permMissingElem.solution(A2));
	}

	@Test
	public void testSuboptimal() {
		assertEquals(SOL1, PermMissingElem.suboptimal(A1));
		assertEquals(SOL2, PermMissingElem.suboptimal(A2));
	}
}
