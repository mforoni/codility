package codility.lesson10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A non-empty array A consisting of N integers is given. <br>
 * A peak is an array element which is larger than its neighbors. More
 * precisely, it is an index P such that 0 < P < N − 1, A[P − 1] < A[P] and A[P]
 * > A[P + 1].
 * <p>
 * For example, the following array A:
 * <p>
 * A[0] = 1 A[1] = 2 A[2] = 3 A[3] = 4 A[4] = 3 A[5] = 4 A[6] = 1 A[7] = 2 A[8]
 * = 3 A[9] = 4 A[10] = 6 A[11] = 2 has exactly three peaks: 3, 5, 10.
 * <p>
 * We want to divide this array into blocks containing the same number of
 * elements. More precisely, we want to choose a number K that will yield the
 * following blocks:
 * <p>
 * A[0], A[1], ..., A[K − 1], A[K], A[K + 1], ..., A[2K − 1], ... A[N − K], A[N
 * − K + 1], ..., A[N − 1]. What's more, every block should contain at least one
 * peak. Notice that extreme elements of the blocks (for example A[K − 1] or
 * A[K]) can also be peaks, but only if they have both neighbors (including one
 * in an adjacent blocks).
 * <p>
 * The goal is to find the maximum number of blocks into which the array A can
 * be divided.
 * <p>
 * Array A can be divided into blocks as follows:
 * <p>
 * one block (1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2). This block contains three
 * peaks.<br>
 * two blocks (1, 2, 3, 4, 3, 4) and (1, 2, 3, 4, 6, 2). Every block has a
 * peak.<br>
 * three blocks (1, 2, 3, 4), (3, 4, 1, 2), (3, 4, 6, 2). Every block has a
 * peak. Notice in particular that the first block (1, 2, 3, 4) has a peak at
 * A[3], because A[2] < A[3] > A[4], even though A[4] is in the adjacent block.
 * <br>
 * However, array A cannot be divided into four blocks, (1, 2, 3), (4, 3, 4),
 * (1, 2, 3) and (4, 6, 2), because the (1, 2, 3) blocks do not contain a peak.
 * Notice in particular that the (4, 3, 4) block contains two peaks: A[3] and
 * A[5].
 * <p>
 * The maximum number of blocks that array A can be divided into is three.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A consisting of N integers, returns the maximum
 * number of blocks into which A can be divided. <br>
 * If A cannot be divided into some number of blocks, the function should return
 * 0.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 1 A[1] = 2 A[2] = 3 A[3] = 4 A[4] = 3 A[5] = 4 A[6] = 1 A[7] = 2 A[8]
 * = 3 A[9] = 4 A[10] = 6 A[11] = 2 the function should return 3, as explained
 * above.
 * <p>
 * Write an efficient algorithm for the following assumptions:<br>
 * 
 * N is an integer within the range [1..100,000];<br>
 * each element of array A is an integer within the range [0..1,000,000,000].
 * @see <a href="https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/peaks/">
 *     app.codility.com/programmers/lessons/10-prime_and_composite_numbers/peaks</a>
 * 
 * @author Marco Foroni
 *
 */
final class Peaks {

	/**
	 * Note: P is the number of peaks. The upper bound of P is N/2. Consider the
	 * array: A = [1 2 1 2 1 2 1]. |A|=7, P=3.
	 * <p>
	 * Idea: Compute the possible ways for dividing array A in blocks having the same length, i.e. the number of divisor
	 * of N where N is the length of A. Compute peaks[i] = the total number of peaks till the index i.
	 * </p>
	 * Time complexity is O(SQRT(N) * SQRT(N)) = O(N)<br>
	 * Space complexity is O(N)
	 * @see <a href="https://app.codility.com/demo/results/trainingJDA5AJ-AQ6/">app.codility.com/demo/results/trainingJDA5AJ-AQ6</a>
	 * 
	 * @param A
	 * @return
	 */
	public int solution(int[] A) {
		final int n = A.length;
		if (n == 1) {
			return 0;
		}
		final int[] peaks = new int[n];
		peaks[0] = 0;
		for (int i = 1; i < n - 1; i++) {
			peaks[i] = A[i - 1] < A[i] && A[i] > A[i + 1] ? peaks[i - 1] + 1 : peaks[i - 1];
		}
		peaks[n - 1] = peaks[n - 2];
 		//System.out.println(Arrays.toString(peaks));
		int max = 0;
		for (int f1 : factors(n)) {
			int f2 = n / f1;
			if (hasPeak(peaks, f1, f2)) {
				//System.out.println(String.format("%d blocks with peak", f1));
				max = Math.max(max, f1);
			}
			if (f1 != f2 && hasPeak(peaks, f2, f1)) {
				//System.out.println(String.format("%d blocks with peak", f2));
				max = Math.max(max, f2);
			}
		}
		return max;
	}

	/**
	 * Time complexity is O(SQRT(N))
	 *
	 * @param peaks
	 * @param numBlocks
	 * @param lenBlock
	 * @return
	 */
	private static boolean hasPeak(int[] peaks, int numBlocks, int lenBlock) {
		for (int k = 0; k < numBlocks; k++) {
			if (!blockHasPeak(peaks, lenBlock * k, lenBlock * (k+1) - 1)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Time complexity is O(1)
	 *
	 * @param peaks
	 * @param start
	 * @param end
	 * @return
	 */
	private static boolean blockHasPeak(int[] peaks, int start, int end) {
		return start == 0 ? peaks[end] > 0 : peaks[end] > peaks[start - 1];
	}

	/**
	 * Time complexity is O(SQRT(N))<br>
	 * Space complexity is O(SQRT(N))
	 *
	 * @param n
	 * @return
	 */
	static List<Integer> factors(final int n) {
		final List<Integer> factors = new ArrayList<>();
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				factors.add(i);
			}
		}
		return factors;
	}

	/**
	 * Note: The array must be divided in blocks containing the same number of elements.
	 * <p>
	 * Idea: For each possible way to split the array A in K blocks compute if each blocks has a peak. The possible ways
	 * for dividing the array A in blocks having the same number of elements is the same of computing the divisor of N
	 * where N is the length of array A.
	 * </p>
	 */
	static class ExhaustiveSearch {

		/**
		 * Time complexity is O(SQRT(N) * 2N) = O(N * SQRT(N))<br>
		 * Space complexity is O(SQRT(N))
		 *
		 * @param A
		 * @return
		 */
		public int solution(int[] A) {
			final int n = A.length;
			int max = 0;
			final List<Integer> factors = factors(n);
			for (int f1 : factors) {
				int f2 = n / f1;
				if (hasPeaks(A, f1, f2)) {
					max = Math.max(max, f2);
				}
				if (f1 != f2 && hasPeaks(A, f2, f1)) {
					max = Math.max(max, f1);
				}
			}
			return max;
		}

		/**
		 * Time complexity is O(N)
		 *
		 * @param A
		 * @param size
		 * @param groups
		 * @return
		 */
		private boolean hasPeaks(int[] A, int size, int groups) {
			for (int g = 0; g < groups; g++) {
				if (!blockHasPeak(A, g * size, g * size + size)) {
					return false;
				}
			}
			return true;
		}

		private boolean blockHasPeak(int[] A, int start, int end) {
			for (int i = start; i < end; i++) {
				if (i != 0 && i != A.length - 1) {
					if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
						return true;
					}
				}
			}
			return false;
		}
	}
}
