package codility.lesson09;

/**
 * An array A consisting of N integers is given. It contains daily prices of a
 * stock share for a period of N consecutive days. If a single share was bought
 * on day P and sold on day Q, where 0 ≤ P ≤ Q < N, then the profit of such
 * transaction is equal to A[Q] − A[P], provided that A[Q] ≥ A[P]. Otherwise,
 * the transaction brings loss of A[P] − A[Q].
 * <p>
 * For example, consider the following array A consisting of six elements such
 * that:
 * <p>
 * A[0] = 23171<br>
 * A[1] = 21011<br>
 * A[2] = 21123<br>
 * A[3] = 21366<br>
 * A[4] = 21013<br>
 * A[5] = 21367<br>
 * If a share was bought on day 0 and sold on day 2, a loss of 2048 would occur
 * because A[2] − A[0] = 21123 − 23171 = −2048. If a share was bought on day 4
 * and sold on day 5, a profit of 354 would occur because A[5] − A[4] = 21367 −
 * 21013 = 354. Maximum possible profit was 356. It would occur if a share was
 * bought on day 1 and sold on day 5.
 * <p>
 * Write a function,
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers containing daily prices of a
 * stock share for a period of N consecutive days, returns the maximum possible
 * profit from one transaction during this period. The function should return 0
 * if it was impossible to gain any profit.
 * <p>
 * For example, given array A consisting of six elements such that:
 * <p>
 * A[0] = 23171 A[1] = 21011 A[2] = 21123 A[3] = 21366 A[4] = 21013 A[5] = 21367
 * <p>
 * the function should return 356, as explained above.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [0..400,000];<br>
 * each element of array A is an integer within the range [0..200,000].
 * <p>
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);<br>
 * expected worst-case space complexity is O(1) (not counting the storage
 * required for input arguments).
 * @see <a href="https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_profit/">
 *     app.codility.com/programmers/lessons/9-maximum_slice_problem/max_profit</a>
 *
 * @author Foroni Marco
 */
final class MaxProfit {

	/**
	 * Idea: we need to compute the minimum value Min(i) i.e. the minimum value in
	 * the array A till i-1:
	 * <pre>
	 * Min(0) = +INFINITE
	 * Min(i) = min(Min(i-1), A[i-1])
	 * 
	 * And the maximum profit MP(i) i.e. the maximum possible profit for the array A 
	 * till i as:
	 * 
	 * MP(0) = 0
	 * MP(i) = max(MP(i-1), A[i] - Min(i-1))
	 * </pre>
	 *
	 * Time complexity is O(N)<br>
	 * Space complexity is O(1)
	 * 
	 * @param A
	 * @return
	 */
	public int solution(int[] A) {
		int currentMin = Integer.MAX_VALUE; // current min value
		int currentMP = 0; // current maxProfit
		for (int i = 1; i < A.length; i++) {
			if (A[i - 1] < currentMin) {
				currentMin = A[i - 1];
			}
			currentMP = Math.max(currentMP, A[i] - currentMin);
		}
		return currentMP;
	}

	/**
	 * Time complexity is O(N)<br>
	 * Space complexity is O(N)
	 *
	 * @param A
	 * @return
	 * @see <a href="https://app.codility.com/demo/results/training4DB6BV-8US/">app.codility.com/demo/results/training4DB6BV-8US</a>
	 */
	public static int subOptimal(int[] A) {
		if (A.length == 0) {
			return 0;
		}
		final int[] min = new int[A.length];
		min[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			min[i] = Math.min(min[i-1], A[i]);
		}
		final int[] maxProfit = new int[A.length];
		maxProfit[0] = 0;
		for (int i = 1; i < A.length; i++) {
			maxProfit[i] = Math.max(maxProfit[i-1], A[i] - min[i-1]);
		}
		int max = maxProfit[0];
		for (int i = 1; i < A.length; i++) {
			max = Math.max(maxProfit[i], max);
		}
		return max;
	}

	/**
	 * Idea: compute all possible profits and return the maximum value
	 * <p>
	 * Time complexity is O(N^2)<br>
	 * Space complexity is O(1)
	 * </p>
	 * 
	 * @param A
	 * @return
	 */
	public static int exhaustiveSearch(final int[] A) {
		int mp = 0; // max profit
		for (int i = 0; i < A.length - 1; i++) {
			for (int j = i + 1; j < A.length; j++) {
				int profit = A[j] - A[i];
				if (profit > mp) {
					mp = profit;
				}
			}
		}
		return mp;
	}
}
