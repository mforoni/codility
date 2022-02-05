package codility.lesson09;

import codility.util.MoreInts;

import java.util.Arrays;

/**
 * A non-empty array A consisting of N integers is given. A pair of integers (P,
 * Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A. The sum of a slice
 * (P, Q) is the total of A[P] + A[P+1] + ... + A[Q].
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, returns the maximum sum of
 * any slice of A.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 3 A[1] = 2 A[2] = -6 A[3] = 4 A[4] = 0 the function should return 5
 * because:
 * <p>
 * (3, 4) is a slice of A that has sum 4, (2, 2) is a slice of A that has sum
 * −6, (0, 1) is a slice of A that has sum 5, no other slice of A has sum
 * greater than (0, 1). Assume that:
 * <p>
 * N is an integer within the range [1..1,000,000];<br>
 * each element of array A is an integer within the range
 * [−1,000,000..1,000,000];<br>
 * the result will be an integer within the range
 * [−2,147,483,648..2,147,483,647].
 * <p>
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);<br>
 * expected worst-case space complexity is O(N) (not counting the storage
 * required for input arguments).
 *
 * @see <a href="https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_slice_sum/">
 *     app.codility.com/programmers/lessons/9-maximum_slice_problem/max_slice_sum</a>
 *
 * @author Marco Foroni
 */
final class MaxSliceSum {

	/**
	 * Idea: MSSE[i] = Max slice sum ending at index i
	 * <pre>
	 *     MSSE[0] = A[0]
	 *     MSSE[i] = Max(MSSE[i-1] + A[i], A[i])
	 * </pre>
	 * MSS = Max element in MSSE array.
	 * <br>
	 * Time complexity is O(N)<br>
	 * Space complexity is O(N)
	 *
	 * @see <a href="https://app.codility.com/demo/results/training5AETQJ-JUK/">
	 *     app.codility.com/demo/results/training5AETQJ-JUK</a>
	 */
	public int solution(int[] A) {
		final int[] msse = new int[A.length];
		msse[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			msse[i] = Math.max(msse[i-1] + A[i], A[i]);
		}
		// System.out.println(Arrays.toString(msse));
		int max = msse[0];
		for (int i = 1; i < msse.length; i++) {
			max = Math.max(max, msse[i]);
		}
		return max;
	}

	/**
	 * Idea: Compute prefix sums at the beginning, then find maximum sum for all
	 * possible slices.<br>
	 * <br>
	 * Time complexity is O(N^2)<br>
	 * Space complexity is O(N)
	 */
	public static int exhaustiveSearch(final int[] A) {
		int max = Integer.MIN_VALUE;
		final int[] sums = MoreInts.prefixSums(A);
		for (int i = 0; i < A.length; i++) { // i = P
			for (int j = i; j < A.length; j++) { // j = Q
				int sum_i_j = i == 0 ? sums[j] : sums[j] - sums[i - 1];
				if (sum_i_j > max) {
					max = sum_i_j;
				}
			}
		}
		return max;
	}
}
