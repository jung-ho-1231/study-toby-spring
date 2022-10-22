package com.example.studytobyspring.learningTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.*;

public class CalsSumTest {
    Calculator calculator;
    String numFilepath;

    @BeforeEach
    void setUp() {
        this.calculator = new Calculator();
        String absolutePath = Paths.get("src", "test", "resources").toFile().getAbsolutePath();
        this.numFilepath = absolutePath + "/numbers.txt";
    }

    @Test
    void sumOfNumbers() throws Exception{
        assertThat(calculator.calsSum(numFilepath)).isEqualTo(10);
    }

    @Test
    void multiplyOfNumbers() throws Exception{
        assertThat(calculator.calcMultiply(numFilepath)).isEqualTo(24);
    }

    @Test
    void concatenate() throws Exception{
        assertThat(calculator.concatenate(this.numFilepath)).isEqualTo("1234");
    }
}
