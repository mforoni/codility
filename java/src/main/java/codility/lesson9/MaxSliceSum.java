package codility.lesson9;

import codility.util.MoreInts;

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
 * @author Foroni Marco
 *
 */
final class MaxSliceSum {

	/**
	 * Time complexity is O(N)<br>
	 * Space complexity is O(2*N) = O(N)
	 * <p>
	 * Idea: We need to compute the msse[i] = maximum slice sum ending at index i:
	 * 
	 * <pre>
	 * msse[0] = A[0] 
	 * msse[i] = Max(A[i], msse[i-1] + A[i])
	 * </pre>
	 * 
	 * then the mss[i] = maximum slice sum in sub-array of A from 0 to i:
	 * 
	 * <pre>
	 * mss[0] = A[0]
	 * mss[i] = Max(mss[i-1], msse[i-1] + A[i], A[i]) = Max(mss[i-1], msse[i])
	 * </pre>
	 * 
	 * @param A
	 * @return
	 */
	public int solution(int[] A) {
		final int[] msse = new int[A.length]; // msse[i] = maximum slice sum ending at i
		msse[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			msse[i] = Math.max(A[i], msse[i - 1] + A[i]);
		}
		final int[] mss = new int[A.length]; // mss[i] = maximum slice sum in sub-array of A from 0 to i
		mss[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			mss[i] = Math.max(mss[i - 1], msse[i]);
			// System.out.println(String.format("i=%s, mss=%s", i, MoreInts.toString(mss)));
		}
		return MoreInts.max(mss);
	}

	/**
	 * Time complexity is O(N^2)<br>
	 * Space complexity is O(N)
	 * <p>
	 * Idea: Compute prefix sums at the beginning, then find maximum sum for all
	 * possible slices.
	 * 
	 * @param A
	 * @return
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
