package codility.lesson08;

import codility.util.MoreInts;

/**
 * <pre>
 * A non-empty array A consisting of N integers is given.
 *
 * The leader of this array is the value that occurs in more than half of the elements of A.
 *
 * An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1],
 * A[S + 2], ..., A[N − 1] have leaders of the same value.
 *
 * For example, given array A such that:
 *     A[0] = 4
 *     A[1] = 3
 *     A[2] = 4
 *     A[3] = 4
 *     A[4] = 4
 *     A[5] = 2
 * we can find two equi leaders:
 * - 0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
 * - 2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
 *
 * The goal is to count the number of equi leaders.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given a non-empty array A consisting of N integers, returns the number of equi leaders.
 *
 * For example, given:
 *     A[0] = 4
 *     A[1] = 3
 *     A[2] = 4
 *     A[3] = 4
 *     A[4] = 4
 *     A[5] = 2
 * the function should return 2, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 * - N is an integer within the range [1..100,000];
 * - each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
 * </pre>
 * @see <a href="https://app.codility.com/programmers/lessons/8-leader/equi_leader/">
 *     app.codility.com/programmers/lessons/8-leader/equi_leader</a>
 */
public class EquiLeader {

    /**
     * Idea: The leader of the sub arrays if exist is equal to the leader of the array A.
     * Compute the leader of the array A and the leader occurrences till index i for each possible index of A.
     * For each possible index i split array A in 2 sub-array [0, i] and [i+1, N-1]. Compute the occurrences of
     * the leader in the first sub-array and check if it is a valid leader for the first sub-array, i.e. the value
     * is greater than half the length of the sub-array. Repeat the same for the second array. Use a counter to store
     * the total of valid leaders for both sub-arrays.
     * <p>
     * Time complexity is O(N)<br>
     * Space complexity is O(1)
     * </p>
     *
     * @see <a href="https://app.codility.com/demo/results/trainingJ5NUN6-XW9/">
     *     app.codility.com/demo/results/trainingJ5NUN6-XW9</a>
     */
    public int solution(int[] A) {
        if (A.length == 1) {
            return 0;
        }
        final int leader = leader(A, 0, A.length - 1);
        //System.out.printf("Leader: %d%n", leader);
        final int[] leaderOccurrences = new int[A.length];
        leaderOccurrences[0] = A[0] == leader ? 1 : 0;
        for (int i = 1; i < A.length; i++) {
            leaderOccurrences[i] = A[i] == leader ? leaderOccurrences[i - 1] + 1 : leaderOccurrences[i - 1];
        }
        int counter = 0;
        for (int i = 0; i < A.length - 1; i++) {
            int occFirstSubArray = leaderOccurrences[i];
            //System.out.printf("Occurrences 1st sub array: %d, limit: %d.%n", occFirstSubArray, (i + 1) / 2);
            if (occFirstSubArray > (i + 1) / 2 ) {
                int occSecondSubArray = leaderOccurrences[A.length - 1] - leaderOccurrences[i];
                //System.out.printf("Occurrences 2nd sub array: %d, limit: %d.%n",  occSecondSubArray, (A.length - i - 1) / 2);
                if (occSecondSubArray > (A.length - i - 1) / 2) {
                    counter += 1;
                }
            }
        }
        return counter;
    }

    /**
     * Idea: For each index use the Boyer–Moore majority vote algorithm to find the leader for the sub-arrays.<br>
     * <br>
     * Time complexity is O(N^2)<br>
     * Space complexity is O(1)
     */
    public static int exhaustiveSearch(final int[] A) {
        if (A.length == 1) {
            return 0;
        }
        int counter = 0;
        for (int i = 0; i < A.length - 1; i++) {
            final int leader1 = leader(A, 0, i);
            //System.out.printf("Sub array [%d, %d] has leader %d.%n", 0, i, leader1);
            if (leader1 != -1) {
                final int leader2 = leader(A, i + 1, A.length - 1);
                //System.out.printf("Sub array [%d, %d] has leader %d.%n", i + 1, A.length - 1, leader2);
                if (leader1 == leader2) {
                    counter += 1;
                }
            }
        }
        return counter;
    }

    /**
     * Idea: Use the Boyer–Moore majority vote algorithm to find the leader in the sub-array starting
     * from index start and ending with index end included.<br>
     * <br>
     * Time complexity is O(N)<br>
     * Space complexity is O(1)
     *
     * @see <a href="https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm">Boyer–Moore majority vote algorithm</a>
     */
    private static int leader(final int[] A, final int start, final int end) {
        final int n = end - start + 1;
        if (n == 0) {
            return -1;
        }
        int candidate = A[start];
        int k = 1;
        for (int i = start + 1; i <= end; i++) {
            if (A[i] != candidate) {
                if (k > 0) {
                    k--;
                } else {
                    candidate = A[i];
                    k = 1;
                }
            } else {
                k++;
            }
        }
        if (k == 0) {
            return -1;
        }
        final int occurrences = occurrences(A, candidate);
        final double limit = (double) A.length / 2;
        return occurrences > limit ? candidate : -1;
    }

    static int occurrences(final int[] array, int key) {
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                counter++;
            }
        }
        return counter;
    }
}
