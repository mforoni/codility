package codility.lesson07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoneWallTest {

	private static final int[] H = { 8, 8, 5, 7, 9, 8, 7, 4, 8 };
	private static final int SOL = 7;

	@Test
	public void testSolution() {
		final StoneWall stoneWall = new StoneWall();
		assertEquals(SOL, stoneWall.solution(H));
	}

}
