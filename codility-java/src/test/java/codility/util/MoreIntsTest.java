package codility.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoreIntsTest {

	private static final int[] A1 = { 3, 2, -6, 4, 0 };

	@Test
	public void testNewRandom() {
	}

	@Test
	public void testNewRandomArray() {
	}

	@Test
	public void testPrefixSums() {
		assertArrayEquals(new int[] { 3, 5, -1, 3, 3 }, MoreInts.prefixSums(A1));
	}

	@Test
	public void testSum() {
		assertEquals(0, MoreInts.sum(A1, 1, 3));
	}

	@Test
	public void testMinIntArray() {
		assertEquals(-6, MoreInts.min(A1));
	}

	@Test
	public void testMinIntArrayIntInt() {
		assertEquals(2, MoreInts.min(A1, 0, 1));
	}

	@Test
	public void testMinIndexIntArray() {
		assertEquals(2, MoreInts.minIndex(A1));
	}

	@Test
	public void testMinIndexIntArrayIntInt() {
		assertEquals(4, MoreInts.minIndex(A1, 3, 4));
	}

	@Test
	public void testMaxIntArray() {
		assertEquals(4, MoreInts.max(A1));
	}

	@Test
	public void testMaxIntArrayIntInt() {
	}

	@Test
	public void testMaxIndexIntArray() {
	}

	@Test
	public void testMaxIndexIntArrayIntInt() {
	}

	@Test
	public void testMaxIntIntInt() {
	}

	@Test
	public void testIndexOfIntArrayInt() {
	}

	@Test
	public void testIndexOfIntArrayIntInt() {
	}

	@Test
	public void testIndexOfIntArrayIntIntInt() {
	}

	@Test
	public void testSwap() {

	}

	@Test
	public void testToStringIntArray() {
		assertEquals("3,2,-6,4,0", MoreInts.toString(A1));
	}

}
