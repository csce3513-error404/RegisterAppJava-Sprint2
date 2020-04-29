package edu.uark.registerapp;

import org.junit.*;
import edu.uark.registerapp.models.api.Product;

import java.util.UUID;

import static org.junit.Assert.assertEquals;


public class ProductObjectTests {
    //----------------------------------------- These tests are for the data fields inside the object to ensure that they work properly when called -------------------------------------------------//
    public static Product product;

    @Before
    public void createThing(){
        product = new Product();
    }

    @Test
    public void inCartTest(){
        product.setInCart(true);
        assertEquals(true, product.getInCart());

        product.setInCart(false);
        assertEquals(false, product.getInCart());
    }

    @Test
    public void idTest(){
        UUID id = UUID.randomUUID();
        product.setId(id);
        assertEquals(id, product.getId());
    }

    @Test
    public void lookUpCodeTest(){
        String code = "I am a lookup code";
        product.setLookupCode(code);
        assertEquals("I am a lookup code", product.getLookupCode());
    }
}