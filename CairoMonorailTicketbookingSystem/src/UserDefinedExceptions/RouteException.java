/*
 *  Group 9
 *  Author: 
 */
package UserDefinedExceptions;

/**
 *
 * @author Mahmmoud
 */
public class RouteException extends Exception {
    private String error;
    public RouteException(String origin, String destination){
        error = "There is no route with this origin: " + origin + " and destination: " + destination;
    }

    @Override
    public String toString() {
        return error;
    }
    
}
