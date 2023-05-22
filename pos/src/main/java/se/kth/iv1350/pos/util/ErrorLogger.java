package se.kth.iv1350.pos.util;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * The class that handles the Error log 
 * The methods implements the logger interface.
 */
public class ErrorLogger implements Logger {
    private PrintWriter logStream;
    
    /**
     * Creates a text file for the programs error log.
     */
    public ErrorLogger(){
        try {
            logStream = new PrintWriter(new FileWriter("ErrorLog.txt"), true);
        }
        
        catch(IOException ioe) {
            System.out.println("ERROR: CAN NOT LOG");
            ioe.printStackTrace();
        }
    }
    
    /**
     * Logs information about the occured error.
     * @param infoAboutError A string that explains the error
     * @param exc The exception which provides the stack trace of the error
     */
    @Override
    public void logError(String infoAboutError, Exception exc){
        logStream.println(infoAboutError);
        logStream.println("The Stack Trace: ");
        exc.printStackTrace(logStream);
        logStream.println();
        
    }
    
}
