package codility.lesson06;

import java.util.Arrays;

/**
 * We draw N discs on a plane. The discs are numbered from 0 to N − 1. An array
 * A of N non-negative integers, specifying the radiuses of the discs, is given.
 * The J-th disc is drawn with its center at (J, 0) and radius A[J].
 * <p>
 * We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and
 * K-th discs have at least one common point (assuming that the discs contain
 * their borders).
 * <p>
 * The figure below shows discs drawn for N = 6 and A as follows:
 * <p>
 * A[0] = 1 A[1] = 5 A[2] = 2 A[3] = 1 A[4] = 4 A[5] = 0
 * <p>
 * 
 * There are eleven (unordered) pairs of discs that intersect, namely:
 * <p>
 * discs 1 and 4 intersect, and both intersect with all the other discs; disc 2
 * also intersects with discs 0 and 3. Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A describing N discs as explained above, returns the
 * number of (unordered) pairs of intersecting discs. The function should return
 * −1 if the number of intersecting pairs exceeds 10,000,000.
 * <p>
 * Given array A shown above, the function should return 11, as explained above.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [0..100,000];<br>
 * each element of array A is an integer within the range [0..2,147,483,647].
 * <p>
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N*log(N));<br>
 * expected worst-case space complexity is O(N) (not counting the storage
 * required for input arguments).
 * @see <a href="https://app.codility.com/programmers/lessons/6-sorting/number_of_disc_intersections/">
 *     app.codility.com/programmers/lessons/6-sorting/number_of_disc_intersections/</a>
 *
 * @author Marco Foroni
 */
final class NumberOfDiscIntersections {

	private static final int MAX_INTERSECTIONS = 10_000_000;

	/**
	 * Idea: consider the points that intersect the X axis, if len(A) = N there are 2 * N points. Separate the disc
	 * starting points from the ending ones using two arrays named respectively s and e. Sort these arrays. Then we
	 * can define:
	 * i, j, k <- 0
	 * <pre>
	 * p[i] = min(s[j], e[k])
	 *
	 * oc[i] = open circles at position p[i] on the X axis =
	 * oc[i - 1] + 1 if p[i] in s
	 * oc[i - 1] - 1 if p[i] in e
	 *
	 * inters[i] = total intersections till position p[i] on the X axis = 
	 * inters[i - 1] + oc[i - 1] if p[i] in s
	 * inters[i - 1] otherwise, if p[i] in e
	 * </pre>
	 * Time complexity is O(2*N + N*log(N)) = O(N*log(N))<br>
	 * Space complexity is O(N) but can be reduced to O(1)
	 *
	 * @see <a href="https://app.codility.com/demo/results/trainingAGZ4NX-HC7/">
	 *     app.codility.com/demo/results/trainingAGZ4NX-HC7</a>
	 */
	public int solution(int[] A) {
		if (A.length == 0) {
			return 0;
		}
		final long[] start = new long[A.length]; // starting points
		final long[] end = new long[A.length]; // ending points
		for (int i = 0; i < A.length; i++) {
			start[i] = i - (long) A[i];
			end[i] = i + (long) A[i];
		}
		Arrays.sort(start);
		Arrays.sort(end);
		//System.out.printf("start=%s, end=%s%n", Arrays.toString(start), Arrays.toString(end));
		final int[] oc = new int[2 * A.length]; // oc[i] = open circles at position i on x axis
		final int[] inters = new int[2 * A.length]; // inters[i] = number of intersections at position i on X axis
		assert (start[0] <= end[0]);
		oc[0] = 1;
		inters[0] = 0;
		int s = 1, e = 0, i = 1;
		for (; i < A.length * 2;) {
			if (s < A.length && start[s] <= end[e]) {
				oc[i] = oc[i - 1] + 1;
				inters[i] = oc[i - 1] + inters[i - 1];
				s++;
			} else {
				oc[i] = oc[i - 1] - 1;
				inters[i] = inters[i - 1];
				e++;
			}
			if (inters[i] > MAX_INTERSECTIONS) {
				return -1;
			}
			i++;
			//System.out.printf("inters=%s, o.c.=%s%n", Arrays.toString(inters), Arrays.toString(oc));
		}
		return inters[2 * A.length - 1];
	}

	/**
	 * Time complexity is O(N^2)<br>
	 * Space complexity is O(1)
	 */
	public static int exhaustiveSearch(final int[] A) {
		int counter = 0;
		for (int i = 0; i < A.length - 1; i++) {
			for (int j = i + 1; j < A.length; j++) {
				if ((long) i + (long) A[i] >= (long) j - (long) A[j]) {
					counter++;
					if (counter == MAX_INTERSECTIONS) {
						return -1;
					}
				}
			}
		}
		return counter;
	}

	/**
	 * Time complexity is O(N*logN)<br>
	 * Space complexity is O(N)
	 *
	 * @see <a href="https://app.codility.com/demo/results/trainingNXCFPG-RUB/">
	 *     app.codility.com/demo/results/trainingNXCFPG-RUB</a>
	 */
	public static int elegantSolution(int[] A) {
		final Point[] points = new Point[A.length * 2];
		for (int i = 0; i < A.length; i++) {
			points[2 * i] = new Point(i - (long)A[i], true);
			points[2 * i + 1] = new Point(i + (long)A[i], false);
		}
		Arrays.sort(points);
		//System.out.println(Arrays.toString(points));
		int discIntersections = 0;
		int openDiscs = 0;
		for (Point p : points) {
			if (p.start) {
				openDiscs += 1;
			} else {
				openDiscs -= 1;
				discIntersections += openDiscs;
			}
			if (discIntersections > 10_000_000) {
				return -1;
			}
			//System.out.printf("Open discs: %d, Intersections: %d.%n", openDiscs, discIntersections);
		}
		return discIntersections;
	}

	static final class Point implements Comparable<Point> {
		private final long x;
		private final boolean start;

		Point(final long x, final boolean start) {
			this.x = x;
			this.start = start;
		}

		@Override
		public String toString() {
			return start ? x + "(" : x + ")";
		}

		@Override
		public int compareTo(Point p){
			if (x == p.x) {
				if (start == p.start) {
					return 0;
				} else {
					return start ? -1 : 1;
				}
			} else {
				return Long.compare(x, p.x);
			}
		}
	}
}
