//Group 9
//Author: Mahmoud 201573
package Person;

import java.util.ArrayList;
import Transportation.*;
import Station.Station;
import UserDefinedExceptions.RouteException;
import java.io.Serializable;
import java.util.Scanner;
import UserDefinedExceptions.SignUpUserNameException;

public class Admin extends Person implements Serializable{

    private int found; // our main counter here to get the index where a train with the received ID exists so we can delete it from the arrayList
    private boolean foundBool; // boolean check whether route is found with passed origin and destination (Used in Generate reports functions)
    transient Scanner input = new Scanner(System.in).useDelimiter("\n"); // Local variable for Input to receive input from the user across all class functions, with useDelimiter to ignore newLines in input fields.

    public Admin(String name,String userName, String password) {
        super(name, userName, password);
        this.foundBool = false;
        this.found = -1;
        
    }
    public Admin(String username, String password) {
        super(username, password);
        this.foundBool = false;
        this.found = -1;
    }
    
    public void changeName(int currentAdminPosition, String newName) throws Exception{
        Station.getAdminsList().get(currentAdminPosition).setName(newName);
        Station.setAdminsList( Station.getAdminsList());
    }
    
    public void changeUserName(int currentAdminPosition, String newUserName) throws Exception{
        int checkUserName = Station.findUserName(newUserName);
        
        if(checkUserName != -1){
            throw new SignUpUserNameException(newUserName);
        }else{
        
        Station.getAdminsList().get(currentAdminPosition).setUsername(newUserName);
        Station.setAdminsList( Station.getAdminsList());
        }
    }
    
    public void changePassword(int currentAdminPosition, String newPassword) throws Exception{
        Station.getAdminsList().get(currentAdminPosition).setPassword(newPassword);
        Station.setAdminsList( Station.getAdminsList());
    }
    
    /* 
    Function to add train to arrayList of trains in station
    */
    public void addTrain(ArrayList<Integer> timeSlot, String tempOrigin, String tempDestination, int tempDistance, int tempPrice, ArrayList<String> stopStations, int seatNumLimit) throws Exception {
       Route tempRoute = new Route(tempOrigin, tempDestination, tempDistance,tempPrice);
       Train trainTemp = new Train(tempRoute, timeSlot, stopStations, seatNumLimit);
       Station.getTrainsList().add(trainTemp);
       Station.setTrainsList(Station.getTrainsList());
    }
    /*
    Function to remove train with its id that gets generated in the report
    Receives Train Id and go across For loop to get the index of the train that assigened with passed ID so we can delete it from the arrayList 
    if it didn't find a train with received id, it will raise an error message
    if it found the train with received ID, it will show that this id got deleted. 
    */
    public int removeTrain(int tempId) throws Exception{ 
         found = -1;
         for (int i=0; i<Station.getTrainsList().size(); i++) {
            Train temp = Station.getTrainsList().get(i);            
            if (temp.getId() == tempId) {
                found = i;
                break;
            }
         }
         return found;
    }
    /*
    Change Specific Train 's Route by passing the train 's id you want to change. 
    Here also we are searching through the list of trains firstly before performing actions on trains.
    Raise not found error in case the train id which the user passed isn't found in the trains arrayList
    if it is found across the trainlist, it will processed And perform Update action on the train associated with passed id and change its route.
    */
   public boolean changeTrainRoute(int tempTrainId, String origin, String destination, int distance, int price) throws Exception{
                found = -1;
                for (int i=0; i<Station.getTrainsList().size(); i++)
                {
                    Train temp = Station.getTrainsList().get(i);            
                    if (temp.getId() == tempTrainId){
                       found = i;
                       break;
                   }
                }
               if(found != -1){
                    Route newRoute = new Route(destination,origin,distance,price);
                    Station.getTrainsList().get(found).setRoute(newRoute);
                    Station.setTrainsList(Station.getTrainsList());
                    return true;
               } else{
                    return false;
               }
    }
    /*
    Change Specific Train 's Time slot by passing the train 's id you want to change. 
    Here also we are searching through the list of trains firstly before performing actions on trains.
    Raise not found error in case the train id which the user passed isn't found in the trains arrayList
    if it is found across the trainlist, it will processed And perform Update action on the train associated with passed id and change its timeslot.
    */
    public  int changeTrainTimeSlot(int TrainId, int oldTimeSlot, int newTimeSlot) throws Exception{
        found = -1;
        for (int i=0; i<Station.getTrainsList().size(); i++)
        {
            Train temp = Station.getTrainsList().get(i);            
            if (temp.getId() == TrainId){
                found = i;
                break;
           }
        }
        if(found != -1) 
        {
            Train t = Station.getTrainsList().get(found);
            if (t.getTakenSeats().containsKey(oldTimeSlot))
            {
                for (int i = 0 ; i <= t.getSEATNUMLIMIT(); i++) 
                {
                     if(t.getTakenSeats().get(oldTimeSlot).get(i)==true)
                     {
                         return -3; //train contains oldTimeSlot, but at least one passenger has already booked a ticket at that time, so you can't remove it
                     }
                }
                Station.getTrainsList().get(found).getTakenSeats().remove(oldTimeSlot);
                ArrayList<Boolean> ts = new ArrayList<>(t.getSEATNUMLIMIT());
                for (int i = 0 ; i < t.getSEATNUMLIMIT() ; i++)
                    ts.add(false);
                Station.getTrainsList().get(found).getTakenSeats().put(newTimeSlot, ts);
                Station.setTrainsList(Station.getTrainsList());
                return 1; //oldTimeSlot have been removed, newTimeSlot have been added as a key in the hashmap along with its boolean arraylist of empty (false) taken Seats
            } 
            else 
                return -2; //train doesn't contain oldTimeSlot
        }
        return -1; //trainID is not found 
 }
    /* 
    Function to generate report with total passengers who booked tickets on trains going through a specific route
    Also along the total passengers We print detalied report with every train and detalid stats about High,Mid, and Low class passengers
    Before performing these actions, We firstly check if any train with passed origin and destination is found in the trains list, if true then perform aforementioned actions and print detailed data
    */
    public ArrayList<Train> getTotalPassengersInSpecificRoute(String origin,String destination) throws RouteException{
        ArrayList<Train> tempArr = new ArrayList<>();
        for(int i = 0; i < Station.getTrainsList().size(); i++){
            if(Station.getTrainsList().get(i).getRoute().getOrigin().equals(origin) && Station.getTrainsList().get(i).getRoute().getDestination().equals(destination)){
                foundBool = true;
                tempArr.add(Station.getTrainsList().get(i));
            }           
        }
        if (tempArr.isEmpty()){
        throw new RouteException(origin,destination);
        }else{
                 return tempArr;   
        }
         
    }
    /* 
    Function to generate report with total tickets and total fare for every class tickets and print total earnings across a specific route by passing route's origin and destination
    We also print total tickets and total fare collected through this route.
    Before performing these actions, We firstly check if any train with passed origin and destination is found in the trains list, if true then perform aforementioned actions and print detailed data about total fare and total tickets for every train found in the list and multiply number of tickets with known price, depending on ticket 's category
    */
    public ArrayList<Train> getTotalFareInSpecificRoute(String origin,String destination) throws RouteException{
        ArrayList<Train> tempArr = new ArrayList<>();
        for(int i = 0; i < Station.getTrainsList().size(); i++){
            if(Station.getTrainsList().get(i).getRoute().getOrigin().equals(origin) && Station.getTrainsList().get(i).getRoute().getDestination().equals(destination)){
                tempArr.add(Station.getTrainsList().get(i));
            }         
        }
        if (tempArr.isEmpty()){
            throw new RouteException(origin,destination);
        }else{
            return tempArr;   
        }
        
    }
    @Override
    public String toString() {
        return "Admin info: " + "id=" + super.getId() + ", name=" + super.getName() + ", username=" + super.getUsername() + ", password=" + super.getPassword() + "\n";
    }
    
    @Override
    public void displayOptions() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}