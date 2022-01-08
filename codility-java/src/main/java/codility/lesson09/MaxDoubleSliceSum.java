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
 * @author Marco Foroni
 *
 */
final class MaxDoubleSliceSum {

	/**
	 * This problem can be solved computing the maximum subarray starting and ending
	 * on each index of the array (extremes excluded). This can be achieved using
	 * kadane's algorithm.
	 * <p>
	 * Time complexity is O(N)<br>
	 * Space complexity is O(N)
	 * 
	 * @param A
	 * @return
	 */
	public int solution(int[] A) {
		if (A.length == 3) {
			return 0;
		}
		int[] mscss = maximumSumContinuosSubsequenceExtremesExcludedStartingAt(A);
		int[] mscse = maximumSumContinuosSubsequenceExtremesExcludedEndingAt(A);
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < A.length - 1; i++) {
			int doubleSliceSum = Math.max(mscse[i - 1], 0) + Math.max(mscss[i + 1], 0);
			if (doubleSliceSum > max) {
				max = doubleSliceSum;
			}
		}
		return max;
	}

	public static int[] maximumSumContinuosSubsequenceExtremesExcludedEndingAt(int[] array) {
		assert (array.length > 1);
		final int n = array.length;
		final int[] mscse = new int[n];
		mscse[1] = array[1];
		for (int i = 2; i < n - 1; i++) {
			mscse[i] = Math.max(mscse[i - 1] + array[i], array[i]);
		}
		return mscse;
	}

	public static int[] maximumSumContinuosSubsequenceExtremesExcludedStartingAt(int[] array) {
		assert (array.length > 1);
		final int n = array.length;
		final int[] mscss = new int[n];
		mscss[n - 2] = array[n - 2];
		for (int i = n - 3; i > 0; i--) {
			mscss[i] = Math.max(mscss[i + 1] + array[i], array[i]);
		}
		return mscss;
	}

	/**
	 * Time complexity is O(N^3)<br>
	 * Space complexity is O(N)
	 * 
	 * @param A
	 * @return
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
