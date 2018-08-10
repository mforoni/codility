package codility.lesson3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

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
	public void testSaveFound() {
		assertEquals(SOL1, PermMissingElem.saveFound(A1));
		assertEquals(SOL2, PermMissingElem.saveFound(A2));
		
	}

}
