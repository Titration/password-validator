package com.example.shan.password_validator;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by SHAN on 18/2/10.
 */

public class ValidatorUnitTest {

    @Test
    public void checkLength() {
        Validator validator = new Validator(); //constructor
        assertEquals(2, validator.validate("abcabcabc")); //return 2, because the string with length 8 and not equal to "password"
    }

    @Test
    public void checkWords() {
        Validator validator = new Validator(); //constructor
        assertEquals(1, validator.validate("PassWord")); //return 1, because the string is "password" (case sensitive)
    }
}
