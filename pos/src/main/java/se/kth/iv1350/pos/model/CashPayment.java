/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.pos.model;

/**
 * Represents the payment
 */
public class CashPayment {
    private double paidAmount;
    private double totalPrice;
    private double changeAmount;
    /**
     * A new instance is created with the specified amount paid by customer
     * and totalPrice for the sale
     * @param amount
     * @param totalPrice 
     */
    public CashPayment(double amount, double totalPrice){
        this.paidAmount = amount;
        this.totalPrice = totalPrice;
        this.changeAmount = calculateChange();
    }
    
    private double calculateChange(){
        return paidAmount - totalPrice;
    }
    
    public double getTotalPrice(){
        return totalPrice;
    }
    
    public double getChange(){
        return changeAmount;
    }
    
    public double getPaidAmount(){
        return paidAmount;
    }
}
