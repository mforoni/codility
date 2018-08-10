package codility.lesson3;

/**
 * An array A consisting of N different integers is given. The array contains
 * integers in the range [1..(N + 1)], which means that exactly one element is
 * missing.
 * 
 * Your goal is to find that missing element.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given an array A, returns the value of the missing element.
 * 
 * For example, given array A such that:
 * 
 * A[0] = 2 A[1] = 3 A[2] = 1 A[3] = 5 the function should return 4, as it is
 * the missing element.
 * 
 * Assume that:
 * 
 * N is an integer within the range [0..100,000]; the elements of A are all
 * distinct; each element of array A is an integer within the range [1..(N +
 * 1)]. Complexity:
 * 
 * expected worst-case time complexity is O(N); expected worst-case space
 * complexity is O(1) (not counting the storage required for input arguments).
 * 
 * @author Foroni
 *
 */
final class PermMissingElem {

	/**
	 * Sum(1...n+1) = Sum(1...n) + n+1  
	 * 
	 * Time complexity is O(n) 
	 * Space complexity is O(1)
	 * 
	 * @param A
	 * @return
	 */
	public int solution(int[] A) {
		final int max = A.length + 1;
		int sum = 0;
		for (int i = 1; i <= max; i++) {
			sum += i;
		}
		int sumA = 0;
		for (int a : A) {
			sumA += a;
		}
		return sum - sumA;
	}

	/**
	 * 
	 * Time complexity is O(n) Space complexity is O(n)
	 * 
	 * @param A
	 * @return
	 */
	public static int saveFound(final int[] A) {
		final int max = A.length + 2;
		final int[] occ = new int[max];
		for (int a : A) {
			occ[a] = 1;
		}
		for (int i = 1; i < occ.length; i++) {
			if (occ[i] == 0) {
				return i;
			}
		}
		throw new AssertionError();
	}

}
