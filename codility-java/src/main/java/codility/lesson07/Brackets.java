package codility.lesson07;

import java.util.Stack;

/**
 * A string S consisting of N characters is considered to be properly nested if
 * any of the following conditions is true:
 * <p>
 * S is empty;<br>
 * S has the form "(U)" or "[U]" or "{U}" where U is a properly nested
 * string;<br>
 * S has the form "VW" where V and W are properly nested strings.
 * <p>
 * For example, the string "{[()()]}" is properly nested but "([)()]" is not.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(String S); }
 * <p>
 * that, given a string S consisting of N characters, returns 1 if S is properly
 * nested and 0 otherwise.
 * <p>
 * For example, given S = "{[()()]}", the function should return 1 and given S =
 * "([)()]", the function should return 0, as explained above.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [0..200,000];<br>
 * string S consists only of the following characters: "(", "{", "[", "]", "}"
 * and/or ")".
 * <p>
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);<br>
 * expected worst-case space complexity is O(N) (not counting the storage
 * required for input arguments).
 *
 * @see <a href="https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/">
 *     app.codility.com/programmers/lessons/7-stacks_and_queues/brackets</a>
 *
 * @author Marco Foroni
 */
final class Brackets {

	/**
	 * Idea: use a stack LIFO ADT<br>
	 * <br>
	 * Time complexity is O(N)<br>
	 * Space complexity is O(N)
	 *
	 * @see <a href="https://app.codility.com/demo/results/trainingFJV54W-5US/">
	 *     app.codility.com/demo/results/trainingFJV54W-5US</a>
	 */
	public int solution(String S) {
		final Stack<Character> stack = new Stack<>();
		for (int i = 0; i < S.length(); i++) {
			final char c = S.charAt(i);
			if (isOpeningBracket(c)) {
				//System.out.println("Pushing " + c);
				stack.push(c);
			} else {
				assert(isClosingBracket(c));
				if (stack.isEmpty()) {
					return 0;
				}
				final char ob = stack.pop();
				//System.out.printf("Popping %s, current %s%n", ob, c);
				if (!isProperlyNested(ob, c)) {
					return 0;
				}
			}
		}
		return stack.isEmpty() ? 1 : 0;
	}

	static boolean isProperlyNested(final char ob, final char cb) {
		return (ob == '(' && cb == ')') || (ob == '[' && cb == ']') || (ob == '{' && cb == '}');
	}

	static boolean isOpeningBracket(final char c) {
		return c == '(' || c == '[' || c == '{';
	}

	static boolean isClosingBracket(final char c) {
		return c == ')' || c == ']' || c == '}';
	}

	/**
	 * Time complexity is O(N)<br>
	 * Space complexity is O(N)
	 *
	 * @see <a href="https://app.codility.com/demo/results/trainingE9X63D-QBM/">
	 *     app.codility.com/demo/results/trainingE9X63D-QBM</a>
	 */
	public static int elegantSolution(String S) {
		if (S.isEmpty()) {
			return 1;
		}
		final Stack<Character> stack = new Stack<>();
		for (int i = 0; i < S.length(); i++) {
			final char c = S.charAt(i);
			if (c == '{' || c == '[' || c == '(') {
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					return 0;
				}
				final char last = stack.pop();
				if (c == '}' && last != '{') {
					return 0;
				}
				if (c == ']' && last != '[') {
					return 0;
				}
				if (c == ')' && last != '(') {
					return 0;
				}
			}
			// System.out.println(stack);
		}
		return stack.isEmpty() ? 1 : 0;
	}

	/**
	 * Time complexity is O(N)<br>
	 * Space complexity is O(1)
	 * <p>
	 * Recognize the string S="([)()]" as a properly nested when it is not!
	 * 
	 * @param S
	 * @return
	 */
	public static int wrongSolution(String S) {
		int rb = 0; // round brackets counter
		int cb = 0; // curly brackets counter;
		int sb = 0; // square brackets counter;
		for (int i = 0; i < S.length(); i++) {
			final char c = S.charAt(i);
			switch (c) {
			case '(':
				rb++;
				break;
			case ')':
				rb--;
				break;
			case '{':
				cb++;
				break;
			case '}':
				cb--;
				break;
			case '[':
				sb++;
				break;
			case ']':
				sb--;
				break;
			}
			if (rb < 0 || cb < 0 || sb < 0) {
				return 0;
			}
		}
		return rb == 0 && cb == 0 && sb == 0 ? 1 : 0;
	}
}
