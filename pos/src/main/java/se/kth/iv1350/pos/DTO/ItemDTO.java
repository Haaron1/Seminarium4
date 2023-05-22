package se.kth.iv1350.pos.DTO;
/**
 * Contains information about one specific item.
 */
public class ItemDTO {
    private final int itemId;
    private final double price;
    private final String name;
    private final double taxRate;
    
    /**
     * Creates an instance of an item dto that contains supposedly unchangable 
     * properties of a specific item, this object is immutable.
     * @param itemId the item identifier 
     * @param price the price of the item
     * @param name the name of the item
     * @param taxRate the tax rate of an item
     */
    public ItemDTO(int itemId, double price, String name, double taxRate){
        this.itemId = itemId;
        this.price = price;
        this.name = name;
        this.taxRate = taxRate;
        
    }
    /*
    *Method to retrieve the price of an item
    */
    public double getPrice(){
        return price;
    }
    
    /*
    *Method to retrieve the id of an item
    */
    public int getItemId(){
        return itemId;
    }
    
    /*
    *Method to retrieve the name of an item
    */
    public String getName(){
        return name;
    }
    
    public double getTaxRate(){
        return taxRate;
    }
}
