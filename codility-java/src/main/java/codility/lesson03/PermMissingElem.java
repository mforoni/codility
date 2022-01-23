package codility.lesson03;

/**
 * An array A consisting of N different integers is given. The array contains
 * integers in the range [1..(N + 1)], which means that exactly one element is
 * missing.
 * <p>
 * Your goal is to find that missing element.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A, returns the value of the missing element.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 2 A[1] = 3 A[2] = 1 A[3] = 5 the function should return 4, as it is
 * the missing element.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [0..100,000];<br>
 * the elements of A are all distinct; each element of array A is an integer
 * within the range [1..(N + 1)].
 * <p>
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);<br>
 * expected worst-case space complexity is O(1) (not counting the storage
 * required for input arguments).
 *
 * @see <a href="https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/">
 *     app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/</a>
 * 
 * @author Marco Foroni
 */
final class PermMissingElem {

	/**
	 * Idea: Sum(1,...,n+1) = 1 + ... + x + ... + n + n+1 = x + Sum(a in A)<br>
	 * <br>
	 * Therefore:<br>
	 * <br>
	 * x = Sum(1,...,n+1) - Sum(a in A)<br>
	 * <br>
	 *
	 * Time complexity is O(n)<br>
	 * Space complexity is O(1)
	 *
	 * @see <a href="https://app.codility.com/demo/results/trainingS4KGHF-TMP/">
	 *     app.codility.com/demo/results/trainingS4KGHF-TMP/</a>
	 */
	public int solution(int[] A) {
		final int max = A.length + 1;
		int sum = 0;
		for (int i = 1; i <= max; i++) {
			sum += i;
		}
		int sumA = 0;
		for (int a : A) {
			sumA += a;
		}
		return sum - sumA;
	}

	/**
	 * Idea: Count occurrences of each element in A. Return the first element with occurrences equal to zero.<br>
	 * <br>
	 * Time complexity is O(n)<br>
	 * Space complexity is O(n)
	 */
	public static int suboptimal(final int[] A) {
		final int max = A.length + 2;
		final int[] occ = new int[max];
		for (int a : A) {
			occ[a] = 1;
		}
		for (int i = 1; i < occ.length; i++) {
			if (occ[i] == 0) {
				return i;
			}
		}
		throw new AssertionError();
	}
}
