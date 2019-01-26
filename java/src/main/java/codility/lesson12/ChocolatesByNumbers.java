package codility.lesson12;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;

/**
 * Two positive integers N and M are given. Integer N represents the number of
 * chocolates arranged in a circle, numbered from 0 to N − 1.
 * <p>
 * You start to eat the chocolates. After eating a chocolate you leave only a
 * wrapper.
 * <p>
 * You begin with eating chocolate number 0. Then you omit the next M − 1
 * chocolates or wrappers on the circle, and eat the following one.
 * <p>
 * More precisely, if you ate chocolate number X, then you will next eat the
 * chocolate with number (X + M) modulo N (remainder of division).
 * <p>
 * You stop eating when you encounter an empty wrapper.
 * <p>
 * For example, given integers N = 10 and M = 4. You will eat the following
 * chocolates: 0, 4, 8, 2, 6.
 * <p>
 * The goal is to count the number of chocolates that you will eat, following
 * the above rules.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int N, int M); }
 * <p>
 * that, given two positive integers N and M, returns the number of chocolates
 * that you will eat.
 * <p>
 * For example, given integers N = 10 and M = 4. the function should return 5,
 * as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:<br>
 * N and M are integers within the range [1..1,000,000,000].
 * 
 * @author Marco Foroni
 *
 */
final class ChocolatesByNumbers {

	/**
	 * Given that: LCM(a,b) = a * b / GCD(a,b)
	 * <p>
	 * We have to compute LCM(a,b) / b = a / GCD(a,b) 
	 * <p>
	 * Time complexity is O(log(N+M))=O(logN)
	 * 
	 * @param N
	 * @param M
	 * @return LCM(N, M) * M
	 */
	public int solution(int N, int M) {
		int gcd = N >= M ? gcd(N, M) : gcd(M, N); 
		return N / gcd;
	}

	/**
	 * Euclidean algorithm by division.
	 * <p>
	 * Time complexity is O(log(a + b))
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int gcd(int a, int b) {
		Preconditions.checkArgument(a >= b);
		if (a % b == 0)
			return b;
		else
			return gcd(b, a % b);
	}

	/**
	 * Time complexity is O(n)*
	 * <p>
	 * * if module operation is O(1)
	 * 
	 * @param n
	 * @param m
	 * @return
	 */
	public static int exhaustiveSearch(int n, int m) {
		final Set<Integer> set = new HashSet<>();
		int next = 0;
		int counter = 0;
		while (set.add(next)) {
			counter++;
			next = (next + m) % n;
		}
		return counter;
	}
}
