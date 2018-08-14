package codility.lesson7;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NestingTest {

	private static final String S1 = "(()(())())";
	private static final int SOL1 = 1;

	private static final String S2 = "())";
	private static final int SOL2 = 0;
	

	private static final String S3 = "";
	private static final int SOL3 = 1;

	@Test
	public void testSolution() {
		final Nesting nesting = new Nesting();
		assertEquals(SOL1, nesting.solution(S1));
		assertEquals(SOL2, nesting.solution(S2));
		assertEquals(SOL3, nesting.solution(S3));
	}
}
