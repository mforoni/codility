package codility.util;

import java.util.concurrent.ThreadLocalRandom;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;

public final class MoreInts {

	private MoreInts() {
		throw new AssertionError();
	}

	public static final int newRandom(final int min, final int max) {
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}

	public static final int[] newRandomArray(final int n, final int min, final int max) {
		final int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = ThreadLocalRandom.current().nextInt(min, max + 1);
		}
		return a;
	}

	public static final int sum(final int[] A, final int start, final int end) {
		assert (start <= end && end < A.length);
		int sum = 0;
		for (int i = start; i <= end; i++) {
			sum += A[i];
		}
		return sum;
	}

	public static int min(final int[] A) {
		return min(A, 0, A.length - 1);
	}

	public static int min(final int[] A, final int start, final int end) {
		return A[minIndex(A, start, end)];
	}

	public static int minIndex(final int[] A) {
		return minIndex(A, 0, A.length - 1);
	}

	public static int minIndex(final int[] A, final int start, final int end) {
		assert (start <= end && end < A.length);
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int i = start; i <= end; i++) {
			if (A[i] < min) {
				min = A[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	public static int max(final int a, final int b, final int c) {
		if (a < b) {
			return c > b ? c : b;
		} else {
			return b > a ? b : a;
		}
	}

	public static int indexOf(final int[] array, final int target) {
		return indexOf(array, target, 0, array.length - 1);
	}

	public static int indexOf(final int[] array, final int target, final int start) {
		return indexOf(array, target, start, array.length - 1);
	}

	public static int indexOf(final int[] array, final int target, final int from, final int end) {
		Preconditions.checkArgument(from <= end);
		Preconditions.checkArgument(end < array.length);
		for (int i = from; i <= end; i++) {
			if (array[i] == target) {
				return i;
			}
		}
		return -1;
	}

	public static void swap(final int[] A, int i, int j) {
		final int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}

	public static String toString(final int[] A) {
		return Ints.join(",", A);
	}
}
