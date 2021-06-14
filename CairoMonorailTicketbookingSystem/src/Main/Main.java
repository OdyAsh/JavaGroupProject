/*
 *  Group 9
 *  Author: Ashraf 196280
 */
package Main;
import Station.*;
import Person.*;
import Transportation.Route;
import Transportation.Train;
import java.util.ArrayList;
public class Main {
   
    public static void main(String[] args) throws Exception {
       // 1.create 3 train objects in station, 2 admins and 3 passengers using different constructors
        //2. prompt user if he is admin or passenger using switch case
        //3. if passenger: prompt to create account or login. If admin, ask for login details directly
        //4. displayOptions() of passenger/admin
        //^^^phase 1 steps
        
        //Below code is commented, as it is run one time only to input data to TrainsList, AdminsList, PassengersList text files respectively,
        //data is commented for reference about the initial data that you will find the text files
        
        //initial trainsList.txt file
        /*
        ArrayList<Integer> timeSlot = new ArrayList<>();
        timeSlot.add(12);
        timeSlot.add(13);
        timeSlot.add(14);
        ArrayList<Integer> timeSlot2 = new ArrayList<>();
        timeSlot2.add(15);
        timeSlot2.add(16);
        ArrayList<Integer> timeSlot3 = new ArrayList<>();
        timeSlot3.add(17);
        Train t = new Train(new Route("cairo", "alexandria", 5), timeSlot);        
        
        Station.getTrainsList().add(new Train(new Route("cairo", "alexandria", 5), timeSlot));
       
        ArrayList <String> stopStations = new ArrayList<>();
        stopStations.add("cairo");
        Station.getTrainsList().add(new Train(new Route("luxor", "mansoura", 80, 10), timeSlot2, stopStations, 70));
        
        Route r=new Route("cairo","mit ghamer",44,12);
        Train T=new Train(r, timeSlot3);
        Station.getTrainsList().add(T);
        
        Station.setTrainsList(Station.getTrainsList());
        */
        System.out.println(Station.getTrainsList());
       
        /* initial AdminsList.txt data
        Station.getAdminsList().add(new Admin("khaledlist", "t123"));
        Station.getAdminsList().add(new Admin("abdelfattah78", "admin123"));
        Station.getAdminsList().add(new Admin("fathy87", "admin456"));
        Station.setAdminsList(Station.getAdminsList());
        */
        //System.out.println(Station.getAdminsList());
        
        
        // initial PassengersList.txt data
        /*
        Station.getPassengersList().add(new Passenger("Mahmmoud Ashraf", "ash7ooda123", "pass123"));
        Station.getPassengersList().add(new Passenger("AmroAbdo456", "pass456")); 
        //^^^most tests are done on this, note that it was changed to username: amro181, password: lol, and this passenger is now booked to first train with 1 ticket in timeslot 12 and 1 in 13
        Station.getPassengersList().add(new Passenger("KhaledList", "pass696badumbist"));
        Station.setPassengersList(Station.getPassengersList()); //Creating a new file for passengers
        */
        //System.out.println(Station.getPassengersList());
        
       // UserType ut = new UserType();
       // ut.setVisible(true);
        
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
