package codility.lesson07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NestingTest {

	private static final String S1 = "(()(())())";
	private static final int SOL1 = 1;

	private static final String S2 = "())";
	private static final int SOL2 = 0;

	private static final String S3 = "";
	private static final int SOL3 = 1;

	@Test
	public void solution() {
		final Nesting nesting = new Nesting();
		assertEquals(SOL1, nesting.solution(S1));
		assertEquals(SOL2, nesting.solution(S2));
		assertEquals(SOL3, nesting.solution(S3));
	}

	@Test
	public void subOptimal() {
		assertEquals(SOL1, Nesting.subOptimal(S1));
		assertEquals(SOL2, Nesting.subOptimal(S2));
		assertEquals(SOL3, Nesting.subOptimal(S3));
	}
}
