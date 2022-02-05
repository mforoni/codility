package codility.lesson09;

import codility.util.MoreInts;

/**
 * A non-empty array A consisting of N integers is given. A triplet (X, Y, Z),
 * such that 0 ≤ X < Y < Z < N, is called a double slice. The sum of double
 * slice (X, Y, Z) is the total of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y +
 * 1] + A[Y + 2] + ... + A[Z − 1].
 * <p>
 * For example, array A such that:<br>
 * A[0] = 3 A[1] = 2 A[2] = 6 A[3] = -1 A[4] = 4 A[5] = 5 A[6] = -1 A[7] = 2<br>
 * contains the following example double slices:<br>
 * double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,<br>
 * double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,<br>
 * double slice (3, 4, 5), sum is 0.
 * <p>
 * The goal is to find the maximal sum of any double slice.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A consisting of N integers, returns the maximal
 * sum of any double slice.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 3 A[1] = 2 A[2] = 6 A[3] = -1 A[4] = 4 A[5] = 5 A[6] = -1 A[7] = 2 the
 * function should return 17, because no double slice of array A has a sum of
 * greater than 17.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [3..100,000];<br>
 * each element of array A is an integer within the range [−10,000..10,000].
 *
 * @see <a href="https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_double_slice_sum/">
 *     app.codility.com/programmers/lessons/9-maximum_slice_problem/max_double_slice_sum</a>
 * 
 * @author Marco Foroni
 */
final class MaxDoubleSliceSum {

	/**
	 * This problem can be solved computing the maximum sub-array starting and ending
	 * on each index of the array (extremes excluded). This can be achieved using
	 * kadane's algorithm.<br>
	 * <br>
	 * Time complexity is O(N)<br>
	 * Space complexity is O(N)
	 * 
	 * @see <a href="https://en.wikipedia.org/wiki/Maximum_subarray_problem#Kadane's_algorithm">Kadane's algorithm</a>
	 *
	 * @see <a href="https://app.codility.com/demo/results/trainingH6BFBK-BV3/">
	 *     app.codility.com/demo/results/trainingH6BFBK-BV3</a>
	 */
	public int solution(int[] A) {
		if (A.length == 3) {
			return 0;
		}
		int[] mcss = maxContiguousSubsequenceStartingAt(A);
		int[] mcse = maxContiguousSubsequenceEndingAt(A);
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < A.length - 1; i++) {
			int doubleSliceSum = Math.max(mcse[i - 1], 0) + Math.max(mcss[i + 1], 0);
			if (doubleSliceSum > max) {
				max = doubleSliceSum;
			}
		}
		return max;
	}

	/**
	 * Return an array containing at each index the maximum sum of a contiguous subsequence extremes excluded
	 * ending at index i.<br>
	 * <br>
	 * Time complexity is O(N)<br>
	 * Space complexity is O(N)
	 */
	static int[] maxContiguousSubsequenceEndingAt(int[] array) {
		assert (array.length > 1);
		final int n = array.length;
		final int[] mcse = new int[n];
		mcse[1] = array[1];
		for (int i = 2; i < n - 1; i++) {
			mcse[i] = Math.max(mcse[i - 1] + array[i], array[i]);
		}
		return mcse;
	}

	/**
	 * Return an array containing at each index the maximum sum of a contiguous subsequence extremes excluded
	 * starting at index i.<br>
	 * <br>
	 * Time complexity is O(N)<br>
	 * Space complexity is O(N)
	 */
	static int[] maxContiguousSubsequenceStartingAt(int[] array) {
		assert (array.length > 1);
		final int n = array.length;
		final int[] mcss = new int[n];
		mcss[n - 2] = array[n - 2];
		for (int i = n - 3; i > 0; i--) {
			mcss[i] = Math.max(mcss[i + 1] + array[i], array[i]);
		}
		return mcss;
	}

	/**
	 * Time complexity is O(N^3)<br>
	 * Space complexity is O(N)
	 */
	public static int exhaustiveSearch(final int[] A) {
		final int[] sums = MoreInts.prefixSums(A);
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < A.length - 2; i++) {
			for (int j = i + 1; j < A.length - 1; j++) {
				for (int k = j + 1; k < A.length; k++) {
					int sum_i_k = i == 0 ? sums[k] : sums[k] - sums[i - 1];
					int doubleSliceSum = sum_i_k - A[i] - A[j] - A[k];
					if (doubleSliceSum > max) {
						max = doubleSliceSum;
					}
				}
			}
		}
		return max;
	}
}
