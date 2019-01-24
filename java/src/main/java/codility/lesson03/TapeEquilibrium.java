package codility.lesson03;

import codility.util.MoreInts;

/**
 * A non-empty array A consisting of N integers is given. Array A represents
 * numbers on a tape.
 * <p>
 * Any integer P, such that 0 < P < N, splits this tape into two non-empty
 * parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
 * <p>
 * The difference between the two parts is the value of: |(A[0] + A[1] + ... +
 * A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
 * <p>
 * In other words, it is the absolute difference between the sum of the first
 * part and the sum of the second part.
 * <p>
 * For example, consider array A such that:
 * <p>
 * A[0] = 3 A[1] = 1 A[2] = 2 A[3] = 4 A[4] = 3 We can split this tape in four
 * places:
 * <p>
 * P = 1, difference = |3 − 10| = 7 P = 2, difference = |4 − 9| = 5 P = 3,
 * difference = |6 − 7| = 1 P = 4, difference = |10 − 3| = 7 Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A of N integers, returns the minimal difference
 * that can be achieved.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 3 A[1] = 1 A[2] = 2 A[3] = 4 A[4] = 3 the function should return 1, as
 * explained above.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [2..100,000];<br>
 * each element of array A is an integer within the range [−1,000..1,000].
 * <p>
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);<br>
 * expected worst-case space complexity is O(N) (not counting the storage
 * required for input arguments).
 * 
 * @author Foroni
 *
 */
final class TapeEquilibrium {

	/**
	 * Time complexity is O(n)<br>
	 * Space complexity is O(n)
	 * 
	 * @param A
	 * @return
	 */
	public int solution(int[] A) {
		final int[] sum = new int[A.length];
		sum[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			sum[i] = sum[i - 1] + A[i];
		}
		final int total = sum[A.length - 1];
		final int[] P = new int[A.length];
		for (int i = 1; i < A.length; i++) {
			P[i] = Math.abs(sum[i - 1] - (total - sum[i - 1]));
		}
		return min(P, 1);
	}

	public static int min(final int A[], final int start) {
		int min = Integer.MAX_VALUE;
		for (int i = start; i < A.length; i++) {
//			System.out.println(A[i]);
			if (A[i] < min) {
				min = A[i];
			}
		}
		return min;
	}

	/**
	 * Time complexity is O(n^2)<br>
	 * Space complexity is O(1)
	 * 
	 * @param A
	 * @return
	 */
	public static int exhausitveSearch(final int[] A) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < A.length - 1; i++) {
			int sumA = MoreInts.sum(A, 0, i);
			int sumB = MoreInts.sum(A, i + 1, A.length - 1);
			int diff = Math.abs(sumA - sumB);
//			System.out.println(String.format("%s - %s", sumA, sumB));
			if (diff < min) {
				min = diff;
			}
		}
		return min;
	}
}