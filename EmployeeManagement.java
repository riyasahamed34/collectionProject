import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import com.ideas2it.employeeProject.model.Employee;

/**
 * EmployeeManagement for Doing Crud Operation
 *
 * @version  2.0 25-02-2021
 * @author  Riyas Ahamed
 */ 
public class EmployeeManagement {
    static Scanner scanner = new Scanner(System.in);
    Map<Integer, Employee> employeeDetails = new HashMap<Integer, Employee>();
    
    public static void main(String[] args) {
	int menuOption = 0;
	int employeeId = 1;
	EmployeeManagement employeeManagement = new EmployeeManagement();
        String menuDisplay = " 1.Create a NewEmployee " +
		    "\n 2.update the existing Employee" +
		    "\n 3.show employee details \n 4.Delete the employee data" +
		    "\n 5.showALL \n 6.Exit \n";
			
	while (6 != menuOption) {
	    System.out.println("\n Enter the Options \n");
	    System.out.println(menuDisplay);
	    menuOption = scanner.nextInt();
		
	    //Choosing the options		
	    switch(menuOption) {
		 case 1:		
		     employeeManagement.addNewEmployeeDetails(employeeId);
		     System.out.println("\n your employee Id is " + employeeId);
		     employeeId++;
		     break;	
		 case 2:
		     System.out.println("\n Enter the employee Id  to update the details" );
	             employeeId = scanner.nextInt();
	             employeeManagement.updateEmployeeDetails(employeeId) ;
	             break;
		 case 3:
		     System.out.println("\n Enter the Employee Id");
	             employeeId = scanner.nextInt();
	             employeeManagement.showEmployeeDetails(employeeId);
		     break;
		 case 4:
		     System.out.println("\n Enter the Employee Id");
	             employeeId = scanner.nextInt();
	             employeeManagement.deleteEmployeeDetails(employeeId);
	             break;
		 case 5:
		     employeeManagement.showAll();
		     break;
	         case 6:
		     System.out.println("Thank you");
		     break;
		 default:
		     System.out.println("Enter a valid option");
		     break;
	    }
        }	
    }
	
    /**
     * Creating New Employee and details
     *
     * @param employeeId
     */
    private void addNewEmployeeDetails(int employeeId) {
    	System.out.println("Enter firstName");
        String firstName = scanner.next();
        System.out.println("Enter lastName");
        String lastName = scanner.next();
        System.out.println("Enter Salary");
        int salary = scanner.nextInt();
        System.out.println("Enter Mobile Number");
        long mobileNumber = validateMobileNumber();
	System.out.println("Enter Date of Birth in the format ('dd/MM/yyyy')");  
	Date dateOfBirth = dateValidate();       
        employeeDetails.put(employeeId, new Employee(employeeId, firstName, lastName, salary, +
                mobileNumber, dateOfBirth));
	System.out.println("\n EmployeeDetails added successfully");    
    }
    
    /**
     * Updating the Existing Employee and Details
     * 
     * @param employeeId
     */	
    private void updateEmployeeDetails(int employeeId) {

    	if(employeeDetails.containsKey(employeeId)) {
    	    System.out.println("Enter firstName");
            String firstName = scanner.next();
            System.out.println("Enter lastName");
            String lastName = scanner.next();
            System.out.println("Enter Salary");
            int salary = scanner.nextInt();
            System.out.println("Enter Mobile Number");
            long mobileNumber = validateMobileNumber();
	    System.out.println(" Enter Date of Birth in the format ('dd/MM/yyyy')"); 
	    Date dateOfBirth = dateValidate();       
            employeeDetails.put(employeeId, new Employee (employeeId, firstName, lastName, +
	   	    salary, mobileNumber, dateOfBirth));     
        } else {
            System.out.println("There is no such Employee Id. Please check the Id ");
        }
	System.out.println("\n EmployeeDetails Updated successfully");
    }
    
    /**
     * showing the particular Employee details
     *
     * @param employeeId
     */	
    private void showEmployeeDetails(int employeeId) {
    	System.out.println(employeeDetails.get(employeeId));	
    }
    
    /**
     * deleting the particular Employee details
     * 
     * @param employeeId
     */
    private void deleteEmployeeDetails(int employeeId) {
    	employeeDetails.remove(employeeId);
	System.out.println("\n EmployeeDetails Deleted successfully");	
    }
    
    /**
     * showing All Employees details 
     */
    private void showAll() {

    	if (employeeDetails.isEmpty()) {
            System.out.println("No Records found");
        } else {
            Iterator<Employee> iterator = employeeDetails.values().iterator();
            while (iterator.hasNext()) {
        	System.out.println(iterator.next());
            }	
        }	
    }

    /**
     * Mobile No validation
     */
    private long validateMobileNumber() {
    	long mobileNumber = scanner.nextLong();
            while (8 != mobileNumber / 1000000000 && 6 != mobileNumber / 1000000000 &&
                    7 != mobileNumber / 1000000000 && 9 != mobileNumber / 1000000000) {
                System.out.println("Invalid Mobile Number, Enter again");
         	mobileNumber = scanner.nextLong();	
            }
            return mobileNumber;	 
    }
    
    /**
     *Date validation
     */
    private Date dateValidate() {
        
        try {
    	    String date = scanner.next();
    	    Date dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(date);    
            return dateOfBirth;
    	} catch (Exception e) {
    	    while(null != e) {
    	        System.out.println(e);
		System.out.println("\n Invalid date Format, " +
		        "please Enter Date of Birth in the format ('dd/MM/yyyy')");
    		return dateValidate();
    	    }
    	    return null;
    	}	   
    }
}



