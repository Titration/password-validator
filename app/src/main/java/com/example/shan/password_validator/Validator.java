package com.example.shan.password_validator;

/**
 * Created by SHAN on 18/2/10.
 */

public class Validator {

    public int validate (String password) {
        int numberOfRule = 0;   //the default number of rules is 0

        if (password.length() >= 8) {    //The password is at least 8 characters long
            numberOfRule++;
        }
        if (!password.equalsIgnoreCase("password")) {   //it is not “password” (case insensitive)
            numberOfRule++;
        }
        if (password.matches(".*[! # @ $ % ^ & * ( ) - _ = + [ ] ; : ' \" , < . > / ?].*")) { //requiring at least 1 special character
            numberOfRule++;
        }
        if (password.matches(".*[0-9].*")) { //requiring at least 1 digit
            numberOfRule++;
        }
        if (password.matches(".*[a-z].*[A-Z].*")) { //requiring upper and lower case
            numberOfRule++;
        }

        return numberOfRule;
    }
}
