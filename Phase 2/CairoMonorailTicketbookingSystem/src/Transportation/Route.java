/*
 *  Group 9
 *  Author: Abdo
 */
package Transportation;

import java.io.Serializable;

public class Route implements Serializable {
    private String origin;
    private String destination;
    private int distance;
    private int routePrice;

    public Route(String origin, String destination, int distance, int routePrice) {
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
        this.routePrice = routePrice;
    }
    public Route(String origin, String destination, int routePrice) {
        this.origin = origin;
        this.destination = destination;
        this.routePrice = routePrice;
        this.distance = 100;
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

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    
    public int getRoutePrice() {
        return routePrice;
    }

    public void setRoutePrice(int routePrice) {
        this.routePrice = routePrice;
    }
    
    
    
}
