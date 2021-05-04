/*
 *  Group 9
 *  Author: Abdo
 */
package Station;
import java.util.ArrayList;
import Person.*;
import Transportation.Train;
public class Station {
    private static ArrayList<Passenger> passengersList = new ArrayList<Passenger>();
    private static ArrayList<Train> trainsList = new ArrayList<Train>();
    private static ArrayList<Admin> adminsList = new ArrayList<Admin>();

    public Station() {
        
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
