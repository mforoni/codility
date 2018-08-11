package codility.lesson4;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PermCheckTest {

	private static final int[] A1 = { 4, 1, 3, 2 };
	private static final int SOL1 = 1;
	private static final int[] A2 = { 4, 1, 3 };
	private static final int SOL2 = 0;
	private static final int[] A3 = { 1 };
	private static final int SOL3 = 1;

	@Test
	public void testSolution() {
		final PermCheck permCheck = new PermCheck();
		assertEquals(SOL1, permCheck.solution(A1));
		assertEquals(SOL2, permCheck.solution(A2));
		assertEquals(SOL3, permCheck.solution(A3));
	}

}
