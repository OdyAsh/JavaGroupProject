/*
 *  Group 9
 *  Author: Ashraf
 */
package Transportation;
import java.util.ArrayList;
import Person.Passenger;
import java.util.Arrays;
public class Train {
    private static int idCounter = 300;
    private int id;
    private Route route;
    private int timeSlot;
    private ArrayList <String> stopStations;
    private ArrayList <Passenger> bookedPassengers;
    private final int SEATNUMLIMIT;
    private boolean[] takenSeats;

    @Override
    public String toString() {
        return "Train's info:\n" + "id: " + id + "\nroute: " + route + "\ntime slot: " 
                + timeSlot + "\nstopping stations: " + stopStations 
                + "\nbooked passengers: " + bookedPassengers + "\ntrain's seats: " 
                + SEATNUMLIMIT + "\ntaken seats (1 for taken): " + Arrays.toString(takenSeats) + "\n";
    }
    
    public Train(Route route, int timeSlot)
    {
        Train.idCounter += 1;
        this.id = idCounter;
        this.route = route;
        this.timeSlot = timeSlot;
        this.stopStations = new ArrayList <>();
        this.bookedPassengers = new ArrayList <>();
        this.SEATNUMLIMIT = 50;
        this.takenSeats = new boolean[SEATNUMLIMIT];
    }

    public Train(Route route, int timeSlot, ArrayList<String> stopStations) {
        Train.idCounter += 1;
        this.id = idCounter;
        this.route = route;
        this.timeSlot = timeSlot;
        this.stopStations = stopStations;
        this.bookedPassengers = new ArrayList <>();
        this.SEATNUMLIMIT = 50;
        this.takenSeats = new boolean[SEATNUMLIMIT];
    }

    public Train(int id, Route route, int timeSlot, ArrayList<String> stopStations, int SEATNUMLIMIT) {
        Train.idCounter += 1;
        this.id = idCounter;
        this.route = route;
        this.timeSlot = timeSlot;
        this.stopStations = stopStations;
        this.bookedPassengers = new ArrayList <>();
        this.SEATNUMLIMIT = SEATNUMLIMIT;
        this.takenSeats = new boolean[SEATNUMLIMIT];
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
    
    public static int getIdCounter() {
        return idCounter;
    }
}
