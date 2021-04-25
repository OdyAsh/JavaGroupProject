/*
 *  Group 9
 *  Author: 
 */
package Transportation;

public class Route {
    private String origin;
    private String destination;
    private int routePrice;

    public Route(String origin, String destination, int routePrice) {
        this.origin = origin;
        this.destination = destination;
        this.routePrice = routePrice;
    }

    public Route(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
        this.routePrice = 3;
    }

    @Override
    public String toString() {
        return "Route info:\n" + "origin: " + origin + "\ndestination: " + destination + "\nroute price: " + routePrice + "\n";
    }
    
    
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getRoutePrice() {
        return routePrice;
    }

    public void setRoutePrice(int routePrice) {
        this.routePrice = routePrice;
    }
    
    
    
}
