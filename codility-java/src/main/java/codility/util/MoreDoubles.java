package codility.util;

public final class MoreDoubles {

	private MoreDoubles() {
		throw new AssertionError();
	}
	
	public static double min(final double[] A) {
		return min(A, 0, A.length - 1);
	}

	public static double min(final double[] A, final int start, final int end) {
		return A[minIndex(A, start, end)];
	}

	public static int minIndex(final double[] A) {
		return minIndex(A, 0, A.length - 1);
	}

	public static int minIndex(final double[] A, final int start, final int end) {
		assert (start <= end && end < A.length);
		double min = Double.MAX_VALUE;
		int minIndex = -1;
		for (int i = start; i <= end; i++) {
			if (A[i] < min) {
				min = A[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
}
