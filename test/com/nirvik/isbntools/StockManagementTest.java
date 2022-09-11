package com.nirvik.isbntools;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StockManagementTest {

    @Test
    public void canGetCorrectLocationCode(){

        ExternalISBNDataService testService = new ExternalISBNDataService() {
            @Override
            public Book lookup(String isbn) {
                return new Book(isbn,"Frans","Dune");
            }
        };

        StockManager stockManager = new StockManager();
        //injecting the testService
        stockManager.setService(testService);


        String isbn = "0340960191";
        assertEquals("0191F1",stockManager.getLocationCode(isbn));
    }
}
