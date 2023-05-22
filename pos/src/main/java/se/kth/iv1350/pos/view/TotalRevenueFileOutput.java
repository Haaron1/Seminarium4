package se.kth.iv1350.pos.view;
import se.kth.iv1350.pos.model.SaleObserver;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

/**
 *
 * The class that handles the revenue output to file.
 */
public class TotalRevenueFileOutput implements SaleObserver{
    
    private PrintWriter logStream;
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private int saleNumber = 1;
    
    /**
     * Creates a new instance, the file containing information about the revenue.
     */
    public TotalRevenueFileOutput(){
        try {
            logStream = new PrintWriter(new FileWriter("TotalRevenue.txt"), true);
        }
        
        catch(IOException ioe) {
            System.out.println("ERROR: CAN NOT LOG");
            ioe.printStackTrace();
        }
    }
    
    /**
     * Writes the order of sales and the total price of each sale 
     * along with the current total revenue to the file TotalRevenue.txt
     * @param recentTotalPrice the total price of the recent sale
     * @param totalRevenue the total revenue of all sales since program started
     */
    @Override
    public void totalRevenue(double recentTotalPrice, double totalRevenue){
        logStream.println("The total price of sale number " + saleNumber + ": " 
                + df.format(recentTotalPrice));
        
        logStream.println("The total revenue currently: " 
                + df.format(totalRevenue) + "\n");
        
        saleNumber++;
        
    }
}
