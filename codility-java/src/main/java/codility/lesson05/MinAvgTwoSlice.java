package codility.lesson05;

import codility.util.MoreInts;

/**
 * A non-empty array A consisting of N integers is given. A pair of integers (P,
 * Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the
 * slice contains at least two elements). The average of a slice (P, Q) is the
 * sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. To be
 * precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).
 * <p>
 * For example, array A such that:
 * <p>
 * A[0] = 4 A[1] = 2 A[2] = 2 A[3] = 5 A[4] = 1 A[5] = 5 A[6] = 8 contains the
 * following example slices:
 * <p>
 * slice (1, 2), whose average is (2 + 2) / 2 = 2;<br>
 * slice (3, 4), whose average is (5 + 1) / 2 = 3;<br>
 * slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
 * <p>
 * The goal is to find the starting position of a slice whose average is
 * minimal.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A consisting of N integers, returns the
 * starting position of the slice with the minimal average. If there is more
 * than one slice with a minimal average, you should return the smallest
 * starting position of such a slice.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 4 A[1] = 2 A[2] = 2 A[3] = 5 A[4] = 1 A[5] = 5 A[6] = 8 the function
 * should return 1, as explained above.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [2..100,000];<br>
 * each element of array A is an integer within the range [−10,000..10,000].
 * <p>
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);<br>
 * expected worst-case space complexity is O(N) (not counting the storage
 * required for input arguments).
 * @see <a href="https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/">
 *     app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/</a>
 *
 * @author Marco Foroni
 */
final class MinAvgTwoSlice {

	/**
	 * Idea: use dynamic programming to compute the following two arrays:<br>
	 * lenMinAvg[i] = length of the slice starting from i whose average is minimal<br>
	 * minAvg[i] = minimal average of the slice starting from i<br>
	 * The index of the minimal value in minAvg is the solution.
	 * <br>
	 * Time complexity is O(N)<br>
	 * Space complexity is O(N)
	 *
	 * @see <a href="https://app.codility.com/demo/results/trainingHUVNPH-7KQ/">
	 *     app.codility.com/demo/results/trainingHUVNPH-7KQ</a>
	 */
	public int solution(int[] A) {
		final int N = A.length;
		assert (N >= 2);
		final double[] minAvg = new double[N - 1];
		final double[] lenMinAvg = new double[N - 1];
		minAvg[N - 2] = (A[N - 1] + A[N - 2]) / 2;
		lenMinAvg[N - 2] = 2;
		for (int i = N - 3; i >= 0; i--) {
			final double a = (minAvg[i + 1] * lenMinAvg[i + 1] + A[i]) / (lenMinAvg[i + 1] + 1);
			final double b = ((double) A[i] + (double) A[i + 1]) / 2;
			if (b <= a) {
				// crucial: for a==b we need to prioritize the slice with lesser length because it is "more minimizable"
				minAvg[i] = b;
				lenMinAvg[i] = 2;
			} else {
				minAvg[i] = a;
				lenMinAvg[i] = lenMinAvg[i + 1] + 1;
			}
			//System.out.printf("minAvg=[%s], lenMinAvg=[%s]%n", Arrays.toString(minAvg), Arrays.toString(lenMinAvg));
		}
		return minIndex(minAvg);
	}

	private static int minIndex(final double[] array) {
		double min = Double.MAX_VALUE;
		int minIndex = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	/**
	 * Idea: Use dynamic programming prefix sum to compute the sum of all elements in A till index i.<br>
	 * <br>
	 * Time complexity is O(N^2)<br>
	 * Space complexity is O(N)
	 */
	public static int exhaustiveSearchOptimized(final int[] A) {
		int[] sums = new int[A.length];
		sums[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			sums[i] = sums[i - 1] + A[i];
		}
		double min = Double.MAX_VALUE;
		int start = -1;
		for (int s = 0; s < A.length - 1; s++) {
			for (int e = s + 1; e < A.length; e++) {
				int sum = s > 0 ? sums[e] - sums[s - 1] : sums[e];
				double avg = (double) sum / (e - s + 1);
				if (avg < min) {
					min = avg;
					start = s;
				}
			}
		}
		return start;
	}

	/**
	 * Time complexity is O(N^3)<br>
	 * Space complexity is O(1)
	 */
	public static int exhaustiveSearch(final int[] A) {
		double min = Double.MAX_VALUE;
		int start = -1;
		for (int s = 0; s < A.length - 1; s++) {
			for (int e = s + 1; e < A.length; e++) {
				int sum = MoreInts.sum(A, s, e);
				double avg = (double) sum / (e - s + 1);
				if (avg < min) {
					min = avg;
					start = s;
				}
				//System.out.printf("s=%s, e=%s, avg=%s, min=%s%n", s, e, avg, min);
			}
		}
		return start;
	}
}
