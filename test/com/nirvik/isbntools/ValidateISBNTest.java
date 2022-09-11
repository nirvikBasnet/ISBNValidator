package com.nirvik.isbntools;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class ValidateISBNTest {
    ValidateISBN validateISBN;

    @Before
    public void setup(){
      validateISBN = new ValidateISBN();
    }


    @Test
    public void checkAValidTenISBN(){
        assertTrue("First value",validateISBN.checkISBN("1698811233"));
        assertTrue("Second value",validateISBN.checkISBN("1726643026"));
    }

    @Test
    public void TenDigitISBNNumberEndingInXAreValid(){
        assertTrue("ISBN With X",validateISBN.checkISBN("012000030X"));
    }

    @Test
    public void checkAnInValidTenISBN(){
        assertFalse(validateISBN.checkISBN("1698911233"));
    }

    @Test(expected = NumberFormatException.class)
    public void nineDigitISBNisNotAllowed(){
        validateISBN.checkISBN("169891123");
        validateISBN.checkISBN("helloworld");
    }

    @Test
    public void validThirteenDigitISBN(){
        assertTrue(validateISBN.checkISBN("9781861978769"));
    }

    @Test
    public void invalidThirteenDigitISBN(){
        assertFalse(validateISBN.checkISBN("9781861978761"));
    }


}
