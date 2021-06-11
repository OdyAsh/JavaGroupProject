//Group 9
//Author: Mahmoud 201573
package Person;

import java.util.ArrayList;
import Transportation.*;
import Station.Station;
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
    
    private void changeName(int currentAdminPosition, String newName){
        /*Scanner input = new Scanner(System.in);
        System.out.println("Enter the new name");
        String newName = input.nextLine();*/
        
        Station.getAdminsList().get(currentAdminPosition).setName(newName);
        //System.out.println("Your name has been updated successfully");
    }
    
    public void changeUserName(int currentAdminPosition, String newUserName) throws Exception{
        /*Scanner input = new Scanner(System.in);
        System.out.println("Enter the new username");
        String newUserName = input.nextLine();
        */
        
        int checkUserName = Station.findUserName(newUserName);
        
        if(checkUserName != -1){
            throw new SignUpUserNameException(newUserName);
        }else{
        
        Station.getAdminsList().get(currentAdminPosition).setUsername(newUserName);
        // System.out.println("Your username has been updated successfully");
        }
    }
    
    private void changePassword(int currentAdminPosition){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the new password");
        String newPassword = input.nextLine();
        
        Station.getAdminsList().get(currentAdminPosition).setPassword(newPassword);
        System.out.println("Your password has been updated successfully");
    }
    
    /* 
    Function to add train to arrayList of trains in station
    */
    public void addTrain(  ArrayList<Integer> timeSlot, String tempOrigin, String tempDestination, int tempDistance, int tempPrice) throws Exception {
        //System.out.println("Submit New Train Data: ");
        //System.out.println("Time slot: ");
        //int tempTimeSlot = input.nextInt();
        /*
                Validation on submited Timeslot to make sure it isn't negative and doesn't exceed our 24 hours based hour
       */
//        while(tempTimeSlot < 0 || tempTimeSlot > 23){
//            //System.out.println("Please submit a non negative timeslot (from 0 to 23): ");
//            //tempTimeSlot = input.nextInt();
//        }
        //String tempOrigin, tempDestination;
        //int tempDistance, tempPrice;

        //System.out.println("Submit the origin of the route: ");
        //tempOrigin = input.next();
        //System.out.println("Submit the desination of the route: ");
        //tempDestination = input.next();
        //System.out.println("Submit the Distance of the route: ");
        //tempDistance = input.nextInt();
        while(tempDistance < 0){
             //System.out.println("Please submit a non negative distance");
             //tempDistance = input.nextInt();
             }
                //System.out.println("Submit the price of the route: ");
                // tempPrice = input.nextInt();
                while(tempPrice < 0){
                    //System.out.println("Please submit a non negative route price");
                    //tempPrice = input.nextInt();
                }

        Route tempRoute = new Route(tempOrigin, tempDestination, tempDistance,tempPrice);
        Train trainTemp = new Train(tempRoute, timeSlot);
       Station.getTrainsList().add(trainTemp);
       Station.setTrainsList(Station.getTrainsList());
        //System.out.println("Train added successfully!");
    }
    /*
    Function to remove train with its id that gets generated in the report
    Receives Train Id and go across For loop to get the index of the train that assigened with passed ID so we can delete it from the arrayList 
    if it didn't find a train with received id, it will raise an error message
    if it found the train with received ID, it will show that this id got deleted. 
    */
    public int removeTrain(int tempId) throws Exception{ 
         found = -1;
         for (int i=0; i<Station.getTrainsList().size(); i++)
         {
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
   public void changeTrainRoute(int tempTrainId) throws Exception{
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
               
                System.out.println("Submit the origin of the route: ");
                String tempOrigin = input.next();
                System.out.println("Submit the desination of the route: ");
                String tempDestination = input.next();
                System.out.println("Submit the Distance of the route: ");
                int tempDistance = input.nextInt();
                /*
                Validation on submited Distance to make sure it isn't negative
                */
                while(tempDistance < 0){
                    System.out.println("Please submit a non negative distance");
                    tempDistance = input.nextInt();
                }
                System.out.println("Submit the price of the route: ");
                int tempPrice = input.nextInt();
                /*
                Validation on submited price to make sure it isn't negative
                */
                while(tempPrice < 0){
                    System.out.println("Please submit a non negative route price");
                    tempPrice = input.nextInt();
                }
                Route newRoute = new Route(tempOrigin,tempDestination,tempDistance,tempPrice);
                Station.getTrainsList().get(found).setRoute(newRoute);
                 Station.setTrainsList(Station.getTrainsList());
                
                System.out.println("Train with id " + tempTrainId + "'s route got updated succesfully");
               } else{
                   System.out.println("Train with id " + tempTrainId + " Isn't found in the Station");
               }
    }
    /*
    Change Specific Train 's Time slot by passing the train 's id you want to change. 
    Here also we are searching through the list of trains firstly before performing actions on trains.
    Raise not found error in case the train id which the user passed isn't found in the trains arrayList
    if it is found across the trainlist, it will processed And perform Update action on the train associated with passed id and change its timeslot.
    */
    public  void changeTrainTimeSlot(int TrainId) throws Exception{
        found = -1;
                for (int i=0; i<Station.getTrainsList().size(); i++)
                {
                 Train temp = Station.getTrainsList().get(i);            
                 if (temp.getId() == TrainId){
                 found = i;
                 break;
                }
                 
                }
                if(found != -1){
                System.out.println("Submit new timeslot: ");
//                int newTimeSlot = input.nextInt();
                /*
                Validation on submited Timeslot to make sure it isn't negative and doesn't exceed our 24 hours based hour
                */
//                while(newTimeSlot < 0 || newTimeSlot > 23){
//                   System.out.println("Please submit a non negative timeslot (from 0 to 23): ");
//                   newTimeSlot = input.nextInt();
//               }
                ArrayList<Integer> timeSlot=new ArrayList <>();
                for(int i=0;i<timeSlot.size();i++)
                {
                    timeSlot.add(i);
                }
                Station.getTrainsList().get(found).setTimeSlot(timeSlot);
                Station.setTrainsList(Station.getTrainsList());
                    System.out.println("Train with id " + TrainId + "'s Timeslot got updated succesfully");
                } else {
                   System.out.println("Train with id " + TrainId + " Isn't found in the Station");
               }
    }
    /* 
    Function to generate report with total passengers who booked tickets on trains going through a specific route
    Also along the total passengers We print detalied report with every train and detalid stats about High,Mid, and Low class passengers
    Before performing these actions, We firstly check if any train with passed origin and destination is found in the trains list, if true then perform aforementioned actions and print detailed data
    */
    public ArrayList<Train> getTotalPassengersInSpecificRoute(String origin,String destination){
        ArrayList<Train> tempArr = new ArrayList<>();
        for(int i = 0; i < Station.getTrainsList().size(); i++){
            if(Station.getTrainsList().get(i).getRoute().getOrigin().equals(origin) && Station.getTrainsList().get(i).getRoute().getDestination().equals(destination)){
                foundBool = true;
                tempArr.add(Station.getTrainsList().get(i));
            }           
        }
        if (tempArr.isEmpty())
            return null;
        return tempArr;
         
    }
    /* 
    Function to generate report with total tickets and total fare for every class tickets and print total earnings across a specific route by passing route's origin and destination
    We also print total tickets and total fare collected through this route.
    Before performing these actions, We firstly check if any train with passed origin and destination is found in the trains list, if true then perform aforementioned actions and print detailed data about total fare and total tickets for every train found in the list and multiply number of tickets with known price, depending on ticket 's category
    */
    public ArrayList<Train> getTotalFareInSpecificRoute(String origin,String destination){
        ArrayList<Train> tempArr = new ArrayList<>();
        for(int i = 0; i < Station.getTrainsList().size(); i++){
            if(Station.getTrainsList().get(i).getRoute().getOrigin().equals(origin) && Station.getTrainsList().get(i).getRoute().getDestination().equals(destination)){
                tempArr.add(Station.getTrainsList().get(i));
            }         
        }
        if (tempArr.isEmpty())
            return null;
        return tempArr;
        
    }
    @Override
    public String toString() {
        return "Admin info: " + "id=" + super.getId() + ", name=" + super.getName() + ", username=" + super.getUsername() + ", password=" + super.getPassword() + "\n";
    }
    //this method is like the interface that the admin see upon login; it displays all the functionalities that the admin can do
    /*@Override
    public void displayOptions() throws Exception {        
        System.out.println("Welcome "+ super.getName() + " to Cairo Monorail Ticket booking System Admin Panel");
        while(true){
            System.out.println("Please, choose one of the following options\n1- Modify Account\n2- Add/ Remove/ Update Trains\n3- Generate reports for specific routes\n4- Exit");
            int AdminChoice = input.nextInt();
            if(AdminChoice == 1){
                
                System.out.println("choose element you want to change \n1- Name\n2- Username\n3- Password\n4- All of them\n5- Come back to main list");
                int tempChoice = input.nextInt();
                
                int currentAdminPosition = Station.findUserName(this.getUsername());
                
                switch(tempChoice){
                    case 1:
                        changeName(currentAdminPosition);
                        break;
                    case 2:
                        changeUserName(currentAdminPosition);
                        break;
                    case 3: 
                        changePassword(currentAdminPosition);
                        break;
                    case 4:
                        changeName(currentAdminPosition);
                        changeUserName(currentAdminPosition);
                        changePassword(currentAdminPosition);
                        break; 
                    default: 
                        break;
                }
                       
            }
            else if(AdminChoice == 2){
                
                // Add/ Remove/ Update Trains
                System.out.println("Choose which action you want to perform\n1- Add new train\n2- Remove train\n3- Update train route\n4- Update train timeslot\n5- Come back to the main list ");
                int tempChoice = input.nextInt();   
                switch(tempChoice){
                    case 1:
                        addTrain();
                        break;
                    case 2: 
                       System.out.println("Please submit train id to remove from the station: ");
                       int tempId = input.nextInt();
                       removeTrain(tempId);
                       break;
                    case 3:  
                        System.out.println("Submit id of the train you want to change its route: ");
                        int tempTrainId = input.nextInt();
                        changeTrainRoute(tempTrainId);
                        break;
               
                    case 4: 
                        System.out.println("Submit id of the train you want to change its Time Slot: ");
                        int TrainId = input.nextInt(); 
                        changeTrainTimeSlot(TrainId);
                        break;
                
                    default:
                        break;
                }
                
            } else if(AdminChoice == 3){
                System.out.println("Choose which action you want to perform\n1- Generate report for number of passengers\n2- Generate report for total fare\n3- Come back to the main list ");
                int tempChoice = input.nextInt();
                switch(tempChoice){
                    case 1:        
                        System.out.println("Submit origin: ");
                        String tempOrigin = input.next();
                        System.out.println("Submit Destination: ");
                        String tempDestination = input.next();
                        System.out.println("Report about Passengers in this route: " + tempOrigin + " -> " + tempDestination + ":"); 
                        getTotalPassengersInSpecificRoute(tempOrigin,tempDestination);
                break;
                    case 2: 
                    System.out.println("Submit origin: ");
                    String tempOriginForFare = input.next();
                    System.out.println("Submit Destination: ");
                    String tempDestinationForFare = input.next(); 
                    System.out.println("Report about Passengers in this route: " + tempOriginForFare + " -> " + tempDestinationForFare + " : ");
                    getTotalFareInSpecificRoute(tempOriginForFare,tempDestinationForFare);
                break;
                    default:
                break;
                }
            }
            else{
                System.out.println("Thank you for using our system");
                return;
            }
        }
    }*/

    @Override
    public void displayOptions() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}