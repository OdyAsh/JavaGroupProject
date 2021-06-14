/*
 *  Group 9
 *  Author: abdo_203795
 */
package UserDefinedExceptions;

/**
 *
 * @author Abdo
 */
public class TimeException extends Exception{
     private final String error;
    public TimeException(int  tempTimeSlot)
    {
        error = "The time you entered \""  + tempTimeSlot + "\" its no use...";
    }
    @Override
    public String toString() {
        return error;
    }
}


