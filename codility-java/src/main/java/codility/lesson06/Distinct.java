package codility.lesson06;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Write a function
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, returns the number of
 * distinct values in array A.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [0..100,000]; each element of array A is an
 * integer within the range [−1,000,000..1,000,000]. For example, given array A
 * consisting of six elements such that:
 * <p>
 * A[0] = 2 A[1] = 1 A[2] = 1 A[3] = 2 A[4] = 3 A[5] = 1 the function should
 * return 3, because there are 3 distinct values appearing in array A, namely 1,
 * 2 and 3.
 * <p>
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N*log(N));<br>
 * expected worst-case space complexity is O(N) (not counting the storage
 * required for input arguments).
 * @see <a href="https://app.codility.com/programmers/lessons/6-sorting/distinct/">
 *     app.codility.com/programmers/lessons/6-sorting/distinct/</a>
 *
 * @author Marco Foroni
 */
final class Distinct {

	/**
	 * Idea: sort the array A and count the elements in A such that A[i] != A[i-1].<br>
	 * <br>
	 * Time complexity is O(N*log(N))<br>
	 * Space complexity is O(N) (but can be reduced to O(1) if we are willing to destroy the input)
	 *
	 * @see <a href="https://app.codility.com/demo/results/trainingFTUMUY-9VA/">
	 *     app.codility.com/demo/results/trainingFTUMUY-9VA</a>
	 */
	public int solution(int[] A) {
		if (A.length == 0) {
			return 0;
		}
		final int[] sorted = A.clone();
		Arrays.sort(sorted);
		int counter = 1;
		for (int i = 1; i < sorted.length; i++) {
			if (sorted[i] != sorted[i - 1]) {
				counter++;
			}
		}
		return counter;
	}

	/**
	 * Idea: use HashSet<br>
	 * <br>
	 * Time complexity is O(N)<br>
	 * Space complexity is O(N)
	 *
	 * @see <a href="https://app.codility.com/demo/results/training3KYMXQ-JGX/">
	 *     app.codility.com/demo/results/training3KYMXQ-JGX</a>
	 */
	public static int solutionWithHashSet(int[] A) {
		final Set<Integer> set = new HashSet<>();
		for (int a : A) {
			set.add(a);
		}
		return set.size();
	}
}
