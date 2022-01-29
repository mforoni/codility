package codility.lesson12;

import codility.util.MoreInts;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommonPrimeDivisorsTest {

    public static final int NUM_TESTS = 100;
    private static final int MIN_Z = 1;
    private static final int MAX_Z = 6_000;
    private static final int MIN_INT = 1;
    private static final int MAX_INT = 30_000;

    private static final int[] A1 = { 15, 10, 3};
    private static final int[] B1 = { 75, 30, 5};
    private static final int SOL1 = 1;

    private static final int[] A2 = { 2, 1, 2};
    private static final int[] B2 = { 1, 2, 2};
    private static final int SOL2 = 1;

    private static final int[] A3 = { 1 };
    private static final int[] B3 = { 1 };
    private static final int SOL3 = 1;

    private static final int[] A4 = { 10, 55, 46, 78, 73, 16 };
    private static final int[] B4 = { 59, 84, 57, 3, 34, 82 };
    private static final int SOL4 = 0;

    private static final int[] A5 = {6, 30};//{ 6, 23, 7, 34, 30, 35, 19, 45, 29, 76 };
    private static final int[] B5 = {66, 60};// { 66, 30, 73, 25, 60, 15, 4, 34, 70, 51 };
    private static final int SOL5 = 1;

    @Test
    public void solution() {
        final CommonPrimeDivisors commonPrimeDivisors = new CommonPrimeDivisors();
        assertEquals(SOL1, commonPrimeDivisors.solution(A1, B1));
        assertEquals(SOL2, commonPrimeDivisors.solution(A2, B2));
        assertEquals(SOL3, commonPrimeDivisors.solution(A3, B3));
        assertEquals(SOL4, commonPrimeDivisors.solution(A4, B4));
        assertEquals(SOL5, commonPrimeDivisors.solution(A5, B5));
    }

    @Test
    public void exhaustiveSearch() {
        assertEquals(SOL1, CommonPrimeDivisors.exhaustiveSearch(A1, B1));
        assertEquals(SOL2, CommonPrimeDivisors.exhaustiveSearch(A2, B2));
        assertEquals(SOL3, CommonPrimeDivisors.exhaustiveSearch(A3, B3));
        assertEquals(SOL4, CommonPrimeDivisors.exhaustiveSearch(A4, B4));
        assertEquals(SOL5, CommonPrimeDivisors.exhaustiveSearch(A5, B5));
    }

    @Test
    public void primeDivisors() {
        assertEquals(new HashSet<>(Arrays.asList(2, 3, 11)), CommonPrimeDivisors.primeDivisors(66));
        assertEquals(new HashSet<>(Arrays.asList(2, 41)), CommonPrimeDivisors.primeDivisors(82));
    }

    @Test
    public void solutionRandomInput() {
        final CommonPrimeDivisors commonPrimeDivisors = new CommonPrimeDivisors();
        for (int t = 0; t < NUM_TESTS; t++) {
            final int z = MoreInts.newRandom(MIN_Z, MAX_Z / 10);
            final int[] A = new int[z];
            final int[] B = new int[z];
            for (int i = 0; i < z; i++) {
                A[i] = MoreInts.newRandom(MIN_INT, MAX_INT / 10);
                B[i] = MoreInts.newRandom(MIN_INT, MAX_INT / 10);
            }
            final int actual = commonPrimeDivisors.solution(A, B);
            final int expected = CommonPrimeDivisors.exhaustiveSearch(A, B);
            if (expected != actual) {
                System.out.printf("A = %s, B = %s", Arrays.toString(A), Arrays.toString(B));
            }
            assertEquals(expected, actual);
        }
    }
}