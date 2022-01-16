package codility.lesson02;

import java.util.HashMap;
import java.util.Map;

import codility.util.MoreInts;

/**
 * A non-empty array A consisting of N integers is given. The array contains an
 * odd number of elements, and each element of the array can be paired with
 * another element that has the same value, except for one element that is left
 * unpaired.
 * <p>
 * For example, in array A such that:
 * <p>
 * A[0] = 9 A[1] = 3 A[2] = 9 A[3] = 3 A[4] = 9 A[5] = 7 A[6] = 9 the elements
 * at indexes 0 and 2 have value 9, the elements at indexes 1 and 3 have value
 * 3, the elements at indexes 4 and 6 have value 9, the element at index 5 has
 * value 7 and is unpaired. Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers fulfilling the above
 * conditions, returns the value of the unpaired element.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 9 A[1] = 3 A[2] = 9 A[3] = 3 A[4] = 9 A[5] = 7 A[6] = 9 the function
 * should return 7, as explained in the example above.
 * <p>
 * Assume that:
 * <p>
 * N is an odd integer within the range [1..1,000,000];<br>
 * each element of array A is an integer within the range
 * [1..1,000,000,000];<br>
 * all but one of the values in A occur an even number of times.
 * <p>
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);<br>
 * expected worst-case space complexity is O(1) (not counting the storage
 * required for input arguments).
 * @see <a href="https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/">
 *     app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array</a>
 * 
 * @author Marco Foroni
 */
final class OddOccurrencesInArray {

	/**
	 * Idea: use xor operator
	 * <br><br>
	 * Time complexity is O(N)<br>
	 * Space complexity is O(1)
	 *
	 * @see <a href="https://app.codility.com/demo/results/trainingVSZ35Q-8XN/">
	 *     app.codility.com/demo/results/trainingVSZ35Q-8XN</a>
	 */
	public int solution(int[] A) {
		int result = 0;
		for (int a : A) {
			result = result ^ a;
		}
		return result;
	}

	/**
	 * Idea: use a Map for mapping the occurrences of each element in array A.<br>
	 * <br>
	 * Time complexity is O(N)<br>
	 * Space complexity is O(N)<br>
	 * <br>
	 * Space complexity can be reduced.
	 */
	public static int subOptimal(int[] A) {
		final Map<Integer, Integer> map = new HashMap<>();
		for (int a : A) {
			final Integer value = map.get(a);
			final int counter = value == null ? 1 : value + 1;
			map.put(a, counter);
		}
		for (int a : map.keySet()) {
			final int value = map.get(a);
			// System.out.printf("%d occur %s times%n", a, value);
			if (value % 2 == 1) {
				return a;
			}
		}
		throw new AssertionError();
	}

	/**
	 * Time complexity is O(N^2)<br>
	 * Space complexity is O(1)
	 */
	public static int moveUnpairedToTheEnd(final int[] A) {
		int i = 0;
		while (i < A.length - 1) {
			if (A[i] == A[i + 1]) {
				i += 2;
			} else {
				int j = MoreInts.indexOf(A, A[i], i + 1);
				if (j == -1) {
					return A[i];
				}
				while (j > i) {
					MoreInts.swap(A, j, j - 1);
					j--;
				}
				i += 2;
			}
		}
		return A[A.length - 1];
	}
}
