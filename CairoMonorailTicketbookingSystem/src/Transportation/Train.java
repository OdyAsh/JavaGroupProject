/*
 *  Group 9
 *  Author: Ashraf
 */
package Transportation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import Person.Passenger;

public class Train {
    private static int idCounter = 300;
    private int id;
    private Route route;
    private int timeSlot; //24 hour based
    private ArrayList <String> stopStations;
    private ArrayList <Passenger> bookedPassengers;
    private final int SEATNUMLIMIT;
    private boolean[] takenSeats;
    
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

    public Train(Route route, int timeSlot, ArrayList<String> stopStations, int SEATNUMLIMIT) {
        Train.idCounter += 1;
        this.id = idCounter;
        this.route = route;
        this.timeSlot = timeSlot;
        this.stopStations = stopStations;
        this.bookedPassengers = new ArrayList <>();
        this.SEATNUMLIMIT = validateTrainSeatsLimit(SEATNUMLIMIT);
        this.takenSeats = new boolean[SEATNUMLIMIT];
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
        for (int i = STARTIDX ; i <= ENDIDX; i++) {
            if (takenSeats[i] == true) 
                seatCount++;
        }
        return seatCount;
    }
    
    public int getMidClassTakenSeats() {
        final int STARTIDX = 10, ENDIDX = 34;
        int seatCount = 0;
        for (int i = STARTIDX ; i <= ENDIDX; i++) {
            if (takenSeats[i] == true) 
                seatCount++;
        }
        return seatCount;
    }
    
    public int getLowClassTakenSeats() {
        final int STARTIDX = 35, ENDIDX = takenSeats.length - 1;
        int seatCount = 0;
        for (int i = STARTIDX ; i <= ENDIDX; i++) {
            if (takenSeats[i] == true) 
                seatCount++;
        }
        return seatCount;
    }
    
    //function to make sure the train's seats are not less than 50 if the object is constructed by admin
    //and they decided to set the SEATNUMLIMIT themselves
    private int validateTrainSeatsLimit(int limit) {
        while (limit < 50) {
            System.out.println("the minimum number of seats per train is 50, please enter a valid number...");
            Scanner input = new Scanner(System.in);
            limit = input.nextInt(); input.nextLine();
        }
        return limit;
    }
    
    
    @Override
    public String toString() {
        return "Train's info:\n" + "id: " + id + "\nroute: " + route + "\ntime slot: " 
                + timeSlot + "\nstopping stations: " + stopStations 
                + "\nbooked passengers: " + bookedPassengers + "\ntrain's seats: " 
                + SEATNUMLIMIT + "\ntaken seats (1 for taken): " + Arrays.toString(takenSeats) + "\n";
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

    public int getSEATNUMLIMIT() {
        return SEATNUMLIMIT;
    }
    
}
