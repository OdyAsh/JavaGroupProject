/*
 *  Group 9
 *  Author: Abdo
 */

package Station;

import java.util.ArrayList;
import Person.*;
import Transportation.Train;
import java.util.Scanner;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import UserDefinedExceptions.SignUpUserNameException;

public class Station {
    private static ArrayList<Passenger> passengersList = new ArrayList<Passenger>();
    private static ArrayList<Train> trainsList = new ArrayList<Train>();
    private static ArrayList<Admin> adminsList = new ArrayList<Admin>();

    public Station() {
        
    }
    
    /*
    checks that username is unique in our system (no other person has this username)
    */
    public static int findUserName(String uUserName) throws Exception {
        Scanner input = new Scanner(System.in);
        for (int i = 0 ; i < Station.getAdminsList().size() ; i++) {
               if (uUserName.equals(Station.getAdminsList().get(i).getUsername())) {
                   return i;
               }
           }
        for (int i = 0 ; i < Station.getPassengersList().size() ; i++) {
               if (uUserName.equals(Station.getPassengersList().get(i).getUsername())) {
                   return i;
               }
           }
        return -1;
    }
    
    /*
    checks user's credentials and returns the object of the user if he is stored in our system,
    and returns null otherwise
    */
    public static Person login(int userType, String uUsername, String uPass) throws Exception {
        /*
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter username: ");
        String uName = input.nextLine();
        System.out.println("Please Enter password: ");
        String uPass = input.nextLine();
        */
        
        boolean found = false;
        if (userType == 1) {
            for (int i = 0; i < Station.getAdminsList().size(); i++) {
                Admin ad = Station.getAdminsList().get(i);
                if (uUsername.equals(ad.getUsername()) && uPass.equals(ad.getPassword())) {
                    //System.out.println("Login Successful!");
                    return Station.getAdminsList().get(i);
                }
            }
        }
        else if (userType == 2) {
            for (int i = 0; i < Station.getPassengersList().size(); i++) {
                Passenger pa = Station.getPassengersList().get(i);
                if (uUsername.equals(pa.getUsername()) && uPass.equals(pa.getPassword())) {
                    //System.out.println("Login Successful!");
                    return Station.getPassengersList().get(i);
                }
            }
        }
        /*
        System.out.println("Invalid username/password...\nWould you like to try again? (yes: 1, no: any other number)");
        int tryAgain = input.nextInt();
        if (tryAgain == 1) {
            return login(userType);
        }
        else {
            System.out.println("invalid type of user...");
            return -1;
        }
        */
        //exception
        return null;
    }
    
    /*
    adds passenger's info in the system and returns the index of the final element in the arrayList
    which points to this newly added person if signed up successfuly, returns null otherwise
    note that even though there is code that could add an admin into the system,
    it is never executed as the project description specifies that the admin could only login into an already existing account,
    so userType in the parameter will never be for admin as this argument will never be passed in main()
    */
    public static Person signUp(int userType, String uName, String uUserName, String uPass) throws Exception {
           /*
           Scanner input = new Scanner(System.in);
           String uUserName, uPass, uName;
           System.out.println("Enter username: ");
           uUserName = input.nextLine();
           */
           if (Station.findUserName(uUserName) != -1) {
               /*
               System.out.println("Username already taken...");
               System.out.println("would you like to try again? (1 if yes, any other number otherwise)");
               int tryAgain = input.nextInt();
               input.nextLine();
               return (tryAgain==1 ? signUp(userType) : -1);
               */
               throw new SignUpUserNameException(uUserName);
           }
           /*
           System.out.println("Enter password: ");
           uPass = input.nextLine();
           System.out.println("Enter display name (type \"no\" if you want it to be the same as username): ");
           uName = input.nextLine();
           uName = ("no".equals(uName) ? uUserName : uName);
           */
           
        switch (userType) {
            case 1:
                Admin a = new Admin(uName, uUserName, uPass);
                Station.getAdminsList().add(a);
                //todo: Station.setAdminsList(Station.getAdminsList());
                return a;
            case 2:
                Passenger p = new Passenger(uName, uUserName, uPass);
                Station.getPassengersList().add(p);
                Station.setPassengersList(Station.getPassengersList()); //will overwrite the PassengersList.txt file with the new array
                
                return p;
            default:
                /*
                System.out.println("invalid type of user...\nwould you like to try again? (1 if yes, any other number otherwise)");
                int tryAgain = input.nextInt();
                input.nextLine();
                return (tryAgain==1 ? signUp(userType) : -1);
                */
                
                return null;
        }
           
    }

    public static ArrayList<Passenger> getPassengersList() {
        if (passengersList.isEmpty())
        {
            try {
                FileInputStream fis = new FileInputStream("PassengersList.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);
                passengersList = (ArrayList<Passenger>)ois.readObject();
                ois.close();
                fis.close();
            } catch(Exception e) {
                System.out.println("1st time execution to input data, so no file is created yet till setPassengersList() is called...\n");
            }
        }
        return passengersList;
    }

    public static void setPassengersList(ArrayList<Passenger> passengersList) throws Exception {
        FileOutputStream fos = new FileOutputStream("PassengersList.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(passengersList);
        Station.passengersList = passengersList;
        oos.close();
        fos.close();
    }

    public static ArrayList<Train> getTrainsList() {
        return trainsList;
    }

    public static void setTrainsList(ArrayList<Train> trainsList) {
        Station.trainsList = trainsList;
    }

    public static ArrayList<Admin> getAdminsList() {
        return adminsList;
    }

    public static void setAdminsList(ArrayList<Admin> adminsList) {
        Station.adminsList = adminsList;
    }

}
