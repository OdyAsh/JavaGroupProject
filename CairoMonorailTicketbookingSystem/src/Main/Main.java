/*
 *  Group 9
 *  Author: Ashraf 196280
 */
package Main;
import GUIGeneral.UserType;
import java.util.ArrayList;
import java.util.Scanner;
import Person.*;
import Station.*;
import Transportation.*;

public class Main {
   
    public static void main(String[] args) throws Exception {
        //1.create 3 train objects in station, 2 admins and 3 passengers using different constructors
        //2. prompt user if he is admin or passenger using switch case
        //3. if passenger: prompt to create account or login. If admin, ask for login details directly
        //4. displayOptions() of passenger/admin
        //^^^phase 1 steps
        
        //Below code is commented, as it is run one time only to input data to TrainsList, AdminsList, PassengersList text files respectively,
        //data is commented for reference about the initial data that you will find the text files
        /*
        Station.getTrainsList().add(new Train(new Route("cairo", "alexandria", 5), 13));
        Station.getTrainsList().add(new Train(new Route("cairo", "alexandria", 5), 15));
        ArrayList <String> stopStations = new ArrayList<>();
        stopStations.add("cairo");
        Station.getTrainsList().add(new Train(new Route("luxor", "mansoura", 80, 10), 7, stopStations, 70));
        
        Station.getAdminsList().add(new Admin("abdelfattah78", "admin123"));
        Station.getAdminsList().add(new Admin("fathy87", "admin456"));
        
        Station.getPassengersList().add(new Passenger("Mahmmoud Ashraf", "ash7ooda123", "pass123"));
        Station.getPassengersList().add(new Passenger("AmroAbdo456", "pass456"));
        Station.getPassengersList().add(new Passenger("KhaledList", "pass696badumbist"));
        
        Station.setPassengersList(Station.getPassengersList()); //Creating a new file for passengers
        */
        
        UserType ut = new UserType();
        ut.setVisible(true);
        
        //Phase 1 code
        /*
        Scanner input = new Scanner(System.in);
        int userType, userPlace;
        do {
            System.out.println("Enter user type (1 or 2):\n1 - Admin\n2 - Passenger\nAny other number - Exit");
            userType = input.nextInt();
            input.nextLine();
            
            switch(userType) {
                case 1:
                    System.out.println("login:");
                    userPlace = login(userType);
                        if (userPlace == -1) {
                            System.out.println("Returning to previous screen...");
                            break;
                        }
                        Station.getAdminsList().get(userPlace).displayOptions();
                        break; 
                        
                case 2: 
                    System.out.println("Do you want to login (1) or sign up (2)?\n1 - Login\n2 - Sign up");
                    int accountChoice = input.nextInt();
                    input.nextLine();
                    if (accountChoice == 1) {
                        userPlace = login(userType);
                        if (userPlace == -1) {
                            System.out.println("Returning to previous screen...");
                            break;
                        }
                        Station.getPassengersList().get(userPlace).displayOptions();
                    }
                    else if (accountChoice == 2) {
                        userPlace = signUp(userType);
                        if (userPlace == -1) {
                            System.out.println("returning to previous screen...");
                            break;
                        }
                        Station.getPassengersList().get(userPlace).displayOptions();
                    }
                    break;
                    
                default:
                    System.out.println("Thanks for using our system!\n");
            }
                
        } while (userType == 1 || userType == 2);
        */
    }
    
}
