import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @BeforeEach
    public void setUpEach(){
        System.out.println("BeforeEach executed");
    }

    @Test
    void testCase1() {
        assertEquals(20, 20);
    }

    @Test
    void testCase2() {
        assertTrue(Calculator.operator.equals("add"));
    }

    @Test
    void testCase3() {
        assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3});
    }

    @Test
    void testCase4() {

        String nullString = null;
        String notNullString = "Cybertek";
//        assertNotNull(notNullString);
//        assertNotNull(nullString);
        assertNull(nullString);
    }

    @Test
    void testCase5() {
        Calculator c1 = new Calculator();
        Calculator c2 = c1;
        Calculator c3 = c2;

        assertSame(c1, c3);
    }

    @Test
    void add() {
        int actual = Calculator.add(2, 3);
        assertEquals(5, actual);
    }

}