package com.aditya;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StringConcatTest {

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

    @Test
    public void test() {
        StringOperations operations = new StringOperations();
        assertEquals("HelloWorld", operations.concat("Hello", "World"));
    }

}
