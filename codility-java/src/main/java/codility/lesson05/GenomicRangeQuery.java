package codility.lesson05;

import codility.util.MoreInts;

import java.util.ArrayList;
import java.util.List;

/**
 * A DNA sequence can be represented as a string consisting of the letters A, C,
 * G and T, which correspond to the types of successive nucleotides in the
 * sequence. Each nucleotide has an impact factor, which is an integer.
 * Nucleotides of types A, C, G and T have impact factors of 1, 2, 3 and 4,
 * respectively. You are going to answer several queries of the form: What is
 * the minimal impact factor of nucleotides contained in a particular part of
 * the given DNA sequence?
 * <p>
 * The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1]
 * consisting of N characters. There are M queries, which are given in non-empty
 * arrays P and Q, each consisting of M integers. The K-th query (0 ≤ K < M)
 * requires you to find the minimal impact factor of nucleotides contained in
 * the DNA sequence between positions P[K] and Q[K] (inclusive).
 * <p>
 * For example, consider string S = CAGCCTA and arrays P, Q such that:
 * <p>
 * P[0] = 2 Q[0] = 4 P[1] = 5 Q[1] = 5 P[2] = 0 Q[2] = 6
 * <p>
 * The answers to these M = 3 queries are as follows:
 * <p>
 * The part of the DNA between positions 2 and 4 contains nucleotides G and C
 * (twice), whose impact factors are 3 and 2 respectively, so the answer is
 * 2.<br>
 * The part between positions 5 and 5 contains a single nucleotide T, whose
 * impact factor is 4, so the answer is 4.<br>
 * The part between positions 0 and 6 (the whole string) contains all
 * nucleotides, in particular nucleotide A whose impact factor is 1, so the
 * answer is 1.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int[] solution(String S, int[] P, int[] Q); }
 * <p>
 * that, given a non-empty string S consisting of N characters and two non-empty
 * arrays P and Q consisting of M integers, returns an array consisting of M
 * integers specifying the consecutive answers to all queries.
 * <p>
 * The sequence should be returned as:
 * <p>
 * a Results structure (in C), or a vector of integers (in C++), or a Results
 * record (in Pascal), or an array of integers (in any other programming
 * language). For example, given the string S = CAGCCTA and arrays P, Q such
 * that:
 * <p>
 * P[0] = 2 Q[0] = 4 P[1] = 5 Q[1] = 5 P[2] = 0 Q[2] = 6 the function should
 * return the values [2, 4, 1], as explained above.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [1..100,000];<br>
 * M is an integer within the range [1..50,000];<br>
 * each element of arrays P, Q is an integer within the range [0..N − 1];<br>
 * P[K] ≤ Q[K], where 0 ≤ K < M;<br>
 * string S consists only of upper-case English letters A, C, G, T.
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
final class GenomicRangeQuery {

	/**
	 * Time complexity is O(N+M)<br>
	 * Space complexity is O(N+M)
	 * <p>
	 * Idea: Simplify the problem answer the question is A present in the
	 * subsequence of S starting from s and ending at e?
	 * <p>
	 * Using an array O to store the occurrences of A till the corresponding index
	 * in S:
	 * <p>
	 * O[i] = number of occurrences of A in S till the index i
	 * <p>
	 * Therefore:
	 * <p>
	 * A is present in the subsequence of S starting from s and ending at e if O[e]
	 * - O[s] > 0.
	 * 
	 * @param S
	 * @param P
	 * @param Q
	 * @return
	 */
	public int[] solution(String S, int[] P, int[] Q) {
//		System.out.println(String.format("S = %s, P = [%s], Q = [%s]", S, MoreInts.toString(P), MoreInts.toString(Q)));
		final int[] occA = new int[S.length()];
		occA[0] = S.charAt(0) == 'A' ? 1 : 0;
		final int[] occC = new int[S.length()];
		occC[0] = S.charAt(0) == 'C' ? 1 : 0;
		final int[] occG = new int[S.length()];
		occG[0] = S.charAt(0) == 'G' ? 1 : 0;
		for (int i = 1; i < S.length(); i++) {
			final char n = S.charAt(i);
			occA[i] = n == 'A' ? occA[i - 1] + 1 : occA[i - 1];
			occC[i] = n == 'C' ? occC[i - 1] + 1 : occC[i - 1];
			occG[i] = n == 'G' ? occG[i - 1] + 1 : occG[i - 1];
		}
//		System.out.println(String.format("OccA = %s", MoreInts.toString(occA)));
//		System.out.println(String.format("OccC = %s", MoreInts.toString(occC)));
//		System.out.println(String.format("OccG = %s", MoreInts.toString(occG)));
		assert (P.length == Q.length);
		final int[] results = new int[P.length];
		for (int i = 0; i < P.length; i++) {
			final int start = P[i];
			final int end = Q[i];
			if (start == 0) {
				if (occA[end] > 0) {
					results[i] = 1;
				} else if (occC[end] > 0) {
					results[i] = 2;
				} else if (occG[end] > 0) {
					results[i] = 3;
				} else {
					// ensured by the fact that S is composed just by A, C, G and T
					// and at this point is verified that A, C, and G does not occur
					// in S between start and end:
					results[i] = 4;
				}
			} else {
				if (occA[end] - occA[start - 1] > 0) {
					results[i] = 1;
				} else if (occC[end] - occC[start - 1] > 0) {
					results[i] = 2;
				} else if (occG[end] - occG[start - 1] > 0) {
					results[i] = 3;
				} else {
					// ensured by the fact that S is composed just by A, C, G and T
					// and at this point is verified that A, C, and G does not occur
					// in S between start and end:
					results[i] = 4;
				}
			}
		}
//		System.out.println(MoreInts.toString(results));
		return results;
	}

	/**
	 * Time complexity is O(M*N)<br>
	 * Space complexity is O(N) 
	 * 
	 * @param S
	 * @param P
	 * @param Q
	 * @return
	 */
	public static int[] exhaustiveSearch(String S, int[] P, int[] Q) {
		final int N = S.length();
		final int[] factors = new int[N];
		for (int i = 0; i < N; i++) {
			final char n = S.charAt(i);
			factors[i] = getFactor(n);
		}
		assert (P.length == Q.length);
		final int[] result = new int[P.length];
		for (int i = 0; i < P.length; i++) {
			final int start = P[i];
			final int end = Q[i];
			result[i] = MoreInts.min(factors, start, end);
		}
		return result;
	}

	/**
	 * Time and space complexity is O(1);
	 * 
	 * @param n
	 * @return
	 */
	public static int getFactor(final char n) {
		switch (n) {
		case 'A':
			return 1;
		case 'C':
			return 2;
		case 'G':
			return 3;
		case 'T':
			return 4;
		default:
			throw new AssertionError();
		}
	}

	static class SubOptimal {

		/**
		 * @param S
		 * @param P
		 * @param Q
		 * @return
		 */
		public int[] solution(String S, int[] P, int[] Q) {
			final List<Integer> indexesOfA = indexes(S, 'A');
			final List<Integer> indexesOfC = indexes(S, 'C');
			final List<Integer> indexesOfG = indexes(S, 'G');
			final List<Integer> indexesOfT = indexes(S, 'T');
			assert (P.length == Q.length);
			final int[] result = new int[P.length];
			for (int i = 0; i < P.length; i++) {
				if (contains(indexesOfA, P[i], Q[i])) {
					result[i] = 1;
				} else if (contains(indexesOfC, P[i], Q[i])) {
					result[i] = 2;
				} else if (contains(indexesOfG, P[i], Q[i])) {
					result[i] = 3;
				} else if (contains(indexesOfT, P[i], Q[i])) {
					result[i] = 4;
				} else {
					throw new IllegalStateException();
				}
			}
			return result;
		}

		private static boolean contains(final List<Integer> indexes, final int start, final int end) {
			for (int index : indexes) {
				if (start <= index && index <= end) {
					return true;
				}
				if (index > end) {
					return false; // since indexes is a sorted list.
				}
			}
			return false;
		}

		private static List<Integer> indexes(final String str, final char c) {
			final List<Integer> list = new ArrayList<>();
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == c) {
					list.add(i);
				}
			}
			return list;
		}
	}
}
