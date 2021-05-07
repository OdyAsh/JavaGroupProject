/*
 *  Group 9
 *  Author: Amro Sherif 201762
 */
package Person;
import Station.*;
import Transportation.*;
import java.util.*;

public class Passenger extends Person {
    private HashMap <Integer, ArrayList<Ticket>> passengerTickets;
    
    public Passenger(String name, String username, String password) {
        super(name, username, password);
        passengerTickets = new HashMap<Integer, ArrayList<Ticket>>();
    }

    public Passenger(String username, String password) {
        super(username, password);
        passengerTickets = new HashMap<Integer, ArrayList<Ticket>>();
    }
    
    //This function returns the index of a train with specific route and time slot or -1 if not found.
    private int findTrain(String source, String destination, int timeSlot){
        for(int i = 0;  i < Station.getTrainsList().size();  ++i){
            String currentOrigin = Station.getTrainsList().get(i).getRoute().getOrigin();
            
            String currentDestination = Station.getTrainsList().get(i).getRoute().getDestination();
            
            int currentTimeSlot = Station.getTrainsList().get(i).getTimeSlot();
            
            if(Objects.equals(currentOrigin, source) && Objects.equals(currentDestination, destination) && Objects.equals(currentTimeSlot, timeSlot)){
                return i;    
            }
        }
        return -1;
    }
    
    private void showAvailableTickets(int trainIndex){
        System.out.println("These are the available seats on this train");
        int trainSeatLimit = Station.getTrainsList().get(trainIndex).getSEATNUMLIMIT();
            for(int i = 0; i < trainSeatLimit; ++i){
                if(Station.getTrainsList().get(trainIndex).getTakenSeats()[i] == false){
                    System.out.print((i + 1) + " ");
                }
            }
    }
    
    private void changeName(int currentPassengerPosition){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the new name");
        String newName = input.nextLine();
        
        Station.getPassengersList().get(currentPassengerPosition).setName(newName);
        System.out.println("Your name has been updated successfully");
    }
    
    private void changeUserName(int currentPassengerPosition){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the new username");
        String newUserName = input.nextLine();
        
        int checkUserName = Station.findUserName(newUserName);
        
        if(checkUserName != -1){
            System.out.println("Invalid username");
            return;
        }
        
        Station.getPassengersList().get(currentPassengerPosition).setUsername(newUserName);
        System.out.println("Your username has been updated successfully");
    }
    
    private void changePassword(int currentPassengerPosition){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the new password");
        String newPassword = input.nextLine();
        
        Station.getPassengersList().get(currentPassengerPosition).setPassword(newPassword);
        System.out.println("Your password has been updated successfully");
    }
    
    private void updateBooking(){
        Scanner input = new Scanner(System.in);
        
        if(passengerTickets.isEmpty()){
            System.out.println("You do not have any booked tickets");
            return;
        }
        
        System.out.println("These are your booked tickets");
        displayBookedTickets();
        
        System.out.println("Enter the source, destination, time slot and ticket number");
        String source = input.nextLine(), destination = input.nextLine();        
        int timeSlot = input.nextInt(), ticketNumber = input.nextInt();
        
        System.out.println("Choose one of the following options:\n1- Change seat number\n2- Change time slot");
        int passengerChoice = input.nextInt();
        
        
        int trainIndex = findTrain(source, destination, timeSlot);
        int trainID = Station.getTrainsList().get(trainIndex).getId();
        
        if(passengerChoice == 1){
            showAvailableTickets(trainIndex);
            System.out.println("\nEnter the number of the seat or 0 to terminate the process");
            
            int newSeat = input.nextInt();
            if(newSeat == 0)return;
            
            Station.getTrainsList().get(trainIndex).getTakenSeats()[ticketNumber - 1] = false;
            Station.getTrainsList().get(trainIndex).getTakenSeats()[newSeat - 1] = true;

            //This loop finds the ticket with the previous seat number and change it to the new value.
            for(int i = 0; i < passengerTickets.get(trainID).size(); ++i){
                if(passengerTickets.get(trainID).get(i).getSeatNum() == ticketNumber){
                    passengerTickets.get(trainID).get(i).setSeatNum(newSeat);
                    System.out.println("The ticket has been updated successfully");
                    return;
                }
            }
        }
        else{
            System.out.println("Enter the new time slot");
            int newTimeSlot = input.nextInt();
            
            int newTrainIndex = findTrain(source, destination, newTimeSlot);
            
            if(newTrainIndex == -1 || Station.getTrainsList().get(newTrainIndex).getTakenSeats()[ticketNumber - 1] == true){
                System.out.println("Either the train does not exist or the seat is taken");
                return;
            }
            
            int newTrainID = Station.getTrainsList().get(newTrainIndex).getId();
            
            //This loop searches for the ticket in the old train.
            for(int i = 0; i < passengerTickets.get(trainID).size(); ++i){
                if(passengerTickets.get(trainID).get(i).getSeatNum() == ticketNumber){
                    if(passengerTickets.get(newTrainID) == null){
                        passengerTickets.put(newTrainID, new ArrayList<Ticket>());
                    }
                    //adding the ticket to the new train.
                    passengerTickets.get(newTrainID).add(passengerTickets.get(trainID).get(i));
                    Station.getTrainsList().get(newTrainIndex).getTakenSeats()[ticketNumber - 1] = true;
                    Station.getTrainsList().get(trainIndex).getTakenSeats()[ticketNumber - 1] = false;
                    //removing the ticket from the previous train.
                    passengerTickets.get(trainID).remove(i);
                    break;
                }
            }
            System.out.println("The ticket has been updated successfully");
        }
    }
    
    private void cancelBooking(String source, String destination, int timeSlot){
        Scanner input = new Scanner(System.in);
        
        int trainIndex = findTrain(source, destination, timeSlot);
        
        if(trainIndex == -1){
            System.out.println("There is no train with this details");
            return;
        }
        
        int trainID = Station.getTrainsList().get(trainIndex).getId();
        
        if(passengerTickets.get(trainID) == null || passengerTickets.get(trainID).isEmpty()){
            System.out.println("You do not have any booked tickets on this train");
            return;
        }
        
        System.out.println("These are your booked tickets on this train");
        for(Ticket i : passengerTickets.get(trainID)){
            System.out.print(i.getSeatNum() + " ");
        }
        
        System.out.println("\nEnter the number of the seat or 0 to terminate the process");
        int passengerChoice = input.nextInt();
        
        if(passengerChoice == 0) return;
        
        Station.getTrainsList().get(trainIndex).getBookedPassengers().remove(this);
        Station.getTrainsList().get(trainIndex).getTakenSeats()[passengerChoice - 1] = false;
        //This loop search for the seat number in the train in order to remove it from array list.
        for(int i = 0; i < passengerTickets.get(trainID).size(); ++i){
            if(passengerTickets.get(trainID).get(i).getSeatNum() == passengerChoice){
                passengerTickets.get(trainID).remove(i);
                System.out.println("The ticket has been canceled successfully");
                return;
            }
        }
    }
    
    private void bookTicket(String source, String destination, int timeSlot){
        Scanner input = new Scanner(System.in);
        
        int trainIndex = findTrain(source, destination, timeSlot);
        
        if(trainIndex == -1){
            System.out.println("There is no train heading from " + source + " to " + destination + " in this time slot");
            return;
        }
        
        showAvailableTickets(trainIndex);
        
        System.out.println("\nEnter the number of the seat or enter 0 to terminate the process");
                
        int passengerChoice = input.nextInt();

        if(passengerChoice == 0)return;
        
        //this checks if the passenger has never booked tickets on this train before and if so a key with the value of the train id with an arraylist of tickets will be add to the hash map.
        if(passengerTickets.get(Station.getTrainsList().get(trainIndex).getId()) == null){
            passengerTickets.put(Station.getTrainsList().get(trainIndex).getId(), new ArrayList<Ticket>());
        }
        passengerTickets.get(Station.getTrainsList().get(trainIndex).getId()).add(new Ticket(passengerChoice));
                
        //Marking the seat as booked in this train.
        Station.getTrainsList().get(trainIndex).getTakenSeats()[passengerChoice - 1] = true;
        
        //Adding the current passenger to the array list of passengers in this train.
        Station.getTrainsList().get(trainIndex).getBookedPassengers().add(this);
        System.out.println("Seat Number " + passengerChoice + " has been booked successfully");
    }
    
    private void displayBookedTickets(){
        if(passengerTickets.isEmpty()){
            System.out.println("You do not have any booked tickets");
        }
        else{
            boolean operationDone = false;
            for(HashMap.Entry <Integer, ArrayList<Ticket>> entry : passengerTickets.entrySet()){
                if(entry.getValue().isEmpty())continue;
                
                operationDone = true;
                //this for loop finds the information of the trains in the hash map and then displays the origin, destination and time slot of each train.
                for(Train j : Station.getTrainsList()){
                    if(j.getId() == entry.getKey()){
                        System.out.print(j.getRoute().getOrigin() + "\t" + j.getRoute().getDestination()+ "\t" + j.getTimeSlot() + " :");
                        break;
                    }
                }
                //This loop goes through the array list of tickets in each train in the hash map and displays the seat numbers that the passenger book on this train.
                for(Ticket j : entry.getValue()){
                    System.out.print(" " + j.getSeatNum());
                }
                System.out.print("\n");
            }
            if(operationDone == false){
                System.out.println("You do not have any booked tickets");
            }
        }
    }
    
    //this method is like the interface that the passenger see upon login; it displays all the functionalities that the passenger can do
    @Override
    public void displayOptions() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Welcome to Cairo Monorail Ticket booking System");

        while(true){
            System.out.println("Please, choose one of the following options\n1- Book ticket\n2- Cancel ticket\n3- Update ticket\n4- Display booked tickets\n5- Modify Account\n6- Exit");
            int passengerChoice = input.nextInt();
            input.nextLine();
            if(passengerChoice == 1){
                System.out.println("Enter the source, destination and time slot");
                String source = input.nextLine(); 
                String destination = input.nextLine();
                int timeSlot = input.nextInt();
                bookTicket(source, destination, timeSlot);
            }
            else if(passengerChoice == 2){
                System.out.println("Enter the source, destination and time slot");
                String source = input.nextLine(); 
                String destination = input.nextLine(); 
                int timeSlot = input.nextInt();
                cancelBooking(source, destination, timeSlot);
            }
            else if(passengerChoice == 3){
                updateBooking();
            }
            else if(passengerChoice == 4){
                displayBookedTickets();
            }
            else if(passengerChoice == 5){
                System.out.println("1- Change name\n2- Change username\n3- Change password\n4- All of them\n5- Come back to main list");
                int option = input.nextInt();
                
                int currentPassengerPosition = Station.findUserName(this.getUsername());
                
                if(option == 1){
                    changeName(currentPassengerPosition);
                }
                else if(option == 2){    
                    changeUserName(currentPassengerPosition);
                }
                else if(option == 3){
                    changePassword(currentPassengerPosition);
                }
                else if(option == 4){
                    changeName(currentPassengerPosition);
                    changeUserName(currentPassengerPosition);
                    changePassword(currentPassengerPosition);
                }
                
            }
            else{
                System.out.println("Thank you for using our system");
                return;
            }
        }
    }
    
    
    public HashMap<Integer, ArrayList<Ticket>> getPassengerTickets() {
        return passengerTickets;
    }

    public void setPassengerTickets(HashMap<Integer, ArrayList<Ticket>> passengerTickets) {
        this.passengerTickets = passengerTickets;
    }

 }
    
