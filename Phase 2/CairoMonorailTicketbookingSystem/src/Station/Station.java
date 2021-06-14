/*
 *  Group 9
 *  Author: Abdo
 */

package Station;

import java.util.ArrayList;
import Person.*;
import Transportation.Route;
import Transportation.Train;
import java.util.Scanner;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import UserDefinedExceptions.SignUpUserNameException;
import java.io.FileNotFoundException;
import java.io.IOException;

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
        boolean found = false;
        if (userType == 1) {
            for (int i = 0; i < Station.getAdminsList().size(); i++) {
                Admin ad = Station.getAdminsList().get(i);
                if (uUsername.equals(ad.getUsername()) && uPass.equals(ad.getPassword())) {
                    return Station.getAdminsList().get(i);
                }
            }
        }
        else if (userType == 2) {
            for (int i = 0; i < Station.getPassengersList().size(); i++) {
                Passenger pa = Station.getPassengersList().get(i);
                if (uUsername.equals(pa.getUsername()) && uPass.equals(pa.getPassword())) {
                    return Station.getPassengersList().get(i);
                }
            }
        }
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
           if (Station.findUserName(uUserName) != -1) {
               throw new SignUpUserNameException(uUserName);
           }
           switch (userType) {
            case 1:
                Admin a = new Admin(uName, uUserName, uPass);
                Station.getAdminsList().add(a);
                Station.setAdminsList(Station.getAdminsList());//will overwrite the AdminsList.txt file with the new array
                return a;
            case 2:
                Passenger p = new Passenger(uName, uUserName, uPass);
                Station.getPassengersList().add(p);
                Station.setPassengersList(Station.getPassengersList()); //will overwrite the PassengersList.txt file with the new array
                return p;
            default:
                return null;
        }
           
    }
    //the logic of handling the files in our program is as follows:
    //1. at the very first time we want to get the passengers array list, the program still won't have any data,
    //so passengersList.isEmpty() will become true, and then the program will check our created PassengersList.txt file to retrieve the data from it,
    //after that, it won't access it again for reading, as it just got the latest data, and any newer data will be in the Station's arraylist, so no need to access the file for reading again,
    //note that when first accessed, the setIdCounter() will make the static counters start at the max id found in the array list (which will be the last element in the arrayList)
    //
    //2. we made the catch print in the CMD, as the user will never see this output, as it displays only if there are no .txt files to begin with, which will never happen while he/she is using our system
    //
    //regarding the setters:
    //1. they are used to write any new data from the station's arrayLists to the respective .txt files by calling the function like this : Station.setPassengersList(Station.getPassengersList());
    public static ArrayList<Passenger> getPassengersList() {
        
        if (passengersList.isEmpty())
        {
            try {
                FileInputStream fis = new FileInputStream("PassengersList.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);
                passengersList = (ArrayList<Passenger>)ois.readObject();
                ois.close();
                fis.close();
                Person.setIdCounter(passengersList.get(passengersList.size()-1).getId());
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

    public static ArrayList<Train> getTrainsList()  {
         if (trainsList.isEmpty())
        {
            try {
                FileInputStream fis = new FileInputStream("trainsList.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);
                trainsList = (ArrayList<Train>)ois.readObject();
                ois.close();
                fis.close();
                Train.setIdCounter(trainsList.get(trainsList.size()-1).getId());
            } catch(Exception e) {
                System.out.println("1st time execution to input data, so no file is created yet till setTrainList() is called...\n");
            }
        }
        return trainsList;
    }
    

    public static void setTrainsList(ArrayList<Train> trainsList) throws Exception {
         FileOutputStream fos = new FileOutputStream("trainsList.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(trainsList);
        Station.trainsList = trainsList;
        oos.close();
        fos.close();
    }

    public static ArrayList<Admin> getAdminsList() {
         if (adminsList.isEmpty())
        {
            try {
                FileInputStream file = new FileInputStream("AdminsList.txt");
                ObjectInputStream output = new ObjectInputStream(file);
                adminsList = (ArrayList<Admin>)output.readObject();
                output.close();
                file.close();
                Person.setIdCounter(adminsList.get(adminsList.size()-1).getId());
            } catch(Exception e) {
                System.out.println("there is no file created yet setAdminsList() should be called first...\n");
            }
        }
        return adminsList;
    }

    public static void setAdminsList(ArrayList<Admin> adminsList) throws Exception {
        FileOutputStream file = new FileOutputStream("AdminsList.txt");
        ObjectOutputStream output = new ObjectOutputStream(file);
        output.writeObject(adminsList);
        Station.adminsList = adminsList;
        output.close();
        file.close();
    }

}
