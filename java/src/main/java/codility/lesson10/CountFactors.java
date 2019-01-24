package codility.lesson10;

import java.util.HashSet;
import java.util.Set;

/**
 * A positive integer D is a factor of a positive integer N if there exists an
 * integer M such that N = D * M.
 * <p>
 * For example, 6 is a factor of 24, because M = 4 satisfies the above condition
 * (24 = 6 * 4).
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int N); }
 * <p>
 * that, given a positive integer N, returns the number of its factors.
 * <p>
 * For example, given N = 24, the function should return 8, because 24 has 8
 * factors, namely 1, 2, 3, 4, 6, 8, 12, 24. There are no other factors of 24.
 * <p>
 * Write an efficient algorithm for the following assumptions:<br>
 * N is an integer within the range [1..2,147,483,647].
 * 
 * @author Marco Foroni
 *
 */
final class CountFactors {

	/**
	 * Time complexity is O(SQRT(N))<br>
	 * Space complexity is O(1)
	 * 
	 * @param n
	 * @return
	 */
	public int solution(int n) {
		int counter = 0;
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				int factor = n / i;
				if (factor != i) {
					counter += 2;
				} else {
					counter += 1;
				}
			}
		}
		return counter;
	}

	public static int exhaustiveSearch(final int n) {
		final Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				set.add(i);
			}
		}
//		System.out.println(set);
		return set.size();
	}
}
