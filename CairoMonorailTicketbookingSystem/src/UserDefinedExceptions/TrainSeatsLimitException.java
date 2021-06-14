/*
 *  Group 9
 *  Author: Ashraf
 */
package UserDefinedExceptions;

/**
 *
 * @author Ashraf
 */
public class TrainSeatsLimitException extends Exception {
    private String err;
    public TrainSeatsLimitException()
    {
        err = "The minimum amount of seats a train can have is 50...";
    }
    @Override
    public String toString() {
        return err;
    }
}
