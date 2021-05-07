/*
 *  Group 9
 *  Author: Abdo
 */
package Station;
import java.util.ArrayList;
import Person.*;
import Transportation.Train;
import java.util.Scanner;
public class Station {
    private static ArrayList<Passenger> passengersList = new ArrayList<Passenger>();
    private static ArrayList<Train> trainsList = new ArrayList<Train>();
    private static ArrayList<Admin> adminsList = new ArrayList<Admin>();

    public Station() {
        
    }
    
    /*
    checks that username is unique in our system (no other person has this username)
    */
    public static int findUserName(String uUserName) {
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

    public static ArrayList<Passenger> getPassengersList() {
        return passengersList;
    }

    public static void setPassengersList(ArrayList<Passenger> passengersList) {
        Station.passengersList = passengersList;
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
