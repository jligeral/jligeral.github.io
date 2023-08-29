/**
 * EmployeeException - A checked exception used when validating data
 * for the Employee class.
 * A EmployeeException is thrown when a Employee object is created
 * or modified with invalid data
 *
 * @author Ligeralde James
 * @assignment A01-Employee 
 * @date August 20, 2022
 */


public class EmployeeException extends Exception{

  /** This is the message that will output when the exception happens */
  private String message = "";
  
  /** This is the constructor for EmployeeException */
  public EmployeeException() {
  }
  
  /** This is the set method */
  public void setMessage(String newMessage) {
    this.message = newMessage;
  }
  
  /** This is the get method */
  public String getMessage() {
    return this.message;
  }

}