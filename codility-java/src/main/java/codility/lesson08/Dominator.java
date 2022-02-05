package codility.lesson08;

import java.util.HashMap;
import java.util.Map;

import codility.util.MoreInts;

/**
 * An array A consisting of N integers is given. The dominator of array A is the
 * value that occurs in more than half of the elements of A.
 * <p>
 * For example, consider array A such that
 * <p>
 * A[0] = 3 A[1] = 4 A[2] = 3 A[3] = 2 A[4] = 3 A[5] = -1 A[6] = 3 A[7] = 3
 * <p>
 * The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely
 * in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.
 * <p>
 * Write a function
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, returns index of any element
 * of array A in which the dominator of A occurs. The function should return −1
 * if array A does not have a dominator.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [0..100,000];<br>
 * each element of array A is an integer within the range
 * [−2,147,483,648..2,147,483,647].
 * <p>
 * For example, given array A such that
 * <p>
 * A[0] = 3 A[1] = 4 A[2] = 3 A[3] = 2 A[4] = 3 A[5] = -1 A[6] = 3 A[7] = 3
 * <p>
 * the function may return 0, 2, 4, 6 or 7, as explained above.
 * <p>
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);<br>
 * expected worst-case space complexity is O(1) (not counting the storage
 * required for input arguments).
 *
 * @see <a href="https://app.codility.com/programmers/lessons/8-leader/dominator/">
 *     app.codility.com/programmers/lessons/8-leader/dominator</a>
 *
 * @author Marco Foroni
 */
final class Dominator {

	/**
	 * This problem can be solved with the Majority Vote algorithm.
	 * <p>
	 * Time complexity is O(N)<br>
	 * Space complexity is O(1)
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm">
	 *     Boyer–Moore majority vote algorithm</a>
	 *
	 * @see <a href="https://app.codility.com/demo/results/training97TZ6S-D4E/">
	 *     app.codility.com/demo/results/training97TZ6S-D4E</a>
	 */
	public int solution(int[] A) {
		if (A.length == 0) {
			return -1;
		}
		int candidate = A[0];
		int k = 1;
		for (int i = 1; i < A.length; i++) {
			if (A[i] != candidate) {
				if (k > 0) {
					k--;
				} else {
					candidate = A[i];
					k = 1;
				}
			} else {
				k++;
			}
		}
		if (k == 0) {
			return -1;
		}
		final int occurrences = occurrences(A, candidate);
		final double limit = (double) A.length / (double) 2;
		return occurrences > limit ? indexOf(A, candidate) : -1;
	}

	static int occurrences(final int[] array, int key) {
		int counter = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == key) {
				counter++;
			}
		}
		return counter;
	}

	static int indexOf(final int[] array, final int key) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == key) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Idea: Use a Map to count the occurrences of each element in A<br>
	 * <br>
	 * Time complexity is O(N)<br>
	 * Space complexity is O(N)
	 */
	public static int exhaustiveSearch(int[] A) {
		final Map<Integer, Integer> map = new HashMap<>();
		for (int a : A) {
			Integer counter = map.get(a);
			if (counter == null) {
				counter = 0;
			}
			counter += 1;
			map.put(a, counter);
		}
		final double limit = (double) A.length / (double) 2;
		for (int a : map.keySet()) {
			int counter = map.get(a);
			if (counter > limit) {
				return indexOf(A, a);
			}
		}
		return -1;
	}
}
