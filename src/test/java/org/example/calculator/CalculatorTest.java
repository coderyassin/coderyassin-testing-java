package org.example.calculator;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private static Instant startedAt;

    private Calculator calculatorUnderTest;

    @BeforeEach
    public void initCalculator() {
        System.out.println("Call before each test");
        calculatorUnderTest = new Calculator();
    }

    @AfterEach
    public void undefCalculator() {
        System.out.println("Call after each test");
        calculatorUnderTest = null;
    }

    @BeforeAll
    public static void initStartingTime() {
        System.out.println("Call before all the tests");
        startedAt = Instant.now();
    }

    @AfterAll
    public static void showTestDuration() {
        System.out.println("Call after all the tests");
        Instant endedAt = Instant.now();
        long duration = Duration.between(startedAt, endedAt).toMillis();
        System.out.println(MessageFormat.format("Test duration : {0} ms", duration));
    }

    @Test
    void testAddTwoPositiveNumbers() {
        // Arrange
        int a = 2;
        int b = 3;

        // Act
        int sum = calculatorUnderTest.add(a, b);

        // Assert
        assertEquals(5, sum);
    }

    @Test
    public void multiplyShouldReturnTheProduct_ofTwoIntegers() {
        // Arrange
        int a = 42;
        int b = 11;

        // Act
        int result = calculatorUnderTest.multiply(a, b);

        // Assert
        assertEquals(462, result);
    }

    @Timeout(1)
    @Test
    public void longCalculationShouldComputeInLessThan1Second() {
        // Arrange

        // Act
        try {
            Thread.sleep(500);
            System.out.println("........");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Assert
        // ...
    }

    @ParameterizedTest(name = "{0} x 0 must be 0")
    @ValueSource(ints = { 1, 2, 42, 1011, 5089 })
    public void multiply_shouldReturnZero_ofZeroWithMultipleIntegers(int arg) {
        // Arrange -- Everything is ready !

        // Act -- Multiply by zero
        int actualResult = calculatorUnderTest.multiply(arg, 0);

        // Assert -- it's always zero !
        assertEquals(0, actualResult);
    }

    @ParameterizedTest(name = "{0} + {1} must be {2}")
    @CsvSource({ "1,1,2", "2,3,5", "42,57,99" })
    public void add_shouldReturnTheSum_ofMultipleIntegers(int arg1, int arg2, int expectResult) {
        // Arrange -- Everything is ready !

        // Act
        int actualResult = calculatorUnderTest.add(arg1, arg2);

        // Assert
        assertEquals(expectResult, actualResult);
    }

}
    