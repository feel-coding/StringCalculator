package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    public void init() {
        calculator = new Calculator();
    }

    @Test
    public void add(){
        int result = calculator.add(10, 20);
        Assertions.assertEquals(30, result);
    }

    @Test
    public void subtract() {
        int result = calculator.subtract(30, 20);
        Assertions.assertEquals(10, result);
    }

    @Test
    public void multiply() {
        int result = calculator.multiply(4, 5);
        Assertions.assertEquals(20, result);
    }

    @Test
    public void divide() {
        int result = calculator.divide(20, 4);
        Assertions.assertEquals(5, result);
    }
}
