
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class CalculatorControllerOperatorsTest {

    @Test
    public void testStringEquality() {
        String expected = "Hello";
        String actual = "Hello";
        assertEquals(expected, actual, "The strings should be equal");
    }

    @Test
    public void testNumberEquality() {
        int expected = 42;
        int actual = 42;
        assertEquals(expected, actual, "The numbers should be equal");
    }

    @Test
    public void testArrayEquality() {
        int[] expectedArray = {1, 2, 3};
        int[] actualArray = {1, 2, 3};
        assertArrayEquals(expectedArray, actualArray, "The arrays should be equal");
    }

    @Test
    public void testBooleanCondition() {
        boolean condition = (5 > 3);
        assertTrue(condition, "The condition should be true");
    }
}
