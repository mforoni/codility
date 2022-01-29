package codility.lesson04;

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
 * @see <a href="https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/">
 *     app.codility.com/programmers/lessons/4-counting_elements/perm_check/</a>
 * 
 * @author Marco Foroni
 */
final class PermCheck {

	/**
	 * Idea: Use int array to count occurrences.
	 * <br>
	 * Time complexity is O(N)<br>
	 * Space complexity is O(N)
	 *
	 * @see <a href="https://app.codility.com/demo/results/trainingUBNYU2-6HC/">
	 *     app.codility.com/demo/results/trainingUBNYU2-6HC/</a>
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

	/**
	 * Idea: Use boolean array to mark occurrences.<br>
	 * <br>
	 * Time complexity is O(N)<br>
	 * Space complexity is O(N)
	 *
	 * @see <a href="https://app.codility.com/demo/results/training7Q4ZNM-VK4/">
	 *     app.codility.com/demo/results/training7Q4ZNM-VK4</a>
	 */
	public static int elegantSolution(int[] A) {
		final boolean[] number = new boolean[A.length + 1];
		number[0] = true;
		for (int i = 1; i <= A.length; i++) {
			number[i] = false;
		}
		for (int a : A) {
			if (a < A.length + 1) {
				number[a] = true;
			}
		}
		for (int i = 1; i <= A.length; i++) {
			if (number[i] == false) {
				return 0;
			}
		}
		return 1;
	}
}
