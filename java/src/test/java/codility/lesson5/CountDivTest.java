package codility.lesson5;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CountDivTest {

	private static final int A1 = 6;
	private static final int B1 = 11;
	private static final int K1 = 2;
	private static final int SOL1 = 3;
	
	private static final int A2 = 7;
	private static final int B2 = 7;
	private static final int K2 = 2;
	private static final int SOL2 = 0;
	
	private static final int A3 = 11;
	private static final int B3 = 345;
	private static final int K3 = 17;
	private static final int SOL3 = 20;
	
	private static final int A4 = 0;
	private static final int B4 = 0;
	private static final int K4 = 2;
	private static final int SOL4 = 1;

	@Test
	public void testSolution() {
		final CountDiv countDiv = new CountDiv();
		assertEquals(SOL1, countDiv.solution(A1, B1, K1));
		assertEquals(SOL2, countDiv.solution(A2, B2, K2));
		assertEquals(SOL3, countDiv.solution(A3, B3, K3));
		assertEquals(SOL4, countDiv.solution(A4, B4, K4));
	}


	@Test
	public void testConstantTime() {
		assertEquals(SOL1, CountDiv.constantTime(A1, B1, K1));
		assertEquals(SOL2, CountDiv.constantTime(A2, B2, K2));
		assertEquals(SOL3, CountDiv.constantTime(A3, B3, K3));
		assertEquals(SOL4, CountDiv.constantTime(A4, B4, K4));
	}
	
	@Test
	public void testChecker() {
		assertEquals(SOL1, CountDiv.checker(A1, B1, K1));
		assertEquals(SOL2, CountDiv.checker(A2, B2, K2));
		assertEquals(SOL3, CountDiv.checker(A3, B3, K3));
		assertEquals(SOL4, CountDiv.checker(A4, B4, K4));
	}
	
	@Test
	public void testCheckerOptmized() {
		assertEquals(SOL1, CountDiv.checkerOptimized(A1, B1, K1));
		assertEquals(SOL2, CountDiv.checkerOptimized(A2, B2, K2));
		assertEquals(SOL3, CountDiv.checkerOptimized(A3, B3, K3));
		assertEquals(SOL4, CountDiv.checkerOptimized(A4, B4, K4));
	}

}
