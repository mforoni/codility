package codility.lesson04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PermCheckTest {

	private static final int[] A1 = { 4, 1, 3, 2 };
	private static final int SOL1 = 1;

	private static final int[] A2 = { 4, 1, 3 };
	private static final int SOL2 = 0;

	private static final int[] A3 = { 1 };
	private static final int SOL3 = 1;

	@Test
	public void solution() {
		final PermCheck permCheck = new PermCheck();
		assertEquals(SOL1, permCheck.solution(A1));
		assertEquals(SOL2, permCheck.solution(A2));
		assertEquals(SOL3, permCheck.solution(A3));
	}

	@Test
	public void elegantSolution() {
		assertEquals(SOL1, PermCheck.elegantSolution(A1));
		assertEquals(SOL2, PermCheck.elegantSolution(A2));
		assertEquals(SOL3, PermCheck.elegantSolution(A3));
	}
}
