import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorController {
    @FXML
   Label display;

     double num1 = 0;
   String operator = "";
    boolean start = true;

    @FXML
    public void processNumbers(javafx.event.ActionEvent event) {
        if (start) {
            display.setText("");
            start = false;
        }
        String value = ((Button)event.getSource()).getText();
        display.setText(display.getText() + value);
    }

    @FXML
    public void processOperators(javafx.event.ActionEvent event) {
        String value = ((Button)event.getSource()).getText();

        if (!value.equals("=")) {
            if (!operator.isEmpty())
                return;

            operator = value;
            num1 = Double.parseDouble(display.getText());
            display.setText("");
        } else {
            if (operator.isEmpty())
                return;

            double num2 = Double.parseDouble(display.getText());
            double result = calculate(num1, num2, operator);
            display.setText(String.valueOf(result));
            operator = "";
            start = true;
        }
    }


    public double calculate(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    return 0;
                }
                return num1 / num2;
            default:
                return 0;
        }
    }
}