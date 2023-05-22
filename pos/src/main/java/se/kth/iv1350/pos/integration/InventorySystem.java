package se.kth.iv1350.pos.integration;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.pos.DTO.ItemDTO;
import se.kth.iv1350.pos.model.Sale;

/**
 *
 * The class representing the inventory system
 */
public class InventorySystem {
    private List<ItemDTO> items = new ArrayList<>();
    /**
     *Creates a new instance, runs a method to add fake items to a list.
     */
    public InventorySystem(){
        addItems();
    }
    /**
     * Searches for specified item in the list of items in inventory system
     * Item id 10 initiates a server error scenario
     * @param itemId the specified item identifier.
     * @return The item with matching item id, or null if there is no 
     * item with matching item id.
     */
    public ItemDTO findItem(int itemId) throws SQLException{
        
        if (itemId == 10){
            throw new SQLException();
        }
        for(ItemDTO item : items){
            if(item.getItemId() == itemId){
                return item;
            }
        }
        
        return null;
    }
    
    private void addItems(){
        items.add(new ItemDTO(1, 9.99, "Apple", 0.12));
        items.add(new ItemDTO(2, 16.95, "Milk", 0.25));
        items.add(new ItemDTO(3, 19.99, "Juice", 0.06));
        items.add(new ItemDTO(4, 5.95, "Carrot",0.06));
        items.add(new ItemDTO(5, 4.99, "Banana",0.12));
    }
    
    /**
     * This method is a placeholder, the inventory system is supposed to get
     * updated by the sale information here.
     * @param sale 
     */
    public void sendSaleInformation(Sale sale){
        
    }
}
