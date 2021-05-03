//Group 9
//Author: Mahmoud 201573
package Person;

import java.util.ArrayList;
import Transportation.*;
import java.util.Scanner;
public class Admin extends Person {
    ArrayList<Train> arr;

    /**
     *
     * @param username
     * @param password
     * @param arr2
     */
    public Admin(String name,String userName, String password, ArrayList<Train> arr2) {
        super(name, userName, password);
        this.arr = arr2;
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
        for (int i=0; i<arr.size(); i++)
        {
            Train temp = arr.get(i);            
            if (temp.getId() == id)
                arr.remove(id);
                 return  "Train with id " + id + " Got deleted succesfully";
        }
        return "Train with id " + id + " Isn't found in the Station";
    }
    public void addTrain(Route route,int timeslot){
        Train trainTemp = new Train(route, timeslot);
        arr.add(trainTemp);
    }
    public String updateTrainRoute(Route route, int id){
        
        for (int i=0; i<arr.size(); i++)
        {
            Train temp = arr.get(i);            
            if (temp.getId() == id){
                arr.get(id).setRoute(route);
                return  "Train with id " + id + "'s route got updated succesfully";
            }
                 
        }
        return "Train with id " + id + " Isn't found in the Station";
    }
    public String updateTrainTimeSlot(int timeSlotNew, int id){
        for (int i=0; i<arr.size(); i++)
        {
            Train temp = arr.get(i);            
            if (temp.getId() == id){
                arr.get(id).setTimeSlot(timeSlotNew);
                return  "Train with id " + id + "'s Timeslot got updated succesfully";
            }
                 
        }
        return "Train with id " + id + " Isn't found in the Station";
    }
    
    public void getTotalPassengersInSpecificRoute(String origin,String destination){
        int tempTotal = 0, tempHigh = 0,tempMid = 0 , tempLow = 0;
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i).getRoute().getOrigin().equals(origin) && arr.get(i).getRoute().getDestination().equals(destination)){
                tempTotal += arr.get(i).getHighClassTakenSeats() + arr.get(i).getLowClassTakenSeats() + arr.get(i).getMidClassTakenSeats();
                tempHigh = arr.get(i).getHighClassTakenSeats();
                tempMid = arr.get(i).getMidClassTakenSeats();
                tempLow = arr.get(i).getLowClassTakenSeats();
                System.out.println("Train: " + arr.get(i).getId() + "\n Number of High Class Passengers: " + tempHigh + "\n Number Mid Class Passengers: " + tempMid + "\n Number Low Class Passengers: " + tempLow + "\n with total of: " + tempTotal + " Passengers \n");
            } else if(!arr.get(i).getRoute().getOrigin().equals(origin) && !arr.get(i).getRoute().getDestination().equals(destination)){
               continue;
            }
            else{
                System.out.println("This route " + origin + " -> " + destination + " has no trains");
                break;
                    }
        }
        
        
    }
    public void getTotalFareInSpecificRoute(String origin,String destination){
        int tempTotal = 0, tempHigh = 0,tempMid = 0 , tempLow = 0;
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i).getRoute().getOrigin() == origin && arr.get(i).getRoute().getDestination() == destination){
                tempTotal += arr.get(i).getHighClassTakenSeats() + arr.get(i).getLowClassTakenSeats() + arr.get(i).getMidClassTakenSeats();
                tempHigh = arr.get(i).getHighClassTakenSeats();
                tempMid = arr.get(i).getMidClassTakenSeats();
                tempLow = arr.get(i).getLowClassTakenSeats();
                System.out.println("Train: " + arr.get(i).getId() + "\n total of High Class fare: $" + tempHigh + "\n Total of Mid Class fare: $" + tempMid + "\n Total of Low Class fare: $" + tempLow + "\n with total of: $" + tempTotal + "\n");
            } else if(!arr.get(i).getRoute().getOrigin().equals(origin) && !arr.get(i).getRoute().getDestination().equals(destination)){
               continue;
            }
            else{
                System.out.println("This route " + origin + " -> " + destination + " has no trains");
                break;
                    }
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

    public String getUsername() {
        return super.getUsername();
    }

    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String toString() {
        return "Admin{" + "username=" + super.getUsername() + ", password=" + super.getPassword() + ", arr=" + arr + '}';
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

