package codility.lesson7;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class BracketsTest {

	private static final String S1 = "{[()()]}";
	private static final int SOL1 = 1;

	private static final String S2 = "([)()]";
	private static final int SOL2 = 0;

	private static final String S3 = "";
	private static final int SOL3 = 1;

	private static final String S4 = "([])[()]";
	private static final int SOL4 = 1;

	private static final String S5 = "()(([])[()])";
	private static final int SOL5 = 1;
	
	private static final String S6 = ")(";
	private static final int SOL6 = 0;
	
	private static final String S7 = "(((";
	private static final int SOL7 = 0;

	@Test
	public void testSolution() {
		final Brackets brackets = new Brackets();
		assertEquals(SOL1, brackets.solution(S1));
		assertEquals(SOL2, brackets.solution(S2));
		assertEquals(SOL3, brackets.solution(S3));
		assertEquals(SOL4, brackets.solution(S4));
		assertEquals(SOL5, brackets.solution(S5));
		assertEquals(SOL6, brackets.solution(S6));
		assertEquals(SOL7, brackets.solution(S7));
	}

	@Test
	public void testWrongSolution() {
		assertEquals(SOL1, Brackets.wrongSolution(S1));
		assertNotEquals(SOL2, Brackets.wrongSolution(S2));
		assertEquals(SOL3, Brackets.wrongSolution(S3));
		assertEquals(SOL4, Brackets.wrongSolution(S4));
		assertEquals(SOL5, Brackets.wrongSolution(S5));
		assertEquals(SOL6, Brackets.wrongSolution(S6));
		assertEquals(SOL7, Brackets.wrongSolution(S7));
	}
}
