package codility.lesson06;

import java.util.Arrays;

/**
 * A non-empty array A consisting of N integers is given. The product of triplet
 * (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).
 * <p>
 * For example, array A such that:
 * <p>
 * A[0] = -3 A[1] = 1 A[2] = 2 A[3] = -2 A[4] = 5 A[5] = 6 contains the
 * following example triplets:
 * <p>
 * (0, 1, 2), product is −3 * 1 * 2 = −6<br>
 * (1, 2, 4), product is 1 * 2 * 5 = 10<br>
 * (2, 4, 5), product is 2 * 5 * 6 = 60
 * <p>
 * Your goal is to find the maximal product of any triplet.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A, returns the value of the maximal product of
 * any triplet.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = -3 A[1] = 1 A[2] = 2 A[3] = -2 A[4] = 5 A[5] = 6 the function should
 * return 60, as the product of triplet (2, 4, 5) is maximal.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [3..100,000];
 * each element of array A is an integer within the range [−1,000..1,000].
 * <p>
 * Complexity:
 * expected worst-case time complexity is O(N*log(N));<br>
 * expected worst-case space complexity is O(1) (not counting the storage
 * required for input arguments).
 * @see <a href="https://app.codility.com/programmers/lessons/6-sorting/max_product_of_three/">
 *     app.codility.com/programmers/lessons/6-sorting/max_product_of_three/</a>
 *
 * @author Marco Foroni
 */
final class MaxProductOfThree {

	/**
	 * <ul>
	 * <li>If A contains only positive integers the solution is simple sort the array and returns the product of the
	 * last three values.</li>
	 * <li>If A contains only negative integers the best solutions is the same for only positive integers.</li>
	 * <li>If A contains both positive and negative integers we need to pay attention to the fact that (-)*(-)*(+) is a
	 * positive number potential greater than the maximal positive product of the last three. What is the best triplet
	 * of that form? In a sorted array we can easily choose the first two greatest negative numbers and the last one,
	 * the greater positive number.</li>
	 * </ul>
	 * Time complexity is O(N*log(N))<br>
	 * Space complexity is O(1) but destroys the input
	 *
	 * @see <a href="https://app.codility.com/demo/results/trainingE76HYW-UJR/">
	 *     app.codility.com/demo/results/trainingE76HYW-UJR</a>
	 */
	public int solution(int[] A) {
		final int N = A.length;
		assert (N >= 3);
		Arrays.sort(A);
		int tmp1 = A[N - 1] * A[N - 2] * A[N - 3];
		int tmp2 = A[0] * A[1] * A[N - 1];
		return Math.max(tmp1, tmp2);
	}

	/**
	 * Time complexity is O(N^3)<br>
	 * Space complexity is O(1)
	 */
	public static int exhaustiveSearch(final int[] A) {
		final int N = A.length;
		assert (N >= 3);
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				for (int k = j + 1; k < N; k++) {
					final int tp = A[i] * A[j] * A[k];
					if (tp > max) {
						max = tp;
					}
				}
			}
		}
		return max;
	}
}
