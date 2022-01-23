package codility.lesson03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrogJumpTest {

    private static final int X1 = 10;
    private static final int Y1 = 85;
    private static final int D1 = 30;
    private static final int SOL1 = 3;

    @Test
    void solution() {
        final FrogJump frogJump = new FrogJump();
        assertEquals(SOL1, frogJump.solution(X1, Y1, D1));
    }
}