package com.aditya;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringConcatParamTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Class");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("after Class");
    }

    @Before
    public void before() {
        System.out.println("Before");
    }

    @After
    public void after() {
        System.out.println("after");
    }

    @Parameter(value = 0)
    public static String s1;
    @Parameter(value = 1)
    public static String s2;
    @Parameter(value = 2)
    public static String s3;

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = { { "Hello", "World", "HelloWorld" },
                { "Aditya", "Kamble", "AdityaKamble" },
                { "Akshay", "Chordiya", "AkshayChordiya" } };
        return Arrays.asList(data);
    }

    @Test
    public void test() {
        StringOperations operations = new StringOperations();
        assertEquals(s3, operations.concat(s1, s2));
    }

}
