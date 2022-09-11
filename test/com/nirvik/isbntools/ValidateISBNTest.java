package com.nirvik.isbntools;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateISBNTest {
    @Test
    public void checkAValidISBN(){
        ValidateISBN validateISBN = new ValidateISBN();
        assertTrue("First value",validateISBN.checkISBN("1698811233"));
        assertTrue("Second value",validateISBN.checkISBN("1726643026"));
    }

    @Test
    public void ISBNNumberEndingInXAreValid(){
        ValidateISBN validateISBN = new ValidateISBN();
        assertTrue("ISBN With X",validateISBN.checkISBN("012000030X"));
    }

    @Test
    public void checkAnInValidISBN(){
        ValidateISBN validateISBN = new ValidateISBN();
        assertFalse(validateISBN.checkISBN("1698911233"));
    }

    @Test(expected = NumberFormatException.class)
    public void nineDigitISBNisNotAllowed(){
        ValidateISBN validateISBN = new ValidateISBN();
        validateISBN.checkISBN("169891123");
        validateISBN.checkISBN("helloworld");
    }


}
