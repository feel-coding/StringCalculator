package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    public StringCalculator stringCalculator;

    @BeforeEach
    public void init() {
        stringCalculator = new StringCalculator();
    }


    @Test
    @DisplayName("숫자 하나만 있는 경우")
    public void test1() {
        int result = stringCalculator.add("1");
        Assertions.assertEquals(1, result);
    }

    @Test
    @DisplayName("null인 경우")
    public void test2() {
        int result = stringCalculator.add(null);
        Assertions.assertEquals(0, result);
    }

    @Test
    @DisplayName("빈 문자열인 경우")
    public void test3() {
        int result = stringCalculator.add("");
        Assertions.assertEquals(0, result);
    }

    @Test
    @DisplayName("콤마로 구분")
    public void test4() {
        int result = stringCalculator.add("1,3,5");
        Assertions.assertEquals(9, result);
    }

    @Test
    @DisplayName("콜론으로 구분")
    public void test5() {
        int result = stringCalculator.add("1:5:8");
        Assertions.assertEquals(14, result);
    }

    @Test
    @DisplayName("콤마와 콜론으로 구분")
    public void test6() {
        int result = stringCalculator.add("1,2:3,4:5");
        Assertions.assertEquals(15, result);
    }

    @Test
    @DisplayName("콤마와 콜론, 커스텀 구분자")
    public void test7() {
        int result = stringCalculator.add("//!\n1,2:3,4:5!7");
        Assertions.assertEquals(22, result);
    }

    @Test
    @DisplayName("음수가 있는 경우")
    public void test8() {
        Assertions.assertThrows(RuntimeException.class, () -> stringCalculator.add("-1,2,3"));
    }
}
