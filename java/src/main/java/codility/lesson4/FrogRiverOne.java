package codility.lesson4;

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
 * 
 * @author Foroni Marco
 *
 */
final class FrogRiverOne {

	/**
	 * Time complexity is O(N)
	 * Space complexity is O(X)=O(N)
	 * 
	 * @param X
	 * @param A
	 * @return
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
	 * Time complexity is O(X*N) = O(N^2) in the worst case with X = N<br>
	 * Space complexity is O(1)
	 * 
	 * @param X
	 * @param A
	 * @return
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
	 * 
	 * @param X
	 * @param A
	 * @param sol
	 * @return
	 */
	public static boolean ensureSoundness(final int X, final int[] A, final int sol) {
		return containsPermutation(A, X, sol);
	}

	public static boolean containsPermutation(final int[] A, final int N, final int end) {
		assert (end < A.length);
		final int[] numbers = new int[N + 1];
		for (int i = 0; i < end; i++) {
			int a = A[i];
			if (a > N) {
				return false;
			}
			numbers[a] = 1;
		}
		for (int i = 1; i <= N; i++) {
			if (numbers[i] == 0) {
				return false;
			}
		}
		return true;
	}

}
