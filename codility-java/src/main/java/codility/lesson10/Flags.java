package codility.lesson10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A non-empty array A consisting of N integers is given.<br>
 * A peak is an array element which is larger than its neighbours. More
 * precisely, it is an index P such that 0 < P < N − 1 and A[P − 1] < A[P] > A[P
 * + 1].
 * <p>
 * For example, the following array A:<br>
 * A[0] = 1 A[1] = 5 A[2] = 3 A[3] = 4 A[4] = 3 A[5] = 4 A[6] = 1 A[7] = 2 A[8]
 * = 3 A[9] = 4 A[10] = 6 A[11] = 2<br>
 * has exactly four peaks: elements 1, 3, 5 and 10.
 * <p>
 * You are going on a trip to a range of mountains whose relative heights are
 * represented by array A, as shown in a figure below. You have to choose how
 * many flags you should take with you. The goal is to set the maximum number of
 * flags on the peaks, according to certain rules.
 * <p>
 * Flags can only be set on peaks. What's more, if you take K flags, then the
 * distance between any two flags should be greater than or equal to K. The
 * distance between indices P and Q is the absolute value |P − Q|.
 * <p>
 * For example, given the mountain range represented by array A, above, with N =
 * 12, if you take:<br>
 * two flags, you can set them on peaks 1 and 5;<br>
 * three flags, you can set them on peaks 1, 5 and 10;<br>
 * four flags, you can set only three flags, on peaks 1, 5 and 10. You can
 * therefore set a maximum of three flags in this case.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A of N integers, returns the maximum number of
 * flags that can be set on the peaks of the array.
 * <p>
 * For example, the following array A:
 * <p>
 * A[0] = 1 A[1] = 5 A[2] = 3 A[3] = 4 A[4] = 3 A[5] = 4 A[6] = 1 A[7] = 2 A[8]
 * = 3 A[9] = 4 A[10] = 6 A[11] = 2 the function should return 3, as explained
 * above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..400,000];<br>
 * each element of array A is an integer within the range [0..1,000,000,000].
 * @see <a href="https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/flags/">
 *     app.codility.com/programmers/lessons/10-prime_and_composite_numbers/flags</a>
 *
 * @author Marco Foroni
 */
final class Flags {

	/**
	 * @param A
	 * @return
	 */
	public int solution(int[] A) {
		final SubOptimal subOptimal = new SubOptimal();
		return subOptimal.solution(A);
	}

	/**
	 * Idea: We can check in O(N) time if K flags can be placed in array A. The maximum number of flags is equal
	 * to the number of peaks.
	 * <ul>
	 * 	 <li>If K flags can be placed then also K-1, K-2, ... flags can be placed.</li>
	 * 	 <li>If K flags cannot be placed then also K+1, K+2, ... flags can be placed.</li>
	 * </ul>
	 * We can use the bisection method to compute all the possible flag values in O(logN) time.
	 */
	static class SubOptimal {

		/**
		 * Time complexity is O(NlogN)<br>
		 * Space complexity is O(N)
		 * @see <a href="https://app.codility.com/demo/results/trainingMMCVQV-MCH/">app.codility.com/demo/results/trainingMMCVQV-MCH</a>
		 *
		 * @param A
		 * @return
		 */
		public int solution(int[] A) {
			//System.out.println(Arrays.toString(A));
			int max = peaks(A);
			int min = max > 0 ? 1 : 0;
			int maxFlags = 0;
			final boolean[] isPeak = isPeak(A);
			while(min <= max){
				int k = (max + min) / 2;
				//System.out.println(String.format("Max = %d, min = %d, k = %d, maxFlags = %d", max, min, k, maxFlags));
				if (!checkFlags(isPeak, k)){
					// We failed to put k flags, then try to check a smaller value.
					max = k - 1;
				}
				// We succeed to put k flags, update the maxFlags and try a larger value.
				else {
					min = k + 1;
					maxFlags = k;
				}
			}
			return maxFlags;
		}

		private int peaks(int[] A) {
			int peaks = 0;
			for (int i = 1; i < A.length - 1; i++) {
				if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
					peaks += 1;
				}
			}
			return peaks;
		}

		private boolean[] isPeak(int[] A) {
			final int n = A.length;
			final boolean[] isPeak = new boolean[n];
			isPeak[0] = false;
			for (int i = 1; i < n - 1; i++) {
				isPeak[i] = A[i] > A[i - 1] && A[i] > A[i + 1];
			}
			isPeak[n - 1] = false;
			return isPeak;
		}

		/**
		 * <p>
		 * Idea: Check if K flags can be placed in array A.
		 * </p>
		 * Time complexity is O(N)<br>
		 * Space complexity is O(N)
		 *
		 * @param isPeak
		 * @param flags
		 * @return
		 */
		private boolean checkFlags(boolean[] isPeak, final int flags)	{
			final int n = isPeak.length;
			int f = 0;
			int i = 1;
			for (; i < n - 1 && f < flags;) {
				if (isPeak[i]) {
					f++;
					i += flags; // next flag can be at index i + flags
				} else {
					i += 1;
				}
			}
			return f == flags;
		}
	}


	/**
	 * Def: A peak is an array element which is larger than its neighbours. More precisely, it is an index P such that
	 * 0 < P < N − 1 and A[P − 1] < A[P] > A[P + 1].
	 * <p>
	 * Idea: Compute the number of peaks in array A. Be F the number of flags and P the number of peaks, for each value
	 * F from 1 to P compute if can set F flags in array A.
	 * </p>
	 * Note:
	 * <ul>
	 * <li>Flags can only be set on peaks.</li>
	 * <li>If you take K flags, then the distance between any two flags should be greater than or equal to K.</li>
	 * </ul>
	 */
	static class ExhaustiveSearch {
		/**
		 * Time complexity is O(N^2)<br>
		 * Space complexity is O(1)
		 *
		 * @param A
		 * @return
		 */
		public int solution(int[] A) {
			int max = 0;
			final int peaks = peaks(A);
			for (int f = 1; f <= peaks; f++) {
				if (canSetFlags(A, f)) {
					max = Math.max(max, f);
				}
			}
			return max;
		}

		/**
		 * Time complexity is O(N)<br>
		 * Space complexity is O(1)
		 *
		 * @param A
		 * @return
		 */
		private int peaks(final int[] A) {
			int counter = 0;
			for (int i = 1; i < A.length - 1; i++) {
				if (isPeak(A, i)) {
					counter++;
				}
			}
			return counter;
		}

		/**
		 * Time and space complexity is O(1)
		 *
		 * @param A
		 * @param i
		 * @return
		 */
		private boolean isPeak(final int[] A, final int i) {
			return A[i] > A[i - 1] && A[i] > A[i + 1];
		}

		/**
		 * Time complexity is O(N)<br>
		 * Space complexity is O(1)
		 *
		 * @param A
		 * @param f
		 * @return
		 */
		private boolean canSetFlags(final int[] A, final int f) {
			int previousFlag = -1;
			int flags = 0;
			for (int i = 1; i < A.length - 1; i++) {
				if (isPeak(A, i)) {
					if (previousFlag == -1) {
						previousFlag = i;
						flags++;
					} else {
						if (i - previousFlag >= f) {
							previousFlag = i;
							flags++;
						}
					}
				}
			}
			return flags >= f;
		}
	}
}
