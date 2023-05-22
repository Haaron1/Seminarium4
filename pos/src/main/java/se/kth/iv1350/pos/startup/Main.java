package se.kth.iv1350.pos.startup;
import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.view.View;
import se.kth.iv1350.pos.util.ErrorLogger;

/**
 * The main class is the start up of the entire program.
 */
public class Main {
    public static void main(String[] args){
        
        Controller contr = new Controller(new ErrorLogger());
        View view = new View(contr);
        
        view.runFakeExecution();
        view.runFakeExecution();
        view.runFakeExecution();
        
    } 
}
