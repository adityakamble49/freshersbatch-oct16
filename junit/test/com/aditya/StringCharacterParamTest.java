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
public class StringCharacterParamTest {

    @Parameter(value = 0)
    public static String s;
    @Parameter(value = 1)
    public static char c;

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = { { "Hello", 'H' }, { "World", 'W' },
                { "Aditya", 'A' } };
        return Arrays.asList(data);
    }

    @Test
    public void test() {
        StringOperations operations = new StringOperations();
        assertEquals(c, operations.getCharacter(s, 0));
    }

}
