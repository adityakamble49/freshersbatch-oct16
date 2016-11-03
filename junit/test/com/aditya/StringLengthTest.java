package com.aditya;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringLengthTest {

    @Test
    public void test() {
        StringOperations operations = new StringOperations();
        assertEquals(5, operations.getLength("Hello"));
    }

}
