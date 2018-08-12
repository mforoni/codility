package codility.lesson5;

/**
 * Write a function:
 * <p>
 * class Solution { public int solution(int A, int B, int K); }
 * <p>
 * that, given three integers A, B and K, returns the number of integers within
 * the range [A..B] that are divisible by K, i.e.:
 * <p>
 * { i : A ≤ i ≤ B, i mod K = 0 }
 * <p>
 * For example, for A = 6, B = 11 and K = 2, your function should return 3,
 * because there are three numbers divisible by 2 within the range [6..11],
 * namely 6, 8 and 10.
 * <p>
 * Assume that:
 * <p>
 * A and B are integers within the range [0..2,000,000,000];<br>
 * K is an integer within the range [1..2,000,000,000]; A ≤ B. Complexity:
 * <p>
 * expected worst-case time complexity is O(1);<br>
 * expected worst-case space complexity is O(1).
 * 
 * 
 * @author Foroni Marco
 *
 */
final class CountDiv {

	public int solution(int A, int B, int K) {
		return constantTime(A, B, K);
	}

	/**
	 * Time and space complexity is O(1)
	 * 
	 * @param A
	 * @param B
	 * @param K
	 * @return
	 */
	public static int constantTime(int A, int B, int K) {
		final int Btimes = B / K;
		if (A != 0) {
			final int Atimes = (A - 1) / K;
			return Btimes - Atimes;
		} else {
			return 1 + Btimes; 
		}
	}

	/**
	 * Time complexity is O(B-A)<br>
	 * Space complexity is O(1)
	 * 
	 * @param A
	 * @param B
	 * @param K
	 * @return
	 */
	public static int checker(int A, int B, int K) {
		int counter = 0;
		for (int n = A; n <= B; n++) {
			if (n % K == 0) {
				counter++;
			}
		}
		return counter;
	}
	
	
	/**
	 * Time complexity is O((B-A)/K+K)<br>
	 * Space complexity is O(1)
	 * 
	 * @param A
	 * @param B
	 * @param K
	 * @return
	 */
	public static int checkerOptimized(int A, int B, int K) {
		int counter = 0;
		for (int n = A; n <= B;) {
			// System.out.println(n);
			if (n % K == 0) {
				counter++;
				n += K;
			} else {
				n++;
			}
		}
		return counter;
	}
}
