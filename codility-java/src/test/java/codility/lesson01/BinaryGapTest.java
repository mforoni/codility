package codility.lesson01;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import codility.lesson01.BinaryGap;

public class BinaryGapTest {

	@Test
	public void testSolution() {
		final BinaryGap binaryGap = new BinaryGap();
		assertEquals(4, binaryGap.solution(529));
		assertEquals(0, binaryGap.solution(32));
		assertEquals(1, binaryGap.solution(20));
		assertEquals(0, binaryGap.solution(0));
		assertEquals(0, binaryGap.solution(1));
		assertEquals(0, binaryGap.solution(15));
		assertEquals(0, binaryGap.solution(255));
	}

	@Test
	public void testLastIndexOf() {
		assertEquals(12, BinaryGap.lastIndexOf("000030010200100", '1'));
	}

	@Test
	public void testConvertAndSplit() {
		assertEquals(4, BinaryGap.convertAndSplit(529));
		assertEquals(0, BinaryGap.convertAndSplit(32));
		assertEquals(1, BinaryGap.convertAndSplit(20));
	}

}
