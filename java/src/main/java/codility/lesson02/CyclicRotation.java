package codility.lesson02;

/**
 * An array A consisting of N integers is given. Rotation of the array means
 * that each element is shifted right by one index, and the last element of the
 * array is moved to the first place. For example, the rotation of array A = [3,
 * 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6
 * is moved to the first place).
 * <p>
 * The goal is to rotate array A K times; that is, each element of A will be
 * shifted to the right K times.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int[] solution(int[] A, int K); }
 * <p>
 * that, given an array A consisting of N integers and an integer K, returns the
 * array A rotated K times.
 * <p>
 * For example, given
 * <p>
 * A = [3, 8, 9, 7, 6]<br>
 * K = 3
 * <p>
 * the function should return [9, 7, 6, 3, 8]. Three rotations were made:
 * <p>
 * [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]<br>
 * [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]<br>
 * [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]<br>
 * <p>
 * For another example, given
 * <p>
 * A = [0, 0, 0]<br>
 * K = 1
 * <p>
 * the function should return [0, 0, 0]
 * <p>
 * Given
 * <p>
 * A = [1, 2, 3, 4]<br>
 * K = 4
 * <p>
 * the function should return [1, 2, 3, 4]
 * <p>
 * Assume that:
 * <p>
 * N and K are integers within the range [0..100];<br>
 * each element of array A is an integer within the range [−1,000..1,000].
 * <p>
 * In your solution, focus on correctness. The performance of your solution will
 * not be the focus of the assessment.
 * 
 * @author Foroni Marco
 *
 */
final class CyclicRotation {

	public int[] solution(int[] A, int K) {
		if (A.length > 0 && K > 0) {
			final int times = K > A.length ? K % A.length : K;
			for (int i = 0; i < times; i++) {
				rotate(A);
			}
		}
		return A;
	}

	public static void rotate(int[] A) {
		final int last = A[A.length - 1];
		for (int i = A.length - 1; i > 0; i--) {
			A[i] = A[i - 1];
		}
		A[0] = last;
	}
}
