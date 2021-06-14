/*
 *  Group 9
 *  Author: 
 */
package UserDefinedExceptions;

//@author Ashraf
public class SignUpUserNameException extends Exception {
    private String err;
    public SignUpUserNameException(String userName)
    {
        err = "The username \""  + userName + "\" is already taken...";
    }
    @Override
    public String toString() {
        return err;
    }
}
