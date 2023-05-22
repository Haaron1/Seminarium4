package se.kth.iv1350.pos.model;

/**
 *
 * An interface for any observer that observe the income of a retail store.
 */
public interface SaleObserver {
    /**
     * The method used by any observer that needs information about
     * the most recent income of a sale and the current total revenue.
     * @param recentTotalPrice the recent income of a sale
     * @param totalRevenue the current total revenue
     */
    public void totalRevenue(double recentTotalPrice,double totalRevenue);
}
