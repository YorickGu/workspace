package com.gyj;

import org.junit.Test;

import static org.junit.Assert.*;

public class MathTest {

    @Test
    public void factorial() throws Exception {
        assertEquals(120, new Math().factorial(5));
    }

    @Test
    public void fibonacci() throws Exception {
        assertEquals(21, new Math().fibonacci(9));
    }
}