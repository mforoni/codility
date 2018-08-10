package codility.lesson2;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class CyclicRotationTest {

	@Test
	public void testSolution() {
		CyclicRotation cyclicRotation = new CyclicRotation();
		int[] A = { 3, 8, 9, 7, 6 };
		int K = 3;
		cyclicRotation.solution(A, K);
		assertArrayEquals(new int[] { 9, 7, 6, 3, 8 }, A);
		A = new int[] { 1, 2, 3, 4 };
		K = 4;
		cyclicRotation.solution(A, K);
		assertArrayEquals(new int[] { 1, 2, 3, 4 }, A);
		A = new int[] { 1, 1, 2, 3, 5 };
		K = 42;
		cyclicRotation.solution(A, K);
		assertArrayEquals(new int[] { 3, 5, 1, 1, 2 }, A);
	}

	@Test
	public void testRotate() {
		int[] A = { 3, 8, 9, 7, 6 };
		CyclicRotation.rotate(A);
		assertArrayEquals(new int[] { 6, 3, 8, 9, 7 }, A);
		CyclicRotation.rotate(A);
		assertArrayEquals(new int[] { 7, 6, 3, 8, 9 }, A);
		A = new int[] { 1, 2, 3, 4 };
		CyclicRotation.rotate(A);
		assertArrayEquals(new int[] { 4, 1, 2, 3 }, A);
	}
}
