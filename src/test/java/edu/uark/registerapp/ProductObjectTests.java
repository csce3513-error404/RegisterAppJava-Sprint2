package edu.uark.registerapp;

import org.junit.*;
import edu.uark.registerapp.models.api.Product;


public class ProductObjectTests {
    //----------------------------------------- These tests are for the data fields inside the object to ensure that they work properly when called -------------------------------------------------//
    @Test
    public void inCartTest(){
        Product product = new Product();
        product.setInCart(true);
        assertEquals(true, product.getInCart());

        product.setInCart(false);
        assertEquals(false, product.getInCart());
    }

    @Test
    public void idTest(){ }

    @Test
    public void lookUpCodeTest(){ }
}