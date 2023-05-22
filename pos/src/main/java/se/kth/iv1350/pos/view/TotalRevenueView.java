package se.kth.iv1350.pos.view;
import java.text.DecimalFormat;
import se.kth.iv1350.pos.model.SaleObserver;

/**
 *
 * A view for the total revenue and the stores latest income.
 */
public class TotalRevenueView implements SaleObserver{
    private static final DecimalFormat df = new DecimalFormat("0.00");
    
    /**
     * Shows the total revenue and latest income on some display for example.
     * @param recentTotalPrice the total price of the recent sale
     * @param totalRevenue the total revenue since program started
     */
    @Override
    public void totalRevenue(double recentTotalPrice,double totalRevenue){
        System.out.println("************ANOTHER VIEW************");
        System.out.println("Recent sale income: " 
                + df.format(recentTotalPrice));
        System.out.println("The current total revenue is: " 
                + df.format(totalRevenue));
        System.out.println("************************************\n");
    }
}
