package codility.lesson1;

/**
 * A binary gap within a positive integer N is any maximal sequence of
 * consecutive zeros that is surrounded by ones at both ends in the binary
 * representation of N.
 * 
 * For example, number 9 has binary representation 1001 and contains a binary
 * gap of length 2. The number 529 has binary representation 1000010001 and
 * contains two binary gaps: one of length 4 and one of length 3. The number 20
 * has binary representation 10100 and contains one binary gap of length 1. The
 * number 15 has binary representation 1111 and has no binary gaps. The number
 * 32 has binary representation 100000 and has no binary gaps.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int N); }
 * 
 * that, given a positive integer N, returns the length of its longest binary
 * gap. The function should return 0 if N doesn't contain a binary gap.
 * 
 * For example, given N = 1041 the function should return 5, because N has
 * binary representation 10000010001 and so its longest binary gap is of length
 * 5. Given N = 32 the function should return 0, because N has binary
 * representation '100000' and thus no binary gaps.
 * 
 * Assume that:
 * 
 * N is an integer within the range [1..2,147,483,647]. Complexity:
 * 
 * expected worst-case time complexity is O(log(N)); expected worst-case space
 * complexity is O(1).
 * 
 * @author marco
 *
 */
final class BinaryGap {

	/**
	 * Time complexity should be O(logN)
	 * Space complexity is O(1)
	 * 
	 * @param N
	 * @return
	 */
	public int solution(int N) {
		final String s = Integer.toBinaryString(N); // seems to have O(logN) time complexity
		final int end = lastIndexOf(s, '1');
		int counter = 0;
		int max = 0;
		for (int i = 0; i < end; i++) { // O(log_2(N)) is the number of digits required to write N in base 2
			char c = s.charAt(i);
			if (c == '1') {
				counter = 0;
			} else {
				counter++;
				if (counter > max) {
					max = counter;
				}
			}
		}
		return max;
	}
	
	public static int lastIndexOf(final String s, final char c) {
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == c) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Space complexity is O(N)
	 * 
	 * @param N
	 * @return
	 */
	public static int convertAndSplit(int N) {
		final String bin = Integer.toBinaryString(N);
		final int start = bin.indexOf('1');
		final int end = lastIndexOf(bin, '1');
		if (start != -1 && end != -1 && start < end) {
			final String sub = bin.substring(start, end);
			final String[] split = sub.split("1");
			int max = 0;
			for (final String s : split) {
				if (s.length() > max) {
					max = s.length();
				}
			}
			return max;
		}
		return 0;
	}
}
