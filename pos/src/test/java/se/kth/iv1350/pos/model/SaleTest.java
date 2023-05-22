package se.kth.iv1350.pos.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.pos.DTO.ItemDTO;

/**
 *
 * @author Haron Osman
 */
public class SaleTest {
    
    public SaleTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
        
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
        
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
        
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
        
    }

    
    
    /**
     * Test of itemToCart method, of class Sale.
     */
    /*
    @org.junit.jupiter.api.Test
    public void testItemToCart() {
        System.out.println("itemToCart");
        ItemDTO foundItem = null;
        Sale instance = new Sale();
        SoldItem expResult = null;
        SoldItem result = instance.itemToCart(foundItem);
        assertEquals(expResult, result);
    }
    */
    /**
     * Test of findListedItem method, of class Sale. 
     *
     */
    /*
    @Test
    public void testFindListedItem() {
       
        
        
        
    }
    */

    /**
     * Test of calculateTotalSum method, of class Sale.
     */
    @org.junit.jupiter.api.Test
    public void testCalculateTotalSum() {
        
        Sale instance = new Sale();
        int itemId = 1;
        ItemDTO tempItem = new ItemDTO(1, 10.0, "fake", 0.10);
        SoldItem temp = instance.itemToCart(tempItem);
        tempItem = new ItemDTO(2, 20.0, "fake2", 0.10);
        temp = instance.itemToCart(tempItem);
        double expResult = 22 + 11;
        double result = instance.calculateTotalSum();
        assertEquals(expResult, result, 0,"The calculation is not correct");
    }
    /*
    @Test
    public void testGetSaleInfo() {
        System.out.println("getSaleInfo");
        CashPayment payment = null;
        Sale instance = new Sale();
        Receipt expResult = null;
        Receipt result = instance.getSaleInfo(payment);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    */
}
