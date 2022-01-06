package codility.lesson10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinPerimeterRectangleTest {

    private static final int N1 = 30;
    private static final int SOL1 = 22;

    private static final int N2 = 1;
    private static final int SOL2 = 4;

    @Test
    public void testSolution() {
        MinPerimeterRectangle minPerimeterRectangle = new MinPerimeterRectangle();
        assertEquals(SOL1, minPerimeterRectangle.solution(N1));
        assertEquals(SOL2, minPerimeterRectangle.solution(N2));
    }
}