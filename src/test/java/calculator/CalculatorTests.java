package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTests {

    public Calculator calculator;

    // This statement should run before each Test Case.
    @BeforeEach
    public void perform_before_each_test() {
        calculator = new Calculator();
    }

    // 4*6 should give us 24
    @Test
    public void should_multiply_correctly() {
        int answer = calculator.multiplication(4,6);
        assertThat(answer).isEqualTo(24);
    }

    // 4*6 should give us 24 and 2*3 should give us 6
    @Test
    public void should_multiply_correctly_as_it_contains_multiple_asserts() {
        int firstAnswer = calculator.multiplication(4,6);
        int secondAnswer = calculator.multiplication(2,3);
        assertThat(firstAnswer).isEqualTo(24);
        assertEquals(6,secondAnswer);
    }

    // 0*0 should equals to 0
    @Test
    public void should_multiply_as_we_are_multiplying_zeros() {
        int answer = calculator.multiplication(0,0);
        assertThat(answer).isEqualTo(0);
    }

    // this should return exception as it is dividing by 0.
    @Test
    public void should_not_divide_by_zero() {
        try {
            calculator.divide(2,0);
            fail("This should not run.");
        } catch (Exception exception) {
            assertThat(exception).isInstanceOf(ArithmeticException.class);
        }
    }

    // This should also return exception but here I am using assertThrows()
    @Test
    public void should_never_divide_by_zero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(4,0));
    }

    // trying to use assertAll() functionality as it gives us chance to group multiple asserts.
    @Test
    public void now_i_am_trying_to_use_assertAll() {
        assertAll(
                () -> assertEquals(6,calculator.multiplication(2,3)),
                () -> assertEquals(20,calculator.multiplication(4,5))
        );
    }

    // Running a test method N number of time using RepeatedTest() Annotation.
    @RepeatedTest(5)
    public void trying_to_create_repeated_test() {
        int answer = calculator.divide(81,9);
        assertThat(answer).isEqualTo(9);
    }
}