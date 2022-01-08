package codility.lesson04;

import java.util.Arrays;

/**
 * You are given N counters, initially set to 0, and you have two possible
 * operations on them:
 * <p>
 * increase(X) − counter X is increased by 1,<br>
 * max counter − all counters are set to the maximum value of any counter.
 * <p>
 * A non-empty array A of M integers is given. This array represents consecutive
 * operations:
 * <p>
 * if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),<br>
 * if A[K] = N + 1 then operation K is max counter.
 * <p>
 * For example, given integer N = 5 and array A such that:
 * <p>
 * A[0] = 3 A[1] = 4 A[2] = 4 A[3] = 6 A[4] = 1 A[5] = 4 A[6] = 4 the values of
 * the counters after each consecutive operation will be:
 * <p>
 * (0, 0, 1, 0, 0)<br>
 * (0, 0, 1, 1, 0)<br>
 * (0, 0, 1, 2, 0)<br>
 * (2, 2, 2, 2, 2)<br>
 * (3, 2, 2, 2, 2)<br>
 * (3, 2, 2, 3, 2)<br>
 * (3, 2, 2, 4, 2)
 * <p>
 * The goal is to calculate the value of every counter after all operations.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int[] solution(int N, int[] A); }
 * <p>
 * that, given an integer N and a non-empty array A consisting of M integers,
 * returns a sequence of integers representing the values of the counters.
 * <p>
 * The sequence should be returned as:
 * <p>
 * a structure Results (in C), or a vector of integers (in C++), or a record
 * Results (in Pascal), or an array of integers (in any other programming
 * language). For example, given:
 * <p>
 * A[0] = 3 A[1] = 4 A[2] = 4 A[3] = 6 A[4] = 1 A[5] = 4 A[6] = 4 the function
 * should return [3, 2, 2, 4, 2], as explained above.
 * <p>
 * Assume that:
 * <p>
 * N and M are integers within the range [1..100,000];<br>
 * each element of array A is an integer within the range [1..N + 1].
 * <p>
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N+M);<br>
 * expected worst-case space complexity is O(N) (not counting the storage
 * required for input arguments).
 * 
 * 
 * @author Foroni Marco
 *
 */
final class MaxCounters {

	/**
	 * Time complexity is O(N + M) where M is the length of array A
	 * Space complexity is O(N)
	 * 
	 * @param N
	 * @param A
	 * @return
	 */
	public int[] solution(int N, int[] A) {
		final int[] counters = new int[N];
		int max = Integer.MIN_VALUE;
		int maxIndex = -1;
		int toSum = 0;
		for (int a : A) {
			a = a - 1;
			if (a == N) {
				toSum = max;
			} else {
				if (a == maxIndex) {
					counters[a] += 1;
				} else {
					if (counters[a] < toSum) {
						counters[a] = toSum; 
					}
					counters[a] += 1;
				}
				if (counters[a] > max) {
					max = counters[a];
					maxIndex = a;
				}
			}
			//System.out.println(String.format("%s | %s | %s | %s | %s", Arrays.toString(counters), a+1, max, maxIndex+1, toSum));
		}
		for (int i = 0; i < counters.length; i++) {
			if (counters[i] <= toSum) {
				counters[i] = toSum;
			}
		}
		return counters;
	}

	/**
	 * Time complexity is O(N + M) where M is the length of array A
	 * Space complexity is O(N)
	 *
	 * @param N
	 * @param A
	 * @return
	 */
	public static int[] elegantSolution(int N, int[] A) {
		//System.out.println("Elegant solution");
		int max = 0;
		int lastMaximization = 0;
		final int[] counters = new int[N];
		for (int command : A) {
			int index = command - 1;
			if (command == N + 1) {
				lastMaximization = max;
			} else {
				counters[index] = Math.max(lastMaximization, counters[index]) + 1;
				max = Math.max(max, counters[index]);
			}
			//System.out.println(String.format("c = [%s] , max = %s , lastMax = %s", Arrays.toString(counters), max, lastMaximization));
		}
		for (int i = 0; i < counters.length; i++) {
			if (counters[i] < lastMaximization) {
				counters[i] = lastMaximization;
			}
		}
		return counters;
	}

	/**
	 * Time complexity is O(M * N) where M is the length of array A<br>
	 * Space complexity is O(N)
	 * 
	 * @param N
	 * @param A
	 * @return
	 */
	public static int[] suboptimal(int N, int[] A) {
		int max = 0;
		final int[] counters = new int[N];	// Array is initialized to 0, the default value of primitive type int.
		for (int a : A) {
			if (a <= N) {
				counters[a - 1] += 1;
				if (max < counters[a - 1]) {
					max = counters[a - 1];
				}
			} else {
				assert (a == N + 1);
				maxCounter(counters, max);
			}
			// System.out.println(Ints.join(", ", counters));
		}
		return counters;
	}

	public static void maxCounter(final int[] array, final int max) {
		for (int i = 0; i < array.length; i++) {
			array[i] = max;
		}
	}
}
