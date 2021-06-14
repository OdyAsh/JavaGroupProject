/*
 *  Group 9
 *  Author: Ashraf
 */
package Transportation;
import java.util.ArrayList;
import Person.Passenger;
import UserDefinedExceptions.TrainSeatsLimitException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Train implements Serializable {
    private static int idCounter = 300;
    private int id;
    private Route route;
    private ArrayList<Integer> timeSlot;
    private ArrayList <String> stopStations;
    private ArrayList <Passenger> bookedPassengers;
    private final int SEATNUMLIMIT;
    private HashMap <Integer,ArrayList<Boolean>> takenSeats;
    
    
        public Train(Route route, ArrayList<Integer> timeSlot){
            Train.idCounter += 1;
            this.id = idCounter;
            this.route = route;
            this.timeSlot = timeSlot;
            this.stopStations = new ArrayList <>();
            this.bookedPassengers = new ArrayList <>();
            this.SEATNUMLIMIT = 50;
            this.takenSeats = new  HashMap<>();
            for (int i : timeSlot) {
                takenSeats.put(i, new ArrayList<Boolean>(SEATNUMLIMIT));
                for (int j = 0 ; j < SEATNUMLIMIT ; j++)
                    takenSeats.get(i).add(false);
            }
        }

    public Train(Route route, ArrayList<Integer> timeSlot, ArrayList<String> stopStations) {
        Train.idCounter += 1;
        this.id = idCounter;
        this.route = route;
        this.timeSlot = timeSlot;
        this.stopStations = stopStations;
        this.bookedPassengers = new ArrayList <>();
        this.SEATNUMLIMIT = 50;
        this.takenSeats = new  HashMap<>();
        for (int i : timeSlot) {
                takenSeats.put(i, new ArrayList<Boolean>(SEATNUMLIMIT));
                for (int j = 0 ; j < SEATNUMLIMIT ; j++)
                    takenSeats.get(i).add(false);
            }
    }

    public Train(Route route, ArrayList<Integer> timeSlot, ArrayList<String> stopStations, int SEATNUMLIMIT) throws TrainSeatsLimitException {
        Train.idCounter += 1;
        this.id = idCounter;
        this.route = route;
        this.timeSlot = timeSlot;
        this.stopStations = stopStations;
        this.bookedPassengers = new ArrayList <>();
        this.SEATNUMLIMIT = validateTrainSeatsLimit(SEATNUMLIMIT);
        this.takenSeats = new  HashMap<>();
        for (int i : timeSlot) {
                takenSeats.put(i, new ArrayList<Boolean>(SEATNUMLIMIT));
                for (int j = 0 ; j < SEATNUMLIMIT ; j++)
                    takenSeats.get(i).add(false);
            }
    }

    
    
    //the 3 methods below are used to get the number of passengers
    //that are booked in the train's high (VIP) class seats, mid and low 
    //class seats respectively.
    //Assumptions:
    //1. no train has less than 50 seats
    //2. the prices of the seats classes are as follows:
    //   high class: 30egp, seats 1 to 10
    //   mid class: 20egp, seats 11 to 35
    //   low class: 10egp, seats 36 to last
    public int getHighClassTakenSeats() {
        final int STARTIDX = 0, ENDIDX = 9;
        int seatCount = 0; 
        for (Map.Entry<Integer, ArrayList<Boolean>> set : takenSeats.entrySet()) {	    
            for (int i = STARTIDX ; i <= ENDIDX; i++) {
                if (set.getValue().get(i) == true) 
                    seatCount++;
            }
        }
        return seatCount;
    }
    
    public int getMidClassTakenSeats() {
        final int STARTIDX = 10, ENDIDX = 34;
        int seatCount = 0;
        for (Map.Entry<Integer, ArrayList<Boolean>> set : takenSeats.entrySet()) {	    
            for (int i = STARTIDX ; i <= ENDIDX; i++) {

                if (set.getValue().get(i) == true) 
                    seatCount++;
            }
        }
        return seatCount;
    }
    
    public int getLowClassTakenSeats() {
        final int STARTIDX = 35, ENDIDX = takenSeats.size()-1;
        int seatCount = 0;
        for (Map.Entry<Integer, ArrayList<Boolean>> set : takenSeats.entrySet()) {	    
            for (int i = STARTIDX ; i <= ENDIDX; i++) {

                if (set.getValue().get(i) == true) 
                    seatCount++;
            }
        }
        return seatCount;
    }
    
    //function to make sure the train's seats are not less than 50 if the object is constructed by admin
    //and they decided to set the SEATNUMLIMIT themselves
    private int validateTrainSeatsLimit(int limit) throws TrainSeatsLimitException {
        if (limit < 50) {
            throw new TrainSeatsLimitException();
        }
        return limit;
    }
    
    
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "{id=" + id + ", route=" + route + ", timeSlot=" + timeSlot + ", stopStations=" + stopStations + ", bookedPassengers=" + bookedPassengers + ", SEATNUMLIMIT=" + SEATNUMLIMIT + ", takenSeats=" + takenSeats + "}\n";
    }

    

    public void setId(int id) {
        this.id = id;
    }

    public static void setIdCounter(int idCounter) {
        Train.idCounter = idCounter;
    }
    
    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public void setTimeSlot(ArrayList<Integer> timeSlot) {
        this.timeSlot = timeSlot;
    }

    public ArrayList<Integer> getTimeSlot() {
        return timeSlot;
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

    public void setTakenSeats(HashMap<Integer, ArrayList<Boolean>> takenSeats) {
        this.takenSeats = takenSeats;
    }

    public HashMap<Integer, ArrayList<Boolean>> getTakenSeats() {
        return takenSeats;
    }

    
    
    public static int getIdCounter() {
        return idCounter;
    }

    public int getSEATNUMLIMIT() {
        return SEATNUMLIMIT;
    }

    
    
}
