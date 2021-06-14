/*
 *  Group 9
 *  Author: Amro Sherif 201762
 */
package Person;
import Station.*;
import Transportation.*;
import UserDefinedExceptions.FindTrainException;
import java.util.*;
import javafx.util.Pair;

public class Passenger extends Person {
    //The key is (trainId, timeSlot).
    private HashMap <Pair<Integer, Integer>, ArrayList<Ticket>> passengerTickets;
    
    public Passenger(String name, String username, String password) {
        super(name, username, password);
        passengerTickets = new HashMap <Pair<Integer, Integer>, ArrayList<Ticket>>();
    }

    public Passenger(String username, String password) {
        super(username, password);
        passengerTickets = new HashMap <Pair<Integer, Integer>, ArrayList<Ticket>>();
    }
    
    
    //This function returns the index of a train with specific route and time slot or -1 if not found.
    public int findTrain(String source, String destination, int timeSlot) throws FindTrainException{
        for(int i = 0;  i < Station.getTrainsList().size();  ++i){
            System.out.println(Station.getTrainsList().get(i).toString());
            String currentOrigin = Station.getTrainsList().get(i).getRoute().getOrigin();
            
            String currentDestination = Station.getTrainsList().get(i).getRoute().getDestination();
            
            if(Objects.equals(currentOrigin, source) && Objects.equals(currentDestination, destination)){
                //Loop through the array list of time slots of this train.
                for(int j = 0; j < Station.getTrainsList().get(i).getTimeSlot().size(); ++j){
                    if(timeSlot == Station.getTrainsList().get(i).getTimeSlot().get(j)){
                        return i;
                    }
                }
            }
        }
        throw new FindTrainException(source, destination, timeSlot);
    }
    
    
    public ArrayList<String> showAvailableTickets(int trainIndex, int timeSlot){
        ArrayList<String> availableTickets = new ArrayList<String>();
        int trainSeatLimit = Station.getTrainsList().get(trainIndex).getSEATNUMLIMIT();
        
        for(int i = 0; i < trainSeatLimit; ++i){
            if(Station.getTrainsList().get(trainIndex).getTakenSeats().get(timeSlot).get(i) == false){
                Integer seat = i + 1;
                availableTickets.add(seat.toString());
            }
            
        }
        return availableTickets;    
    }
    
    
    public ArrayList<String> showBookedTicketsOnCertainTrain(int trainId, int timeSlot){
        ArrayList<String> bookedTickets = new ArrayList<String>();
        Integer seatNumber;
        
        Pair<Integer, Integer>temp= new Pair<Integer, Integer>(trainId, timeSlot);
        
        for(Ticket i : passengerTickets.get(temp)){
            seatNumber = i.getSeatNum();
            bookedTickets.add(seatNumber.toString());
        }
        return bookedTickets;
    }
    
    public void updateSeatNumber(int trainIndex, int trainId, int timeSlot, int oldSeatNumber){
        Station.getTrainsList().get(trainIndex).getTakenSeats().get(timeSlot).set(oldSeatNumber - 1, false);
        //This loop finds the ticket with the previous seat number and change it to the new value.
        Pair<Integer, Integer>temp = new Pair<Integer, Integer>(trainId, timeSlot);
        for(int i = 0; i < passengerTickets.get(temp).size(); ++i){
            if(passengerTickets.get(temp).get(i).getSeatNum() == oldSeatNumber){
                passengerTickets.get(temp).remove(i);
                return;
            }
        }
    }
    
    public void updateTimeSlot(int trainIndex, int newTimeSlot, int oldTimeSlot, int ticketNumber){
        int trainId = Station.getTrainsList().get(trainIndex).getId();

        //This loop searches for the ticket in the old train.
        Pair<Integer, Integer>newTrain = new Pair<Integer, Integer>(trainId, newTimeSlot);
        Pair<Integer, Integer>oldTrain = new Pair<Integer, Integer>(trainId, oldTimeSlot);
        for(int i = 0; i < passengerTickets.get(oldTrain).size(); ++i){
            if(passengerTickets.get(oldTrain).get(i).getSeatNum() == ticketNumber){
                if(passengerTickets.get(newTrain) == null){
                    passengerTickets.put(newTrain, new ArrayList<Ticket>());
                }
                //adding the ticket to the new train.
                passengerTickets.get(newTrain).add(passengerTickets.get(oldTrain).get(i));
                Station.getTrainsList().get(trainIndex).getTakenSeats().get(oldTimeSlot).set(ticketNumber - 1, false);
                Station.getTrainsList().get(trainIndex).getTakenSeats().get(newTimeSlot).set(ticketNumber - 1, true);
                //removing the ticket from the previous train.
                passengerTickets.get(oldTrain).remove(i);
                break;
            }
        }
    }
    
    
    public void cancelBooking(int trainIndex, int trainId, int seatNumber, int timeSlot){
        Pair<Integer, Integer>temp = new Pair<Integer, Integer>(trainId, timeSlot);
        
        Station.getTrainsList().get(trainIndex).getTakenSeats().get(timeSlot).set(seatNumber - 1, false);
        
        //This loop search for the seat number in the train in order to remove it from array list.
        for(int i = 0; i < passengerTickets.get(temp).size(); ++i){
            if(passengerTickets.get(temp).get(i).getSeatNum() == seatNumber){
                passengerTickets.get(temp).remove(i);
                break;
            }
        }
        
        //This loop checks if this passenger has other bookings on this train whether it is on this time slot or any other time.
        boolean flg = false;
        for(Map.Entry<Pair<Integer, Integer>, ArrayList<Ticket>> entry : passengerTickets.entrySet()){
            if(entry.getKey().getKey() == trainId && !entry.getValue().isEmpty()){
                flg = true;
                break;
            }
        }
        //If flag is false, this means that this passenger has no bookings on this train so we should delete him from the arraylist of passengers of this train.
        if(flg == false){
            Station.getTrainsList().get(trainIndex).getBookedPassengers().remove(this);
        }
    }
    
    
    public void bookTicket(int trainIndex, int seatNum, int timeSlot){
        int trainId = Station.getTrainsList().get(trainIndex).getId();
        
        Pair<Integer, Integer>temp = new Pair<Integer, Integer>(trainId, timeSlot);
        
        //this if statement checks if the passenger has never booked tickets on this train before and if so a key with the value of the train id with an arraylist of tickets will be add to the hash map.
        if(passengerTickets.get(temp) == null){
            passengerTickets.put(temp, new ArrayList<Ticket>());
        }
        passengerTickets.get(temp).add(new Ticket(seatNum));
                
        //Marking the seat as booked in this train.
        Station.getTrainsList().get(trainIndex).getTakenSeats().get(timeSlot).set(seatNum - 1, true);
        
        //Adding the current passenger to the array list of passengers in this train if it does not already exist.
        for(int i = 0; i < Station.getTrainsList().get(trainIndex).getBookedPassengers().size(); ++i){
            if(Station.getTrainsList().get(trainIndex).getBookedPassengers().get(i).getId() == this.getId())
                return;
        }
        Station.getTrainsList().get(trainIndex).getBookedPassengers().add(this);
    }
    
    @Override
    public void displayOptions() {
        
    }
    
    public HashMap<Pair<Integer, Integer>, ArrayList<Ticket>> getPassengerTickets() {
        return passengerTickets;
    }

    public void setPassengerTickets(HashMap<Pair<Integer, Integer>, ArrayList<Ticket>> passengerTickets) {
        this.passengerTickets = passengerTickets;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\n" + "passengerTickets=" + passengerTickets + "\n";
    }
    
    
 }
    
