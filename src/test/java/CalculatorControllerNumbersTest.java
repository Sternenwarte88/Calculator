import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorControllerNumbersTest {

    private CalculatorController controller;
    private Label display;

    @BeforeEach
    public void setUp() {
        controller = new CalculatorController();
        display = mock(Label.class);
        controller.display = display;
    }

    @Test
    public void testProcessNumber1() {
        Button button = mock(Button.class);
        when(button.getText()).thenReturn("1");
        ActionEvent event = new ActionEvent(button, null);

        controller.processNumbers(event);
        verify(display).setText("1");
    }

    @Test
    public void testProcessOperatorAddition() {
        when(display.getText()).thenReturn("5");
        Button button = mock(Button.class);
        when(button.getText()).thenReturn("+");
        ActionEvent event = new ActionEvent(button, null);

        controller.processOperators(event);
        assertEquals("+", controller.operator);
        assertEquals(5.0, controller.num1);
    }

    @Test
    public void testProcessOperatorEqual() {
        controller.operator = "+";
        controller.num1 = 7;
        when(display.getText()).thenReturn("3");
        Button button = mock(Button.class);
        when(button.getText()).thenReturn("=");
        ActionEvent event = new ActionEvent(button, null);

        controller.processOperators(event);
        verify(display).setText("10.0");
    }

    @Test
    public void testDisplayReset() {
        when(display.getText()).thenReturn("8");
        controller.start = true;

        Button button = mock(Button.class);
        when(button.getText()).thenReturn("4");
        ActionEvent event = new ActionEvent(button, null);

        controller.processNumbers(event);
        verify(display).setText("4");
    }


}
