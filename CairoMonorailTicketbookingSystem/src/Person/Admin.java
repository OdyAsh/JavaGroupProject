//Group 9
//Author: Mahmoud 201573
package Person;

import java.util.ArrayList;
import Transportation.*;
import Station.Station;
import java.util.Scanner;
public class Admin extends Person {


    public Admin(String name,String userName, String password) {
        super(name, userName, password);
    }
    public Admin(String username, String password) {
        super(username, password);
    }
    public void getTotalPassengersInSpecificRoute(String origin,String destination){
        int tempTotal = 0, tempHigh = 0,tempMid = 0 , tempLow = 0;
        boolean found = false;
        for(int i = 0; i < Station.getTrainsList().size(); i++){
            if(Station.getTrainsList().get(i).getRoute().getOrigin().equals(origin) && Station.getTrainsList().get(i).getRoute().getDestination().equals(destination)){
                found = true;
                tempTotal += Station.getTrainsList().get(i).getHighClassTakenSeats() + Station.getTrainsList().get(i).getLowClassTakenSeats() + Station.getTrainsList().get(i).getMidClassTakenSeats();
                tempHigh = Station.getTrainsList().get(i).getHighClassTakenSeats();
                tempMid = Station.getTrainsList().get(i).getMidClassTakenSeats();
                tempLow = Station.getTrainsList().get(i).getLowClassTakenSeats();
                System.out.println("Train: " + Station.getTrainsList().get(i).getId() + "\n Number of High Class Passengers: " + tempHigh + 
                        "\n Number Mid Class Passengers: " + tempMid + "\n Number Low Class Passengers: " + tempLow + 
                        "\n with total of: " + tempTotal + " Passengers \n");
            }           
        }
        if (!found) 
            System.out.println("No trains with origin: " + origin + " and destination: " + destination + " were found.\n");
         
    }
    public void getTotalFareInSpecificRoute(String origin,String destination){
        int totalTickets = 0, totalFare = 0, 
            tempHigh = 0,tempMid = 0 , tempLow = 0, 
            ticketHigh = 30, ticketMid = 20, ticketLow = 10;
        boolean found = false;
        for(int i = 0; i < Station.getTrainsList().size(); i++){
            if(Station.getTrainsList().get(i).getRoute().getOrigin().equals(origin) && Station.getTrainsList().get(i).getRoute().getDestination().equals(destination)){
                found = true;
                tempHigh = Station.getTrainsList().get(i).getHighClassTakenSeats();
                tempMid = Station.getTrainsList().get(i).getMidClassTakenSeats();
                tempLow = Station.getTrainsList().get(i).getLowClassTakenSeats();
                int highSeatsPrice = tempHigh * ticketHigh;
                int midSeatsPrice = tempMid * ticketMid;
                int lowSeatsPrice = tempLow * ticketLow; 
                int tempTotalPrice = highSeatsPrice + midSeatsPrice + lowSeatsPrice;
                totalTickets += tempHigh + tempMid + tempLow;
                totalFare += tempTotalPrice;
                System.out.println("Train: " + Station.getTrainsList().get(i).getId() 
                        + "\n total High Class tickets: " + tempHigh + "\n fare: $" + highSeatsPrice 
                        + "\n total Mid Class tickets: " + tempMid + "\n fare: $" + midSeatsPrice 
                        + "\n total Low class tickets: " + tempLow + "\n fare: $" + lowSeatsPrice
                        + "\n with total fare: $" + tempTotalPrice);
            }         
        }
        if (!found) {
            System.out.println("No trains with origin: " + origin + " and destination: " + destination + " were found.\n");
        }
        else {
            System.out.println("-----------------------\n total tickets of all trains: " + totalTickets
                                + "\n with total fare: $" + totalFare + "\n");
        }
        
    }
    @Override
    public String toString() {
        return "Admin info: " + "id=" + super.getId() + ", name=" + super.getName() + ", username=" + super.getUsername() + ", password=" + super.getPassword() + "\n";
    }
    @Override
    public void displayOptions() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Welcome to Cairo Monorail Ticket booking System Admin Panel");

        while(true){
            System.out.println("Please, choose one of the following options\n1- Modify Account\n2- Add/ Remove/ Update Trains\n3- Generate reports for specific routes\n4- Exit");
            int AdminChoice = input.nextInt();
            if(AdminChoice == 1){
                
                System.out.println("choose element you want to change \n1- Username\n2- Password\n3- Name\n4- All of them\n5- Come back to main list");
                int tempChoice = input.nextInt();
                switch(tempChoice){
                    case 1:
                System.out.println("Submit new Username: ");
                
                String newUserName = input.next();
                setUsername(newUserName);   
                break;
                    case 2:
                System.out.println("Submit the new Password: ");
                String newPassword = input.next();
                setPassword(newPassword);
                break;
                    case 3: 
                System.out.println("Submit the new Name: ");
                String newName = input.next();
                setName(newName);
                break;
                    case 4:
                System.out.println("Submit new Username: ");
                String newUserNameWithAll = input.next();
                setUsername(newUserNameWithAll);  
                
                System.out.println("Submit the new Password: ");
                String newPasswordWithAll = input.next();
                setPassword(newPasswordWithAll);
                
                System.out.println("Submit the new Name: ");
                String newNameWithAll = input.next();
                setName(newNameWithAll);
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
                System.out.println("Submit New Train Data: ");
                System.out.println("Time slot: ");
                int tempTimeSlot = input.nextInt();
                String tempOrigin, tempDestination;
                int tempDistance, tempPrice;
                
                System.out.println("Submit the origin of the route: ");
                tempOrigin = input.next();
                System.out.println("Submit the desination of the route: ");
                tempDestination = input.next();
                System.out.println("Submit the Distance of the route: ");
                tempDistance = input.nextInt();
                System.out.println("Submit the price of the route: ");
                tempPrice = input.nextInt();
                
                Route tempRoute = new Route(tempOrigin, tempDestination, tempDistance,tempPrice);
                Train trainTemp = new Train(tempRoute, tempTimeSlot);
                Station.getTrainsList().add(trainTemp);
                System.out.println("Train added successfully!");
                break;
                    case 2: 
                        System.out.println("Please submit train id to remove from the station: ");
                        int tempId = input.nextInt();
                        int found = -1;
                       for (int i=0; i<Station.getTrainsList().size(); i++)
                        {
                            Train temp = Station.getTrainsList().get(i);            
                            if (temp.getId() == tempId) {
                                found = i;
                                break;
                            }
                        }
                       if(found != -1){
                           Station.getTrainsList().remove(found);
                           System.out.println("Train with id " + tempId + " Got deleted succesfully");
                       } else{
                           System.out.println("Train with id " + tempId + " Isn't found in the Station");
                       }
                break;
                    case 3:  
                System.out.println("Submit id of the train you want to change its route: ");
                int tempTrainId = input.nextInt();
                int found2 = -1; //called it found2, as compiler reads "found" variable from the previous case in the same scope, so it fails to declare it again
                 for (int i=0; i<Station.getTrainsList().size(); i++)
                {
                 Train temp = Station.getTrainsList().get(i);            
                 if (temp.getId() == tempTrainId){
                    found2 = i;
                    break;
                }
                }
               if(found2 != -1){
                
                System.out.println("Submit the origin of the route: ");
                tempOrigin = input.next();
                System.out.println("Submit the desination of the route: ");
                tempDestination = input.next();
                System.out.println("Submit the Distance of the route: ");
                tempDistance = input.nextInt();
                System.out.println("Submit the price of the route: ");
                tempPrice = input.nextInt();
                
                Route newRoute = new Route(tempOrigin,tempDestination,tempDistance,tempPrice);
                Station.getTrainsList().get(found2).setRoute(newRoute);
                
                System.out.println("Train with id " + tempTrainId + "'s route got updated succesfully");
               } else{
                   System.out.println("Train with id " + tempTrainId + " Isn't found in the Station");
               }
                break;
               
                    case 4: 
                System.out.println("Submit id of the train you want to change its route: ");
                int TrainId = input.nextInt(); 
                int found3 = -1;
                for (int i=0; i<Station.getTrainsList().size(); i++)
                {
                 Train temp = Station.getTrainsList().get(i);            
                 if (temp.getId() == TrainId){
                 found3 = i;
                 break;
                }
                 
                }
                if(found3 != -1){
                System.out.println("Submit new timeslot: ");
                int newTimeSlot = input.nextInt();
                Station.getTrainsList().get(found3).setTimeSlot(newTimeSlot);
                    System.out.println("Train with id " + TrainId + "'s Timeslot got updated succesfully");
                } else {
                   System.out.println("Train with id " + TrainId + " Isn't found in the Station");
               }
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
                    System.out.println("Report about Passengers in this route: " + tempOriginForFare + " -> " + tempDestinationForFare + ":");
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
    }
    
}

