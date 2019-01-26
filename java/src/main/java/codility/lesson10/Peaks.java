package codility.lesson10;

import java.util.ArrayList;
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
 * 
 * @author Marco Foroni
 *
 */
final class Peaks {

	/**
	 * Note: P is the number of peaks. The upper bound of P is N/2. Consider the
	 * array: A = [1 2 1 2 1 2 1]. |A|=7, P=3.
	 * 
	 * Time complexity is O(SQRT(N) * SQRT(N)) = O(N)<br>
	 * Space complexity is O(N)
	 * 
	 * @param A
	 * @return
	 */
	public int solution(int[] A) {
//		System.out.println("\n"+MoreInts.toString(A));
		final int n = A.length;
		int max = 0;
		final int[] pikesAt = pikesTotal(A);
//		System.out.println("PikesAt " + MoreInts.toString(pikesAt));
		final List<Integer> factors = factors(n);
		for (int f1 : factors) {
			int f2 = n / f1;
			if (hasPikesEff(pikesAt, f1, f2)) {
				max = Math.max(max, f2);
			}
			if (f1 != f2 && hasPikesEff(pikesAt, f2, f1)) {
				max = Math.max(max, f1);
			}
		}
		return max;
	}

	/**
	 * PT[i] = Peaks total at position i.
	 * <p>
	 * Time complexity is O(N)
	 * 
	 * @param A
	 * @return
	 */
	static int[] pikesTotal(final int[] A) {
		final int[] pt = new int[A.length];
		pt[0] = 0;
		for (int i = 1; i < A.length - 1; i++) {
			if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
				pt[i] = pt[i - 1] + 1;
			} else {
				pt[i] = pt[i - 1];
			}
		}
		pt[A.length - 1] = pt[A.length - 2];
		return pt;
	}

	/**
	 * Time complexity is O(SQRT(N))
	 * 
	 */
	static boolean hasPikesEff(int[] pikesAt, int size, int groups) {
		for (int g = 0; g < groups; g++) {
			if (!hasPikeEff(pikesAt, g * size, g * size + size)) {
//				System.out.println(
//						String.format("Doesn't have pike between %d:%d, groups=%d", g * size, g * size + size, g + 1));
//				System.out.println(String.format("Doesn't have pikes with size=%d, groups=%d", size, groups));
				return false;
			}
		}
//		System.out.println(String.format("Has pikes with size=%d, groups=%d", size, groups));
		return true;
	}

	static boolean hasPikeEff(int[] pikesAt, int start, int end) {
		int pikesBetweenStartEnd = start == 0 ? pikesAt[end - 1] : pikesAt[end - 1] - pikesAt[start - 1];
		return pikesBetweenStartEnd > 0 ? true : false;
	}

	/**
	 * Time complexity is O(SQRT(N) * 2N)<br>
	 * Space complexity is O(SQRT(N))
	 * 
	 * @param A
	 * @return
	 */
	public static int exhaustiveSearch(int[] A) {
		final int n = A.length;
		int max = 0;
		final List<Integer> factors = factors(n);
		for (int f1 : factors) {
			int f2 = n / f1;
			if (hasPikes(A, f1, f2)) {
				max = Math.max(max, f2);
			}
			if (f1 != f2 && hasPikes(A, f2, f1)) {
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
	static boolean hasPikes(int[] A, int size, int groups) {
		for (int g = 0; g < groups; g++) {
			if (!hasPike(A, g * size, g * size + size)) {
				return false;
			}
		}
		return true;
	}

	static boolean hasPike(int[] A, int start, int end) {
		for (int i = start; i < end; i++) {
			if (i != 0 && i != A.length - 1) {
				if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Time complexity is O(SQRT(N))<br>
	 * Space complexity is O(SQRT(N)) ?
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
}
