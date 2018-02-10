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
        assertEquals(2, validator.validate("abcabcabc")); //return 2, the string with length 8 and not equal to "password"
    }

    @Test
    public void checkWords() {
        Validator validator = new Validator(); //constructor
        assertEquals(1, validator.validate("password")); //return 1, the string is "password" (case sensitive)
    }

    @Test
    public void checkSpecialChar() {
        Validator validator = new Validator(); // constructor
        assertEquals(2, validator.validate("!@#$")); //return 2, the string contains special characters and not equal to "password"
    }

    @Test
    public void checkDigits() {
        Validator validator = new Validator(); //constructor
        assertEquals(2, validator.validate("1")); //return 1, the string has at least 1 digit and not equal to "password"
    }

    @Test
    public void checkCase() {
        Validator validator = new Validator(); //constructor
        assertEquals(2, validator.validate("ABABAB")); //return 2, the string contains upper and not equal to "password"
    }
}
