/*
 *  Group 9
 *  Author: 
 */
package Main;
import java.util.ArrayList;
import java.util.Scanner;
import Person.*;
import Station.*;
import Transportation.*;
public class Main {
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
        
        
        
    }
}
