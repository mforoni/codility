package codility.lesson04;

import codility.util.MoreInts;

/**
 * A small frog wants to get to the other side of a river. The frog is initially
 * located on one bank of the river (position 0) and wants to get to the
 * opposite bank (position X+1). Leaves fall from a tree onto the surface of the
 * river.
 * <p>
 * You are given an array A consisting of N integers representing the falling
 * leaves. A[K] represents the position where one leaf falls at time K, measured
 * in seconds.
 * <p>
 * The goal is to find the earliest time when the frog can jump to the other
 * side of the river. The frog can cross only when leaves appear at every
 * position across the river from 1 to X (that is, we want to find the earliest
 * moment when all the positions from 1 to X are covered by leaves). You may
 * assume that the speed of the current in the river is negligibly small, i.e.
 * the leaves do not change their positions once they fall in the river.
 * <p>
 * For example, you are given integer X = 5 and array A such that:
 * <p>
 * A[0] = 1 A[1] = 3 A[2] = 1 A[3] = 4 A[4] = 2 A[5] = 3 A[6] = 5 A[7] = 4 In
 * second 6, a leaf falls into position 5. This is the earliest time when leaves
 * appear in every position across the river.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int X, int[] A); }
 * <p>
 * that, given a non-empty array A consisting of N integers and integer X,
 * returns the earliest time when the frog can jump to the other side of the
 * river.
 * <p>
 * If the frog is never able to jump to the other side of the river, the
 * function should return −1.
 * <p>
 * For example, given X = 5 and array A such that:
 * <p>
 * A[0] = 1 A[1] = 3 A[2] = 1 A[3] = 4 A[4] = 2 A[5] = 3 A[6] = 5 A[7] = 4 the
 * function should return 6, as explained above.
 * <p>
 * Assume that:
 * <p>
 * N and X are integers within the range [1..100,000];<br>
 * each element of array A is an integer within the range [1..X].
 * <p>
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);<br>
 * expected worst-case space complexity is O(X) (not counting the storage
 * required for input arguments).
 * @see <a href="https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/">
 *     app.codility.com/programmers/lessons/4-counting_elements/frog_river_one</a>
 * 
 * @author Marco Foroni
 *
 */
final class FrogRiverOne {

	/**
	 * Time complexity is O(X * N)
	 * Space complexity is O(X + N)
	 * 
	 * @see <a href="https://app.codility.com/demo/results/trainingX4P2VA-9F5/">
	 *     app.codility.com/demo/results/trainingX4P2VA-9F5</a>
	 */
	public int solution(int X, int[] A) {
		int x = 0; // frog can reach leaf x at the current time/iteration
		final boolean[] leaves = new boolean[X+1]; // leaves[i] = 1 iff leaf is fall form three at the current time/iteration
		leaves[0] = true;
		for (int i = 0; i < A.length; i++) {
			leaves[A[i]] = true;
			if (A[i] == x+1) { // if the leaf fall in the position to jump more
				while (leaves[x+1] == true) { // update current reachable leaf
					x++;
					if (x == X) {
						return i;
					}
				}
			}
		}
		return -1;
	}
	
	/**
	 * Idea: compute the array:<br>
	 * earliestTime[k] = the earliest time for a leaf to appear in position k<br>
	 * <br>
	 * Time complexity is O(X + N)<br>
	 * Space complexity is O(X + N)
	 * 
	 * @see <a href="https://app.codility.com/demo/results/trainingKVRF8F-86X/">
	 *     app.codility.com/demo/results/trainingKVRF8F-86X</a>
	 */
    public static int elegantSolution(int X, int[] A) {
		//System.out.println(String.format("X = %d, A = %s", X, Arrays.toString(A)));
        final int[] earliestTime = new int[X + 1];
        for (int i = 1; i <= X; i++) {
            earliestTime[i] = -1;
        }
        for (int i = 0; i < A.length; i++) {
            if (earliestTime[A[i]] == -1) {
                earliestTime[A[i]] = i;
            }
        }
		//System.out.println(Arrays.toString(earliestTime));
		int max = -1;
        for (int i = 1; i <= X; i++) {
            if (earliestTime[i] == -1) {
                return -1;
            } else {
				max = Math.max(max, earliestTime[i]);
			}
        }
        return max;
    }
	

	/**
	 * Time complexity is O(X*N) = O(N^2) in the worst case with X = N<br>
	 * Space complexity is O(1)
	 */
	public static int exhaustiveSearch(final int X, final int[] A) {
		int firstTime = 0;
		for (int i = 1; i <= X; i++) {
			final int indexOf = MoreInts.indexOf(A, i, 0, A.length - 1);
			if (indexOf == -1) {
				return -1;
			}
			firstTime = Math.max(firstTime, indexOf);
		}
		return firstTime;
	}

	/**
	 * {@code sol} is a correct solution for the FrogRiverOne problem if A[0, sol]
	 * contains a permutation of the integer numbers from 1 to X.
	 * <p>
	 * Time complexity is O(N)<br>
	 * Space complexity is O(X)
	 */
	public static boolean ensureSoundness(final int X, final int[] A, final int sol) {
		return containsPermutation(A, X, sol);
	}

	public static boolean containsPermutation(final int[] A, final int N, final int end) {
		assert (end < A.length);
		final boolean[] numbers = new boolean[N + 1];
		numbers[0] = true;
		for (int i = 1; i <= N; i++) {
			numbers[i] = false;
		}
		for (int i = 0; i <= end; i++) {
			numbers[A[i]] = true;
		}
		for (int i = 1; i <= N; i++) {
			if (!numbers[i]) {
				return false;
			}
		}
		return true;
	}
}
