package codility.lesson4;

/**
 * A non-empty array A consisting of N integers is given.
 * <p>
 * A permutation is a sequence containing each element from 1 to N once, and
 * only once.
 * <p>
 * For example, array A such that:
 * <p>
 * A[0] = 4 A[1] = 1 A[2] = 3 A[3] = 2 is a permutation, but array A such that:
 * <p>
 * A[0] = 4 A[1] = 1 A[2] = 3 is not a permutation, because value 2 is missing.
 * <p>
 * The goal is to check whether array A is a permutation.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A, returns 1 if array A is a permutation and 0 if it is
 * not.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 4 A[1] = 1 A[2] = 3 A[3] = 2 the function should return 1.
 * <p>
 * Given array A such that:
 * <p>
 * A[0] = 4 A[1] = 1 A[2] = 3 the function should return 0.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [1..100,000];<br>
 * each element of array A is an integer within the range [1..1,000,000,000].
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
final class PermCheck {

	/**
	 * Time complexity is O(N)<br>
	 * Space complexity is O(N)
	 * 
	 * @param A
	 * @param N
	 * @return
	 */
	public int solution(int A[]) {
		final int N = A.length;
		final int[] numbers = new int[N + 1];
		for (int a : A) {
			if (a > N) {
				return 0;
			}
			numbers[a] = 1;
		}
		for (int i = 1; i <= N; i++) {
			if (numbers[i] == 0) {
				return 0;
			}
		}
		return 1;
	}
}
