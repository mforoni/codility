package codility.lesson07;

import java.util.Stack;

/**
 * A string S consisting of N characters is called properly nested if:
 * <p>
 * S is empty;<br>
 * S has the form "(U)" where U is a properly nested string;<br>
 * S has the form "VW" where V and W are properly nested strings.
 * <p>
 * For example, string "(()(())())" is properly nested but string "())" isn't.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(String S); }
 * <p>
 * that, given a string S consisting of N characters, returns 1 if string S is
 * properly nested and 0 otherwise.
 * <P>
 * For example, given S = "(()(())())", the function should return 1 and given S
 * = "())", the function should return 0, as explained above.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [0..1,000,000];<br>
 * string S consists only of the characters "(" and/or ")".
 * <p>
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N); <br>
 * expected worst-case space complexity is O(1) (not counting the storage
 * required for input arguments).
 * 
 * @author Foroni Marco
 *
 */
final class Nesting {

	/**
	 * Time complexity is O(N)<br>
	 * Space complexity is O(1)
	 * 
	 * @param S
	 * @return
	 */
	public int solution(String S) {
		int counter = 0;
		for (int i = 0; i < S.length(); i++) {
			final char c = S.charAt(i);
			if (c == '(') {
				counter++;
			} else {
				assert (c == ')');
				counter--;
			}
			if (counter < 0) {
				return 0;
			}
		}
		return counter == 0 ? 1 : 0;
	}

	/**
	 * Idea: Use a LIFO queue for storing opening brackets
	 * Time complexity is O(N)<br>
	 * Space complexity is O(N)
	 *
	 * @param S
	 * @return
	 */
	public static int subOptimal(String S) {
		if (S.isEmpty()) {
			return 1;
		}
		// Stack (LIFO queue) for storing opening brackets
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < S.length(); i++) {
			final char c = S.charAt(i);
			if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				if (stack.isEmpty()) {
					return 0;
				}
				stack.pop();
			} else {
				throw new AssertionError();
			}
		}
		return stack.isEmpty() ? 1 : 0;
	}
}
