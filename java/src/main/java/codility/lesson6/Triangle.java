package codility.lesson6;

import java.util.Arrays;

/**
 * An array A consisting of N integers is given. A triplet (P, Q, R) is
 * triangular if 0 ≤ P < Q < R < N and:
 * <p>
 * A[P] + A[Q] > A[R],<br>
 * A[Q] + A[R] > A[P],<br>
 * A[R] + A[P] > A[Q].
 * <p>
 * For example, consider array A such that:
 * <p>
 * A[0] = 10 A[1] = 2 A[2] = 5 A[3] = 1 A[4] = 8 A[5] = 20
 * <p>
 * Triplet (0, 2, 4) is triangular.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, returns 1 if there exists a
 * triangular triplet for this array and returns 0 otherwise.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 10 A[1] = 2 A[2] = 5 A[3] = 1 A[4] = 8 A[5] = 20 the function should
 * return 1, as explained above. Given array A such that:
 * <p>
 * A[0] = 10 A[1] = 50 A[2] = 5 A[3] = 1 the function should return 0.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [0..100,000];<br>
 * each element of array A is an integer within the range
 * [−2,147,483,648..2,147,483,647].
 * <p>
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N*log(N));<br>
 * expected worst-case space complexity is O(N) (not counting the storage
 * required for input arguments).
 * 
 * @author Foroni Marco
 *
 */
final class Triangle {

	/**
	 * Time complexity is O(N*log(N))<br>
	 * Space complexity is O(N)
	 * <p>
	 * N is the length of the array A.<br>
	 * Suppose that A is sorted: for each i in {0...N-1} A[i] < A[i+1]
	 * <p>
	 * Therefore for each i in {0...N-1} A[i] < A[i+1] + A[i+2] AND A[i+1] < A[i+2]
	 * + A[i]
	 * <p>
	 * So in a sorted array for each i,j,k in {0...N-1} such that i<j<k the
	 * equations (2) and (3) are true.
	 * <p>
	 * We have to check if exists an i such that A[i+2] < A[i] + A[i+1]
	 * 
	 */
	public int solution(int[] A) {
		final int[] S = A.clone();
		Arrays.sort(S);
		for (int i = S.length - 1; i >= 2; i--) {
			try {
				if (S[i] < Math.addExact(S[i - 1], S[i - 2])) { // an integer overflow may occur
					return 1;
				}
			} catch (ArithmeticException e) {
				long sum = (long) S[i - 1] + (long) S[i - 2];
				if (S[i] < sum) {
					return 1;
				}
			}
		}
		return 0;
	}

	/**
	 * Time complexity is O(N^3)<br>
	 * Space complexity is O(1)
	 * 
	 * @param A
	 * @return
	 */
	public static int exhaustiveSearch(final int[] A) {
		if (A.length < 3) {
			return 0;
		}
		for (int p = 0; p < A.length - 2; p++) {
			for (int q = p + 1; q < A.length - 1; q++) {
				for (int r = q + 1; r < A.length; r++) {
					if (A[p] + A[q] > A[r] && A[q] + A[r] > A[p] && A[r] + A[p] > A[q]) {
						return 1;
					}
				}
			}
		}
		return 0;
	}
}
