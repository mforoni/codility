package codility.lesson4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * This is a demo task.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A of N integers, returns the smallest positive integer
 * (greater than 0) that does not occur in A.
 * <p>
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * <p>
 * Given A = [1, 2, 3], the function should return 4.
 * <p>
 * Given A = [−1, −3], the function should return 1.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [1..100,000];<br>
 * each element of array A is an integer within the range
 * [−1,000,000..1,000,000].
 * <p>
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);<br>
 * expected worst-case space complexity is O(N) (not counting the storage
 * required for input arguments).
 * 
 * 
 * @author Foroni Marco
 *
 */
final class MissingInteger {

	/**
	 * Time complexity is O(N)<br>
	 * Space complexity is O(N)
	 * <p>
	 * Idea: use an array P of size N where P[i] = 1 if i is present in array A.
	 * <p>
	 * Note:<br>
	 * the integers in A greater than N can be skipped<br>
	 * the integers in A lesser than 0 can be skipped
	 * 
	 * @param A
	 * @return
	 */
	public int solution(final int[] A) {
		final int N = A.length;
		final int[] P = new int[N];
		for (int a : A) {
			if (a > 0 && a <= N) {
				P[a - 1] = 1;
			}
		}
		int x = 0;
		for (; x < P.length; x++) {
			if (P[x] == 0) {
				return x + 1;
			}
		}
		return x + 1;
	}

	/**
	 * Time complexity is O(N*log(N))<br>
	 * Space complexity is O(1) - destroy the input
	 * 
	 * @param A
	 * @return
	 */
	public static int sortAndFind(final int[] A) {
		int x = 1;
		Arrays.sort(A);
		for (int a : A) {
			if (a == x) {
				x += 1;
			}
		}
		return x;
	}

	/**
	 * Time complexity is O(N+N)=O(N)<br>
	 * Space complexity is O(N)
	 * 
	 * @param A
	 * @return
	 */
	public static int withHashSet(final int[] A) {
		final Set<Integer> set = new HashSet<>(A.length);
		for (int a : A) {
			if (a > 0) {
				set.add(a);
			}
		}
		int x = 1;
		while (set.contains(x)) {
			x++;
		}
		return x;
		/*
		 * other way to make it clear that the time required is O(n) in the worst case
		 */
		// int x = 1;
		// for (; x <= A.length; x++) { if (!set.contains(x)) { return x; } }
		// return x;
	}

}
