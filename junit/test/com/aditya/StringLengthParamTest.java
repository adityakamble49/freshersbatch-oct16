package com.aditya;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringLengthParamTest {

    @Parameter(value = 0)
    public static String s;
    @Parameter(value = 1)
    public static int l;

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = { { "Hello", 5 }, { "World", 5 }, { "Aditya", 6 } };
        return Arrays.asList(data);
    }

    @Test
    public void test() {
        StringOperations operations = new StringOperations();
        assertEquals(l, operations.getLength(s));
    }

}
