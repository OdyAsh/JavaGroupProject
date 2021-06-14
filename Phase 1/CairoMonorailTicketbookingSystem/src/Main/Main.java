/*
 *  Group 9
 *  Author: Ashraf 196280
 */
package Main;
import java.util.ArrayList;
import java.util.Scanner;
import Person.*;
import Station.*;
import Transportation.*;

public class Main { 
    /*
    checks user's credentials and returns the index of the user object if he is stored in our system,
    and returns -1 otherwise
    */
    public static int login(int userType) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter username: ");
        String uName = input.nextLine();
        System.out.println("Please Enter password: ");
        String uPass = input.nextLine();
        boolean found = false;
        if (userType == 1) {
            for (int i = 0; i < Station.getAdminsList().size(); i++) {
                Admin ad = Station.getAdminsList().get(i);
                if (uName.equals(ad.getUsername()) && uPass.equals(ad.getPassword())) {
                    System.out.println("Login Successful!");
                    return i;
                }
            }
        }
        else if (userType == 2) {
            for (int i = 0; i < Station.getPassengersList().size(); i++) {
                Passenger pa = Station.getPassengersList().get(i);
                if (uName.equals(pa.getUsername()) && uPass.equals(pa.getPassword())) {
                    System.out.println("Login Successful!");
                    return i;
                }
            }
        }
        
        System.out.println("Invalid username/password...\nWould you like to try again? (yes: 1, no: any other number)");
        int tryAgain = input.nextInt();
        if (tryAgain == 1) {
            return login(userType);
        }
        else {
            System.out.println("invalid type of user...");
            return -1;
        }
    }
    
    /*
    adds passenger's info in the system and returns the index of the final element in the arrayList
    which points to this newly added person if signed up successfuly, returns -1 otherwise
    note that even though there is code that could add an admin into the system,
    it is never executed as the project description specifies that the admin could only login into an already existing account,
    so userType in the parameter will never be for admin as this argument will never be passed in main()
    */
    public static int signUp(int userType) {
           Scanner input = new Scanner(System.in);
           String uUserName, uPass, uName;
           System.out.println("Enter username: ");
           uUserName = input.nextLine();
           if (Station.findUserName(uUserName) != -1) {
               System.out.println("Username already taken...");
               System.out.println("would you like to try again? (1 if yes, any other number otherwise)");
               int tryAgain = input.nextInt();
               input.nextLine();
               return (tryAgain==1 ? signUp(userType) : -1);
           }
           System.out.println("Enter password: ");
           uPass = input.nextLine();
           System.out.println("Enter display name (type \"no\" if you want it to be the same as username): ");
           uName = input.nextLine();
           uName = ("no".equals(uName) ? uUserName : uName);
           
        switch (userType) {
            case 1:
                Station.getAdminsList().add(new Admin(uName, uUserName, uPass));
                return Station.getAdminsList().size() - 1;
            case 2:
                Station.getPassengersList().add(new Passenger(uName, uUserName, uPass));
                return Station.getPassengersList().size() - 1;
            default:
                System.out.println("invalid type of user...\nwould you like to try again? (1 if yes, any other number otherwise)");
                int tryAgain = input.nextInt();
                input.nextLine();
                return (tryAgain==1 ? signUp(userType) : -1);
        }
           
    }
    
    public static void main(String[] args) {
        //1.create 3 train objects in station, 2 admins and 3 passengers using different constructors
        //2. prompt user if he is admin or passenger using switch case
        //3. if passenger: prompt to create account or login. If admin, ask for login details directly
        //4. displayOptions() of passenger/admin
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
        
    }
}
