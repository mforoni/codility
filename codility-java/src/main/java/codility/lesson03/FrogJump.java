package codility.lesson03;

/**
 * A small frog wants to get to the other side of the road. The frog is
 * currently located at position X and wants to get to a position greater than
 * or equal to Y. The small frog always jumps a fixed distance, D.
 * <p>
 * Count the minimal number of jumps that the small frog must perform to reach
 * its target.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int X, int Y, int D); }
 * <p>
 * that, given three integers X, Y and D, returns the minimal number of jumps
 * from position X to a position equal to or greater than Y.
 * <p>
 * For example, given:
 * <p>
 * X = 10 Y = 85 D = 30 the function should return 3, because the frog will be
 * positioned as follows:
 * <p>
 * after the first jump, at position 10 + 30 = 40 after the second jump, at
 * position 10 + 30 + 30 = 70 after the third jump, at position 10 + 30 + 30 +
 * 30 = 100 Assume that:
 * <p>
 * X, Y and D are integers within the range [1..1,000,000,000]; X ≤ Y.
 * <p>
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(1);<br>
 * expected worst-case space complexity is O(1).
 *
 * @see <a href="https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/">
 *     app.codility.com/programmers/lessons/3-time_complexity/frog_jmp</a>
 * 
 * @author Marco Foroni
 */
final class FrogJump {

	/**
	 * Time complexity is O(1)<br>
	 * Space complexity is O(1)
	 *
	 * @see <a href="https://app.codility.com/demo/results/training43RDJS-RVC/">
	 *     app.codility.com/demo/results/training43RDJS-RVC/</a>
	 */
	public int solution(int X, int Y, int D) {
		return (int) Math.ceil((double) (Y - X) / D);
	}
}
