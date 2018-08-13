package codility.lesson5;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import codility.util.MoreInts;

public class GenomicRangeQueryTest {

	private static final int MIN_N = 1;
	private static final int MAX_N = 100_000;
	private static final int MIN_M = 1;
	private static final int MAX_M = 50_000;

	private static final String S1 = "CAGCCTA";
	private static final int[] P1 = { 2, 5, 0 };
	private static final int[] Q1 = { 4, 5, 6 };
	private static final int[] SOL1 = { 2, 4, 1 };

	@Test
	public void testSolution() {
		final GenomicRangeQuery genomicRangeQuery = new GenomicRangeQuery();
		assertArrayEquals(SOL1, genomicRangeQuery.solution(S1, P1, Q1));
	}

	@Test
	public void testChecker() {
		assertArrayEquals(SOL1, GenomicRangeQuery.checker(S1, P1, Q1));
	}

	@Test
	public void testGetFactor() {
	}

	@Test
	public void testMassive() {
		final GenomicRangeQuery genomicRangeQuery = new GenomicRangeQuery();
		int ntest = 200;
		for (int t = 0; t < ntest; t++) {
//			final int n = MoreInts.newRandom(MIN_N, MAX_N);
			final int n = MoreInts.newRandom(MIN_N, 10_000);
			final int[] s = MoreInts.newRandomArray(n, 1, 4);
//			final int m = MoreInts.newRandom(MIN_M, MAX_M);
			final int m = MoreInts.newRandom(MIN_M, 5_000);
			final int[] P = new int[m];
			final int[] Q = new int[m];
			for (int i = 0; i < m; i++) {
				P[i] = MoreInts.newRandom(0, n-1);
				Q[i] = MoreInts.newRandom(P[i], n-1);
			}
			final String S = parse(s); 
//			System.out.println(String.format("Test %s, S=%s, P=[%s], Q=[%s]", t, S, MoreInts.toString(P), MoreInts.toString(Q))); 
			assertArrayEquals(GenomicRangeQuery.checker(S, P, Q), genomicRangeQuery.solution(S, P, Q));
		}
	}

	private static String parse(final int[] factors) {
		final char[] s = new char[factors.length];
		for (int i = 0; i < factors.length; i++) {
			s[i] = getNucleotide(factors[i]);
		}
		return new String(s);
	}
	
	public static char getNucleotide(final int factor) {
		switch (factor) {
		case 1:
			return 'A';
		case 2:
			return 'C';
		case 3:
			return 'G';
		case 4:
			return 'T';
		default:
			throw new AssertionError();
		}
	}
}
