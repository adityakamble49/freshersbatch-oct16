package com.aditya;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringCharacterTest {

    @Test
    public void test() {
        StringOperations operations = new StringOperations();
        assertEquals('H', operations.getCharacter("Hello", 0));
    }

}
