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
	EmployeeManagement employee = new EmployeeManagement();
			
	while (6 != menuOption) {
	    System.out.println("Enter the Options");
	    System.out.println(" 1.Create a NewEmployee " +
		    "\n 2.update the existing Employee" +
		    "\n 3.show employee details \n 4.Delete the employee data" +
		    "\n 5.showALL \n 6.Exit");
	    menuOption = scanner.nextInt();
		
	    //Choosing the options		
	    switch(menuOption) {
		 case 1:		
		     employee.addNewEmployeeDetails(employeeId);
		     System.out.println("your employee Id is " + employeeId);
		     employeeId++;
		     break;	
		 case 2:
		     System.out.println("Enter the employee Id  to update the details" );
	             employeeId = scanner.nextInt();
	             employee.updateEmployeeDetails(employeeId) ;
	             break;
		 case 3:
		     System.out.println("Enter the Employee Id");
	             employeeId = scanner.nextInt();
	             employee.showEmployeeDetails(employeeId);
		     break;
		 case 4:
		     System.out.println("Enter the Employee Id");
	             employeeId = scanner.nextInt();
	             employee.deleteEmployeeDetails(employeeId);
	             break;
		 case 5:
		     employee.showAll();
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
        System.out.println("Salary");
        int salary = scanner.nextInt();
        System.out.println("Mobile Number");
        long mobileNo = validateMobileNo();        
        employeeDetails.put(employeeId, new Employee(employeeId, firstName, lastName, salary, mobileNo));     
    }
    
    /**
     * Updating the Existing Employee and
     * 
     * @param employeeId
     */	
    private void updateEmployeeDetails(int employeeId) {

    	if(employeeDetails.containsKey(employeeId ) ) {
    	    System.out.println("Enter firstName");
            String firstName = scanner.next();
            System.out.println("Enter lastName");
            String lastName = scanner.next();
            System.out.println("Salary");
            int salary = scanner.nextInt();
            System.out.println("Mobile Number");
            long mobileNo = scanner.nextLong();        
            employeeDetails.put(employeeId, new Employee (employeeId, firstName, lastName, salary, mobileNo));     
        } else {
            System.out.println("There is no such Employee Id. Please check the Id ");
        }
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
    }
    
    /**
     * showing All Employees details 
     */
    private void showAll() {

    	if (employeeDetails.isEmpty() ) {
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
    private long validateMobileNo() {
    	long mobileNo = scanner.nextLong();

    	if (mobileNo / 1000000000 == 8 || mobileNo / 1000000000 == 6 ||
                mobileNo / 1000000000 == 7 || mobileNo / 1000000000 == 9) {
            return mobileNo;
        } else {

            while (mobileNo / 1000000000 != 8 && mobileNo / 1000000000 != 6 &&
                    mobileNo / 1000000000 != 7 && mobileNo / 1000000000 != 9) {
                System.out.println("Invalid Mobile Number, Enter again");
         	mobileNo = scanner.nextLong();	
            }
            return mobileNo;	 
        }
    }
}



