import java.util.Scanner;
import java.util.InputMismatchException;
import java.text.*;

/**
 * HR - A program that will allow users to add employee objects to an array
 *      to compare salaries and also to print out all employees
 * 
 *
 * @author Ligeralde James
 * @assignment HR
 * @date September 11, 2022
 */

public class HR {

  public static void main (String[] args) {
    // The roster number is declared and initialized as a constant

    final int ROSTER_NUMBER = 5;
    Employee[] employeeList = new Employee[ROSTER_NUMBER];
    // The variables for the employee object parameters and their
    // input variables for bounds checking
    String menuAnswer = "";
    int enumb = 0;
    int inputEnumb = 0;
    double salary = 0;
    double inputSalary = 0;
    String name = "";
    String inputName = "";
    // Match variables to let user know if no matches are made
    int enumbMatches = 0;
    int salaryMatches = 0;
    
    // Simple message to describe what program does
    System.out.printf("This program will allow you to build a roster list of%n" +
                      "employees which you can edit, compare, and print out.%n");
    
    // Using do while loop to ensure menu returns if 0 is not selected
    do {
      
      // This is a menu that describes the 5 selectable options
      System.out.printf("%nPlease select and enter a number to choose an option:%n" +
                        "%n" +
                        "1) Add a New Employee%n" +
                        "2) Remove an Employee%n" +
                        "3) Print Employees that Earn More Than a Given Amount%n" +
                        "4) Print All the Employees%n" +
                        "0) End Program%n%n" +
                        "Enter option here: ");
      
      // Two scanners initialized here to take in numbers or strings
      Scanner reader1 = new Scanner(System.in);
      Scanner reader2 = new Scanner(System.in);
      
      // Try catch block here not needed for String input
      try {
        // Switch case used to integrate menu options
        // String input read to prevent InputMismatchException
        menuAnswer = reader2.nextLine();
         
        switch (menuAnswer) {
            
          // Option 1 will be used to add new employee objects
          // Each parameter of a new employee must be input first before
          // new employee is created 
          // Duplicates cannot be made - Employee numbers be checked
          // first before adding new employee
          case "1":
            System.out.printf("Add a new employee%n");
            System.out.printf("======%n");
            System.out.printf("Enter New Employee Number: ");
            // Because Employee Number is an integer with specific range
            // Try Catch is used to prevent entering non-integers
            // and If Else is used to prevent entering integers
            // outside of range
            try {
              inputEnumb = reader1.nextInt();
              if ((10001 <= inputEnumb) && (inputEnumb <= 99999)) {
                enumb = inputEnumb;
                // Only prompt for inputSalary if inputEnumb is validated
                // Try Catch and If Else implemented again since input must be
                //double value within specified range
                System.out.printf("Enter New Employee Salary: ");
                try {
                  inputSalary = reader1.nextDouble();
                  if ((0 <= inputSalary) && (inputSalary <= 500000)) {
                    salary = inputSalary;     
                    // Again only prompt for inputName is inputSalary
                    // is validated
                    System.out.printf("Enter New Employee Name: ");
                      inputName = reader2.nextLine();
                      // Input is String object, so Try Catch not needed
                      // If Else prevents names too short from passing
                      if (2 <= inputName.length()) {
                        name = inputName;
                        try {
                          // Once all inputs are validated, new Employee
                          // object can be created
                          Employee newEmployee = new Employee(enumb, salary, name);
                          // Boolean variable is declared and initialized
                          // to be used search for preexisting enumbs in array
                          boolean found = false;
                          int toFind = inputEnumb;
                          // For Loop will loop through array checking
                          // for all indices without Null values to match
                          // with added Employee objects
                          for (int i = 0; i < employeeList.length; i++) {
                            if(employeeList[i] != null) {
                              if(employeeList[i].getEnumb()==(toFind)) {
                                System.out.printf("======%n");
                                System.out.println("That employee number already exists");
                                System.out.printf("Therefore employee not added%n");
                                found = true;
                                System.out.printf("======%n");
                              }
                              
                            }
                          }
                          // If no duplicates exist, new employee is added to array
                          if(!found) {
                          
                            for (int i = 0; i < employeeList.length; i++) {
                              if(employeeList[i] == null) {
                                employeeList[i] = newEmployee;
                                System.out.printf("======%n");
                                System.out.println("Employee added");
                                System.out.printf("======%n");
                                // Prevents duplicates from being added to other null index
                                break;
                              }
                              // Let's user know if roster is full
                              if(i == 4) {
                                System.out.printf("======%n");
                                System.out.println("Employee roster is currently full." +
                                                   " Please delete an existing employee" +
                                                   " first to add another");
                                System.out.printf("======%n");
                              }
                            }
                                                                
                          } // Closes if(!found)
                                 
                        }
                        catch (EmployeeException ee) {
                          System.out.println(ee);
                        }
                      }    
                      else {
                        System.out.printf("%s is an invalid name, and" +
                                          " should be at least" +
                                          " two characters long%n", inputName);
                      }
                  }
                  else {
                    System.out.printf("%f is an invalid value" + 
                                      " and must be a positive" +
                                      " number no greater than" +
                                      " 500000%n", inputSalary);
                  }
                }
                        
                catch(InputMismatchException ie) {
                  System.out.println("Error: Employee salary should be a positive" + 
                                     " number between 0 and 500000 inclusive");  
                }
              }
              else {
                System.out.printf("%d is an invalid value and must" + 
                                  " be between the values 10001 and" +
                                  "  99999%n", inputEnumb);
              }
            } 
            catch(InputMismatchException ie) {
              System.out.println("Error: Employee number should only be a" + 
                                 " number between 10001 and 99999 inclusive");
            }
               
               
            break;
            
          // Option 2 will be used to remove an existing employee object from
          // the employeeList array using enumb
          // If no matching employee exists, a message will be output
          // to state the employee does not exist   
          case "2":
            System.out.printf("Remove an Employee%n");
            System.out.printf("======%n");
            System.out.printf("Enter the employee number of the employee" +
                              " you'd like to remove: ");
            // Because input must be an integer, InputMismatchException
            // will be tried and caught here
            try {
                  
              inputEnumb = reader1.nextInt();
                  
              if ((10001 <= inputEnumb) && (inputEnumb <= 99999)) {
                // This variable can be matched with currently stored
                // Employee Numbers in array
                int toFind = inputEnumb;
                for (int i = 0; i < employeeList.length; i++) {
                  if(employeeList[i] != null) {
                    if(employeeList[i].getEnumb()==(toFind)) {
                      System.out.printf("======%n");
                      System.out.println("Employee found and removed");
                      System.out.printf("======%n");
                      // Removes entered Employee by changing it to Null
                      employeeList[i] = null;
                      enumbMatches++;
                    }
                  }
                }
                // Prints message for cases where input within valid range
                // does not match a case
                if(enumbMatches == 0) {
                  System.out.printf("======%n");
                  System.out.printf("Employee Number not found in current" +
                                    " roster%n");
                  System.out.printf("Therefore could not remove employee.%n");
                  System.out.println("Operation finished");
                  System.out.printf("======%n");
                }
              }
              else {
                System.out.printf("Invalid value. Employee numbers start from" +
                                  " 10001 and end at 99999%n");
              }
            }
            catch(InputMismatchException ie) {
              System.out.println("Please enter an integer value between" +
                                 " 10001 and 99999 inclusive");
            }
            break;
            
          // Option 3 will allow the user to print out all employees in the
          // array with a salary above a provided amount  
          case "3":
            System.out.printf("Print Employees that Earn More Than a Given Amount%n");
            System.out.printf("======%n");
            System.out.printf("Enter a salary value: ");
            // Try Catch and If Else again used to bounds check and prevent String
            // and char input
            try {
              inputSalary = reader1.nextDouble();
              
              // DecimalFormat declared and initialized here to format salary value
              DecimalFormat formatter = new DecimalFormat("$###,###.00");
              
              System.out.printf("Printing employees with salary over " +
                                formatter.format(inputSalary) + "%n");
              System.out.println("======");
                for (int i=0; i < employeeList.length; i++) {
                  if(employeeList[i] != null) {
                    if(employeeList[i].getSalary() > inputSalary) {
                      System.out.println(employeeList[i].toString());
                      salaryMatches++;
                      System.out.println("======");
                    }
                    else if(salaryMatches == 0) {
                      System.out.printf("No employees make above " +
                                        formatter.format(inputSalary) +
                                        "%n");
                      salaryMatches++;
                    }
                  }
                        
                }
                if(salaryMatches == 0) {
                  System.out.printf("There are currently no employees in" +
                                    " the roster%n");
                }
                System.out.println("Operation finished");
                System.out.printf("======%n");
             }
             catch (InputMismatchException ie) {
               System.out.println("Error: The salary value can only be a number");
             }
             break;
            
           // Option 4 will simply print out all employees currently added
           // to the employeeList array  
           case "4":
             System.out.printf("Printing All Listed Employees:%n%n");
             System.out.printf("======%n");
             for (int i = 0; i < employeeList.length; i++) {
               if(employeeList[i] != null) {
                 System.out.println(employeeList[i].toString());
                 enumbMatches++;
                 System.out.println("======");
            
               }
             }
             if(enumbMatches == 0) {
               System.out.printf("There are currently no employees in" +
                                 " the roster%n");
             }
             System.out.println("Operation finished");
             System.out.printf("======%n");
             break;
            
           // The 0 option will simply print a statement saying the program
           // is ending, then stop the loop  
           case "0":
             System.out.printf("======%n");
             System.out.printf("Ending Program.%n");
             break;
           // In the event user enters a number outside the menu options  
           default:
             System.out.printf("That number is not an option." +
                               " Please enter a number between 0 and 4%n");
             break;
            
        }
         
      }
      catch (InputMismatchException ie) {
        System.out.printf("Error: Correct menu options are" +
                          " only 0, 1, 2, 3, and 4. Select one.%n");
      }
    }
    // Allows menu to loop infinitely until user enters 0
    while (!menuAnswer.equals("0"));
   
   
  }

}