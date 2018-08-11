package codility.lesson4;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.ThreadLocalRandom;

import org.junit.Test;

import com.google.common.primitives.Ints;

import codility.util.MoreInts;

public class MissingIntegerTest {

	private static final int MIN = -1_000_000;
	private static final int MAX = 1_000_000;
	private static final int N = 100_000;

	@Test
	public void testSortAndFind() {
		assertEquals(5, MissingInteger.sortAndFind(new int[] { 1, 3, 6, 4, 1, 2 }));
		assertEquals(1, MissingInteger.sortAndFind(new int[] {}));
		assertEquals(1, MissingInteger.sortAndFind(new int[] { 2 }));
		assertEquals(2, MissingInteger.sortAndFind(new int[] { 1 }));
	}

		@Test
	public void testWithHashSet() {
		assertEquals(5, MissingInteger.withHashSet(new int[] { 1, 3, 6, 4, 1, 2 }));
		assertEquals(1, MissingInteger.withHashSet(new int[] {}));
		assertEquals(1, MissingInteger.withHashSet(new int[] { 2 }));
		assertEquals(2, MissingInteger.withHashSet(new int[] { 1 }));
	}
	
	@Test
	public void testMassive() {
		final int ntest = 200;
		for (int t = 0; t < ntest; t++) {
			final int n = ThreadLocalRandom.current().nextInt(1, N + 1);
			final int[] a = MoreInts.newRandomArray(n, MIN, MAX + 1);
			final int[] b = a.clone();
			final int sol1 = MissingInteger.withHashSet(a);
			final int sol2 = MissingInteger.sortAndFind(b);
			if (sol1 != sol2) {
//				System.out.println(Ints.join(", ", a));
				System.out.println(String.format("Array contains %s? %s", sol1, Ints.contains(a, sol1)));
				System.out.println(String.format("Array contains %s? %s", sol2, Ints.contains(a, sol2)));
			}
			assertEquals(sol1, sol2);
		}
	}
}
