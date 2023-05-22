package se.kth.iv1350.pos.model;
import se.kth.iv1350.pos.DTO.ItemDTO;
/**
 * Information about one or multiple sold items of the same goods.
 */
public class SoldItem {
    private int quantity;
    private final double unitRunningTotal;
    
    private ItemDTO soldItemData;
    
    /**
     * Creates a new instance, contains all information about a sold item.
     * @param foundItem makes use of the immutable information about the item
     * @param unitRunningTotal the previously calculated unitRunningTotal 
     */
    public SoldItem(ItemDTO foundItem, double unitRunningTotal){
        this.quantity = 1;
        this.unitRunningTotal = unitRunningTotal;
        soldItemData = foundItem;
    }
    
    /**
     * Increases sold quantity of item
     */
    public void increaseQuantity(){
        quantity++;
    }
    
    /**
     * Gets the name of an item.
     * @return the return value of the method getName of the item data
     */
    public String getName(){
        return soldItemData.getName();
    }
    
    /**
     * Gets the name of an item.
     * @return the return value of the method getItemId of the item data
     */
    public int getItemId(){
        return soldItemData.getItemId();
    }
    
    /**
     * The calculation for the running total is the quantity times the running 
     * total per unit.
     * @return The result of the calculation
     */
    public double getRunningTotal(){
        return getUnitRunningTotal() * getQuantity();
    }
    
    /**
     * gets the running total of one unit of an item.
     * @return the running total value per unit
     */
    public double getUnitRunningTotal(){
        return unitRunningTotal;
    }
    
    /**
     * The calculation for the price without tax is the quantity times the price 
     * per unit of the item.
     * @return The result of the calculations
     */
    public double getPrice(){
        return getUnitPrice() * getQuantity();
    }
    
    /**
     * Gets the price per unit of the item.
     * @return 
     */
    public double getUnitPrice(){
        return soldItemData.getPrice();
    }
    
    /**
     * Gets the quantity of the item.
     * @return the quantity of the item
     */
    public int getQuantity(){
        return quantity;
    }
    
    /**
     * gets the tax rate
     * @return the tax rate
     */
    public double getTaxRate(){
        return soldItemData.getTaxRate();
    }
    
    /**
     * returns the ItemDTO data of an item.
     * @return 
     */
    public ItemDTO getItemData(){
        return soldItemData;
    }
    
}
