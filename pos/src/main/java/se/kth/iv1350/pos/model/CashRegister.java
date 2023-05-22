package se.kth.iv1350.pos.model;

/**
 *
 * This class represents the cash register. 
 */
public class CashRegister {
    private double balance;
    
    /**
     * Adds the total price for the sale to the balance of the cash register.
     * @param payment The object that contains information about the payment,
     * that is paid amount, total price and change.
     */
    public void addPayment(CashPayment payment){
        balance += payment.getTotalPrice();
    }
}
