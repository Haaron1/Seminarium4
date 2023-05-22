package se.kth.iv1350.pos.model;
import java.util.List;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The receipt of the sale
 * 
 */
public class Receipt {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private List<SoldItem> purchasedItems;
    private LocalDateTime saleTime;
    private CashPayment payment;
    private double totalPriceWithoutTax;
    
    /**
     * Creates a new instance
     * @param payment Contains information about the payment, total and change 
     * @param purchasedItems contains info about all purchased items
     * @param saleTime the sale time
     * @param totalPriceWithoutTax the total price without tax
     */
    public Receipt(CashPayment payment, List<SoldItem> purchasedItems, 
            LocalDateTime saleTime, double totalPriceWithoutTax){
        this.purchasedItems = purchasedItems;
        this.saleTime = saleTime;
        this.payment = payment;
        this.totalPriceWithoutTax = totalPriceWithoutTax;
    }
    
    /**
     * Calculates the amount of tax by subtracting the total price without tax 
     * from the total price with tax
     * @return The calculated difference value 
     */
    private double getTotalTax(){
        return payment.getTotalPrice() - totalPriceWithoutTax;
    }
    
    /**
     * Calculates the tax percentage by finding the change factor of
     * total price over total price without tax, subtracting 1 from
     * the result provides the percentage in decimal form, multiplying by 100
     * gives the percentage.
     * @return The percentage of the total tax rate
     */
    private double getTotalTaxRate(){
        return 100 * ((payment.getTotalPrice() / totalPriceWithoutTax) - 1);
    }
    
    /**
     * Builds a receipt in form of a String
     * @return the receipt represented by a string
     */
    public String receiptPaperFormat(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
        StringBuilder builder = new StringBuilder();
        
        builder.append("------------RECEIPT------------");
        endSection(builder);
        builder.append("Time of Sale: ");
        appendLine(builder, saleTime.format(format));
        endSection(builder);
        
        appendLine(builder, printPurchasedItems());
        
        builder.append("Your change: ");
        appendLine(builder, df.format(payment.getChange()));
        
        builder.append("Paid amount: ");
        appendLine(builder, df.format(payment.getPaidAmount()));
        
        builder.append("Total price without tax: ");
        appendLine(builder, df.format(totalPriceWithoutTax));
        
        builder.append("Tax amount: ");
        appendLine(builder, df.format(getTotalTax()));
        
        builder.append("Total price: ");
        appendLine(builder, df.format(payment.getTotalPrice()) );
        
        builder.append("Tax rate: ");
        appendLine(builder, df.format(getTotalTaxRate()) + "%" );
        builder.append("-------------------------------");
        
        return builder.toString();
    }
    
    private void appendLine(StringBuilder builder, String line){
        builder.append(line);
        builder.append("\n");
    }
    
    private void endSection(StringBuilder builder){
        builder.append("\n");
    }
    
    private String printPurchasedItems(){
        String purchasedItemsToString = "";
        for(SoldItem item : purchasedItems){
            purchasedItemsToString += item.getName() 
                    + "  " 
                    + item.getQuantity() 
                    + " x " 
                    + df.format(item.getUnitRunningTotal()) 
                    + "      " + df.format(item.getRunningTotal())
                    + "\n";
        }
        return purchasedItemsToString;
    }
}
