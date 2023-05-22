package se.kth.iv1350.pos.model;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.pos.DTO.ItemDTO;

/**
 * The sale
 */
public class Sale {
    private List<SoldItem> purchasedItems;
    private double totalPrice;
    private double totalPriceWithoutTax;
    private Receipt receipt;
    
    /**
     * Creates a new instance, creates a list that will 
     * contain all purchased item
     */
    public Sale(){
        purchasedItems = new ArrayList<>();
    }
    /*
    *Calculates running total, the price of item plus tax
    */
    private double calculateRunningTotal(ItemDTO foundItem){
        return foundItem.getPrice() + foundItem.getPrice() * foundItem.getTaxRate();
    }
    /**
     * Calculates the runningTotal of {@link foundItem} and creates a new object
     * {@link item}
     * @param foundItem
     * @return 
     */
    public SoldItem itemToCart(ItemDTO foundItem){
        double runningTotal = calculateRunningTotal(foundItem);
        SoldItem item = new SoldItem(foundItem, runningTotal);
        addItem(item);
        return item;
    }
    /**
     * Searches for an item in {@link purchasedItems} and increases the sold 
     * quantity of an item if it has a matching itemId as specified. 
     * 
     * @param itemId the item identifier of an item
     * @return Returns the item that has been found in sale, or null if no such
     * item is in sale yet.
     */
    public SoldItem findListedItem(int itemId){
        for(SoldItem item : purchasedItems){
            if(item.getItemId() == itemId){
                item.increaseQuantity();
                return item;
            }
        }
        return null;
    }
    /**
     * Calculates the total price including tax by looping through the 
     * purchasedItems list and gets the running total and the price before tax 
     * of the purchased item. The values are then added to the variable 
     * {@link totalPrice} respectively {@link totalPriceWithoutTax}.
     * 
     * @return The total price.
     */
    public double calculateTotalSum(){
        for(SoldItem item : purchasedItems){
            totalPrice += item.getRunningTotal();
            totalPriceWithoutTax += item.getPrice();
        }
        return totalPrice;
    }
    /**
     * Retrieves the time of sale and creates a <code>Receipt</code> object 
     * with information about the sale provided for the customer. 
     * The receipt includes <code>LocalTime</code> 
     * 
     * @param payment Contains information about paid amount, change and total price 
     * @return The receipt
     */
    public Receipt getSaleInfo(CashPayment payment){
        LocalDateTime saleTime = LocalDateTime.now();
        receipt = new Receipt(payment, purchasedItems, saleTime, 
                totalPriceWithoutTax);
        return receipt;
    } 
    
    private void addItem(SoldItem item){
        purchasedItems.add(item);
    } 
    
    public double getTotalPrice(){
        return totalPrice;
    }
    
}
