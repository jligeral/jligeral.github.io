import java.text.*;

/**
 * Employee - Defines an Employee object.
 * Stores information about:
 *   1) Employee number
 *   2) Salary
 *   3) Employee name
 *
 * @author James Ligeralde
 * @assignment A01-Employee
 * @date August 31, 2022
 */


public class Employee {

  /** Information about the Employee object */
  private int enumb = 0;
  private double salary = 0;
  private String name = "";
  
  /**
  * Constructs Employee object.
  *
  * @param enumb The number of the employee.
  * @param salary The salary of the employee.
  * @param name The name of the employee.
  * @exception EmployeeException If emnum is not within the correct range
  *                              If salary is negative or over 500000
  *                              If name is less than 2 characters long
  */
  
  public Employee(int enumb, double salary, String name)
  throws EmployeeException {
    this.setEnumb(enumb);
    this.setSalary(salary);
    this.setName(name);
  }

  /** Accessor Methods */
  public int getEnumb() {
    return this.enumb;
  }
  public double getSalary() {
    return this.salary;
  }
  public String getName() {
    return this.name;
  }
  
  /** 
   * Mutator method for the employee number. Ensures the number is within
   * the valid range of 10001 and 99999 inclusive 
   *
   * @param newEnumb The new employee number
   * @exception EmployeeException If number is less than 10001 or greater than 99999
   */
  
  public void setEnumb(int newEnumb) throws EmployeeException {
    if((newEnumb >= 10001) && (newEnumb <= 99999)) {
      this.enumb = newEnumb;
    }
    else {
      EmployeeException ee = new EmployeeException();
      ee.setMessage("Error: " + newEnumb + " is an invalid employee number and must" +
                    " be between the values of 10001 and 99999.");
      throw ee;
    }
  }
  
  /** 
   * Mutator method for the salary. Ensures the salary is within the range of
   * 0 and 500000 inclusive. 
   *
   * @param newSalary The new salary
   * @exception EmployeeException If salary is less than 0 or greater than 500000
   */
  
  // DecimalFormat declared and initialized here to format salary value
  // for error message and toString output at the end
  DecimalFormat formatter = new DecimalFormat("$###,###.00");
  public void setSalary(double newSalary) throws EmployeeException {
    if((newSalary >= 0) && (newSalary <= 500000)) {
      this.salary = newSalary;
    }
    else {
      EmployeeException ee = new EmployeeException();
      ee.setMessage("Error: " + formatter.format(newSalary) + " is an invalid salary value and must be" +
                    " a positive number less than or equal to 500000.00");
      throw ee; 
    }
  }
  
  /** 
   * Mutator method for the name. Ensure the name is at least 2 characters long
   * or just whitespace. Trims the new name then checks the length
   * of the resulting string. 
   *
   * @param newName The new name
   * @exception EmployeeException If name is length less than 2 after trimming
   */
  
  public void setName(String newName) throws EmployeeException {
    String trimmedName = newName.trim();
    if (trimmedName.length() >= 2) {
      this.name = newName;
    }
    else {
      EmployeeException ee = new EmployeeException(); 
      ee.setMessage("Error: " + newName + " should be at least two characters long.");
      throw ee;
    } 
  }
  
  
  /**
   * Returns a printable String of this object's instance variables.
   * For example, for a new Employee(10001, 0, "John")
   *       Employee Number: 10001
   *                Salary: 0
   *                  Name: John
   *
   * @return output A printable string of this object.
   */
  
  public String toString() {
    // Used to build of a string with all the instance variables on each line.
    String output = "";
    
    // Build the string with all the instance variables on separate lines.
    // this.salary formatted with DecimalFormatter declared above mutator
    // method for salary.
    output += String.format("%17s " + this.enumb, "Employee Number:");
    output += String.format("%n%17s " + formatter.format(this.salary), "Salary:");
    output += String.format("%n%17s " + this.name, "Name:");
    
    return output;
  }
}