/*
 *  Group 9
 *  Author: Ashraf
 */
package Person;
//the idCounter generates the id of each object created, in order to avoid id duplicates if the id was manually entered per object creation
//this logic is used in the following classes:
//Person: 100
//Train: 300
//Ticket: 400
public abstract class Person {
    private static int idCounter = 100;
    private int id;
    private String name;
    private String username;
    private String password;
    
    
    //in admin:
    //display options of adding, removing, or updating train from the station class. 
    //Also provides an option to generate report of total fare and passengers 
    //in the trains that take a specific route
    //in passenger:
    //display options of booking, cancelling, or updating train reservation.
    public abstract void displayOptions();

    @Override
    public String toString() {
        return "Basic info: " + "id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + "\n";
    }
    
    public Person(String name, String username, String password) {
        Person.idCounter += 1;
        this.id = Person.idCounter;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public Person(String username, String password) {
        Person.idCounter += 1;
        this.id = Person.idCounter;
        this.name = username;
        this.username = username;
        this.password = password;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
