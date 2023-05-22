/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.pos.integration;
import java.text.DecimalFormat;
import java.util.List;
import se.kth.iv1350.pos.model.Receipt;
import se.kth.iv1350.pos.model.SoldItem;

/**
 *
 * The class representing the printer
 */
public class Printer {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private List<SoldItem> purchasedItems;
    
    /**
     * This class is a placeholder for the external printer system
     */
    public Printer(){
        
    }
    /**
     * Simulates how the printed receipt could look like by building a string.
     * @param receipt The receipt that is supposed to be printed
     * @return The built string which will represent the receipt paper
     */
    public String printReceipt(Receipt receipt){
        return receipt.receiptPaperFormat();
    }
    
}
