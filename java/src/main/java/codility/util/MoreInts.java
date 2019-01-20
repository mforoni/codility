package codility.util;

import java.util.concurrent.ThreadLocalRandom;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;

public final class MoreInts {

	private MoreInts() {
		throw new AssertionError();
	}

	public static int newRandom(final int min, final int max) {
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}

	public static int[] newRandomArray(final int n, final int min, final int max) {
		final int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = ThreadLocalRandom.current().nextInt(min, max + 1);
		}
		return a;
	}
	
	public static int[] prefixSums(final int[] array) {
		final int[] sums = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			sums[i] = i == 0 ? array[i] : sums[i - 1] + array[i];
		}
		return sums;
	}

	public static int sum(final int[] array, final int start, final int end) {
		assert (start <= end && end < array.length);
		int sum = 0;
		for (int i = start; i <= end; i++) {
			sum += array[i];
		}
		return sum;
	}

	public static int min(final int[] array) {
		return array[minIndex(array, 0, array.length - 1)];
	}

	public static int min(final int[] array, final int start, final int end) {
		return array[minIndex(array, start, end)];
	}

	public static int minIndex(final int[] array) {
		return minIndex(array, 0, array.length - 1);
	}

	public static int minIndex(final int[] array, final int start, final int end) {
		assert (start <= end && end < array.length);
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int i = start; i <= end; i++) {
			if (array[i] < min) {
				min = array[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	public static int max(final int[] array) {
		return array[maxIndex(array, 0, array.length - 1)];
	}

	public static int max(final int[] array, final int start, final int end) {
		return array[maxIndex(array, start, end)];
	}

	public static int maxIndex(final int[] array) {
		return maxIndex(array, 0, array.length - 1);
	}

	public static int maxIndex(final int[] array, final int start, final int end) {
		assert (start <= end && end < array.length);
		int max = Integer.MIN_VALUE;
		int maxIndex = -1;
		for (int i = start; i <= end; i++) {
			if (array[i] > max) {
				max = array[i];
				maxIndex = i;
			}
		}
		return maxIndex;
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
	
	public static int occurrences(final int[] array, int key) {
		int counter = 0;
		for (int a : array) {
			if (a ==key) {
				counter++;
			}
		}
		return counter;
	}

	public static void swap(final int[] array, int i, int j) {
		final int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	public static String toString(final int[] array) {
		return Ints.join(",", array);
	}
}
