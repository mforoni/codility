package codility.lesson11;

import java.util.*;
import java.util.stream.Collectors;

/**
 * You are given an array A consisting of N integers.<br>
 * For each number A[i] such that 0 ≤ i < N, we want to count the number of
 * elements of the array that are not the divisors of A[i]. We say that these
 * elements are non-divisors.
 * <p>
 * For example, consider integer N = 5 and array A such that:
 * <p>
 * A[0] = 3 A[1] = 1 A[2] = 2 A[3] = 3 A[4] = 6
 * <p>
 * For the following elements:
 * <p>
 * A[0] = 3, the non-divisors are: 2, 6,<br>
 * A[1] = 1, the non-divisors are: 3, 2, 3, 6,<br>
 * A[2] = 2, the non-divisors are: 3, 3, 6,<br>
 * A[3] = 3, the non-divisors are: 2, 6,<br>
 * A[4] = 6, there aren't any non-divisors.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int[] solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, returns a sequence of
 * integers representing the amount of non-divisors.<br>
 * Result array should be returned as an array of integers.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 3 A[1] = 1 A[2] = 2 A[3] = 3 A[4] = 6 the function should return [2,
 * 4, 3, 2, 0], as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:<br>
 * N is an integer within the range [1..50,000];<br>
 * each element of array A is an integer within the range [1..2 * N].
 * @see <a href="https://app.codility.com/programmers/lessons/11-sieve_of_eratosthenes/count_non_divisible/">
 *     app.codility.com/programmers/lessons/11-sieve_of_eratosthenes/count_non_divisible</a>
 *
 * @author Marco Foroni
 */
final class CountNonDivisible {

	/**
	 * <p>
	 * Idea: for each element e in array A calculate the number of divisors of e.
	 * </p>
	 * Time complexity is O(N*SQRT(N)+M)
	 * @see <a href="https://app.codility.com/demo/results/training3VC7JK-S99/">app.codility.com/demo/results/training3VC7JK-S99</a>
	 *
	 * @param A
	 * @return
	 */
	public int[] solution(int[] A) {
		//System.out.println("A = " + Arrays.toString(A));
		final int N = A.length;
		final int[] occurrences = occurrences(A);
		final int[] nonDivisors = new int[N];
		for (int i = 0; i < N; i++) {
			final int divisors = divisors(A[i], occurrences);
			//System.out.println(String.format("A[i] = %d, divisors = %s", A[i], divisors));
			nonDivisors[i] = N - divisors;
		}
		return nonDivisors;
	}

	/**
	 * Compute the number of divisors of n in A given an array counting the occurrences for each element of A.
	 * <p>
	 *     occurrences[i] = number of occurrences of i in A
	 * </p>
	 * Time complexity is O(SQRT(N))
	 *
	 * @param n
	 * @return
	 */
	static int divisors(int n, int[] occurrences) {
		int counter = 0;
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				counter += occurrences[i];
				final int factor = n / i;
				if (factor != i) {
					counter += occurrences[factor];
				}
			}
		}
		return counter;
	}

	/**
	 * <p>
	 * Find max element in A
	 * </p>
	 * Time complexity is O(N)
	 *
	 * @param A
	 * @return
	 */
	static int max(final int[] A) {
		int max = A[0];
		for (int i = 1; i < A.length; i++) {
			max = Math.max(max, A[i]);
		}
		return max;
	}

	/**
	 * Time complexity is O(N+M)
	 * 
	 * @param A
	 * @return
	 */
	static int[] occurrences(final int[] A) {
		int n = A.length;
		final int max = max(A);
		final int[] occ = new int[max + 1];
		for (int i = 0; i < n; i++) {
			occ[A[i]] += 1;
		}
		return occ;
	}

	/**
	 * Time complexity is O(N^2)<br>
	 * Space complexity is O(1)
	 * @see <a href="https://app.codility.com/demo/results/trainingB7SN68-5EG/">
	 *     app.codility.com/demo/results/trainingB7SN68-5EG</a>
	 * 
	 * @param A
	 * @return
	 */
	public static int[] exhaustiveSearch(int[] A) {
		final int[] nonDivisors = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			nonDivisors[i] = nonDivisors(A[i], A);
		}
		return nonDivisors;
	}

	public static int nonDivisors(int n, final int[] array) {
		int counter = 0;
		for (int a : array) {
			if (a > n || n % a != 0) {
				counter++;
			}
		}
		return counter;
	}
}