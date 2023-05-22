package se.kth.iv1350.pos.controller;


/**
 *
 * Exception for an invalid input of an item identifier.
 */
public class NoSuchItemException extends Exception {
    public NoSuchItemException(String msg){
        super(msg);
    }
}
