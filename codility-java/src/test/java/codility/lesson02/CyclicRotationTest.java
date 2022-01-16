package codility.lesson02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CyclicRotationTest {

	private static final int[] A1 = { 3, 8, 9, 7, 6 };
	private static final int K1 = 3;
	private static final int[] SOL1 = { 9, 7, 6, 3, 8 };

	private static final int[] A2 = { 1, 2, 3, 4 };
	private static final int K2 = 4;
	private static final int[] SOL2 = { 1, 2, 3, 4 };

	private static final int[] A3 = { 1, 1, 2, 3, 5 };
	private static final int K3A = 42;
	private static final int K3B = 2;
	private static final int[] SOL3 = { 3, 5, 1, 1, 2 };

	private static final int[] A4 = {};
	private static final int K4 = 5;
	private static final int[] SOL4 = {};


	@Test
	public void testSolution() {
		CyclicRotation cyclicRotation = new CyclicRotation();

		cyclicRotation.solution(A1, K1);
		assertArrayEquals(SOL1, A1);

		cyclicRotation.solution(A2, K2);
		assertArrayEquals(SOL2, A2);

		int[] a3 = Arrays.copyOf(A3, A3.length);
		cyclicRotation.solution(a3, K3A);
		assertArrayEquals(SOL3, a3);

		a3 = Arrays.copyOf(A3, A3.length);
		cyclicRotation.solution(a3, K3B);
		assertArrayEquals(SOL3, a3);

		cyclicRotation.solution(A4, K4);
		assertArrayEquals(SOL4, A4);
	}

	@Test
	public void testRotate() {
		int[] arr = { 3, 8, 9, 7, 6 };
		CyclicRotation.rotate(arr);
		assertArrayEquals(new int[] { 6, 3, 8, 9, 7 }, arr);

		CyclicRotation.rotate(arr);
		assertArrayEquals(new int[] { 7, 6, 3, 8, 9 }, arr);

		arr = new int[] { 1, 2, 3, 4 };
		CyclicRotation.rotate(arr);
		assertArrayEquals(new int[] { 4, 1, 2, 3 }, arr);
	}
}
