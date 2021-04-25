/*
 *  Group 9
 *  Author: 
 */
package Person;

public class Passenger extends Person {
    
    public Passenger(String name, String username, String password) {
        super(name, username, password);
    }

    public Passenger(String username, String password) {
        super(username, password);
    }
    

    @Override
    public void displayOptions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
 }
    
