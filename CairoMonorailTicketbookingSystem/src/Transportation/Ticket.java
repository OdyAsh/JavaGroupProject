/*
 *  Group 9
 *  Author: Abdo - Ashraf
 */
package Transportation;

import java.io.Serializable;

public class Ticket implements Serializable{
    private static int idCounter = 400;
    private int id;
    private int seatNum;
    
    public Ticket(int seatNum) {
        idCounter += 1;
        this.id = Ticket.idCounter;
        this.seatNum = seatNum;
    }

    //gets ticket price depending on seat position; 
    //the lower the seat number position, 
    //the higher the quality of the seat, and thus higher ticket price;
    //seats 1 to 10: 20egp
    //seats 11 to 35: 15egp
    //seats 36 to last: 10egp
    public int getSeatPrice() {
        return (seatNum<=10 ? 30 : seatNum<=35 ? 20 : 10);
    }
    

    @Override
    public String toString() {
        return "id: " + id + ", seat no.: " + seatNum;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }
}
