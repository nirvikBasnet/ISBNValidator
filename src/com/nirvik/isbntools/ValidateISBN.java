package com.nirvik.isbntools;

public class ValidateISBN {

    public static final int LONG_ISBN_LENGTH = 13;
    public static final int SHORT_ISBN_LENGTH = 10;

    public boolean checkISBN(String isbn) {
        if(isbn.length() == LONG_ISBN_LENGTH) {
            return isThisAValidLongISBN(isbn);
        }else if(isbn.length() == SHORT_ISBN_LENGTH){
            return isThisAValidShortISBN(isbn);
        }else{
            throw new NumberFormatException("ISBN should be 10 or 13 digits long.");
        }
    }

    private boolean isThisAValidShortISBN(String isbn) {
        int total = 0;

        for(int i = 0; i<SHORT_ISBN_LENGTH;i++){
            if(!Character.isDigit(isbn.charAt(i))){
                if( i == 9 && isbn.charAt(i) == 'X'){
                    total += 10;
                }else{
                    throw new NumberFormatException("ISBN should be integer.");
                }

            }else{
                total += Character.getNumericValue(isbn.charAt(i))*(SHORT_ISBN_LENGTH-i);
            }

        }
        return total%11 == 0;
    }

    private boolean isThisAValidLongISBN(String isbn) {
        int total = 0;
        for (int i = 0; i < LONG_ISBN_LENGTH; i++) {
            if(i%2 == 0){
                total += Character.getNumericValue(isbn.charAt(i));
            }else{
                total += Character.getNumericValue(isbn.charAt(i))*3;
            }
        }
        return total%10==0;
    }
}
