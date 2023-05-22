package se.kth.iv1350.pos.controller;

import java.sql.SQLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import se.kth.iv1350.pos.DTO.ItemDTO;
import se.kth.iv1350.pos.model.SoldItem;
import se.kth.iv1350.pos.util.ErrorLogger;

/**
 *
 * Test for controller class.
 */
public class ControllerTest {
    
    public ControllerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    

    @Test
    public void testSearchMatchingItemSuccess() {
        System.out.println("searchMatchingItem");
        int itemId = 1;
        Controller instance = new Controller(new ErrorLogger());
        instance.startSale();
        try{
            SoldItem result = instance.searchMatchingItem(itemId);
            assertNotNull(result,"Item was not returned");
        }
        
        catch(Exception exc){
            System.out.println("Something went wrong");
        }
        
    }
    /**
     * Tests exception for invalid item id
     * Result is true if 
     */
    @Test
    public void testSearchMatchingItemException() {
        int itemId = 0;
        Controller instance = new Controller(new ErrorLogger());
        instance.startSale();
        SoldItem foundItem;
        Boolean result = false;
        try{
            foundItem = instance.searchMatchingItem(itemId);
            
        }
        
        catch(NoSuchItemException exc){
            result = true;
        }
        
        catch(ServerErrorException exc){
            fail("Something went wrong, an unexpected exception was caught");
        }
        
        assertTrue(result,"Item exists, not expected");
        
    }
    
    @Test
    public void testSearchMatchingItem3IncreaseQuantity() {
        int itemId = 1;
        Controller instance = new Controller(new ErrorLogger());
        instance.startSale();
        try {
            SoldItem result = instance.searchMatchingItem(itemId);
            assertTrue(result.getQuantity() == 1,"Item was not added to sale");
        
            SoldItem anotherResult = instance.searchMatchingItem(itemId);
            assertEquals(result, anotherResult);
            assertTrue(result.getQuantity()== 2,"Quantity of item was not increased");
        }
        
        catch(Exception exc){
            fail("Something went wrong exception was caught");
        }
    }
    
    /**
     * item id 10 initiates the fake scenario causing server error exception.
     */
    @Test
    public void testSearchMatchingItemServerErrorException() {
        int itemId = 10;
        Controller instance = new Controller(new ErrorLogger());
        instance.startSale();
        boolean result = false;
        try {
            SoldItem fakeItem = instance.searchMatchingItem(itemId);
        }
        
        catch(ServerErrorException exc){
            result = true;
        }
        
        catch(Exception exc){
            fail("Something went wrong, an unexpected exception was caught");
        }
        
        assertTrue(result, "The server error scenario was not initiated");
    }  
}
