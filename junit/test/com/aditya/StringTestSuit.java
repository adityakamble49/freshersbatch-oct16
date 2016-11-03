package com.aditya;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ StringConcatTest.class, StringCharacterTest.class,
        StringLengthTest.class, StringCharacterParamTest.class,
        StringConcatParamTest.class, StringLengthParamTest.class })
public class StringTestSuit {

}
