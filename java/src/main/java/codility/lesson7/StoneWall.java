package codility.lesson7;

import java.util.Stack;

/**
 * You are going to build a stone wall. The wall should be straight and N meters
 * long, and its thickness should be constant; however, it should have different
 * heights in different places. The height of the wall is specified by an array
 * H of N positive integers. H[I] is the height of the wall from I to I+1 meters
 * to the right of its left end. In particular, H[0] is the height of the wall's
 * left end and H[N−1] is the height of the wall's right end.
 * <p>
 * The wall should be built of cuboid stone blocks (that is, all sides of such
 * blocks are rectangular). Your task is to compute the minimum number of blocks
 * needed to build the wall.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] H); }
 * <p>
 * that, given an array H of N positive integers specifying the height of the
 * wall, returns the minimum number of blocks needed to build it.
 * <p>
 * For example, given array H containing N = 9 integers:
 * <p>
 * H[0] = 8 H[1] = 8 H[2] = 5 H[3] = 7 H[4] = 9 H[5] = 8 H[6] = 7 H[7] = 4 H[8]
 * = 8
 * <p>
 * the function should return 7. The figure shows one possible arrangement of
 * seven blocks. 
 * <pre>
 *         _
 *  __    | |_     _ 
 * |  |  _|_|_|_  | |
 * |  | |       | | |
 * |  |_|_ _ _ _| | |
 * |  |         |_|_| 
 * |  |         |   | 
 * |  |         |   | 
 * |  |         |   | 
 * |__|_________|___|
 * </pre>
 * Assume that:
 * <p>
 * N is an integer within the range [1..100,000];<br>
 * each element of array H is an integer within the range [1..1,000,000,000].
 * <p>
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);<br>
 * expected worst-case space complexity is O(N) (not counting the storage
 * required for input arguments).
 * 
 * @author Foroni Marco
 *
 */
final class StoneWall {

	/**
	 * Time complexity is O(N)<br>
	 * Space complexity is O(N)
	 * 
	 * @param H
	 * @return
	 */
	public int solution(int[] H) {
		if (H.length == 0) {
			return 0;
		}
		int mb = 1; // minimum blocks
		final Stack<Integer> stack = new Stack<>();
		stack.add(H[0]);
		for (int i = 1; i < H.length; i++) {
			Integer previous = null;
			while (!stack.isEmpty() && (previous = stack.peek()) > H[i]) {
				stack.pop();
			}
			if (previous != null && previous != H[i]) {
				mb += 1;
			}
			if (previous != H[i]) {
				stack.push(H[i]);
			}
			System.out.println(String.format("H[%s]=%s, mb=%s, previous=%s, stack=%s", i, H[i], mb, previous, stack));
		}
		return mb;
	}
}
