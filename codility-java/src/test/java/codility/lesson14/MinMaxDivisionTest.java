package codility.lesson14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxDivisionTest {

    private static final int[] A1 = { 2, 1, 5, 1, 2, 2, 2};
    private static final int K1 = 3;
    private static final int M1 = 5;
    private static final int SOL1 = 6;

    @Test
    void solution() {
        final MinMaxDivision minMaxDivision = new MinMaxDivision();
        assertEquals(SOL1, minMaxDivision.solution(K1, M1, A1));
    }

    @Test
    void partition() {
        assertEquals(1, MinMaxDivision.partition(1, 1));
        assertEquals(1, MinMaxDivision.partition(2, 2));
        assertEquals(1, MinMaxDivision.partition(2, 1));
        assertEquals(1, MinMaxDivision.partition(3, 3));
        assertEquals(1, MinMaxDivision.partition(3, 2));
        assertEquals(1, MinMaxDivision.partition(3, 1));
        assertEquals(5, MinMaxDivision.partition(8, 3));
    }
}