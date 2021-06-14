/*
 *  Group 9
 *  Author: Amro Sherif 201762
 */
package UserDefinedExceptions;

public class FindTrainException extends Exception {
    private String error;
    public FindTrainException(String source, String destination, int timeSlot){
        error = "There is no train from " + source + " to " + destination + " at " + timeSlot;
    }

    @Override
    public String toString() {
        return error;
    }
    
}
