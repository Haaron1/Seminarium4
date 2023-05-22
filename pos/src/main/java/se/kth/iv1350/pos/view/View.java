package se.kth.iv1350.pos.view;
import java.text.DecimalFormat;
import se.kth.iv1350.pos.controller.Controller; 
import se.kth.iv1350.pos.controller.NoSuchItemException;
import se.kth.iv1350.pos.controller.ServerErrorException;
import se.kth.iv1350.pos.model.SoldItem; 

/**
 *This class is a placeholder for the user interface
 *
 */
public class View {
    private Controller contr;
    private static final DecimalFormat df = new DecimalFormat("0.00");
    
    
    public View(Controller contr){
        this.contr = contr;
        contr.addSaleObserver(new TotalRevenueFileOutput());
        contr.addSaleObserver(new TotalRevenueView());
    }
    /**
     * Simulates a presentation of an item that 
     * has been added to sale for the sample execution.
     * 
     * @param foundItem The item that has been found and added to sale.
     */
    private void samplePresentItem(SoldItem foundItem){
        System.out.println(foundItem.getName() 
                + "\nPrice:         " 
                + foundItem.getQuantity() + " x " 
                + foundItem.getUnitPrice() 
                + "     " + foundItem.getPrice()
                + "\nRunning total: " 
                + foundItem.getQuantity() + " x " 
                + df.format(foundItem.getUnitRunningTotal())
                + "     " + df.format(foundItem.getRunningTotal())
                + "\nquantity: " + foundItem.getQuantity());
    }
    
    /**
     * Simulates a cashier scanning an item
     * Item id 10 simulates a scenario where the server crash
     * @param itemId 
     */
    private void chooseItem(int itemId){
        try {
            
            SoldItem foundItem = contr.searchMatchingItem(itemId);
            System.out.println("Item has been found: ");
            samplePresentItem(foundItem);
            System.out.println();
        }
        
        catch(NoSuchItemException exc){
           
            System.out.println("Invalid item identifier: " + itemId);
            System.out.println();
        }
        
        catch(ServerErrorException exc) {
            System.out.println("There has been a problem, lost connection to the server");
            System.out.println("Could not search for item id: " + itemId + "\n");
           
        }
        
        
    }
    /**
    * Simulates user inputs of the system operations.
    */
    public void runFakeExecution(){
        contr.startSale();
        System.out.println("A new sale has been started.");
        
        chooseItem(5);
        chooseItem(8);
        chooseItem(3);
        chooseItem(3);
        chooseItem(6);
        chooseItem(2);
        chooseItem(1);
        chooseItem(4);
        chooseItem(4);
        chooseItem(10);
        
        double totalPrice = contr.endSale();
        
        System.out.println("Sale has ended \nYour total price is: " 
                + df.format(totalPrice));
        
        System.out.println();
        
        System.out.println("You pay 200\n");
        
        String receiptPaper = contr.pay(200, totalPrice);
        System.out.println("*Receipt gets printed*\n");
        System.out.println(receiptPaper);
        
        System.out.println("\nInventory system has been updated\n");
        System.out.println("Accounting system has been updated\n");
        
        
    }
}
