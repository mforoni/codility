package codility.lesson13;

import java.util.*;

/**
 * 
 * The Fibonacci sequence is defined using the following recursive formula:
 * <p>
 * F(0) = 0<br>
 * F(1) = 1<br>
 * F(M) = F(M - 1) + F(M - 2) if M >= 2
 * <p>
 * A small frog wants to get to the other side of a river. The frog is initially
 * located at one bank of the river (position −1) and wants to get to the other
 * bank (position N). The frog can jump over any distance F(K), where F(K) is
 * the K-th Fibonacci number. Luckily, there are many leaves on the river, and
 * the frog can jump between the leaves, but only in the direction of the bank
 * at position N.
 * <p>
 * The leaves on the river are represented in an array A consisting of N
 * integers. Consecutive elements of array A represent consecutive positions
 * from 0 to N − 1 on the river. Array A contains only 0s and/or 1s:
 * <p>
 * 0 represents a position without a leaf;<br>
 * 1 represents a position containing a leaf.
 * <p>
 * The goal is to count the minimum number of jumps in which the frog can get to
 * the other side of the river (from position −1 to position N). The frog can
 * jump between positions −1 and N (the banks of the river) and every position
 * containing a leaf.
 * <p>
 * For example, consider array A such that:
 * <p>
 * A[0] = 0 A[1] = 0 A[2] = 0 A[3] = 1 A[4] = 1 A[5] = 0 A[6] = 1 A[7] = 0 A[8]
 * = 0 A[9] = 0 A[10] = 0
 * <p>
 * The frog can make three jumps of length F(5) = 5, F(3) = 2 and F(5) = 5.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, returns the minimum number
 * of jumps by which the frog can get to the other side of the river. If the
 * frog cannot reach the other side of the river, the function should return −1.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 0 A[1] = 0 A[2] = 0 A[3] = 1 A[4] = 1 A[5] = 0 A[6] = 1 A[7] = 0 A[8]
 * = 0 A[9] = 0 A[10] = 0
 * <p>
 * the function should return 3, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:<br>
 * N is an integer within the range [0..100,000];<br>
 * each element of array A is an integer that can have one of the following
 * values: 0, 1.
 * @see <a href="https://app.codility.com/programmers/lessons/13-fibonacci_numbers/fib_frog/">
 *     app.codility.com/programmers/lessons/13-fibonacci_numbers/fib_frog</a>
 * 
 * @author Marco Foroni
 */
final class FibFrog {

	/**
	 * <pre>
	 * Idea: Compute the following array minFibJumps[i] = minimum number of fibonacci jumps to reach position i.
	 * The size of this array is N + 1 where N is the length of the array in input A.
	 * minFibJumps[0] = 1 if A[i] = 1 otherwise 0
	 * minFibJumps[i] =
	 * 	for each f in Fibonacci(N) minFibJumps[i + f] = 1 + minFibJumps[i] if A[i] = 1 and minFibJumps[i + f] > 1 + minFibJumps[i]
	 * minFibJumps must be initialized to a maximum value
	 * </pre>
	 * Time complexity is O(N * logN) = O(N * logN) because the number of fibonacci numbers less or equal to n is O(logN)
	 * by Binet's formula
	 * Space complexity is O(N)
	 * @see <a href="https://app.codility.com/demo/results/trainingG64FNB-F2A/">app.codility.com/demo/results/trainingG64FNB-F2A</a>
	 * @see <a href="https://math.stackexchange.com/questions/67707/how-many-numbers-are-in-the-fibonacci-sequence-below-a-given-threshold">
	 *     How many numbers are in the Fibonacci sequence below a given threshold?</a>
	 *
	 * @param A
	 * @return
	 */
	public int solution(int[] A) {
		final int n = A.length;
		if (n == 0) {
			return 1;
		}
		final Set<Integer> fibSet = fibSet(n + 1);
		final int[] minFibJumps = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			minFibJumps[i] = Integer.MAX_VALUE;
		}
		for (int f : fibSet) {
			if (f == n + 1) {
				return 1;
			}
			else if (f < n + 1) {
				minFibJumps[f - 1] = A[f - 1] == 1 ? 1 : 0;
			}
		}
//		System.out.printf("N = %d%n", n);
//		System.out.printf("A\t= %s%n", Arrays.toString(A));
//		printMFJ(minFibJumps);
		for (int i = 0; i < n; i++) {
			if (A[i] == 1 && minFibJumps[i] < Integer.MAX_VALUE) {
				for (int f : fibSet) {
					if ((i + f < n && A[i + f] == 1) || i + f == n) {
						minFibJumps[i + f] = Math.min(minFibJumps[i + f], minFibJumps[i] + 1);
					}
				}
//				printMFJ(minFibJumps);
			}
		}
		return minFibJumps[n] == Integer.MAX_VALUE ? -1 : minFibJumps[n];
	}

	/**
	 * Time complexity is O(N)<br>
	 * Space complexity is O(N)
	 *
	 * @param n
	 * @return
	 */
	static Set<Integer> fibSet(int n) {
		final Set<Integer> set = new HashSet<>();
		int f1 = 0, f2 = 1, f3 = 1;
		while (f1 <= n) {
			if (f1 != 0)
				set.add(f1);
			f1 = f2;
			f2 = f3;
			f3 = f1 + f2;
		}
		return set;
	}

	private static void printMFJ(final int[] mfj) {
		System.out.print("MFJ\t= [");
		for (int i = 0; i < mfj.length; i++) {
			if (i < mfj.length - 1) {
				System.out.print(mfj[i] == Integer.MAX_VALUE ? "M, " : mfj[i] + ", ");
			} else {
				System.out.print(mfj[i] == Integer.MAX_VALUE ? "M" : mfj[i]);
			}
		}
		System.out.println("]");
	}

	/**
	 * Idea:
	 */
	static class ExhaustiveSearch {
		/**
		 * Time complexity is exponential
		 *
		 * @param A
		 * @return
		 */
		public int solution(int[] A) {
			final int n = A.length;
			final Set<Integer> fibSet = fibSet(n + 1);
			final int solution = minFibJumps(A, -1, fibSet);
//			System.out.printf("A = %s, N = %d, FibSet = %s, sol = %d%n", Arrays.toString(A), n, fibSet, solution);
			return solution;
		}

		/**
		 * <pre>
		 * Idea:
		 * MinFibJobs(A, pos) =
		 * 	1 if pos + f = N
		 * 	Min(1 + MinFibJobs(A, pos + f)) for each f in Fibonacci(N)
		 * </pre>
		 * Time complexity is O(?)
		 *
		 * @param A
		 * @param pos
		 * @param fibSet
		 * @return
		 */
		private int minFibJumps(int[] A, int pos, Set<Integer> fibSet) {
			int min = Integer.MAX_VALUE;
			for (int f : fibSet) {
				if (pos + f == A.length) {
					return 1;
				} else if (pos + f < A.length && A[pos + f] == 1) {
					int candidate = minFibJumps(A, pos + f, fibSet);
					if (candidate > 0) {
						min = Math.min(min, candidate + 1);
					}
				}
			}
			return min == Integer.MAX_VALUE ? -1 : min;
		}
	}

	/**
	 * Idea: exhaustive search but returns the sequence of fibonacci numbers composing the solution
	 */
	static class MinFibJumpSequence {

		public List<Integer> solution(int[] A) {
			final int n = A.length;
			final Set<Integer> fibSet = fibSet(n + 1);
			final List<Integer> solution = minFibJumpSequence(A, -1, fibSet);
//			System.out.printf("A = %s, N = %d, FibSet = %s%n", Arrays.toString(A), n, fibSet);
//			System.out.printf("Solution = %s%n", solution);
			Collections.reverse(solution);
			return solution;
		}

		private List<Integer> minFibJumpSequence(int[] A, int pos, Set<Integer> fibSet) {
			int min = Integer.MAX_VALUE;
			List<Integer> solution = new ArrayList<>();
			for (int f : fibSet) {
				if (pos + f == A.length) {
					return Arrays.asList(f);
				} else if (pos + f < A.length && A[pos + f] == 1) {
					List<Integer> candidate = minFibJumpSequence(A, pos + f, fibSet);
					if (candidate.size() > 0 && candidate.size() + 1 < min) {
						min = candidate.size() + 1;
						solution = new ArrayList<>();
						solution.addAll(candidate);
						solution.add(f);
					}
				}
			}
			return solution;
		}
	}

	/**
	 * Time complexity is O(N)<br>
	 * Space complexity is O(N)
	 *
	 * @param n
	 * @return
	 */
	static int[] fibonacci(int n) {
		final int[] fib = new int[n];
		fib[0] = 0;
		fib[1] = 1;
		for (int i = 2; i < n; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		return fib;
	}

	/**
	 * Returns count of fibonacci numbers in [low, high].
	 * <p>
	 * Time complexity is O(logN)<br>
	 * Space complexity is O(1)
	 * 
	 * @param low
	 * @param high
	 * @return
	 */
	static int countFibs(int low, int high) {
		int f1 = 0, f2 = 1, f3 = 1;
		int result = 0;
		while (f1 <= high) {
			if (f1 >= low)
				result++;
			f1 = f2;
			f2 = f3;
			f3 = f1 + f2;
		}
		return result;
	}
}
