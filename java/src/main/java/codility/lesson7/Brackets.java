package codility.lesson7;

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
 * @author Foroni Marco
 *
 */
final class Brackets {

	/**
	 * Time complexity is O(N)<br>
	 * Space complexity is O(N)
	 * <p>
	 * Idea: use a stack LIFO ADT
	 * 
	 * @param S
	 * @return
	 */
	public int solution(String S) {
		final Stack<Character> stack = new Stack<>();
		for (int i = 0; i < S.length(); i++) {
			final char c = S.charAt(i);
			if (isOpeningBracket(c)) {
//				System.out.println("Pushing " + c);
				stack.push(c);
			} else {
				assert(isClosingBracket(c));
				if (stack.isEmpty()) {
					return 0;
				}
				final char ob = stack.pop();
//				System.out.println(String.format("Popping %s, current %s", ob, c));
				if (!isProperlyNested(ob, c)) {
					return 0;
				}
			}
		}
		return stack.isEmpty() ? 1 : 0;
	}

	public static boolean isProperlyNested(final char ob, final char cb) {
		return (ob == '(' && cb == ')') || (ob == '[' && cb == ']') || (ob == '{' && cb == '}');
	}

	public static boolean isOpeningBracket(final char c) {
		return c == '(' || c == '[' || c == '{';
	}

	public static boolean isClosingBracket(final char c) {
		return c == ')' || c == ']' || c == '}';
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
