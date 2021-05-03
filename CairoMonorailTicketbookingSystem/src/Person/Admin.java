//Group 9
//Author: Mahmoud 201573
package Person;

import java.util.ArrayList;
import Transportation.*;
import Station.Station;
import java.util.Scanner;
public class Admin extends Person {

    /**
     *
     * @param name
     * @param userName
     * @param password
     */
    public Admin(String name,String userName, String password) {
        super(name, userName, password);
    }

    public Admin(String username, String password) {
        super(username, password);
    }

    public void changeName(String name){
        super.setName(name);
    }
    public void changeUsername(String username){
        super.setUsername(username);
    }
    public void changepPassword(String newPassword){
       super.setPassword(newPassword);
    }
    
    public String deleteTrain(int id){  
        for (int i=0; i<Station.getTrainsList().size(); i++)
        {
            Train temp = Station.getTrainsList().get(i);            
            if (temp.getId() == id)
                Station.getTrainsList().remove(id);
                 return  "Train with id " + id + " Got deleted succesfully";
        }
        return "Train with id " + id + " Isn't found in the Station";
    }
    public void addTrain(Route route,int timeslot){
        Train trainTemp = new Train(route, timeslot);
        Station.getTrainsList().add(trainTemp);
    }
    public String updateTrainRoute(Route route, int id){
        
        for (int i=0; i<Station.getTrainsList().size(); i++)
        {
            Train temp = Station.getTrainsList().get(i);            
            if (temp.getId() == id){
                Station.getTrainsList().get(id).setRoute(route);
                return  "Train with id " + id + "'s route got updated succesfully";
            }
                 
        }
        return "Train with id " + id + " Isn't found in the Station";
    }
    public String updateTrainTimeSlot(int timeSlotNew, int id){
        for (int i=0; i<Station.getTrainsList().size(); i++)
        {
            Train temp = Station.getTrainsList().get(i);            
            if (temp.getId() == id){
                Station.getTrainsList().get(id).setTimeSlot(timeSlotNew);
                return  "Train with id " + id + "'s Timeslot got updated succesfully";
            }
                 
        }
        return "Train with id " + id + " Isn't found in the Station";
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
        
        
//        int tempHigh = 0,tempMid = 0 , tempLow = 0;
//        for(int i = 0; i < arr.size(); i++){
//            if(arr.get(i).getRoute().getOrigin() == origin && arr.get(i).getRoute().getDestination() == destination){
//                tempHigh += arr.get(i).getHighClassTakenSeats(); 
//                tempLow += arr.get(i).getLowClassTakenSeats();
//                tempMid += arr.get(i).getMidClassTakenSeats();
//            }
//        
//        }
//        return (tempHigh * 20) + (tempMid * 15) + (tempLow * 10);
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
            input.nextLine();
            if(AdminChoice == 1){
                System.out.println("choose element you want to change \n1- Username\n2- Password\n3- Name\n4- All of them\n5- Come back to main list");
                int tempChoice = input.nextInt();
                switch(tempChoice){
                    case 1:
                System.out.println("Submit new Username: ");
                String newUserName = input.nextLine();
                changeUsername(newUserName);   
                break;
                    case 2:
                System.out.println("Submit the new Password: ");
                String newPassword = input.nextLine();
                changepPassword(newPassword);
                break;
                    case 3: 
                System.out.println("Submit the new Name: ");
                String newName = input.nextLine();
                changeName(newName);
                break;
                    case 4:
                System.out.println("Submit new Username: ");
                String newUserNameWithAll = input.nextLine();
                changeUsername(newUserNameWithAll);  
                
                System.out.println("Submit the new Password: ");
                String newPasswordWithAll = input.nextLine();
                changepPassword(newPasswordWithAll);
                
                System.out.println("Submit the new Name: ");
                String newNameWithAll = input.nextLine();
                changeName(newNameWithAll);
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
                input.nextLine();
                // String origin, String destination, int distance, int routePrice
                String tempOrigin, tempDestination;
                int tempDistance, tempPrice;
                
                System.out.println("Submit the origin of the route: ");
                tempOrigin = input.nextLine();
                System.out.println("Submit the desination of the route: ");
                tempDestination = input.nextLine();
                System.out.println("Submit the Distance of the route: ");
                tempDistance = input.nextInt();
                System.out.println("Submit the price of the route: ");
                tempPrice = input.nextInt();
                
                Route tempRoute = new Route(tempOrigin, tempDestination, tempDistance,tempPrice);
                
                addTrain(tempRoute, tempTimeSlot);
                break;
                    case 2: 
                        System.out.println("Please submit train id to remove from the station: ");
                        int tempId = input.nextInt();
                        deleteTrain(tempId);
                break;
                    case 3:   
                        
                System.out.println("Submit id of the train you want to change its route: ");
                int tempTrainId = input.nextInt();
                input.nextLine();
                
                System.out.println("Submit the origin of the route: ");
                tempOrigin = input.nextLine();
                System.out.println("Submit the desination of the route: ");
                tempDestination = input.nextLine();
                System.out.println("Submit the Distance of the route: ");
                tempDistance = input.nextInt();
                System.out.println("Submit the price of the route: ");
                tempPrice = input.nextInt();
                
                Route newRoute = new Route(tempOrigin, tempDestination, tempDistance,tempPrice);    
                updateTrainRoute(newRoute, tempTrainId);
                break;
                    case 4: 
                    
                System.out.println("Submit id of the train you want to change its route: ");
                int TrainId = input.nextInt(); 
                
                System.out.println("Submit new timeslot: ");
                int newTimeSlot = input.nextInt();
                updateTrainTimeSlot(newTimeSlot, TrainId);
                    default:
                 break;
                }
                
            } else if(AdminChoice == 3){
                System.out.println("Choose which action you want to perform\n1- Generate report for number of passengers\n2- Generate report for total fare\n3- Come back to the main list ");
                int tempChoice = input.nextInt();
                input.nextLine();
                switch(tempChoice){
                    case 1:        
                        System.out.println("Submit origin: ");
                        String tempOrigin = input.nextLine();
                        System.out.println("Submit Destination: ");
                        String tempDestination = input.nextLine();
                        System.out.println("Report about Passengers in this route:" + tempOrigin + " -> " + tempDestination+ "----------------------------------"); 
                        getTotalPassengersInSpecificRoute(tempOrigin,tempDestination);
                break;
                    case 2: 
                    System.out.println("Submit origin: ");
                    String tempOriginForFare = input.nextLine();
                    System.out.println("Submit Destination: ");
                    String tempDestinationForFare = input.nextLine(); 
                    System.out.println("Report about Passengers in this route:" + tempOriginForFare + " -> " + tempDestinationForFare + "----------------------------------"); 
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

