package codility.util;

import java.util.concurrent.ThreadLocalRandom;

import com.google.common.base.Preconditions;

public final class MoreInts {

	private MoreInts() {
		throw new AssertionError();
	}

	public static final int[] newRandomArray(final int n, final int min, final int max) {
		final int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = ThreadLocalRandom.current().nextInt(min, max);
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
}
