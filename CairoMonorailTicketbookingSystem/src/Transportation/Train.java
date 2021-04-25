/*
 *  Group 9
 *  Author: 
 */
package Transportation;
import java.util.ArrayList;
import Person.Passenger;
public class Train {
    private static int idCounter = 300;
    private int id;
    private Route route;
    private int timeSlot;
    private ArrayList <String> stopStations;
    private ArrayList <Passenger> bookedPassengers;
    private final int SEATNUM = 50;
    private boolean[] takenSeats = new boolean[SEATNUM];

    public Train(Route route, int timeSlot)
    {
        Train.idCounter += 1;
        this.id = idCounter;
        this.route = route;
        
        this.timeSlot = timeSlot;
    }

    public Train(Route route, int timeSlot, ArrayList<String> stopStations, ArrayList<Passenger> bookedPassengers) {
        Train.idCounter += 1;
        this.id = idCounter;
        this.route = route;
        this.timeSlot = timeSlot;
        this.stopStations = stopStations;
        this.bookedPassengers = bookedPassengers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public int getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(int timeSlot) {
        this.timeSlot = timeSlot;
    }

    public ArrayList<String> getStopStations() {
        return stopStations;
    }

    public void setStopStations(ArrayList<String> stopStations) {
        this.stopStations = stopStations;
    }

    public ArrayList<Passenger> getBookedPassengers() {
        return bookedPassengers;
    }

    public void setBookedPassengers(ArrayList<Passenger> bookedPassengers) {
        this.bookedPassengers = bookedPassengers;
    }

    public boolean[] getTakenSeats() {
        return takenSeats;
    }

    public void setTakenSeats(boolean[] takenSeats) {
        this.takenSeats = takenSeats;
    }
    
    
}
